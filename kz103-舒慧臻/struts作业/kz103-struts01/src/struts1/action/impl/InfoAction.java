package struts1.action.impl;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.Action;

public class InfoAction implements Action {

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("uname");
		String sex = req.getParameter("sex");
		String city = req.getParameter("city");
		if(sex.equalsIgnoreCase("ÄÐ")){
			return new ActionForward("man", false);
		}else if(sex.equalsIgnoreCase("Å®")){
			return new ActionForward("woman", false);
		}
		System.out.println(name+"----------"+sex+"-----------"+city);
		return null;
	}
	

}
