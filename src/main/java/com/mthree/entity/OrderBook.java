package com.mthree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="orderbook")
public class OrderBook {

	@Id
	@GeneratedValue
    @Column(name="orderbook_id")
    private int orderBookId; 
	
	@OneToMany(mappedBy = "orderBookId",fetch = FetchType. EAGER)
    private List<Order> orders = new ArrayList<>();
	
	@OneToOne(mappedBy="orderBook")
    private Instrument instrument;
	 
	@ManyToOne(fetch = FetchType. EAGER)
	@JoinColumn(name = "exchange_id")
	@JsonBackReference
	private Exchange exchangeId;

	public OrderBook() {}

	public OrderBook(int orderBookId) {
		super();
		this.orderBookId = orderBookId;
	}
	public OrderBook(int orderBookId,Exchange exchangeId) {
		super();
		this.orderBookId = orderBookId;
		this.exchangeId = exchangeId;
	}

	public OrderBook(int orderBookId, List<Order> orders, Instrument instrument, Exchange exchangeId) {
		super();
		this.orderBookId = orderBookId;
		this.orders = orders;
		this.instrument = instrument;
		this.exchangeId = exchangeId;
	}

	public int getOrderBookId() {
		return orderBookId;
	}

	public void setOrderBookId(int orderBookId) {
		this.orderBookId = orderBookId;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Exchange getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(Exchange exchangeId) {
		this.exchangeId = exchangeId;
	}

//	@Override
//	public String toString() {
//		return "OrderBook [orderBookId=" + orderBookId + ", orders=" + orders + ", instrument=" + instrument
//				+ ", exchangeId=" + exchangeId + "]";
//	}
	
	
}
