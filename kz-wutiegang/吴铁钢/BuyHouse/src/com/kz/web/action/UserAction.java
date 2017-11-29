package com.kz.web.action;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kz.biz.UserBiz;
import com.kz.entity.Tbl_user;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private Tbl_user tbluser;
	private Tbl_user user;
	private UserBiz userbiz=new UserBiz();

	//用户注册的转发页面
	public String reg(){
		return "reg_success";
	}
	public String register(){
		try {
			int number=userbiz.add("seq_tbluser",tbluser);
			if (number>0) {
				return "register_success";
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "register_file";
	}
	//登录验证
	public String login(){
		user = userbiz.findByUserAndPassword(tbluser.getUname(), tbluser.getUpass());
		
		boolean boo = userbiz.loginTureOrFalse(tbluser.getUname(), tbluser.getUpass());
		if (boo) {
			return "login_success";
		}
		return "login_file";
	}
	//注销
	public String loginout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "loginout_success";
	}
	public String userlogin(){
		
		return "userlogin_success";
	}
	public Tbl_user getTbluser() {
		return tbluser;
	}
	public void setTbluser(Tbl_user tbluser) {
		this.tbluser = tbluser;
	}

	public Tbl_user getUser() {
		return user;
	}

	public void setUser(Tbl_user user) {
		this.user = user;
	}

	
	
}
