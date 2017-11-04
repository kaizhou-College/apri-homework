package com.kz.web.action;

import com.kz.dao.UsersDao;
import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UsersAction extends ActionSupport{
	private Users user;
	private UsersDao ud = new UsersDao();
	public String login(){
		//System.out.println("���� usersAction .....user="+user);
		Users tempUser = ud.findByNameAndPwd(user);
		if(tempUser!=null){
			return "login_success";
		}else{
			//���ص�¼ҳ��
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
