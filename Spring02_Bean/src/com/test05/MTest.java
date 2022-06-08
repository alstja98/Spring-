package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		Emp hong = factory.getBean("hong", Emp.class);
		System.out.println(hong);
		
		Emp lee = factory.getBean("lee", Emp.class);
		System.out.println(lee);
	}

}
