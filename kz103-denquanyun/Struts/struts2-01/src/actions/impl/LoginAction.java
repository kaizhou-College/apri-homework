package actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
/*
写一个用户登录的jsp，提交到login.action中，准备一个LoginAction实现Action接口，实现execute(),拿到用户名和密码，
当用户名和密码都是admin，那么就封装ActionForward（success.jsp,false）,否则就封装ActionForward（error.jsp,false）
在actionConfig.properties配置好uri(login)和LoginAction关系
 * */
public class LoginAction implements Action{
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		if(name.equals("admin")){
			if(pwd.equals("admin")){
				return new ActionForward("success",false);
			}
		}
		return new ActionForward("error",false);
	}

}
