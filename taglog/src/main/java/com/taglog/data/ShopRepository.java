package com.taglog.data;

import java.util.List;
import java.util.Map;

import com.taglog.Shop;

public interface ShopRepository {
	
	Shop save(Shop shop);
	
	List<Map<String, Object>> findByTweetId(Long tweetId);
	
	List<Map<String, Object>> findByLocation(String location);
	
	List<Map<String, Object>> findByGenre(String genre);
	
	
}
