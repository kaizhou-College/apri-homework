package action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class RealtySalesman implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("���ز�ҵ��Ա��ʼ����");
		return new ActionForward("mvc", false);
	}

}
