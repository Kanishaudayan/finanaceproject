package com.mthree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.entity.Instrument;
import com.mthree.entity.Order;
import com.mthree.entity.User;
import com.mthree.repository.OrderRepository;
import com.mthree.entity.OrderBook;
import com.mthree.entity.User;
import com.mthree.service.OrderService;

@SpringBootTest
public class OrderTest {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderRepository ordRep;
	@Test
	void getOrderstypeBuy() {
		Order expectedorders=ordRep.getOne(19);
		Instrument i1=new Instrument(1,"TATA Motors", "III.L", "IN9155A01020","B02ZP96","876568601","III:LN","XLOM","(null)","low",94.1);
		User u1=new User(1,"user1","12345","user1@gmail.com");
		OrderBook o1=new OrderBook(0);
		Order or=new Order(19,20, 23, "new", "buy",o1,u1,i1);
//		System.out.println(or.toString());
//		System.out.println(expectedorders.toString());
		assertEquals(or.toString(),expectedorders.toString());
		
	}
	
	@Test
	void addOrder() {
		OrderBook o1=new OrderBook(0);
		User u1=new User(1,"user1","12345","user1@gmail.com");
		Instrument i1=new Instrument(1,"TATA Motors", "III.L", "IN9155A01020","B02ZP96","876568601","III:LN","XLOM","(null)","low",94.1);
		Order o=new Order(12,20, 95.6, "new", "buy", o1,u1,i1);
		Order expected=orderService.saveNewOrder(o);
//		System.out.println(expected.toString());
		assertEquals(o.toString(),expected.toString());
		
		
	}
}
