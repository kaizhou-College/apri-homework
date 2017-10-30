package com.kz.action.ipml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;
import com.kz.entity.ActionForward;

public class InfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse reponse) {
		ActionForward af =null;
		String sex = request.getParameter("sex");
		if(sex=="ÄÐ"){
			af = new ActionForward("man.jsp",false);
		}else{
			af = new ActionForward("woman.jsp",false);
		}
		return af;
	}

}
