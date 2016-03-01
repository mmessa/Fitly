package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.dao.UserDAO;

@Service("fitlyService")
public class FitlyService {
	
	private UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> getCurrent()
	{
		return userDAO.getUsers();
	}
}
