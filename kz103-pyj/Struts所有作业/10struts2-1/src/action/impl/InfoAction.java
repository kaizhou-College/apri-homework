package action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class InfoAction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String shi=req.getParameter("shi");
		String sex = req.getParameter("sex");
		if(sex=="ÄÐ"){
			return new ActionForward("man", false);
		}else{
			return new ActionForward("woman", false);
		}
	}
}
