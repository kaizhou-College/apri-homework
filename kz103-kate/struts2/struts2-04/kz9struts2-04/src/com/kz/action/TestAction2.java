package com.kz.action;

import java.util.ArrayList;
import java.util.List;

import com.kz.dao.BaseDao;
import com.kz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction2 extends ActionSupport{
	private List<Users> ulist;//uList;
	public String test2(){
		//�����ݿ��ѯ
		//uList = BaseDao.findAll();
		ulist = new ArrayList<Users>();
		ulist.add(new Users("1","1����"));
		ulist.add(new Users("2","2����"));
		ulist.add(new Users("3","3����"));
		//reqest.setAttribute("ulist",uList);
		return SUCCESS;
	}
	public List<Users> getUlist() {
		return ulist;
	}
	public void setUlist(List<Users> ulist) {
		this.ulist = ulist;
	}
	
	/*public List<Users> getuList() {
		return uList;
	}
	public void setuList(List<Users> uList) {
		this.uList = uList;
	}*/
	
	

}
