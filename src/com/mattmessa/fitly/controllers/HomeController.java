package com.mattmessa.fitly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.service.UsersService;

@Controller
public class HomeController {

	private UsersService usersService;
	
	@Autowired
	public void setFitlyService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/")
	public String showHome(Model model)
	{
		
		List<User> users = usersService.getCurrent();
		
		model.addAttribute("users", users);
			
		return "home";
	}
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		
		return "error";
	}
	
}
