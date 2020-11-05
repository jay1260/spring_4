package com.it.gb4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Subway {
	
	public void buyBBang() {
		System.out.println("빵 구매");
	}

	public void takeSubway() {
		System.out.println("====================");
		System.out.println("지하철 자리 찾기");
		System.out.println("지하철에서 드라마 보기");
		System.out.println("====================");
	}
	
}
