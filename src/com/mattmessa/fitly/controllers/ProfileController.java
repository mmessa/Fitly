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

import com.mattmessa.fitly.dao.BodyFat;
import com.mattmessa.fitly.dao.Goal;
import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.dao.Supplement;
import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.dao.Weight;
import com.mattmessa.fitly.service.BodyFatService;
import com.mattmessa.fitly.service.GoalService;
import com.mattmessa.fitly.service.ProfileService;
import com.mattmessa.fitly.service.SupplementService;
import com.mattmessa.fitly.service.UserService;
import com.mattmessa.fitly.service.WeightService;


@Controller
public class ProfileController {

	private ProfileService profilesService;
	private UserService usersService;
	private WeightService weightsService;
	private SupplementService supplementsService;
	private GoalService goalsService;
	private BodyFatService bodyFatsService;
	
	@Autowired
	public void setBodyFatsService(BodyFatService bodyFatsService) {
		this.bodyFatsService = bodyFatsService;
	}

	@Autowired
	public void setGoalsService(GoalService goalsService) {
		this.goalsService = goalsService;
	}
	
	@Autowired
	public void setSupplementsService(SupplementService supplementsService) {
		this.supplementsService = supplementsService;
	}

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
	
	
	@RequestMapping("/profile")
	public String showProfile(Model model, HttpServletRequest request)
	{
		int userId = (int) request.getSession().getAttribute("userId");
		Profile profile = profilesService.getProfile(userId);
		
		List<Weight> weights = weightsService.getWeights(userId);
		List<Goal> goals = goalsService.getGoals(userId);
		List<BodyFat> bodyFats = bodyFatsService.getBodyFats(userId);
		List<Supplement> supplements = supplementsService.getSupplements(userId);

		model.addAttribute("profile", profile);
		model.addAttribute("goals", goals);
		model.addAttribute("bodyFats", bodyFats);
		model.addAttribute("weights", weights);
		model.addAttribute("supplements", supplements);

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
	
	@RequestMapping("/editprofile") 
	public String showEditProfile(Model model, HttpServletRequest request){
		
		int userId = (int)request.getSession().getAttribute("userId");
		Profile profile = profilesService.getProfile(userId);
		System.out.printf("userId =  %d\n", profile.getUserId());
		model.addAttribute("profile", profile);
			
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
