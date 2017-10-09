package com.kqw.entity;



public class Book {
	private int id;
	private String name;
	private int price;
	private String writer;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, int price, String writer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.writer = writer;
	}
	
	public Book(String name, int price, String writer) {
		super();
		this.name = name;
		this.price = price;
		this.writer = writer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"\t"+writer;
	}
	
}
