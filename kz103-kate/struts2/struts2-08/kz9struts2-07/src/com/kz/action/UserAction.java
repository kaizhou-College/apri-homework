package com.kz.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String username;
	private String userpwd;
	public String changeLanguage(){
		
		return "success";
	}
	public String login(){
		//假设如果用户名不叫admin 就提示用户名错误
		if(!username.equals("admin")){
			//获取全局资源
			this.addFieldError("uname.error",getText("unameerror",new String[]{username,"王大炮"}));
			//获取局部资源
			this.addFieldError("uage.error", getText("ageError"));
			return "success";
		}
		return "login_success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
}
