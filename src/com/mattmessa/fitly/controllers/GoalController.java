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

import com.mattmessa.fitly.dao.Goal;
import com.mattmessa.fitly.service.GoalService;

@Controller
public class GoalController {
	
	private GoalService goalsService;

	@Autowired
	public void setGoalsService(GoalService goalsService) {
		this.goalsService = goalsService;
	}
	
	@RequestMapping("/creategoal")
	public String createGoal(Model model, HttpServletRequest request) {
	
		Goal goal = new Goal();
		int goalId = 0;
		
		if (request.getParameter("goalId") != null)
		{
			goalId = Integer.parseInt(request.getParameter("goalId"));
		}
		if (goalId != 0)
		{
			goal = goalsService.getGoal(goalId);
		}
		
		model.addAttribute("goal", goal);
		
		return "creategoal";
	}
	
	@RequestMapping(value="/docreategoal", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Goal goal, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(result.hasErrors()) {
			return "creategoal";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		goal.setUserId(userId);
		
		System.out.printf("userId = %d\n", userId);
		goalsService.saveOrUpdate(goal);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/editgoal") 
	public String showEditGoal(Model model, HttpServletRequest request){
		
		int userId = (int)request.getSession().getAttribute("userId");
		Goal goal = goalsService.getGoal(userId);
		System.out.printf("userId =  %d\n", goal.getUserId());
		model.addAttribute("goal", goal);
			
		return "editgoal";
	}
	
	@RequestMapping("/deletegoal") 
	public String deleteGoal(Model model, HttpServletRequest request){
		
		int goalId = Integer.parseInt(request.getParameter("goalId"));
		goalsService.deleteGoal(goalId);
		
		return "redirect:profile";
	}
}
