package com.mattmessa.fitly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.service.ProfileService;
import com.mattmessa.fitly.service.UserService;


@Controller
public class ProfileController {

	private ProfileService profilesService;
	
	@Autowired
	public void setProfilesService(ProfileService profilesService) {
		this.profilesService = profilesService;
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
		
		profilesService.create(profile);
		
		return "profilecreated";
	}
	
	
}
