package com.it.gb4.card;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {

	@After("execution(* com.it.gb4.transfer.Taxi.get*())")
	public void cardCheck() {
		System.out.println("카드 찍기");
		System.out.println("마스크를 착용하세요.");
	}
	
	@Around("execution(* com.it.gb4.transfer.*.take*(..))")
	public Object transferCard(ProceedingJoinPoint join) {
		System.out.println("승차전 카드 찍기");
		
		Object obj = null;
		
		try {
			Object[] ar = join.getArgs();
			
			for(Object o : ar) {
				System.out.println(o);
			}
			
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("하차전 카드 찍기");
		
		return obj;
	}
}
