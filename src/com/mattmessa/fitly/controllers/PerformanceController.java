package com.mattmessa.fitly.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mattmessa.fitly.dao.Performance;
import com.mattmessa.fitly.service.PerformanceService;

@Controller
public class PerformanceController {
private PerformanceService performancesService;
	
	@Autowired
	public void setPerformancesService(PerformanceService performancesService) {
		this.performancesService = performancesService;
	}
	
	@RequestMapping("/docompleteperformance")
	public String completePerformance(Model model, HttpServletRequest request) {
	
		int performanceId = 0;
		
		performanceId = Integer.parseInt(request.getParameter("performanceId"));
		performancesService.completePerformance(performanceId);
		
		
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
