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

import com.mattmessa.fitly.dao.BodyFat;
import com.mattmessa.fitly.service.BodyFatService;

@Controller
public class BodyFatController {

	private BodyFatService bodyFatsService;

	@Autowired
	public void setBodyFatsService(BodyFatService bodyFatsService) {
		this.bodyFatsService = bodyFatsService;
	}
	
	@RequestMapping("/createbodyFat")
	public String createBodyFat(Model model, HttpServletRequest request) {
	
		BodyFat bodyFat = new BodyFat();
		model.addAttribute("bodyFat", bodyFat);
		
		return "createbodyFat";
	}
	
	@RequestMapping(value="/docreatebodyFat", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid BodyFat bodyFat, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(result.hasErrors()) {
			return "createbodyFat";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		bodyFat.setUserId(userId);
		
		System.out.printf("userId = %d\n", userId);
		bodyFatsService.saveOrUpdate(bodyFat);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/editbodyFat") 
	public String showEditBodyFat(Model model, HttpServletRequest request){
		
		int userId = (int)request.getSession().getAttribute("userId");
		BodyFat bodyFat = bodyFatsService.getBodyFat(userId);
		System.out.printf("userId =  %d\n", bodyFat.getUserId());
		model.addAttribute("bodyFat", bodyFat);
			
		return "editbodyFat";
	}
}
