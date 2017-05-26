package com.taglog.beauty.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taglog.beauty.BeautyCategory;
import com.taglog.beauty.BeautyTweet;
import com.taglog.beauty.data.BeautyCategoryRepository;
import com.taglog.beauty.data.BeautyTweetRepository;

@Controller
public class BeautyController {

	private BeautyTweetRepository beautyTweetRepository;
	private BeautyCategoryRepository beautyCategoryRepository;
	
	@Autowired
	public BeautyController(BeautyTweetRepository beautyTweetRepository, BeautyCategoryRepository beautyCategoryRepository) {
		this.beautyTweetRepository = beautyTweetRepository;
		this.beautyCategoryRepository = beautyCategoryRepository;
	}
	
	@RequestMapping(value="/beauty", method=RequestMethod.GET)
	public String beautyHome(Model model) {
		System.out.println("/beauty called.");
		List<Map<String, Object>> beautyCategoryMapList = beautyCategoryRepository.findAll();
		List<BeautyCategory> beautyCategoryList = new ArrayList<BeautyCategory>();
		
		for (Map<String, Object> beautyCategoryMap :beautyCategoryMapList) {
			BeautyCategory beautyCategory = new BeautyCategory();
			beautyCategory.setCategoryId((Long)beautyCategoryMap.get("categoryId"));
			beautyCategory.setCategoryName((String)beautyCategoryMap.get("categoryName"));
			beautyCategory.setDisplayNum((Long)beautyCategoryMap.get("displayNum"));
			beautyCategoryList.add(beautyCategory);
		}
		
		model.addAttribute("beautyCategoryList", beautyCategoryList);
		
		return "beauty/home";
	}
	
	@RequestMapping(value="/beauty/category/{category}", method=RequestMethod.GET)
	public String showBeautyCategory(@PathVariable String category, @RequestParam("order") String order , Model model) {
		System.out.println("/beauty/category/" + category + " called. order is " + order);
		
		//categoryIdをDBから取得 from categoryName
		Long categoryId = null;
		List<Map<String, Object>> beautyCategoryMapList = beautyCategoryRepository.findByCategoryName(category);
		BeautyCategory beautyCategory = new BeautyCategory();
		for (Map<String, Object> beautyCategoryMap :beautyCategoryMapList) {
			beautyCategory.setCategoryId((Long)beautyCategoryMap.get("categoryId"));
			beautyCategory.setCategoryName((String)beautyCategoryMap.get("categoryName"));
			beautyCategory.setDisplayNum((Long)beautyCategoryMap.get("displayNum"));
		}
		
		categoryId = beautyCategory.getCategoryId();
		
		List<Map<String, Object>> beautyTweetMapList = new ArrayList<Map<String, Object>>();
		//何も指定されていないときはfav順
		if (order.equals("favorite") || order == null || order == "") {
			beautyTweetMapList = beautyTweetRepository.findByCategoryIdOrderByFavorite(categoryId);
		} else if (order.equals("retweet")) {
			beautyTweetMapList = beautyTweetRepository.findByCategoryIdOrderByRetweet(categoryId);
		} else if (order.equals("newer")) {
			beautyTweetMapList = beautyTweetRepository.findByCategoryIdOrderByTweetId(categoryId);
		} else if (order.equals("random")) {
			beautyTweetMapList = beautyTweetRepository.findByCategoryIdOrderByFavorite(categoryId);
			Collections.shuffle(beautyTweetMapList);
		}
		
		List<BeautyTweet> beautyTweetList = new ArrayList<BeautyTweet>();
		for (Map<String, Object> beautyTweetMap :beautyTweetMapList) {
			BeautyTweet beautyTweet = new BeautyTweet();
			beautyTweet.setTweetId((Long)beautyTweetMap.get("tweetId"));
			beautyTweet.setTweet((String)beautyTweetMap.get("tweet"));
			beautyTweet.setFavCount((Long)beautyTweetMap.get("favCount"));
			beautyTweet.setRtCount((Long)beautyTweetMap.get("rtCount"));
			beautyTweet.setCategoryId((Long)beautyTweetMap.get("categoryId"));
			beautyTweetList.add(beautyTweet);
		}
		
		model.addAttribute("category", category);
		model.addAttribute("beautyTweetList", beautyTweetList);
		
		return "beauty/category";
	}
	
	@RequestMapping(value="/beauty/search", method=RequestMethod.GET)
	public String showSearchResult(@RequestParam("keyword") String keyword , Model model) {
		System.out.println("search method is called");
		System.out.println(keyword);
		
		List<Map<String, Object>> beautyTweetMapList = new ArrayList<Map<String, Object>>();
		beautyTweetMapList = beautyTweetRepository.findByKeywordOrderByFavorite(keyword);
		List<BeautyTweet> beautyTweetList = new ArrayList<BeautyTweet>();
		for (Map<String, Object> beautyTweetMap :beautyTweetMapList) {
			BeautyTweet beautyTweet = new BeautyTweet();
			beautyTweet.setTweetId((Long)beautyTweetMap.get("tweetId"));
			beautyTweet.setTweet((String)beautyTweetMap.get("tweet"));
			beautyTweet.setFavCount((Long)beautyTweetMap.get("favCount"));
			beautyTweet.setRtCount((Long)beautyTweetMap.get("rtCount"));
			beautyTweet.setCategoryId((Long)beautyTweetMap.get("categoryId"));
			beautyTweetList.add(beautyTweet);
		}
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("beautyTweetList", beautyTweetList);
		return "beauty/result";
	}
	
}
