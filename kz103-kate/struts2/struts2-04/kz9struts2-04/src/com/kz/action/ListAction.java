package com.kz.action;

import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{
	private Users users;
	private List<Users> ulist;
	public String test(){
		//数组
		/*users = new Users();
		users.setName("达文西");
		users.setHobbies(new String[]{"打撸","吃鸡","睡觉","上厕所"});*/
		
		//集合
		ulist = new ArrayList<Users>();
		
		
		ulist.add(new Users("11","1狗子"));
		ulist.add(new Users("22","2狗子"));
		ulist.add(new Users("33","3狗子"));
		ulist.add(new Users("44","4狗子"));
		ulist.add(new Users("55","5狗子"));
		
		return SUCCESS;
	}
	private int[] hobbies;
	public String update(){
		//获取表单值 ，更新数据库
		System.out.println("users=="+users);
		for(int id:hobbies){
			System.out.println("id="+id);
		}
		return "";
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Users> getUlist() {
		return ulist;
	}
	public void setUlist(List<Users> ulist) {
		this.ulist = ulist;
	}
	public int[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(int[] hobbies) {
		this.hobbies = hobbies;
	}
	
	
	
	
}
