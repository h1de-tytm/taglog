package com.taglog.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taglog.TagMapping;
import com.taglog.Taglog;
import com.taglog.data.TaglogRepository;

@Controller
public class TaglogController {
	private TaglogRepository taglogRepository;

	@RequestMapping(value="/taglog", method=RequestMethod.GET)
	public String returnHome() {
		System.out.println("/taglog called.");
		return "menu";
	}
	
	@Autowired
	public TaglogController(TaglogRepository taglogRepository) {
		this.taglogRepository = taglogRepository;
	}
	
	@RequestMapping(value="/tag/{tag}", method=RequestMethod.GET)
	public String showTaglogTag(@PathVariable String tag, Model model) {
		System.out.println("/tag/{tag}" + tag + "is called");
		List<Map<String, Object>> taglogMapList = taglogRepository.findByTag(tag);
		List<Taglog> taglogList = new ArrayList<Taglog>();
		for (Map<String, Object> taglogMap : taglogMapList) {
			
			Taglog taglog = new Taglog();
			taglog.setId((Long)taglogMap.get("id"));
			taglog.setTag((String)taglogMap.get("tag"));
			taglog.setLocation((String)taglogMap.get("location"));
			taglog.setGenre((String)taglogMap.get("genre"));
			taglog.setTweet((String)taglogMap.get("tweet"));
			taglog.setTabelogUrl((String)taglogMap.get("tabelogUrl"));
			taglog.setShopName((String)taglogMap.get("shopName"));
			taglogList.add(taglog);
			
		}
		
		TagMapping tagMapping = new TagMapping();
		String tagName = tagMapping.getTagName(tag);
		model.addAttribute("tagName", tagName);
		model.addAttribute("taglogList", taglogList);
		return "taglog";
	}
}
