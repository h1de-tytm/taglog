package com.taglog.beauty.data;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcBeautyCategoryRepository implements BeautyCategoryRepository {

	private JdbcOperations jdbc;
	
	@Autowired
	public JdbcBeautyCategoryRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public List<Map<String, Object>> findAll() {

		return jdbc.queryForList(
			"select categoryId, categoryName, displayNum from beautyCategory order by displayNum asc"	
		);
	}

	@Override
	public List<Map<String, Object>> findByCategoryId(Long categoryId) {
		return jdbc.queryForList(
				"select categoryId, categoryName, displayNum from beautyCategory where categoryId = ?",
				categoryId
			);
	}

	@Override
	public List<Map<String, Object>> findByCategoryName(String categoryName) {
		return jdbc.queryForList(
				"select categoryId, categoryName, displayNum from beautyCategory where categoryName = ?",
				categoryName
			);
	}



}
