package com.kz.Actionimp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.Action.Action;
import com.kz.entity.ActionForward;

public class LoginAction implements Action {
	public ActionForward execute(HttpServletRequest req,HttpServletResponse res) {
		String user = req.getParameter("use");
		String pwd = req.getParameter("pwd");
		if(user.equals("admin")&pwd.equals("admin")){
			return new ActionForward("success.jsp",false);
		}else{
			return new ActionForward("error.jsp",false);
		}
	}
}