package action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class BankSalesman implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("银行业务员开始工作");
		return new ActionForward("mvc", false);
	}

}
