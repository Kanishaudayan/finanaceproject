package com.mthree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.entity.Exchange;
import com.mthree.entity.Instrument;
import com.mthree.entity.Order;
import com.mthree.entity.OrderBook;
import com.mthree.entity.User;
import com.mthree.service.FeeLadderService;

@SpringBootTest
public class FeeLadderTest {
	@Autowired
	private FeeLadderService feeLadder;
	
	@Test
	void findNSEFee() {
		Instrument i1=new Instrument(1,"TATA Motors", "III.L", "IN9155A01020","B02ZP96","876568601","III:LN","XLOM","(null)","low",94.1);
		User u1=new User(1,"user1","12345","user1@gmail.com");
		Exchange e=new Exchange(1,"NSE",54201.79,"India");
		OrderBook o1=new OrderBook(1,e);
		Order or=new Order(1, 20, 100.56, "new", "buy",o1,u1,i1);
		double actual=feeLadder.findFeeForExchange(e.getExchangeId(), or);
		assertEquals(123.4,actual);
	}
	@Test
	void findNSEFeeabove100() {
		Instrument i1=new Instrument(1,"TATA Motors", "III.L", "IN9155A01020","B02ZP96","876568601","III:LN","XLOM","(null)","low",94.1);
		User u1=new User(1,"user1","12345","user1@gmail.com");
		Exchange e=new Exchange(1,"NSE",54201.79,"India");
		OrderBook o1=new OrderBook(1,e);
		Order or=new Order(1, 300, 100.56, "new", "buy",o1,u1,i1);
		double actual=feeLadder.findFeeForExchange(e.getExchangeId(), or);
		assertEquals(436.7,actual);
	}
	
	@Test
	void findBSEFee() {
		Instrument i1=new Instrument(1,"TATA Motors", "III.L", "IN9155A01020","B02ZP96","876568601","III:LN","XLOM","(null)","low",94.1);
		User u1=new User(1,"user1","12345","user1@gmail.com");
		Exchange e=new Exchange(2,"BSE",33228.8,"Mumbai");
		OrderBook o1=new OrderBook(2,e);
		Order or=new Order(1, 20, 500.56, "new", "buy",o1,u1,i1);
		double actual=feeLadder.findFeeForExchange(e.getExchangeId(), or);
		assertEquals(95.4,actual);
	}
	@Test
	void findBSEFeeabove500() {
		Instrument i1=new Instrument(1,"TATA Motors", "III.L", "IN9155A01020","B02ZP96","876568601","III:LN","XLOM","(null)","low",94.1);
		User u1=new User(1,"user1","12345","user1@gmail.com");
		Exchange e=new Exchange(2,"BSE",33228.8,"Mumbai");
		OrderBook o1=new OrderBook(2,e);
		Order or=new Order(1, 501, 500.56, "new", "buy",o1,u1,i1);
		double actual=feeLadder.findFeeForExchange(e.getExchangeId(), or);
		assertEquals(456.7,actual);
	}



}
