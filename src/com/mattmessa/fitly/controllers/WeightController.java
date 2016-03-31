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

import com.mattmessa.fitly.dao.Weight;
import com.mattmessa.fitly.service.WeightService;

@Controller
public class WeightController {
	
	private WeightService weightsService;
	
	@Autowired
	public void setWeightsService(WeightService weightsService) {
		this.weightsService = weightsService;
	}
	
	@RequestMapping("/createweight")
	public String createWeight(Model model, HttpServletRequest request) {
	
		Weight weight = new Weight();
		model.addAttribute("weight", weight);
		
		return "createweight";
	}
	
	@RequestMapping(value="/docreateweight", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Weight weight, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(result.hasErrors()) {
			return "createweight";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		weight.setUserId(userId);
		
		System.out.printf("userId = %d\n", userId);
		weightsService.saveOrUpdate(weight);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/editweight") 
	public String showEditWeight(Model model, HttpServletRequest request){
		
		int userId = (int)request.getSession().getAttribute("userId");
		Weight weight = weightsService.getWeight(userId);
		System.out.printf("userId =  %d\n", weight.getUserId());
		model.addAttribute("weight", weight);
			
		return "editweight";
	}
	
}
