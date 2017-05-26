package com.taglog.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
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
	
	public int getFollowerCountByTweetId(TwitterTemplate twitter, long tweetId) {
		int followerCount = 0;
		Tweet tweet = twitter.timelineOperations().getStatus(tweetId);
		TwitterProfile profile = tweet.getUser();
		followerCount = profile.getFollowersCount();
		return followerCount;
	}
	
	
	
}
