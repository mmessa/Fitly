package com.mattmessa.fitly.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.service.UserService;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	private UserService usersService;
	
	@Autowired
	public void setUsersService(UserService usersService) {
		this.usersService = usersService;
	}
	
	//private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails =  (UserDetails) authentication.getPrincipal();
	    String username = userDetails.getUsername();
	    
		User user = usersService.getUser(username);
		request.getSession().setAttribute("userId", user.getUserId());
		//request.getRequestDispatcher(arg0)
		//String targetUrl = request.getRequestURL().toString();
		String targetUrl = "profile";
		response.sendRedirect(targetUrl);
        /*Set target URL to redirect*/
		//String targetUrl = determineTargetUrl(authentication); 
        //redirectStrategy.sendRedirect(request, response, targetUrl);
		
	}
	/*
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
 
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	*/
}
