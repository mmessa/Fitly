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
	
	@RequestMapping("/createbodyfat")
	public String createBodyFat(Model model, HttpServletRequest request) {
	
		BodyFat bodyFat = new BodyFat();
		int bodyFatId = 0;
		
		if (request.getParameter("bodyFatId") != null)
		{
			bodyFatId = Integer.parseInt(request.getParameter("bodyFatId"));
		}
		if (bodyFatId != 0)
		{
			bodyFat = bodyFatsService.getBodyFat(bodyFatId);
		}
		
		model.addAttribute("bodyFat", bodyFat);
		
		return "createbodyfat";
	}
	
	@RequestMapping(value="/docreatebodyfat", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid BodyFat bodyFat, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(result.hasErrors()) {
			return "createbodyfat";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		bodyFat.setUserId(userId);
		
		System.out.printf("userId = %d\n", userId);
		bodyFatsService.saveOrUpdate(bodyFat);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/deletebodyfat") 
	public String deleteBodyFat(Model model, HttpServletRequest request){
		
		int bodyFatId = Integer.parseInt(request.getParameter("bodyFatId"));
		bodyFatsService.deleteBodyFat(bodyFatId);
		
		return "redirect:profile";
	}
}
