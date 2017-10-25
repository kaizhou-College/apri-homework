package impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class InfoAction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String jiguan=req.getParameter("jiguan");
		String sex=req.getParameter("sex");
		if(sex.equals("ÄÐ")){
			return new ActionForward("man", false);
		}else{
			return new ActionForward("woman", false);
		}
	}

}
