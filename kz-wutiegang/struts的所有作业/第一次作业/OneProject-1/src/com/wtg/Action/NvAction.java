package com.wtg.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ůҵ��Ա
public class NvAction implements Action{

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return new ActionForward("result.jsp", false);
	}
	
}
