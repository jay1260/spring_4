package com.it.gb4.transfer;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.gb4.MyTestCase;
import com.it.gb4.card.Card;

public class TransferTest extends MyTestCase {

	@Autowired
	private Bus bus;
	
	@Autowired
	private Taxi taxi;
	
	@Autowired
	private Subway subway;
	
	//@Autowired
	private Card card;
	
	@Test
	public void test() {
		
		bus.takeBus(30,"bus");
		
		
		subway.takeSubway();
		
		taxi.getTaxi();
	}

}
