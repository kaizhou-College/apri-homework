package com.kz.action.ipml;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.kz.action.Action;
import com.kz.dao.UserDao;
import com.kz.entity.ActionForward;
import com.kz.entity.Users;

public class ShowUserAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse reponse) {
		ActionForward af = new ActionForward("showUser.jsp",false);
		return af;
	}
}
