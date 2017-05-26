package com.taglog.beauty.data;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcBeautyTweetRepository implements BeautyTweetRepository {

	private JdbcOperations jdbc;
	
	@Autowired
	public JdbcBeautyTweetRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Map<String, Object>> findByCategoryIdOrderByFavorite(Long categoryId) {
		return jdbc.queryForList(
			"select tweet from beautyTweet where categoryId = ? order by favCount desc", categoryId
		);
	}

	@Override
	public List<Map<String, Object>> findByCategoryIdOrderByRetweet(Long categoryId) {
		return jdbc.queryForList(
				"select tweet from beautyTweet where categoryId = ? order by rtCount desc", categoryId
			);
	}
	@Override
	public List<Map<String, Object>> findByCategoryIdOrderByTweetId(Long categoryId) {
		return jdbc.queryForList(
				"select tweet from beautyTweet where categoryId = ? order by tweetId desc", categoryId
			);
	}

	@Override
	public List<Map<String, Object>> findByKeywordOrderByFavorite(String keyword) {
		return jdbc.queryForList(
				"select tweet from beautyTweet where tweet LIKE '%" + keyword + "%' order by favCount desc"
			);
	}

}
