package com.kz.entity;

import java.util.Date;

public class House {
	private Integer id;
	private Integer user_id;
	private Integer type_id;
	private String title;
	private String description;
	private Integer price;
	private Date pubdate;
	private Integer floorage;
	private String contact;
	private Integer street_id;
	@Override
	public String toString() {
		return "House [contact=" + contact + ", description=" + description
				+ ", floorage=" + floorage + ", id=" + id + ", price=" + price
				+ ", pubdate=" + pubdate + ", street_id=" + street_id
				+ ", title=" + title + ", type_id=" + type_id + ", user_id="
				+ user_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int typeId) {
		type_id = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public int getFloorage() {
		return floorage;
	}
	public void setFloorage(int floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getStreet_id() {
		return street_id;
	}
	public void setStreet_id(int streetId) {
		street_id = streetId;
	}
	
	
	
}
