package com.kz.action;

import com.opensymphony.xwork2.Action;

public class TestAction1 implements Action{

	public String execute() throws Exception {
		System.out.println("����TestAction1, �ܸ���Ϊ�����....");
		return SUCCESS;//result������ (����jsp���ļ�����
	}
	
	public String test1(){
		System.out.println("����TestAction1�е�test1����, �ܸ���Ϊ�����....");
		return "cg";
	}
	public String login(){
		System.out.println("��ʼ��½��......");
		return SUCCESS;
	}

}
