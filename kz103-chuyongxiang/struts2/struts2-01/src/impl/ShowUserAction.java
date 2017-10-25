package impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

import dao.BaseDao;
import entity.Users;


public class ShowUserAction implements Action{
	private List list;
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			list = BaseDao.select(Users.class);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("list",list);
		return new ActionForward("showUser",false);
	}

}
