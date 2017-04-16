package com.taglog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taglog.data.ShopRepository;

@Controller
public class ShopController {

	private ShopRepository shopRepository;
	
	/*
	@RequestMapping(value="/location/${location}", method=RequestMethod.GET)
	public String showLocation(@PathVariable String location, Model model) {
		
		return "shop";
	}
	*/
}
