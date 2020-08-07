package com.mthree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sort")
public class Sort {
	
	@Id
	@GeneratedValue
    @Column(name="sort_id")
    private int sortId; 
	
	@Column(name="region", unique = true)
    private String region;
	
//	@OneToMany(mappedBy = "region")
//	private List<Exchange> exchanges = new ArrayList<>();
	
	public Sort() {}

	public Sort(int sortId, String region) {
		super();
		this.sortId = sortId;
		this.region = region;
		//this.exchanges = exchanges;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

//	public List<Exchange> getExchanges() {
//		return exchanges;
//	}
//
//	public void setExchanges(List<Exchange> exchanges) {
//		this.exchanges = exchanges;
//	}

	@Override
	public String toString() {
		return "Sort [sortId=" + sortId + ", region=" + region + "]";
	}

	
	
}
