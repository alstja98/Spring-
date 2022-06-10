package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Person w = factory.getBean("woman", Person.class);
		Person m = factory.getBean("man", Person.class);
		
		System.out.println("양성희입장");
		w.classWork();
		System.out.println("-------");
		System.out.println("이영재입장");
		m.classWork();
	}

}
