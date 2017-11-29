package com.kz.examination.wed.filter;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInpterceptor extends  MethodFilterInterceptor{
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object name = session.getAttribute("user");
		if(name==null){
			return "input";
		}else{
			invocation.invoke();
		}
		return null;
	}

}
