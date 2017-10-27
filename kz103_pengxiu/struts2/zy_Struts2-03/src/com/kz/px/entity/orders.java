package com.kz.px.entity;

public class orders {
	private Integer ordered;
	private String custname;
	private String prodname;
	private Integer ordercount;
	private String orderdate;
	public orders(Integer ordered, String custname, String prodname,
			Integer ordercount, String orderdate) {
		super();
		this.ordered = ordered;
		this.custname = custname;
		this.prodname = prodname;
		this.ordercount = ordercount;
		this.orderdate = orderdate;
	}
	public orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getOrdered() {
		return ordered;
	}
	public void setOrdered(Integer ordered) {
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
	public Integer getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(Integer ordercount) {
		this.ordercount = ordercount;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	@Override
	public String toString() {
		return "orders [custname=" + custname + ", ordercount=" + ordercount
				+ ", orderdate=" + orderdate + ", ordered=" + ordered
				+ ", prodname=" + prodname + "]";
	}
	
}
