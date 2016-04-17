package com.mattmessa.fitly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mattmessa.fitly.service.UserService;

@Controller
public class HomeController {

	private UserService usersService;
	
	@Autowired
	public void setFitlyService(UserService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/")
	public String showHome(Model model)
	{
		return "home";
	}
	
	
}
