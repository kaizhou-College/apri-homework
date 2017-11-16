package com.kz.web.inpterceptor;


import org.apache.struts2.ServletActionContext;

import com.kz.web.action.BookAction;
import com.kz.web.entity.Users;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BookInpterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("进入BookInpterceptor拦截器.....");
		//验证是否登录
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user==null){//没有登录
			//1,添加错误信息----值栈
			BookAction bc = (BookAction) arg0.getAction();
			bc.addActionError("大兄弟,请先登录!!!!");
			//2,跳转到登录页面----loign.jsp 显示错误信息
			return "login";
			
		}else{//登录了
			//放行
			arg0.invoke();
		}
		return null;
	}

}
