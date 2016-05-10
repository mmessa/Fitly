package com.mattmessa.fitly.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mattmessa.fitly.dao.Challenge;
import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.service.ChallengeService;
import com.mattmessa.fitly.service.ProfileService;

@Controller
public class ChallengeController {

	ChallengeService challengesService;
	ProfileService profilesService;
	
	@Autowired
	public void setChallengesService(ChallengeService challengesService) {
		this.challengesService = challengesService;
	}
	
	@Autowired
	public void setProfilesService(ProfileService profilesService) {
		this.profilesService = profilesService;
	}


	@RequestMapping("/challenges")
	public String showChallenges(Model model, HttpServletRequest request) {
		
		int userId = (int) request.getSession().getAttribute("userId");
		Profile profile = profilesService.getProfile(userId);
		
		int level = profile.getLevel();
		List<Challenge> challenges = challengesService.getChallenges();
		List<Challenge> beginnerChallenges = challengesService.getBeginnerChallenges();
		List<Challenge> intermediateChallenges = challengesService.getIntermediateChallenges();
		List<Challenge> advancedChallenges = challengesService.getAdvancedChallenges();
		List<Challenge> completedChallenges = challengesService.getCompletedChallenges(userId);
		
		model.addAttribute("challenges", challenges);
		model.addAttribute("beginnerChallenges", beginnerChallenges);
		model.addAttribute("intermediateChallenges", intermediateChallenges);
		model.addAttribute("advancedChallenges", advancedChallenges);
		model.addAttribute("completedChallenges", completedChallenges);
		model.addAttribute("level", level);

		
		return "challenges";
		
	}
	
}
