package actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
/*
дһ���û���¼��jsp���ύ��login.action�У�׼��һ��LoginActionʵ��Action�ӿڣ�ʵ��execute(),�õ��û��������룬
���û��������붼��admin����ô�ͷ�װActionForward��success.jsp,false��,����ͷ�װActionForward��error.jsp,false��
��actionConfig.properties���ú�uri(login)��LoginAction��ϵ
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
