	package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Man m = factory.getBean("man",Man.class);
		Woman w = factory.getBean("woman", Woman.class);
		
		System.out.println("�̿��� ����!");
		m.classWork();
		System.out.println("=======");
		System.out.println("�缺�� ����");
		w.classWork();
	}

}
