package com.taglog;

import java.util.HashMap;
import java.util.Map;

public class TagMapping {
	
	private Map<String, String> tagMapping = new HashMap<String, String>();;
	
	public String getTagName(String tag) {
		String tagName = null;
		tagName = tagMapping.get(tag);
		return tagName;
	}
	public TagMapping() {
		tagMapping.put("kiyolog", "きよログ");
		
	}
}
