package com.wtg.Action;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.Users;

public class ZhuceAction {
	private String name;
	private String password;
	private String repassword;
	private String telephone;
	private String username;
	public String Zhuce() throws IllegalArgumentException, IllegalAccessException{
		
		Users u=new Users();
		u.setName(name);
		if (password.equalsIgnoreCase(repassword)) {
			u.setPassword(password);
		}else{
			return "mima";
		}
		u.setTelephone(telephone);
		u.setUsername(username);
		u.setIsadmin("²»ÊÇ");
		System.out.println(u.toString());
		
		BaseDao.add("seq_id", u);
		return "success";
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
