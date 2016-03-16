package com.mattmessa.fitly.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.service.UserService;

@Controller
public class LoginController {
	
	private UserService usersService;
	
	@Autowired
	public void setUsersService(UserService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin(){
		/*
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails =  (UserDetails) auth.getPrincipal();
	    String username = userDetails.getUsername();
	    
		User user = usersService.getUser(username);
		request.getSession().setAttribute("userId", user.getUserId());
		//int userId = (int) request.getSession().getAttribute("userId");
		System.out.printf("UserId = %d", request.getSession().getAttribute("userId"));
		*/
		return "login";
	}
	
	@RequestMapping(value="/loggedout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "loggedout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newaccount";
		}
		
		user.setAuthority("user");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}
		
		try {
			usersService.create(user);
		} catch (DuplicateKeyException ex) {
			
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}
		
		return "accountcreated";
	}
	
}
