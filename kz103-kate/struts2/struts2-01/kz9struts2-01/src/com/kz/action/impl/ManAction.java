package com.kz.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;

//�����ڣ��п�ҽ����
public class ManAction implements Action{//���ӿ�
	
	public ActionForward/*String*/ excute(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("�������ڿ���");
		//1,�������ý�� 2,��ôȥ��ȥ�ý��(ת��ȥ/�ض���)
		return new ActionForward("success", true);//Ĭ�ϵ�success.jsp�ý��
		//springMVC
		//return "redirect:success";
	}

}
