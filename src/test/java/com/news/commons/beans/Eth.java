package com.news.commons.beans;

import java.sql.Timestamp;

public class Eth {
	
	private Integer id;
	private Double ask;
	private Double bid;
	private Timestamp insertDate;
	
	public Eth() {
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getAsk() {
		return ask;
	}


	public void setAsk(Double ask) {
		this.ask = ask;
	}


	public Double getBid() {
		return bid;
	}


	public void setBid(Double bid) {
		this.bid = bid;
	}


	public Eth(Double ask, Double bid) {
		this.ask=ask;
		this.bid=bid;
		
	}


	public Timestamp getInsertDate() {
		return insertDate;
	}


	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}
	


}
	
	