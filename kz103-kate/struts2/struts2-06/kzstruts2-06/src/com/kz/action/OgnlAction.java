package com.kz.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kz.entity.Dog;
import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;
public class OgnlAction extends ActionSupport{
	private String uname;
	private Users users;
	private List<Users> list;
	private Set<Users> set;
	
	private Map<String, Users> map;
	
	public static String staticStr ="我是静态属性";
	//见名知意
	public String list(){
		uname = "二狗子";
		
		users = new Users(1,"旺财",12, new Dog(1,"d1"));
		
		list = new ArrayList<Users>();
		list.add(new Users(2,"tom1",10,new Dog(2,"ud1")));
		list.add(new Users(3,"tom2",11,new Dog(3,"ud2")));
		list.add(new Users(4,"tom3",12,new Dog(1,"ud3")));
		list.add(new Users(5,"tom4",13,new Dog(5,"ud14")));
		
		set = new HashSet<Users>();
		set.add(new Users(2,"tom1",10,new Dog(2,"ud1")));
		set.add(new Users(3,"tom2",10,new Dog(3,"ud2")));
		set.add(new Users(4,"tom3",10,new Dog(4,"ud3")));
		set.add(new Users(5,"tom4",10,new Dog(5,"ud14")));
		
		map = new HashMap<String, Users>();
		map.put("u1", new Users(2,"tom1",10,new Dog(2,"ud1")));
		map.put("u2", new Users(3,"tom2",10,new Dog(3,"ud2")));
		map.put("u3", new Users(4,"tom3",10,new Dog(4,"ud3")));
		map.put("u4", new Users(5,"tom4",10,new Dog(5,"ud4")));
	
		return "list_success";
	}
	//get、set方法
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Users getUsers() {
		return users;
	}
	public static String getA(){
		return "你好";
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Users> getList() {
		return list;
	}
	public void setList(List<Users> list) {
		this.list = list;
	}
	public Set<Users> getSet() {
		return set;
	}
	public void setSet(Set<Users> set) {
		this.set = set;
	}
	public Map<String, Users> getMap() {
		return map;
	}
	public void setMap(Map<String, Users> map) {
		this.map = map;
	}
	
	
	
}
