package com.kz.entity;

public class Product {
	private String pname;
	private Double pprice;
	private Integer number;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String pname, Double pprice, Integer number) {
		super();
		this.pname = pname;
		this.pprice = pprice;
		this.number = number;
	}



	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPprice() {
		return pprice;
	}

	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "product [number=" + number + ", pname=" + pname + ", pprice="
				+ pprice + "]";
	}
	
}
