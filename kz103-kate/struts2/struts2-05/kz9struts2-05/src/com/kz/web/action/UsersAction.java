package com.kz.web.action;

import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport{
	//方式一：属性驱动
	private Users user;
	/*用户注册*/
	public String regist(){
		System.out.println("user="+user);
		return "regist_success";
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	/*@Override
	public void validate() {
		名字不能为空
		if(user.getUname()==null||!(user.getUname().trim().length()>0)){
			this.addFieldError("msg.error.uname", "用户名不能为空");
		}
		密码必须为8位
		年龄必须在0到150以内
		if(user.getAge()<0||user.getAge()>150){
			this.addFieldError("msg.error.age", "年龄必须在0到150以内");
		}
	}*/
	
	 
	
}	
