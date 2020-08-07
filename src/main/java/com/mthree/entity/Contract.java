package com.mthree.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="contract")
public class Contract {
	
	@Id
	@GeneratedValue
    @Column(name="contract_id")
    private int contractId; 
	
    @Column(name="contract_Name")
    private String contractName; 
    
    @Column(name="contract_startdate")
	private Date startDate;
    
    @Column(name="contract_enddate")
	private Date endDate;
	
    @ManyToOne
	@JoinColumn(name = "instrument_id")
	@JsonBackReference
	private Instrument instrumentId;

    public Contract() {}

	public Contract(int contractId, String contractName, Date startDate, Date endDate, Instrument instrumentId) {
		super();
		this.contractId = contractId;
		this.contractName = contractName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instrumentId = instrumentId;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Instrument getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Instrument instrumentId) {
		this.instrumentId = instrumentId;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractName=" + contractName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", instrumentId=" + instrumentId + "]";
	}
    
	
	
}
