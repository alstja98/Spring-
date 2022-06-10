package com.edu.main;

import com.edu.entity.Shape;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/edu/main/applicationContext.xml");
		Shape rect = factory.getBean("rect", Shape.class);
		Shape tri = factory.getBean("rect", Shape.class);
		
		rect.viewSize();
		System.out.println("========");
		tri.viewSize();
	}

}
