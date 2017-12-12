package com.kz.action;

import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Product;
import com.kz.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;
	private List<Product> list;
	public String login(){
		//System.out.println(user+"====user");
		list=new ArrayList<Product>();
		list.add(new Product("辣条1", 2.1, 11));
		list.add(new Product("辣条2", 2.2, 12));
		list.add(new Product("辣条3", 2.3, 13));
		list.add(new Product("辣条4", 2.4, 14));
		
		return "login_success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	
}
