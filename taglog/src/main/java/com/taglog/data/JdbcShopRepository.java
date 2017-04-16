package com.taglog.data;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.taglog.Shop;

@Repository
public class JdbcShopRepository implements ShopRepository {
	
	private JdbcOperations jdbc;
	
	@Autowired
	public JdbcShopRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Shop save(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByTweetId(Long tweetId) {
		return jdbc.queryForList(
			"select shopId, tweetId, shopName, genre, location, tabelogUrl " 
			+ "from shop where tweetId=?",
				tweetId
		);
	}

	@Override
	public List<Map<String, Object>> findByLocation(String location) {
		return jdbc.queryForList(
				"select shopId, tweetId, shopName, genre, location, tabelogUrl " 
				+ "from shop where location=?",
				location
			);
	}

	@Override
	public List<Map<String, Object>> findByGenre(String genre) {
		return jdbc.queryForList(
				"select shopId, tweetId, shopName, genre, location, tabelogUrl " 
				+ "from shop where genre=?",
				genre
			);
	}

}
