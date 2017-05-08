package com.taglog.beauty.data;

import java.util.List;
import java.util.Map;

public interface BeautyCategoryRepository {
	List<Map<String, Object>> findByCategoryIdOrderByFavorite(Long categoryId);
	List<Map<String, Object>> findByCategoryIdOrderByRetweet(Long categoryId);
}
