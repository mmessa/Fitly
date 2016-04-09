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

import com.mattmessa.fitly.dao.Update;
import com.mattmessa.fitly.service.UpdateService;

@Controller
public class UpdateController {

private UpdateService updatesService;
	
	@Autowired
	public void setUpdatesService(UpdateService updatesService) {
		this.updatesService = updatesService;
	}
	
	@RequestMapping("/createupdate")
	public String createUpdate(Model model, HttpServletRequest request) {
	
		Update update = new Update();
		model.addAttribute("update", update);
		
		return "createupdate";
	}
	
	@RequestMapping(value="/docreateupdate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Update update, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(result.hasErrors()) {
			return "createupdate";
		}
		
		int userId = (int)request.getSession().getAttribute("userId");
		
		update.setUserId(userId);
		
		System.out.printf("userId = %d\n", userId);
		updatesService.saveOrUpdate(update);
		
		response.sendRedirect("profile");
		
		return "profile";
	}
	
	@RequestMapping("/editupdate") 
	public String showEditUpdate(Model model, HttpServletRequest request){
		
		int userId = (int)request.getSession().getAttribute("userId");
		Update update = updatesService.getUpdate(userId);
		System.out.printf("userId =  %d\n", update.getUserId());
		model.addAttribute("update", update);
			
		return "editupdate";
	}
}
