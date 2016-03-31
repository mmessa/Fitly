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

import com.mattmessa.fitly.dao.Supplement;
import com.mattmessa.fitly.service.SupplementService;

@Controller
public class SupplementController {
	
	private SupplementService supplementsService;
	
	@Autowired
	public void setSupplementsService(SupplementService supplementsService) {
		this.supplementsService = supplementsService;
	}
	
	@RequestMapping("/createsupplement")
	public String createSupplement(Model model, HttpServletRequest request) {
	
		Supplement supplement = new Supplement();
		model.addAttribute("supplement", supplement);
		
		return "createsupplement";
	}
	
	@RequestMapping(value="/docreatesupplement", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Supplement supplement, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(result.hasErrors()) {
			return "createsupplement";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		supplement.setUserId(userId);
		
		System.out.printf("userId = %d\n", userId);
		supplementsService.saveOrUpdate(supplement);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/editsupplement") 
	public String showEditSupplement(Model model, HttpServletRequest request){
		
		int userId = (int)request.getSession().getAttribute("userId");
		Supplement supplement = supplementsService.getSupplement(userId);
		System.out.printf("userId =  %d\n", supplement.getUserId());
		model.addAttribute("supplement", supplement);
			
		return "editsupplement";
	}
}
