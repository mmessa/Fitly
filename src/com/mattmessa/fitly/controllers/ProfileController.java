package com.mattmessa.fitly.controllers;

import java.util.List;

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
	public String showProfile(Model model)
	{
		return "profile";
	}
	
	@RequestMapping("/profiles")
	public String showProfiles(Model model) {
		
		List<Profile> profiles = profilesService.getCurrent();
		
		model.addAttribute("profiles", profiles);
		
		return "profiles";
	}
	
	@RequestMapping("/createprofile")
	public String createProfile(Model model) {
	
		model.addAttribute("profile", new Profile());
		
		return "createprofile";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Profile profile, BindingResult result) {
		
		if(result.hasErrors()) {
			return "createprofile";
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails =  (UserDetails) auth.getPrincipal();
	    String username = userDetails.getUsername();
		
		User user = usersService.getUser(username);
		int userId = user.getUserId();
		
		profile.getUser().setUserId(userId);
		
		profilesService.create(profile);
		
		return "profilecreated";
	}
	
	
}
