package com.mattmessa.fitly.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/test")
	public String s(){
		return "test";
	}
	
	@RequestMapping(value="/loggedout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    
	    return "redirect:/";
	}
	
	
	
	
	
}
