package com.taglog;

import javax.validation.constraints.NotNull;

public class Taglog {
	private Long id;
	
	@NotNull
	private String tag;
	
	@NotNull
	private String location;
	
	@NotNull
	private String tweet;
	
	@NotNull
	private String genre;
	
	private String tabelogUrl;
	
	private String shopName;
	
	public Taglog(String tag, String location, String genre, String tweet, String tabelogUrl, String shopName) {
		this(null, tag, location, genre, tweet, tabelogUrl, shopName);
	}
	
	public Taglog(Long id, String tag, String location, String genre, String tweet, String tabelogUrl, String shopName) {
		this.id = id;
		this.tag = tag;
		this.location = location;
		this.genre = genre;
		this.tweet = tweet;
		this.tabelogUrl = tabelogUrl;
		this.shopName = shopName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTabelogUrl() {
		return tabelogUrl;
	}

	public void setTabelogUrl(String tabelogUrl) {
		this.tabelogUrl = tabelogUrl;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	
	
}
