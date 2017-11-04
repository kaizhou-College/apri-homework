package com.kz.web.action;

import com.kz.dao.UsersDao;
import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UsersAction extends ActionSupport{
	private Users user;
	private UsersDao ud = new UsersDao();
	public String login(){
		//System.out.println("进入 usersAction .....user="+user);
		Users tempUser = ud.findByNameAndPwd(user);
		if(tempUser!=null){
			return "login_success";
		}else{
			//返回登录页面
			return "login";
		}
	
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
}
