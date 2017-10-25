package action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.Basedao;
import entity.Users;

public class DelUsersAction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		int num = Basedao.Del(Users.class, id);
		if(num>0){
			return new ActionForward("success",true);
		}
		return new ActionForward("error",true);
	}

}
