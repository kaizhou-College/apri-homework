package com.kz.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;

//����ڣ����ƣ�
public class WomanAction implements Action {
	public ActionForward excute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("������ڿ���....");
		//�������ý��
		return null;//"success";
	}


}
