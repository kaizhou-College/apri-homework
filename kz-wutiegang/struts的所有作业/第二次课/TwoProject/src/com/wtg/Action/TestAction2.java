package com.wtg.Action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction2 extends ActionSupport{
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我是TestAction2的继承ActionSupport的方法");
		return SUCCESS;
	}
	public String Test2(){
		System.out.println("我是TestAction2的Test方法");
		return "success";
	}
}
