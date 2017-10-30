package com.kz.px.action.imp;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.kz.px.dao.SelectDao;
import com.kz.px.entity.orders;
import com.kz.px.entity.users;

public class OrdersSelectAction implements RequestAware {
	private Map<String, Object> req;
	public String execute(){
		orders o=new orders();
		List<users> list=null;
		String object = "'"+ req.get("name").toString()+"'";
	
		try {
			list=SelectDao.frind(o.getClass(),"custname",object);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		req.put("list",list);
		return "success";
	}
	public void setRequest(Map<String, Object> arg0) {
		req=arg0;
	}
}
