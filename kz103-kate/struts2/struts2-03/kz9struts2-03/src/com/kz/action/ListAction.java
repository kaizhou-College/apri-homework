package com.kz.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kz.entity.Users;

public class ListAction {
	//ֵջ����----set/get����
	private List<Users> users;
	public String execute(){
		//request���з�����(session,appliaction)
		HttpServletRequest request = ServletActionContext.getRequest();
		/*List<Users> users = new ArrayList<Users>();
		Users u1 = new Users();
		u1.setUname("������");
		u1.setPwd("123");
		
		Users u2 = new Users();
		u2.setUname("������");
		u2.setPwd("456");
		
		users.add(u1);
		users.add(u2);
		request.setAttribute("list",users);*/
		users = new ArrayList<Users>();
		Users u1 = new Users();
		u1.setUname("������");
		u1.setPwd("123");
		
		Users u2 = new Users();
		u2.setUname("������");
		u2.setPwd("456");
		
		users.add(u1);
		users.add(u2);
		
		return "success";
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
}
