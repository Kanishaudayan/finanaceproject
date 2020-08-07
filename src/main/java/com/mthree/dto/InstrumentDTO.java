package com.mthree.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InstrumentDTO implements Serializable{

	private int instrumentId; 
	private String instrumentName;
	private String marketCap;
	private double price;
	public InstrumentDTO(int instrumentId, String instrumentName, String marketCap, double price) {
		super();
		this.instrumentId = instrumentId;
		this.instrumentName = instrumentName;
		this.marketCap = marketCap;
		this.price = price;
	}
	@Override
	public String toString() {
		return "InstrumentDTO [instrumentId=" + instrumentId + ", instrumentName=" + instrumentName + ", marketCap="
				+ marketCap + ", price=" + price + "]";
	}
	
	
	
}
