package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Woman w = factory.getBean("woman", Woman.class);
		Man m = factory.getBean("man",Man.class);
		
		System.out.println("�缺�� ����!");
		w.classWork();
		System.out.println("-------");
		System.out.println("�̿��� ����");
		m.classWork();
	}

}