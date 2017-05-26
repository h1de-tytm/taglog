package com.taglog.beauty.data;

import java.util.List;
import java.util.Map;

public interface BeautyCategoryRepository {
	List<Map<String, Object>> findAll();
	List<Map<String, Object>> findByCategoryId(Long categoryId);
	List<Map<String, Object>> findByCategoryName(String categoryName);
}
