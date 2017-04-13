package com.taglog.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	/*
	@RequestMapping("/")
	String menuForm() {
		return "menu/menuForm";
	}
	*/
	
	@RequestMapping("/")
	public String menu(Model model) {
		return "menu";
	}
}
