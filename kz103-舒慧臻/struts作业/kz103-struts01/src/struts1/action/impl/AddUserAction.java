package struts1.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.Action;
import struts1.dao.BaseDao;
import struts1.entity.Users;

public class AddUserAction implements Action {

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("uname");
		String password = req.getParameter("password");
		String birthday = req.getParameter("birthday");
		Users user = new Users(name, password, birthday);
		BaseDao dao = new BaseDao();
		dao.add("seq_users", user);
		if(dao.add("seq_users", user)>0){
			return new ActionForward("seccess", true);
		}else{
			return new ActionForward("error", true);
		}
	}

}
