package com.taglog.beauty.data;

import java.util.List;
import java.util.Map;

public interface BeautyTweetRepository {
	
	List<Map<String, Object>> findByCategoryId(Long categoryId);
	
}
