package com.kz.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.entity.ActionForward;

//(2)����һ��ҵ��Ա�Ľӿ�Action�ӿڣ�Ҫ����һ����Ϊ����execute������������������Ӧ����
//����һ�����ҳ���ActionForward����
public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse reponse);
}
