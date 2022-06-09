package com.test09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test09.TV;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test09/applicationContext.xml");
		System.out.println("spring bean container 积己 肯丰");
		
		System.out.println("getBean积己 傈");
		TV tv = (TV)factory.getBean("samsung");
		System.out.println("getBean 积己 饶");
		tv.powerOff();
		tv.volUp();
		tv.volDown();
		tv.powerOn();
	}

}
