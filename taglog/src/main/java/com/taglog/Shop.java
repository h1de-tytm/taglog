package com.taglog;

import javax.validation.constraints.NotNull;

public class Shop {
	private Long shopId;
	
	@NotNull
	private Long tweetId;
	
	@NotNull
	private String shopName;
	
	@NotNull
	private String genre;
	
	@NotNull
	private String location;
	
	@NotNull
	private String tabelogUrl;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTabelogUrl() {
		return tabelogUrl;
	}

	public void setTabelogUrl(String tabelogUrl) {
		this.tabelogUrl = tabelogUrl;
	}
	
	
}
