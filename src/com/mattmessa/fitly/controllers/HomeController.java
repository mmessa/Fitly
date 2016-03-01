package com.mattmessa.fitly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.service.FitlyService;

@Controller
public class HomeController {

	private FitlyService fitlyService;
	
	@Autowired
	public void setFitlyService(FitlyService fitlyService) {
		this.fitlyService = fitlyService;
	}

	@RequestMapping("/")
	public String showHome(Model model)
	{
		
		List<User> users = fitlyService.getCurrent();
		
		model.addAttribute("users", users);
			
		return "home";
	}
}
