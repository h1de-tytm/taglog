package com.taglog.twitter;

import org.junit.Test;

import com.taglog.test.Settings;


public class TwitterDataCollectorTest {
	private String consumerKey = Settings.consumerKey;
	private String consumerSecret = Settings.consumerSecret;
	private String accessToken = Settings.accessToken;
	private String accessTokenSecret = Settings.accessTokenSecret;

	
	@Test
	public void retweetCountTest() {
		TwitterDataCollector dataCollector = new TwitterDataCollector(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		int count = dataCollector.getRetweetCountByTweetId(860018598168768512L);
		System.out.println(count);
	}
	
	@Test
	public void favoriteCountTest() {
		TwitterDataCollector dataCollector = new TwitterDataCollector(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		int count = dataCollector.getFavoriteCountByTweetId(859971799173390336L);
		
		System.out.println(count);
	}
	
	@Test
	public void QuoteTweetTest() {
		TwitterDataCollector dataCollector = new TwitterDataCollector(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		String quote= dataCollector.getTweetQuote(859971799173390336L);
		
		System.out.println(quote);
	}
	

}
