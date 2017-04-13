package com.taglog.data;

import java.util.List;
import java.util.Map;

import com.taglog.Taglog;

public interface TaglogRepository {

	Taglog sava(Taglog taglog);
	
	List<Map<String, Object>>  findByTag(String tag);
	
	Taglog findByLocation(String location);
}
