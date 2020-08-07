package com.mthree.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="instrument")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Instrument implements Serializable{
	@Id
	@GeneratedValue
    @Column(name="instrument_id")
    private int instrumentId; 
	
	 @Column(name="instrument_name")
	 private String instrumentName;
	 
	 @Column(name="instrument_ric")
	 private String ric;
	 
	 @Column(name="instrument_isin")
	 private String isin;
	 
	 @Column(name="instrument_sedol")
	 private String sedol;
	 
	 @Column(name="instrument_cusip")
	 private String cusip;
	 
	 @Column(name="instrument_bbid")
	 private String bbid;
	 
	 @Column(name="instrument_mic")
	 private String mic;
	 
	 @Column(name="instrument_cik")
	 private String cik;
	 
	 @Column(name="instrument_marketCap")
	 private String marketCap;
	 
	 @Column
	 private double price;
	 
	 @OneToOne
	 @JoinColumn(name = "orderbook_id")
	 @JsonBackReference
	 private OrderBook orderBook;
	 
	 @OneToMany(mappedBy = "instrumentId")
	 @JsonBackReference
	 private List<Order> orders = new ArrayList<>();
	 
	 @OneToMany(mappedBy ="instrumentId")
	 @JsonBackReference
	 private List<Contract> contracts = new ArrayList<>();
	 
	 public Instrument() {}
	 public Instrument(int instrumentId, String instrumentName, String ric, String isin, String sedol, String cusip,
				String bbid, String mic, String cik, String marketCap, double price) {
		 super();
			this.instrumentId = instrumentId;
			this.instrumentName = instrumentName;
			this.ric = ric;
			this.isin = isin;
			this.sedol = sedol;
			this.cusip = cusip;
			this.bbid = bbid;
			this.mic = mic;
			this.cik = cik;
			this.marketCap = marketCap;
			this.price = price;
	 }
	 
	public Instrument(int instrumentId, String instrumentName, String ric, String isin, String sedol, String cusip,
			String bbid, String mic, String cik, String marketCap, double price, OrderBook orderBook,
			List<Order> orders, List<Contract> contracts) {
		super();
		this.instrumentId = instrumentId;
		this.instrumentName = instrumentName;
		this.ric = ric;
		this.isin = isin;
		this.sedol = sedol;
		this.cusip = cusip;
		this.bbid = bbid;
		this.mic = mic;
		this.cik = cik;
		this.marketCap = marketCap;
		this.price = price;
		this.orderBook = orderBook;
		this.orders = orders;
		this.contracts = contracts;
	}


	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getRic() {
		return ric;
	}

	public void setRic(String ric) {
		this.ric = ric;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getSedol() {
		return sedol;
	}

	public void setSedol(String sedol) {
		this.sedol = sedol;
	}

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	public String getBbid() {
		return bbid;
	}

	public void setBbid(String bbid) {
		this.bbid = bbid;
	}

	public String getMic() {
		return mic;
	}

	public void setMic(String mic) {
		this.mic = mic;
	}

	public String getCik() {
		return cik;
	}

	public void setCik(String cik) {
		this.cik = cik;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderBook getOrderBook() {
		return orderBook;
	}

	public void setOrderBook(OrderBook orderBook) {
		this.orderBook = orderBook;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

//	@Override
//	public String toString() {
//		return "Instrument [instrumentId=" + instrumentId + ", instrumentName=" + instrumentName + ", ric=" + ric
//				+ ", isin=" + isin + ", sedol=" + sedol + ", cusip=" + cusip + ", bbid=" + bbid + ", mic=" + mic
//				+ ", cik=" + cik + ", marketCap=" + marketCap + ", price=" + price + ", orderBook=" + orderBook
//				+ ", orders=" + orders + ", contracts=" + contracts + "]";
//	}

	 
	 	

}
