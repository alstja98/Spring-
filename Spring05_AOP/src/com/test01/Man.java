package com.test01;

public class Man {
	public void classWork() {
		System.out.println("zoom에 접속해서 qr을 찍는다.");
		
		try {
			System.out.println("침대에 눕는다.");
		}catch(Exception e) {
			System.out.println("쉬는 날이었다.");
		}finally {
			System.out.println("zoom을 종료한다.");
		}
	}
}
