package com.kz.entity;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class user implements HttpSessionBindingListener{
	public static int count=0;
	private String name;
	private String pwd;
	public user(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "user [name=" + name + ", pwd=" + pwd + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		count++;
		System.out.println("多少人多少人"+count);
		ServletContext application = event.getSession().getServletContext();
		application.setAttribute("online",count);
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		count--;
		ServletContext application = event.getSession().getServletContext();
		application.setAttribute("online",count);
	}
	public static int getCount() {
		return count;
	}
	
}
