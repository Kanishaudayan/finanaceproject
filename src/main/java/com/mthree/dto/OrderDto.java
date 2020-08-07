package com.mthree.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mthree.entity.Instrument;
import com.mthree.entity.OrderBook;
import com.mthree.entity.User;

public class OrderDto {
	
	private int orderId; 
	
    private int quantity; 
	
    private double price; 
	
    private String status; 
		

	private String orderType;
	
	private int stocksToBeTraded;
	
	@JsonBackReference
	private OrderBook orderBookId; 
	@JsonBackReference
	private User userId;
	@JsonBackReference
	private Instrument instrumentId;

	public int getOrderId() {
		return orderId;
	}

	public OrderDto(int orderId, int quantity, double price, String status, String orderType, int stocksToBeTraded,
			OrderBook orderBookId, User userId, Instrument instrumentId) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.orderType = orderType;
		this.stocksToBeTraded = stocksToBeTraded;
		this.orderBookId = orderBookId;
		this.userId = userId;
		this.instrumentId = instrumentId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getStocksToBeTraded() {
		return stocksToBeTraded;
	}

	public void setStocksToBeTraded(int stocksToBeTraded) {
		this.stocksToBeTraded = stocksToBeTraded;
	}

	public OrderBook getOrderBookId() {
		return orderBookId;
	}

	public void setOrderBookId(OrderBook orderBookId) {
		this.orderBookId = orderBookId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Instrument getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Instrument instrumentId) {
		this.instrumentId = instrumentId;
	}

	

	
}
