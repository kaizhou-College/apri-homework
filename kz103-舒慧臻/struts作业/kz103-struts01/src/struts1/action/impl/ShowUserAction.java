package struts1.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.Action;
import struts1.dao.BaseDao;
import struts1.entity.Users;

public class ShowUserAction implements Action {

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		BaseDao dao = new BaseDao();
		Users user = new Users();
		List list = dao.queryAll(user.getClass());
		req.setAttribute("list", list);
		return new ActionForward("showUser", false);
	}

}
