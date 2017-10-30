package com.kz.action.ipml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;
import com.kz.entity.ActionForward;

public class Login implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse reponse) {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		ActionForward ac = null;
		if(name.equals("admin")&&pwd.equals("admin")){
			ac = new ActionForward("success.jsp", false);
		}else{
			ac =  new ActionForward("error.jsp",false);
		}
		return ac;
	}
}
