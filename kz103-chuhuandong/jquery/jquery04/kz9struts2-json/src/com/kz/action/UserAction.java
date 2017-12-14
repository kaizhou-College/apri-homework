package com.kz.action;

import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Product;
import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private Users users;
	private List<Product> prods;
	public String login(){
		System.out.println("users==="+users);
		//获取所有商品的信息，到首页显示----json格式传过去？
		//模拟
		prods = new ArrayList<Product>();
		prods.add(new Product("1", "吃鸡1", 12.2));
		prods.add(new Product("2", "吃鸡2", 12.3));
		prods.add(new Product("3", "吃鸡3", 12.4));
		prods.add(new Product("4", "吃鸡4", 12.5));
		return "login_success";
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Product> getProds() {
		return prods;
	}
	public void setProds(List<Product> prods) {
		this.prods = prods;
	}
	
	
}
