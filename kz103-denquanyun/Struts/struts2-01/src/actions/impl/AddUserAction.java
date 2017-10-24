package actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;
import entity.Users;

import actions.Action;

public class AddUserAction implements Action{

	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		int num = BaseDao.add("seq_users",new Users(name,pwd));
		if(num>0){
			return new ActionForward("success",true);
		}
		return new ActionForward("error",true);
	}

}
