package com.mattmessa.fitly;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.dao.UserDAO;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/mattmessa/fitly/beans/beans.xml");
		
		UserDAO userDao = (UserDAO)context.getBean("UserDAO"); 
		
		List<User> users = userDao.getUsers();
		
		for (User user: users)
		{
			System.out.println(user);
		}
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
