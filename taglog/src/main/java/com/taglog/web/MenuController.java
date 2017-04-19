package com.taglog.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taglog.Shop;
import com.taglog.data.ShopRepository;
import com.taglog.data.TaglogRepository;

@Controller
public class MenuController {
	
	//TODO: 性能に問題が出た場合はクエリの結果をキャッシュ化する
	
	private TaglogRepository taglogRepository;
	private ShopRepository shopRepository;
	
	
	@Autowired
	public MenuController(TaglogRepository taglogRepository, ShopRepository shopRepository) {
		this.taglogRepository = taglogRepository;
		this.shopRepository = shopRepository;
	}
	
	@RequestMapping("/")
	public String menu(Model model) {

		List<Map<String, Object>> tagMapList = taglogRepository.orderByTagCount();
		List<String> tagList = new ArrayList<String>();
		for (Map<String, Object> tagMap : tagMapList) {
			Long count = (Long)tagMap.get("recordCount");
			String tag = (String)tagMap.get("tag");

			tagList.add(tag);
		}

		List<Map<String, Object>> locationMapList = shopRepository.orderByLocationCount();
		List<String> locationList = new ArrayList<String>();
		for (Map<String, Object> locationMap : locationMapList) {
			Long count = (Long)locationMap.get("recordCount");
			String location = (String)locationMap.get("location");

			locationList.add(location);
		}
		
		List<Map<String, Object>> genreMapList = shopRepository.orderByGenreCount();
		List<String> genreList = new ArrayList<String>();
		for (Map<String, Object> genreMap : genreMapList) {
			Long count = (Long)genreMap.get("recordCount");
			String genre = (String)genreMap.get("genre");
			System.out.println("count:" + count + "  genre:" + genre);
			genreList.add(genre);
		}
		
		model.addAttribute("tagList", tagList);
		model.addAttribute("locationList", locationList);
		model.addAttribute("genreList", genreList);
		return "menu";
	}
}
