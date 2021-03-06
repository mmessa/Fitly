package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.dao.UserDao;

@Service("usersService")
public class UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void create(User user){
		userDao.create(user);
	}
	
	
	public List<User> getUsers()
	{
		return userDao.getUsers();
	}
	
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	public boolean exists(String username) {
		// TODO Auto-generated method stub
		return userDao.exists(username);
	}
	
}
