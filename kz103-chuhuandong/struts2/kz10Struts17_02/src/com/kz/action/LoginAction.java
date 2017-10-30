package com.kz.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String name;
	private String pwd;
	public String execute() throws Exception {
		if(name!=null){
			System.out.println(name+"-----"+pwd);
		}else{
			System.out.println("nameµ»Ï∂null");
		}
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
