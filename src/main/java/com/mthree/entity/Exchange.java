package com.mthree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="exchange")
public class Exchange {
	
	@Id
	@GeneratedValue
    @Column(name="exchange_id")
    private int exchangeId; 
	
	@Column(name="exchange_name")
    private String exchangeName;
	
	@Column(name= "trade_value")
	private double tradeValue;
	
//	@ManyToOne
//	@JoinColumn(name = "region")
//	@JsonBackReference
	
	private String region;
	
	@OneToMany(mappedBy = "exchangeId")
    private List<OrderBook> orderBooks = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "feeladder_id")
	private FeeLadder feeLadder;
	
	public Exchange() {}

	public Exchange(int exchangeId, String exchangeName, double tradeValue, String region) {
		super();
		this.exchangeId = exchangeId;
		this.exchangeName = exchangeName;
		this.tradeValue = tradeValue;
		this.region = region;
	}
	public Exchange(int exchangeId, String exchangeName, double tradeValue, String region, List<OrderBook> orderBooks,
			FeeLadder feeLadder) {
		super();
		this.exchangeId = exchangeId;
		this.exchangeName = exchangeName;
		this.tradeValue = tradeValue;
		this.region = region;
		this.orderBooks = orderBooks;
		this.feeLadder = feeLadder;
	}

	public int getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public double getTradeValue() {
		return tradeValue;
	}

	public void setTradeValue(double tradeValue) {
		this.tradeValue = tradeValue;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<OrderBook> getOrderBooks() {
		return orderBooks;
	}

	public void setOrderBooks(List<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}

	public FeeLadder getFeeLadder() {
		return feeLadder;
	}

	public void setFeeLadder(FeeLadder feeLadder) {
		this.feeLadder = feeLadder;
	}

	@Override
	public String toString() {
		return "Exchange [exchangeId=" + exchangeId + ", exchangeName=" + exchangeName + ", tradeValue=" + tradeValue
				+ ", region=" + region + ", orderBooks=" + orderBooks + ", feeLadder=" + feeLadder + "]";
	}


	
}
