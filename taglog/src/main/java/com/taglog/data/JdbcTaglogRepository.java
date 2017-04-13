package com.taglog.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.taglog.Taglog;

@Repository
public class JdbcTaglogRepository implements TaglogRepository{
	
	private JdbcOperations jdbc;
	
	@Autowired
	public JdbcTaglogRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	public Taglog sava(Taglog taglog) {
		jdbc.update(
			"insert into Taglog(tag, location, genre, tweet, tabelogUrl, shopName)" +
			"values (?, ?, ?, ?, ?, ?)",
			taglog.getTag(),
			taglog.getLocation(),
			taglog.getGenre(),
			taglog.getTweet(),	
			taglog.getTabelogUrl(),
			taglog.getShopName()
		);
		return taglog;
	}

	@Override
	public List<Map<String, Object>> findByTag(String tag) {
		/*
		return jdbc.queryForObject
			("select id, tag, location, genre, tweet, tabelogUrl, shopName from taglog where tag=?", 
			new TaglogRowMapper(),
			tag);
		*/
		return jdbc.queryForList(
			"select id, tag, location, genre, tweet, tabelogUrl, shopName "
			+ "from taglog where tag=?", tag);
	}

	@Override
	public Taglog findByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class TaglogRowMapper implements RowMapper<Taglog> {
		public Taglog mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Taglog(
				rs.getLong("id"),
				rs.getString("tag"),
				rs.getString("location"),
				rs.getString("genre"),
				rs.getString("tweet"),
				rs.getString("tabelogUrl"),
				rs.getString("shopName")
			);
		}
	}
	
	private static class TaglogResultSetExtractor implements ResultSetExtractor<Taglog> {

		public Taglog extractData(ResultSet arg0) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
