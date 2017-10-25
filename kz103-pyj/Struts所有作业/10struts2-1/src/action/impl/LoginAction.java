package action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class LoginAction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		if(name.equals("admin")){
			if(pwd.equals("admin")){
				return new ActionForward("success", false);
			}
		}
			return new ActionForward("error", false);
	}
}
