package com.kz.action;

import javax.xml.registry.infomodel.User;

import org.omg.CORBA.Request;

import com.kz.entity.Users;
import com.opensymphony.xwork2.ModelDriven;

//������ֵ��ʽһ�� ��������
//������ֵ��ʽ����ģ������
public class LoginAction implements ModelDriven<Users>{
	//��������
	
	//1��setXXX��xxx����ͱ���nameֵһ��
	//2�������ṩget/set����
	private String uname;
	private String pwd;
	private Users us222;
	//ģ������ ע������
	////1,����ʵ��ModelDriven�ӿ�  2����������ʼ��   3�����������getModel
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
