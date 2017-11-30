package com.kz.web.interceper;

import java.util.Map;

import com.kz.web.action.FwxxAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceper extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		//��һ�����õ�session
		Map<String, Object> session = ai.getInvocationContext().getSession();
		//�ڶ�������session����ֵ
	        String uname = (String) session.get("uname");  
	        if(uname!=null){  
	            return ai.invoke();  
	        }else{  
	        	/*//���session��û��ֵ�͵õ�action
	        	FwxxAction fwxxaction = (FwxxAction) ai.getAction();
	        	fwxxaction.addActionError("���ȵ�¼�û���");*/
	        	String tips="���ȵ�¼�û���!";
	        	session.put("tips", tips);
	            return "input";  
	        }  
	}

}
