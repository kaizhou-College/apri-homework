package com.kz.web.action;

import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport{
	//��ʽһ����������
	private Users user;
	/*�û�ע��*/
	public String regist(){
		System.out.println("user="+user);
		return "regist_success";
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	/*@Override
	public void validate() {
		���ֲ���Ϊ��
		if(user.getUname()==null||!(user.getUname().trim().length()>0)){
			this.addFieldError("msg.error.uname", "�û�������Ϊ��");
		}
		�������Ϊ8λ
		���������0��150����
		if(user.getAge()<0||user.getAge()>150){
			this.addFieldError("msg.error.age", "���������0��150����");
		}
	}*/
	
	 
	
}	
