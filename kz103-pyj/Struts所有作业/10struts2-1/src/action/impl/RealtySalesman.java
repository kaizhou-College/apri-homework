package action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class RealtySalesman implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("房地产业务员开始工作");
		return new ActionForward("mvc", false);
	}

}
