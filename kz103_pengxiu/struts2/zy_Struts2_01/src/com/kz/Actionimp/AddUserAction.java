package com.kz.Actionimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.Action.Action;
import com.kz.dao.UsersDao;
import com.kz.entity.ActionForward;
import com.kz.entity.Users;

public class AddUserAction implements Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String date = req.getParameter("date");
		List<Users> list=UsersDao.Insert();
		boolean add = list.add(new Users(name, pwd, date));
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(add+"===add ===");
		if(add){
			return new ActionForward("success.jsp",false);
		}else{
			return new ActionForward("error.jsp",false);
		}
	}
}
