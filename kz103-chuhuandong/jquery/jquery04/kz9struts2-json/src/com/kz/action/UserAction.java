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
		//��ȡ������Ʒ����Ϣ������ҳ��ʾ----json��ʽ����ȥ��
		//ģ��
		prods = new ArrayList<Product>();
		prods.add(new Product("1", "�Լ�1", 12.2));
		prods.add(new Product("2", "�Լ�2", 12.3));
		prods.add(new Product("3", "�Լ�3", 12.4));
		prods.add(new Product("4", "�Լ�4", 12.5));
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
