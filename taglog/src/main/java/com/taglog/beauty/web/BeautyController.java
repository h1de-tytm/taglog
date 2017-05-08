package com.taglog.beauty.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taglog.beauty.data.BeautyCategoryRepository;
import com.taglog.beauty.data.BeautyTweetRepository;

@Controller
public class BeautyController {

	private BeautyTweetRepository beautyTweetRepository;
	private BeautyCategoryRepository beautyCategoryRepository;
	
	@Autowired
	public BeautyController(BeautyTweetRepository beautyTweetRepository, BeautyCategoryRepository beautyCategoryReposotory) {
		this.beautyTweetRepository = beautyTweetRepository;
		this.beautyCategoryRepository = beautyCategoryRepository;
	}
	
	@RequestMapping(value="/beauty", method=RequestMethod.GET)
	public String returnBeautyHome() {
		return "beauty/home";
	}
	
	@RequestMapping(value="/beauty/category/{category}", method=RequestMethod.GET)
	public String showBeautyCategory(@PathVariable String category, Model model) {
		
	//categoryIdをDBから取得 from categoryName
	Long categoryId = null;
		
	List<Map<String, Object>> beautyCategoryMapList = beautyCategoryRepository.findByCategoryIdOrderByFavorite(categoryId);
	return "beauty/category";
	}
	
}
