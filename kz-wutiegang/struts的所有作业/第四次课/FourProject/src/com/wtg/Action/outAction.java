package com.wtg.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class outAction {

	public String out(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println("session===="+session.getAttribute("name"));
		session.invalidate();
		return "out_success";
	}
	
	
}
