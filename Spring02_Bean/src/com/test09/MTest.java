package com.test09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test09.TV;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test09/applicationContext.xml");
		System.out.println("spring bean container ���� �Ϸ�");
		
		System.out.println("getBean���� ��");
		TV tv = (TV)factory.getBean("samsung");
		System.out.println("getBean ���� ��");
		tv.powerOff();
		tv.volUp();
		tv.volDown();
		tv.powerOn();
	}

}
