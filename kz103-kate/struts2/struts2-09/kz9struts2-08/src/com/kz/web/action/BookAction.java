package com.kz.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	public String delBook(){
		System.out.println("删除书....");
		return "del_succ";
	}
	public String addBook(){
		System.out.println("添加书....");
		return "add_succ";
	}
	public String updateBook(){
		System.out.println("更新书....");
		return "update_succ";
	}
	public String listBook(){
		System.out.println("查询书....");
		return "list_succ";
	}
}
