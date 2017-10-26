package com.kz.action;

import javax.xml.registry.infomodel.User;

import org.omg.CORBA.Request;

import com.kz.entity.Users;
import com.opensymphony.xwork2.ModelDriven;

//参数传值方式一： 属性驱动
//参数传值方式二：模型驱动
public class LoginAction implements ModelDriven<Users>{
	//属性驱动
	
	//1，setXXX的xxx必须和表单的name值一样
	//2，必须提供get/set方法
	private String uname;
	private String pwd;
	private Users us222;
	//模型驱动 注意三点
	////1,必须实现ModelDriven接口  2，对象必须初始化   3，方法必须叫getModel
	private Users user = new Users();
	public Users getModel() {
		return user;
	}
	public String login(){
		System.out.println("uname="+user.getUname()+"\tpwd==="+user.getPwd());
		return "login_success";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	

/*	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}*/
	
	
	
}
