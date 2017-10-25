package impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;

import action.Action;

import entity.Users;



public class DelUserAction implements Action{
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		int num = BaseDao.del(Users.class, id);
		if(num>0){
			return new ActionForward("success",true);
		}
		return new ActionForward("error",true);
	}

}
