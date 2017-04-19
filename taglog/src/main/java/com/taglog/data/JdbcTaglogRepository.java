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


	@Override
	public List<Map<String, Object>> findByTag(String tag) {
		return jdbc.queryForList(
			"select taglogId, tag, tweet, tweetId "
			+ "from taglog where tag=?", tag);
	}


	private static class TaglogRowMapper implements RowMapper<Taglog> {
		public Taglog mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Taglog(
				rs.getLong("taglogId"),
				rs.getString("tag"),
				rs.getString("tweet"),
				rs.getLong("tweetId")
			);
		}
	}
	
	private static class TaglogResultSetExtractor implements ResultSetExtractor<Taglog> {
		public Taglog extractData(ResultSet arg0) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	@Override
	public List<Map<String, Object>> findByTweetId(Long tweetId) {
		return jdbc.queryForList(
				"select taglogId, tag, tweet, tweetId "
				+ "from taglog where tweetId=?", tweetId);
		
	}
	
	@Override
	public List<Map<String, Object>> orderByTagCount() {
		return jdbc.queryForList(
				"select count(*) as recordCount, tag " 
				+ "from taglog group by tag order by recordCount desc"
			);
	}
}
