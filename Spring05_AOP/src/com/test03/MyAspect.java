package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("zoom�� �����ؼ� qr�� ��´�.");
	}
	
	public void after() {
		System.out.println("zoom�� �����Ѵ�.");
	}
}
