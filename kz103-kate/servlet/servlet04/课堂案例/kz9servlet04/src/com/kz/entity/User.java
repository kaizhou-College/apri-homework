package com.kz.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//�û�ʵ����(����sesion���������û����Ƴ��������)
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
		System.out.println("user�������õ�session��");
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("user�����session��ȡ��");
		
	}
	
	
}
