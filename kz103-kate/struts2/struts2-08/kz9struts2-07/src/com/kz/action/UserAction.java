package com.kz.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String username;
	private String userpwd;
	public String changeLanguage(){
		
		return "success";
	}
	public String login(){
		//��������û�������admin ����ʾ�û�������
		if(!username.equals("admin")){
			//��ȡȫ����Դ
			this.addFieldError("uname.error",getText("unameerror",new String[]{username,"������"}));
			//��ȡ�ֲ���Դ
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
