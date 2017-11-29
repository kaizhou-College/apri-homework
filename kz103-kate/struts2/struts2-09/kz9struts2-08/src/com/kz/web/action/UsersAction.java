package com.kz.web.action;

import org.apache.struts2.ServletActionContext;

import com.kz.web.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport{
	private String uname;
	private String upwd;
	/*登录*/
	public String logon(){
		System.out.println("uname==="+uname+"\tupwd==="+upwd);
		//查询数据库是否存在改用户---
		Users user = new Users();
		user.setUname(uname);
		user.setUpwd(upwd);
		//如果存在改用户将用户信息保存到session
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		//如果不存在就跳转到登录页面重新登录 login
		return "logon_success";
	}
	
	public void test(){
		System.out.println("test....");
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
}
