package com.mattmessa.fitly;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/mattmessa/fitly/beans/beans.xml");
		
		context.close();
	}

}
