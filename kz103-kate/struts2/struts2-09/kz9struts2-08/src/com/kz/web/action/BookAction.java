package com.kz.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	public String delBook(){
		System.out.println("ɾ����....");
		return "del_succ";
	}
	public String addBook(){
		System.out.println("�����....");
		return "add_succ";
	}
	public String updateBook(){
		System.out.println("������....");
		return "update_succ";
	}
	public String listBook(){
		System.out.println("��ѯ��....");
		return "list_succ";
	}
}
