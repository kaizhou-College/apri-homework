package com.kz.action;

import com.opensymphony.xwork2.ActionSupport;
//ActionSupport:ֵ�İ󶨣�У��.......
public class TestAction3 extends ActionSupport{
	public String execute(){
		System.out.println("����TestAction3, �ܸ���Ϊ�����....");
		return SUCCESS;
	}
	public String test3(){
		System.out.println("����TestAction3�е�test3����, �ܸ���Ϊ�����....");
		return "cg";
	}
}
