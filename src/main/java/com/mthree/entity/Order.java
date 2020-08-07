package com.mthree.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="order_table")
@Proxy(lazy=false)
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId; 
	
	@Column(name="order_quantity")
    private int quantity; 
	
	@Column(name="order_price")
    private double price; 
	
	@Column(name="order_status")
    private String status; 
		
	@Column(name = "order_type")
	private String orderType;
	
	@Column()
	private int stocksToBeTraded;
	
	@ManyToOne(fetch = FetchType. EAGER)
    @JoinColumn(name="orderbook_id")
	@JsonBackReference
    private OrderBook orderBookId; 
	
	@ManyToOne(fetch = FetchType. EAGER)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "instrument_id")
	@JsonBackReference
	private Instrument instrumentId;

	public Order() {}
	
	
	
	public Order(int orderId, int quantity, double price, String status, String orderType, OrderBook orderBookId,
			User userId, Instrument instrumentId) {
		super();
		//this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.status = "new";
		this.orderType = orderType;
		this.orderBookId = orderBookId;
		this.userId = userId;
		this.instrumentId = instrumentId;
		this.stocksToBeTraded = quantity;
	}
	
	

//	public Order(int quantity, double price, String orderType) {
//		super();
//		this.quantity = quantity;
//		this.price = price;
//		this.status = "new";
//		this.orderType = orderType;
//		this.stocksToBeTraded = quantity;
//		//this.orderBookId.setOrderBookId(0);
//		//this.instrumentId.setInstrumentId(instrumentId);
//	}



	public Order(int quantity, double price, String status, String orderType,
			OrderBook orderBookId, User userId, Instrument instrumentId) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.orderType = orderType;
		this.stocksToBeTraded = quantity;
		this.orderBookId = orderBookId;
		this.userId = userId;
		this.instrumentId = instrumentId;
	}



	public Order(String orderType, int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.orderType = orderType;
		this.stocksToBeTraded=quantity;
	}



	public int getOrderId() {
		return orderId;
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

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", price=" + price + ", status=" + status
				+ ", orderType=" + orderType + ", stocksToBeTraded=" + stocksToBeTraded + "]";
	}

	
}