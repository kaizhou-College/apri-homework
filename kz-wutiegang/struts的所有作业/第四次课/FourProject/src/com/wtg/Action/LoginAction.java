package com.wtg.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.Users;

public class LoginAction {
	private String name;
	private String password;
	public String Login(){
		System.out.println("name==="+name+"=======password======"+password);
		try {
			HttpServletRequest req=ServletActionContext.getRequest();
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			System.out.println("session==="+session);
			List<Users> list = BaseDao.findAll(Users.class);
			for (int i = 0; i < list.size(); i++) {
				String name2 = list.get(i).getName();
				String password2 = list.get(i).getPassword();
				if (name.equalsIgnoreCase(name2)&&password.equalsIgnoreCase(password2)) {
					return "success";
					
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "loser";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
