package com.kz.entity;

import java.util.Date;

public class orders {
	private int ordered;                
	private String custname;            
	private String prodname;              
	private double ordercount;             
	private Date orderdate;
	public orders(int ordered, String custname, String prodname,
			double ordercount, Date orderdate) {
		super();
		this.ordered = ordered;
		this.custname = custname;
		this.prodname = prodname;
		this.ordercount = ordercount;
		this.orderdate = orderdate;
	}
	public orders() {
		super();
	}
	public int getOrdered() {
		return ordered;
	}
	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public double getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(double ordercount) {
		this.ordercount = ordercount;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	@Override
	public String toString() {
		return "orders [custname=" + custname + ", ordercount=" + ordercount
				+ ", orderdate=" + orderdate + ", ordered=" + ordered
				+ ", prodname=" + prodname + "]";
	}
}
