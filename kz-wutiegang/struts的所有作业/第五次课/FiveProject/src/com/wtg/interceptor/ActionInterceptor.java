package com.wtg.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wtg.Action.AuctionAction;

public class ActionInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("������������");
		
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("mname");
		System.out.println(attribute);
		if(attribute!=null){
			//����
			invocation.invoke();
		}else{
			AuctionAction aa= (AuctionAction) invocation.getAction();
			aa.addActionError("������¼���ܲ�������");
			return "login";
		}
		return null;
		
	}

}
