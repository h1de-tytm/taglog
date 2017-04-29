package com.taglog.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Verifier;
import com.github.scribejava.core.oauth.OAuthService;

/**
 * @see http://qiita.com/rubytomato@github/items/e6d7ed0d25a3835bf44b
 * @see http://yuroyoro.hatenablog.com/entry/20100506/1273137673
 * @author h1de
 *
 */
@Controller
@RequestMapping("/twitter")
public class TwitterController {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(TwitterController.class);
	
	@Value("${twitter.appId}")
	private String apiKey;
	
	@Value("${twitter.appSecret}")
	private String apiSecret;
	
	@Value("${twitter.callbackurl}")
	private String callbackUrl;
	
	@Value("${twitter.host}")
	private String host;
	
	//API End point
	private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";
	
	
	@RequestMapping(value = "/signin", method= RequestMethod.GET)
	public void signin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.debug("signin");
		OAuthService service = new ServiceBuilder()
				.provider(TwitterApi.Authenticate.class)
				.apiKey(apiKey)
				.apiSecret(apiSecret)
				.callback(host + callbackUrl)
				.build();
				
		Token requestToken = service.getRequestToken();
		String redirectURL = service.getAuthorizationUrl(requestToken);
		logger.info("redirectURL:{}", redirectURL);
		
		response.sendRedirect(redirectURL);
	}
	
	@RequestMapping(value="/callback", method=RequestMethod.GET)
	public String callback(@RequestParam(value = "oauth_token", required = false) String oauth_token,
			@RequestParam(value = "oauth_verifier", required = false) String oauth_verifier,
			HttpServletRequest request, HttpServletResponse response, Model model) {
	    OAuthService service = new ServiceBuilder()
	    	      .provider(TwitterApi.Authenticate.class)
	    	      .apiKey(apiKey)
	    	      .apiSecret(apiSecret)
	    	      .callback(host + callbackUrl)
	    	      .build();

	    final Verifier verifier = new Verifier(oauth_verifier);
	    final Token requestToken = new Token(oauth_token, oauth_verifier);
	    final Token accessToken = service.getAccessToken(requestToken, verifier);

	    final OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
	    service.signRequest(accessToken, oauthRequest);

	    final Response resourceResponse = oauthRequest.send();

	    logger.info("code:{}", resourceResponse.getCode());
	    logger.info("body:{}", resourceResponse.getBody());
	    logger.info("message:{}",resourceResponse.getMessage());

	    final JSONObject obj = new JSONObject(resourceResponse.getBody());
	    logger.info("json:{}" ,obj.toString());

	    String twitterId = obj.getString("id_str");
	    String name = obj.getString("name");
	    String profileImageUrl = obj.getString("profile_image_url");

	    model.addAttribute("id", twitterId);
	    model.addAttribute("name", name);
	    model.addAttribute("imageUrl", profileImageUrl);

	    request.getSession().setAttribute("TWITTER_ACCESS_TOKEN", accessToken);		
		return "twitter/profile";
	}
	
	  @RequestMapping(value ="/profile", method = RequestMethod.GET)
	  public String profile(HttpServletRequest request, HttpServletResponse response, Model model) {
	    logger.debug("profile");

	    OAuthService service = new ServiceBuilder()
    	      .provider(TwitterApi.Authenticate.class)
    	      .apiKey(apiKey)
    	      .apiSecret(apiSecret)
    	      .callback(host + callbackUrl)
    	      .build();

	    final Token accessToken = (Token) request.getSession().getAttribute("TWITTER_ACCESS_TOKEN");

	    final OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
	    service.signRequest(accessToken, oauthRequest);

	    final Response resourceResponse = oauthRequest.send();

	    logger.info("code:{}", resourceResponse.getCode());
	    logger.info("body:{}", resourceResponse.getBody());
	    logger.info("message:{}",resourceResponse.getMessage());

	    final JSONObject obj = new JSONObject(resourceResponse.getBody());
	    logger.info("json:{}" ,obj.toString());

	    String twitterId = obj.getString("id_str");
	    String name = obj.getString("name");
	    String profileImageUrl = obj.getString("profile_image_url");

	    model.addAttribute("id", twitterId);
	    model.addAttribute("name", name);
	    model.addAttribute("imageUrl", profileImageUrl);

	    return "twitter/profile";
	  }	
}
