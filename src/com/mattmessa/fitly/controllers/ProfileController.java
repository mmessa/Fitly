package com.mattmessa.fitly.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.service.ProfileService;
import com.mattmessa.fitly.service.UserService;


@Controller
public class ProfileController {

	private ProfileService profilesService;
	private UserService usersService;
	
	@Autowired
	public void setProfilesService(ProfileService profilesService) {
		this.profilesService = profilesService;
	}
	
	@Autowired
	public void setUsersService(UserService usersService) {
		this.usersService = usersService;
	}
	
	
	@RequestMapping("/profile")
	public String showProfile(Model model, HttpServletRequest request)
	{
		int userId = (int) request.getSession().getAttribute("userId");
		System.out.printf("controller id = %d", userId);
		Profile profile = profilesService.getProfile(userId);
		model.addAttribute("profile", profile);
		return "profile";
	}
	
	/*
	@RequestMapping("/profiles")
	public String showProfiles(Model model) {
		
		List<Profile> profiles = profilesService.getProfiles();
		
		model.addAttribute("profiles", profiles);
		
		return "profiles";
	}
	*/
	
	@RequestMapping("/createprofile")
	public String createProfile(Model model) {
	
		model.addAttribute("profile", new Profile());
		
		return "createprofile";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Profile profile, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "createprofile";
		}
	
		int userId = (int)request.getSession().getAttribute("userId");
		
		profile.getUser().setUserId(userId);
		
		profilesService.create(profile);
		
		return "profilecreated";
	}
	
	
}
