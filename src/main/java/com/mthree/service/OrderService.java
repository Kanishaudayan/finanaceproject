package com.mthree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.dto.OrderDto;
import com.mthree.entity.Instrument;
import com.mthree.entity.Order;
import com.mthree.entity.OrderBook;
import com.mthree.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public List<Order> getOrdersFromOrderBook(String orderType, int instrumentId, int orderBookId, String status){
		return orderRepo.getOrdersFromOrderBook(orderType, instrumentId, orderBookId,status);
	}
	
	
	public Order saveNewOrder(Order o) {
		return orderRepo.save(o);
	}
	
	public int changeOrderStatus(int orderId, String status) {
		return orderRepo.setOrderStatus(orderId, status);
	}
	
	public int changeQuantity(int orderId, int quantity) {
		return orderRepo.setRemainingQuantity(orderId, quantity);
	}
	
//	public int changeOrderBookId(int orderId, int orderBookId) {
//		return orderRepo.updateOrderBookId(orderId, orderBookId);
//	}
}