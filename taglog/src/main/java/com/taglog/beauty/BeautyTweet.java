package com.taglog.beauty;

import javax.validation.constraints.NotNull;

public class BeautyTweet {
	private Long tweetId;
	
	@NotNull
	private String tweet;
	
	@NotNull
	private Long favCount;
	
	@NotNull
	private Long rtCount;
	
	@NotNull
	private Long categoryId;

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public Long getFavCount() {
		return favCount;
	}

	public void setFavCount(Long favCount) {
		this.favCount = favCount;
	}

	public Long getRtCount() {
		return rtCount;
	}

	public void setRtCount(Long rtCount) {
		this.rtCount = rtCount;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}
