package com.wtg.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action{

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String psw = req.getParameter("psw");
		if (username.equalsIgnoreCase("admin")&&psw.equalsIgnoreCase("admin")) {
			return new ActionForward("success.jsp", false);
		}else{
			return new ActionForward("error.jsp", false);
		}
		
	}

}
