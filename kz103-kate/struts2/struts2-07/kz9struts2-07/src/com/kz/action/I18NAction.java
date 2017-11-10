package com.kz.action;

import com.opensymphony.xwork2.ActionSupport;

public class I18NAction extends ActionSupport{
	public String execute(){
		System.out.println(getText("uname2"));
		return "";
	}
}
