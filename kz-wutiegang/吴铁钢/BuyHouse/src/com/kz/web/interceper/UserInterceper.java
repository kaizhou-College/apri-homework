package com.kz.web.interceper;

import java.util.Map;

import com.kz.web.action.FwxxAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceper extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		//第一步：拿到session
		Map<String, Object> session = ai.getInvocationContext().getSession();
		//第二步：在session中拿值
	        String uname = (String) session.get("uname");  
	        if(uname!=null){  
	            return ai.invoke();  
	        }else{  
	        	/*//如果session中没有值就得到action
	        	FwxxAction fwxxaction = (FwxxAction) ai.getAction();
	        	fwxxaction.addActionError("请先登录用户！");*/
	        	String tips="请先登录用户啊!";
	        	session.put("tips", tips);
	            return "input";  
	        }  
	}

}
