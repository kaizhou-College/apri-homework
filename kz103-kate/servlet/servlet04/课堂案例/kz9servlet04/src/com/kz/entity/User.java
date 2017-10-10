package com.kz.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//用户实体类(监听sesion对象中设置或者移除该类对象)
public class User implements HttpSessionBindingListener{
	private String name;
	private int uuid;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("user对象被设置到session中");
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("user对象从session中取出");
		
	}
	
	
}
