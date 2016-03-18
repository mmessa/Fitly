package com.mattmessa.fitly.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.dao.Weight;
import com.mattmessa.fitly.service.ProfileService;
import com.mattmessa.fitly.service.UserService;
import com.mattmessa.fitly.service.WeightService;

@Controller
public class WeightController {
	
	private ProfileService profilesService;
	private UserService usersService;
	private WeightService weightsService;
	
	@Autowired
	public void setWeightsService(WeightService weightsService) {
		this.weightsService = weightsService;
	}
	
	@Autowired
	public void setProfilesService(ProfileService profilesService) {
		this.profilesService = profilesService;
	}
	
	@Autowired
	public void setUsersService(UserService usersService) {
		this.usersService = usersService;
	}
	
	
	@RequestMapping("/createweight")
	public String createWeight(Model model, HttpServletRequest request) {
	
		Weight weight = null;
		
		int userId = (int)request.getSession().getAttribute("userId");
			
		weight = weightsService.getWeight(userId);
		
		if(weight == null) {
			weight = new Weight();
		}
		
		model.addAttribute("weight", weight);
		
		return "createweight";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Weight weight, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "createweight";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		weight.setUserId(userId);
		
		weightsService.saveOrUpdate(weight);
		
		return "offercreated";
	}
	
	@RequestMapping("/editweight") 
	public String showEditWeight(Model model, HttpServletRequest request){
		
		int userId = (int)request.getSession().getAttribute("userId");
		Weight weight = weightsService.getWeight(userId);
		System.out.printf("userId =  %d\n", weight.getUserId());
		model.addAttribute("weight", weight);
			
		return "editprofile";
	}
	
	
	@RequestMapping(value="/updateprofile", method=RequestMethod.POST)
	public String updateProfile(@Valid Profile profile, BindingResult result, HttpServletResponse response) throws IOException, ServletException {
		
		//System.out.println("about to update profile");
		profilesService.updateProfile(profile);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		
		model.addAttribute("user", new User());
		//model.addAttribute("profile", new Profile());
		
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
		
		Profile profile = new Profile();
		
		user = usersService.getUser(user.getUsername());
		
		int userId = user.getUserId();
		
		profile.setUserId(userId);
		
		profilesService.create(profile);
		
		return "login";
	}
}
