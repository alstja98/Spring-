package com.test08;

public class MTest {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		
		TV tv = (TV) factory.getBean("samsung");
		
		tv.powerOff();
		tv.volUp();
		tv.volDown();
		tv.powerOn();
	}

}
