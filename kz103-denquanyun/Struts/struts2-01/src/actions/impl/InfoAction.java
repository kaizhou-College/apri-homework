package actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;

public class InfoAction implements Action{
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String sex=req.getParameter("sex");
		req.setAttribute("name",name);
		req.setAttribute("add",address);
		if(sex.equals("ÄÐ")){
			return new ActionForward("man",false);
		}else{
			return new ActionForward("woman",false);
		}
	}

}
