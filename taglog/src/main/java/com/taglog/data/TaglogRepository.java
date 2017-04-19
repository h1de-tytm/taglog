package com.taglog.data;

import java.util.List;
import java.util.Map;

import com.taglog.Taglog;

public interface TaglogRepository {

	List<Map<String, Object>> findByTweetId(Long tweetId);
	
	List<Map<String, Object>>  findByTag(String tag);
	
	List<Map<String, Object>> orderByTagCount();
}
