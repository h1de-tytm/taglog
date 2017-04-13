package com.taglog.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/taglog/{tag}", method=RequestMethod.GET)
	public String showTaglogTag(@PathVariable String tag, Model model) {
		System.out.println("/taglog/{tag}" + tag + "is called");
		//Taglog taglog = taglogRepository.findByTag(tag);
		List<Map<String, Object>> taglogList = taglogRepository.findByTag(tag);
		for (Map<String, Object> map : taglogList) {
			System.out.println(map.get("tweet"));
			
		}
		model.addAttribute("test");
		return "tag";
	}
}
