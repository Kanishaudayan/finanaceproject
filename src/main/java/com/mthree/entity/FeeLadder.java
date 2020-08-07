package com.mthree.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="feeladder")
public class FeeLadder {
	
	@Id
	@GeneratedValue
	@Column(name="feeladder_id")
	private int id;
	
	@Column(name= "below100")
	private double below100;
	@Column(name = "below500")
	private double below500;
	@Column(name = "above500")
	private double above500;
	
	@OneToOne(mappedBy="feeLadder")
    private Exchange exchange;
	
	public FeeLadder() {}

	public FeeLadder(int id, double below100, double below500, double above500, Exchange exchange) {
		super();
		this.id = id;
		this.below100 = below100;
		this.below500 = below500;
		this.above500 = above500;
		this.exchange = exchange;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBelow100() {
		return below100;
	}

	public void setBelow100(double below100) {
		this.below100 = below100;
	}

	public double getBelow500() {
		return below500;
	}

	public void setBelow500(double below500) {
		this.below500 = below500;
	}

	public double getAbove500() {
		return above500;
	}

	public void setAbove500(double above500) {
		this.above500 = above500;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public String toString() {
		return "FeeLadder [id=" + id + ", below100=" + below100 + ", below500=" + below500 + ", above500=" + above500
				+ ", exchange=" + exchange + "]";
	}

	

}
