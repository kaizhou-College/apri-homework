package struts1.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.Action;

public class LoginAction implements Action {

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("uname");
		String password = req.getParameter("upassword");
		if(name.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")){
			return new ActionForward("seccess", false);
		}else{
			return new ActionForward("error",false);
		}
	}
	

}
