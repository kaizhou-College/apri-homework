package com.kz.action.ipml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.kz.action.Action;
import com.kz.dao.UserDao;
import com.kz.entity.ActionForward;

public class DelUserAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse reponse) {
		ActionForward af=null;
		String name = request.getParameter("name");
		int num = UserDao.Delete(name);
		if(num>0){
			af = new ActionForward("success.jsp",true);
		}else{
			af = new ActionForward("error.jsp",true);
		}
		return af;
	}

}
