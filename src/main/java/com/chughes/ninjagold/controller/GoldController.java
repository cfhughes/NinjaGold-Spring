package com.chughes.ninjagold.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chughes.ninjagold.service.GoldService;

@Controller
public class GoldController {
	
	GoldService goldService;
	
	@Autowired
	public GoldController(GoldService goldService) {
		this.goldService = goldService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("total", goldService.getGold());
		model.addAttribute("activities", Arrays.asList("Went to a cave"));
		return "index.jsp";
	}
	
	@PostMapping("/process_money")
	public String processMoney(@RequestParam("hidden") String hidden) {
		goldService.processMoney(hidden);
		return "redirect:/";
	}
	
}
