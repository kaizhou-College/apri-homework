package impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import action.Action;

public class LoginAction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		System.out.println("看到我啦我在登陆");
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		if(name.equals("admin")&& pwd.equals("admin")){
			return new ActionForward("success", false);
		}else{
			return new ActionForward("error", false);
		}
	}

}
