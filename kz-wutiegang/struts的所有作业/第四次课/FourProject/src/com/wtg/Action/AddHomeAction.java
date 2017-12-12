package com.wtg.Action;

import java.util.Date;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.District;
import com.wtg.entity.House;
import com.wtg.entity.QueryHouse;

public class AddHomeAction {
	private QueryHouse qh;
	/*private String title;
	private int type_id;
	private int floorage;
	private int price;
	private String houseDate;
	private int street_id;
	private String contact;
	private String description;*/
	public String fabu() throws IllegalArgumentException, IllegalAccessException{
		House house=new House();
		house.setTitle(qh.getTitle());
		house.setType_id(qh.getType_id());
		house.setFloorage(qh.getFloorage());
		house.setPrice(qh.getPrice());
		house.setPubdate(qh.getPubdate());
		house.setStreet_id(qh.getStreet_id());
		house.setContact(qh.getContact());
		house.setDescription(qh.getDescription());
		int add = BaseDao.add("seq_id", house);
		if (add>0) {
			return "success";
		} 
		return "loser";
	}
	public QueryHouse getQh() {
		return qh;
	}
	public void setQh(QueryHouse qh) {
		this.qh = qh;
	}
	
	

	
}
