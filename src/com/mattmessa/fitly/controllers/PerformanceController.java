package com.mattmessa.fitly.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String doCreate(Model model, @Valid Performance performance, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(result.hasErrors()) {
			return "createperformance";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		performance.setUserId(userId);
		
		System.out.printf("userId = %d\n", userId);
		performancesService.create(performance);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/deleteperformance") 
	public String deletePerformance(Model model, HttpServletRequest request){
		
		int performanceId = Integer.parseInt(request.getParameter("performanceId"));
		performancesService.deletePerformance(performanceId);
		
		return "redirect:profile";
	}
}
