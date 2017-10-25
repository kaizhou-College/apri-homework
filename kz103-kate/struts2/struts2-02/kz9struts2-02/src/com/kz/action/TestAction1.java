package com.kz.action;

import com.opensymphony.xwork2.Action;

public class TestAction1 implements Action{

	public String execute() throws Exception {
		System.out.println("我是TestAction1, 很高心为你服务....");
		return SUCCESS;//result的名字 (不是jsp的文件名）
	}
	
	public String test1(){
		System.out.println("我是TestAction1中的test1方法, 很高心为你服务....");
		return "cg";
	}
	public String login(){
		System.out.println("开始登陆了......");
		return SUCCESS;
	}

}
