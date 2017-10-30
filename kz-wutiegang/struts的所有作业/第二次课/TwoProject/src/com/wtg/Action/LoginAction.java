package com.wtg.Action;

import java.util.List;


import com.opensymphony.xwork2.ModelDriven;
import com.wtg.Dao.UserDao;
import com.wtg.entity.User;
import com.wtg.entity.Users;

public class LoginAction implements ModelDriven<User>{
	private String uname;
	private String psw;
	private User u=new User();
	public User getModel() {
		// TODO Auto-generated method stub

		return u;
	}
	public String Test() throws InstantiationException, IllegalAccessException{
		System.out.println("uname="+u.getUname()+"\tpwd==="+u.getPsw());
		List<Users> list = UserDao.showUser(Users.class);
		for (int i = 0; i < list.size(); i++) {
			String uname2 = list.get(i).getUname();
			if (u.getUname().equalsIgnoreCase(uname2)) {
				return "loser";
			}
		}
		
		return "success";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
}
