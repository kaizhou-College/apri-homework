package com.kz.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.impl.ActionForward;

//һ�鹦�ܵ�Լ��----��׼(ҽ���ı�׼ ҽ��֤)
public interface Action {
	//���п�������Ϊ---����
	public ActionForward/*String*/ excute(HttpServletRequest req,HttpServletResponse resp);
	
}
