package com.kz.examination.wed.action;

import org.apache.struts2.ServletActionContext;

import com.kz.examination.dao.BaseDao;
import com.kz.examination.dao.TBL_USERDao;
import com.kz.examination.entity.Tbl_User;
import com.opensymphony.xwork2.ActionSupport;

public class TblUserAction extends ActionSupport{
	//登入时获取的对象
	private Tbl_User login;
	
	//一个非常简单的登入
	public String loginUser(){
		boolean login2 = TBL_USERDao.login(login);
		if(login2){
			ServletActionContext.getRequest().getSession().setAttribute("user",login.getUname());
			return "loginUser";
		}else{
			return "error";
		}
	}
	public String addUser(){
		int insert = BaseDao.insert(login,"uuid");
		if(insert>0){
			return "addUser";
		}else{
			return "error";
		}
		
		
	}
	public String goIndex(){
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("user");
		if(attribute!=null){
			ServletActionContext.getRequest().getSession().invalidate();
		}
		return "goIndex";
	}
	public Tbl_User getLogin() {
		return login;
	}
	public void setLogin(Tbl_User login) {
		this.login = login;
	}
	
	
	
}
