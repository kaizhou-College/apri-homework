package com.kz.Actionimp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.Action.Action;
import com.kz.entity.ActionForward;

public class InfoAction implements Action{
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String JG = req.getParameter("JG");
		String sex = req.getParameter("sex");
		req.setAttribute("name",name);
		req.setAttribute("JG",JG);
		req.setAttribute("sex",sex);
		if(sex.equals("ÄÐ")){
			return new	ActionForward("man.jsp",true);
		}else{
			return new	ActionForward("woman.jsp",true);
		}
	}
}