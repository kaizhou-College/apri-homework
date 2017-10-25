package com.kz.action;

import com.opensymphony.xwork2.ActionSupport;
//ActionSupport:值的绑定，校验.......
public class TestAction3 extends ActionSupport{
	public String execute(){
		System.out.println("我是TestAction3, 很高心为你服务....");
		return SUCCESS;
	}
	public String test3(){
		System.out.println("我是TestAction3中的test3方法, 很高心为你服务....");
		return "cg";
	}
}
