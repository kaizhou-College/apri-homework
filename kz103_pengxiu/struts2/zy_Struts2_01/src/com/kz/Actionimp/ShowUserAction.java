package com.kz.Actionimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.Action.Action;
import com.kz.dao.UsersDao;
import com.kz.entity.ActionForward;
import com.kz.entity.Users;

public class ShowUserAction implements Action{
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		List<Users> list=UsersDao.Insert();
		req.setAttribute("list",list);
		return new ActionForward("showUser.jsp",true);
	}

}
