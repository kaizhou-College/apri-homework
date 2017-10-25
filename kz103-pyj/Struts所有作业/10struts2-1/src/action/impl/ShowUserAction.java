package action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.Basedao;
import entity.Users;

public class ShowUserAction implements Action{
	private List list;
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		list = Basedao.SelectAll(Users.class);
		req.setAttribute("list",list);
		return new ActionForward("showUsers",false);
	}

}
