package com.kz.px.action.imp;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.kz.px.dao.SelectDao;
import com.kz.px.entity.users;

public class LoginAction implements RequestAware{
	private Map<String, Object> req;
	private String user;
	private String pwd;
	public String execute(){
		users u=new users();
		List<users> list=null;
		try {
			list = SelectDao.frind(u.getClass());
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name=null;
		boolean Username=false;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getUsername().equals(user)){
				name=list.get(i).getUsername();
				System.out.println("有该用户名");
				String pwd1=list.get(i).getUserpwd();
				List<users> list1=null;
					try {
						list1=SelectDao.frind(u.getClass(),"userpwd",pwd1);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				if(list1.get(0).getUserpwd().equals(pwd)){
					Username=true;
					System.out.println("该用户名密码正确");
				}else{
					System.out.println("该用户名密码错误");
				}
			}else{
				System.out.println("该用户名错误");
			}
		}
		if(Username){
			req.put("name", name);
			return "success";
		}else{
			return "error";
		}
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		req=arg0;
	}
	
}
