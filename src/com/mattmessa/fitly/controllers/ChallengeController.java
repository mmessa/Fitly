package com.mattmessa.fitly.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mattmessa.fitly.dao.Challenge;
import com.mattmessa.fitly.service.ChallengeService;

@Controller
public class ChallengeController {

	ChallengeService challengesService;
	
	@Autowired
	public void setChallengesService(ChallengeService challengesService) {
		this.challengesService = challengesService;
	}
	
	@RequestMapping("/challenges")
	public String showChallenges(Model model, HttpServletRequest request) {
		
		List<Challenge> challenges = challengesService.getChallenges();
		
		model.addAttribute("challenges", challenges);
		
		return "challenges";
		
	}
	
}
