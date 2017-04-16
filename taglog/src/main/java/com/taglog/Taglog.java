package com.taglog;

import java.util.List;

import javax.validation.constraints.NotNull;

public class Taglog {
	private Long taglogId;
	
	@NotNull
	private String tag;
	
	@NotNull
	private String tweet;
	
	@NotNull
	private Long tweetId;
	
	private List<Shop> shopList;
	
	
	public Taglog() {}
	
	public Taglog(String tag, String tweet, Long tweetId) {
		this(null, tag, tweet, tweetId);
	}
	
	public Taglog(Long taglogId, String tag, String tweet, Long tweetId) {
		this.taglogId = taglogId;
		this.tag = tag;
		this.tweet = tweet;
		this.tweetId = tweetId;
	}


	public Long getTaglogId() {
		return taglogId;
	}

	public void setTaglogId(Long taglogId) {
		this.taglogId = taglogId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	
}
