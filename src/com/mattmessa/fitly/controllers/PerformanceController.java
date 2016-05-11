package com.mattmessa.fitly.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mattmessa.fitly.dao.Performance;
import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.service.PerformanceService;
import com.mattmessa.fitly.service.ProfileService;

@Controller
public class PerformanceController {
	
	private PerformanceService performancesService;
	private ProfileService profilesService;
	
	@Autowired
	public void setPerformancesService(PerformanceService performancesService) {
		this.performancesService = performancesService;
	}
	
	@Autowired
	public void setProfilesService(ProfileService profilesService) {
		this.profilesService = profilesService;
	}

	@RequestMapping("/docompleteperformance")
	public String completePerformance(Model model, HttpServletRequest request) {
	
		int userId = (int)request.getSession().getAttribute("userId");
		int performanceId = Integer.parseInt(request.getParameter("performanceId"));
		
		Performance performance = performancesService.getPerformance(performanceId);
		Profile profile = profilesService.getProfile(userId);

		//add coins and xp to profile, check to see if lvled up
		boolean leveledUp = false;
		int coins = profile.getCoins();
		int level = profile.getLevel();
		int xp = profile.getExperiencePoints();
		
		coins = coins + performance.getCoinsGiven();
		xp = xp + performance.getExperienceGiven();
		
		leveledUp = profile.didLevelUp(xp);
		if (leveledUp)
			System.out.println("leveledUp = true");
		
		if (leveledUp)
		{
			level = level + 1;
			System.out.printf("level = %d", level);
			profile.setLevel(level);
		}
		
		
		System.out.printf("coins = %d and xp = %d", coins, xp);
		profile.setCoins(coins);
		profile.setExperiencePoints(xp);
		
		profilesService.updateProfile(profile);
		performancesService.completePerformance(performanceId);
		System.out.println("past here 3");

		
		return "redirect:profile";
	}
	
	@RequestMapping(value="/docreateperformance", method=RequestMethod.POST)
	public String doCreate(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		Performance performance = new Performance();
		
		int userId = (int)request.getSession().getAttribute("userId");
		int challengeId = Integer.parseInt(request.getParameter("challengeId"));
		
		performance.setUserId(userId);
		performance.setChallengeId(challengeId);
		
		performancesService.create(performance);
		
		return "redirect:challenges";
	}
	
	@RequestMapping("/deleteperformance") 
	public String deletePerformance(Model model, HttpServletRequest request){
		
		int performanceId = Integer.parseInt(request.getParameter("performanceId"));
		performancesService.deletePerformance(performanceId);
		
		return "redirect:profile";
	}
}
