package com.wtg.Action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction2 extends ActionSupport{
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����TestAction2�ļ̳�ActionSupport�ķ���");
		return SUCCESS;
	}
	public String Test2(){
		System.out.println("����TestAction2��Test����");
		return "success";
	}
}
