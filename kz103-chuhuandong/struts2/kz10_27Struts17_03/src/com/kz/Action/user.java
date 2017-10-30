package com.kz.Action;

import java.util.List;
import java.util.Map;

import com.kz.dao.BaseDao;
import com.kz.entity.Users;
import com.kz.entity.orders;
import com.opensymphony.xwork2.ActionContext;

public class user{
	private Map<String, Object> requestMap;
	public String execute(){
		ActionContext context = ActionContext.getContext();
		requestMap = context.getParameters();
		BaseDao bs = new BaseDao();
		List<Users> list = bs.getUsers(orders.class);
		context.put("list", list);
		return "cc";
	}
}
