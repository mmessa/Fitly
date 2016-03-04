package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.dao.UserDao;

@Service("usersService")
public class UsersService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDAO(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void create(User user){
		userDao.create(user);
	}
	
	
	public List<User> getCurrent()
	{
		return userDao.getUsers();
	}
	
}
