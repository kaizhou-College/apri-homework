package actions.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;
import entity.Users;

import actions.Action;

public class ShowUserAction implements Action{
	private List list;
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		list = BaseDao.queryAll(Users.class);
		req.setAttribute("list",list);
		return new ActionForward("showUser",false);
	}

}
