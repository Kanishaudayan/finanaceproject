package com.mthree.restcontroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.AlgoEngine.AlgoEngine;
import com.mthree.entity.Instrument;
import com.mthree.entity.Order;
import com.mthree.entity.OrderBook;
import com.mthree.entity.User;
import com.mthree.repository.InstrumentRepository;
import com.mthree.repository.OrderBookRepository;
import com.mthree.repository.OrderRepository;
import com.mthree.service.OrderService;
import com.mthree.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderRestController {

	@Autowired
	private OrderService orderServ;
	
	private OrderBook o = new OrderBook(); 
	@Autowired
	private AlgoEngine ae;
	@Autowired
	public InstrumentRepository is;
	@Autowired
	public OrderRepository or;
	@Autowired
	public UserService	us;
	@Autowired
	public OrderBookRepository ob;
	@PostMapping(path="/placeOrder", consumes="application/json", produces="application/json") 
	public Order addNewOrder(@RequestBody Map<String, String> params) {
		User u=us.getUserByUserName("user1");
		OrderBook o=ob.getOne(0);
		Instrument i=is.getInstrument(Integer.parseInt(params.get("instrumentId")));
		Order order = new Order(Integer.parseInt(params.get("quantity")),Double.parseDouble(params.get("price")),"new",params.get("orderType"),o,u,i); 
		//order.setOrderId(14);
		System.out.println(order);
		return orderServ.saveNewOrder(order);	
	}
	
	@PostMapping("/getSellOrders")
	public List<Order> getSellOrders(@RequestBody Map<String,String> param){
		List<Order> allOrders = new ArrayList<>();
		List<Order> orders = new ArrayList<>();
		int a=Integer.parseInt(param.get("instrumentId"));
		orders = orderServ.getOrdersFromOrderBook("sell", a,0,"inprogress");
		for(Order o : orders)
			allOrders.add(o);
		orders = orderServ.getOrdersFromOrderBook("sell", a,0,"new");
		for(Order o: orders)
			allOrders.add(o);
		Collections.sort(allOrders, new Comparator<Order>() { 
            public int compare(Order o1,  
                               Order o2) 
            { 
                return ((Double)o1.getPrice()).compareTo(o2.getPrice()); 
            } 
        });
		return allOrders;
	}
	
	@PostMapping("/getBuyOrders")
	public List<Order> getBuyOrders(@RequestBody Map<String,String> param){
		List<Order> allOrders = new ArrayList<>();
		List<Order> orders = new ArrayList<>();
		int a=Integer.parseInt(param.get("instrumentId"));
		orders = or.getBuyOrdersFromOrderBook("buy", a,0,"inprogress");
		for(Order o : orders)
			allOrders.add(o);
		orders = or.getBuyOrdersFromOrderBook("buy", a,0,"new");
		for(Order o: orders)
			allOrders.add(o);
		Collections.sort(allOrders, new Comparator<Order>() { 
            public int compare(Order o1,  
                               Order o2) 
            { 
                return ((Double)o2.getPrice()).compareTo(o1.getPrice()); 
            } 
        });
		return allOrders;
	}
	@PostMapping("/pushToAlgo")
	public void pushToAlgo(@RequestBody Map<String,String> param) {
		int a=Integer.parseInt(param.get("orderId"));
		int n=ae.pushToAlgoEngine(a);
		or.updateOrderBookByIdInOrder(a, n);
		System.out.println("updated :"+n);
		Order o= or.getOne(a);
		Instrument insId=o.getInstrumentId();
		ae.matchBuyersAndSellers(insId.getInstrumentId(),n);
	}
	@PostMapping("/getInstrument")
	public Instrument getInstrument(@RequestBody Map<String,String> param) {
		return is.getInstrument(Integer.parseInt(param.get("instrumentId")));
	}
	
}
