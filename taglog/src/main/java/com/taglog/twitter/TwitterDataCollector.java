package com.taglog.twitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class TwitterDataCollector {
	
	@Value("${data.consumer.key}")
	private String consumerKey;
	
	@Value("${data.consumer.secret}")
	private String consumerSecret;
	
	@Value("${data.access.token}")
	private String accessToken;
	
	@Value("${data.access.token.secret}")
	private String accessTokenSecret;
	
	private TwitterTemplate twitter;
	
	public TwitterDataCollector() {
	}
	
	public TwitterDataCollector(String consumerKey, String consumerSecret, 
			String accessToken, String accessTokenSecret) {
		twitter = getTwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
	}
	
	public TwitterTemplate getTwitterTemplate() {
		TwitterTemplate twitter = getTwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		return twitter;
	}
	
	public TwitterTemplate getTwitterTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		TwitterTemplate twitter 
			= new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		
		return twitter;
	}
	
	/**
	 * 以下の引用形式でツイートを引っこ抜く
	 * <blockquote class="twitter-tweet" 
	 * data-lang="ja">
	 * <p lang="und" dir="ltr">
	 * <a href="https://t.co/sFtQbMYT1l">pic.twitter.com/sFtQbMYT1l</a></p>&mdash; Goth Ms. Frizzle 
	 * (@spookperson) <a href="https://twitter.com/spookperson/status/859912839703678977">
	 * 2017年5月3日</a></blockquote>
	 * <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
	 * @param tweetId
	 * @return
	 */
	public String getTweetQuote(long tweetId) {
		StringBuilder tweetQuote = new StringBuilder();
		Tweet tweet = twitter.timelineOperations().getStatus(tweetId);
		tweetQuote.append("<blockquote class=\"twitter-tweet\" data-lang=\"ja\"" + "\n");
		tweetQuote.append("<p lang=\"und\" dir=\"ltr\">" + "\n");
		if (tweet.hasMedia()) {
			tweetQuote.append("<a href=\"");
		}
		
		System.out.println(tweet.getText());
		System.out.println("---------------");
		System.out.println(tweet.getSource());
		
		
		
		return tweetQuote.toString();
	}

	public int getFavoriteCountByTweetId(long tweetId) {
		int favCount = 0;
		favCount = getFavoriteCountByTweetId(twitter, tweetId);
		return favCount;
	}
	
	public int getFavoriteCountByTweetId(TwitterTemplate twitter,long tweetId) {
		int favCount = 0;
		Tweet tweet = twitter.timelineOperations().getStatus(tweetId);
		favCount = tweet.getFavoriteCount();
		return favCount;
	}
	
	public int getRetweetCountByTweetId(long tweetId) {
		int retweetCount = 0;
		retweetCount = getRetweetCountByTweetId(twitter, tweetId);
		return retweetCount;
	}
	
	public int getRetweetCountByTweetId(TwitterTemplate twitter, long tweetId) {
		int retweetCount = 0;
		
		Tweet tweet = twitter.timelineOperations().getStatus(tweetId);
		retweetCount = tweet.getRetweetCount();
		return retweetCount;
		
	}
}
