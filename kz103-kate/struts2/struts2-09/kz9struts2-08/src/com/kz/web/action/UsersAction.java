package com.kz.web.action;

import org.apache.struts2.ServletActionContext;

import com.kz.web.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport{
	private String uname;
	private String upwd;
	/*��¼*/
	public String logon(){
		System.out.println("uname==="+uname+"\tupwd==="+upwd);
		//��ѯ���ݿ��Ƿ���ڸ��û�---
		Users user = new Users();
		user.setUname(uname);
		user.setUpwd(upwd);
		//������ڸ��û����û���Ϣ���浽session
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		//��������ھ���ת����¼ҳ�����µ�¼ login
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
