package com.kz.web.inpterceptor;


import org.apache.struts2.ServletActionContext;

import com.kz.web.action.BookAction;
import com.kz.web.entity.Users;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BookInpterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("����BookInpterceptor������.....");
		//��֤�Ƿ��¼
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user==null){//û�е�¼
			//1,��Ӵ�����Ϣ----ֵջ
			BookAction bc = (BookAction) arg0.getAction();
			bc.addActionError("���ֵ�,���ȵ�¼!!!!");
			//2,��ת����¼ҳ��----loign.jsp ��ʾ������Ϣ
			return "login";
			
		}else{//��¼��
			//����
			arg0.invoke();
		}
		return null;
	}

}
