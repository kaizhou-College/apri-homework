package actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;

public class CuteGirl implements Action{

	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		System.out.println("可爱的小姐姐");
		return new ActionForward("index",false);
	}

//	public String execute() {
//		System.out.println("可爱的小姐姐");
//		return "index";
//	}

}
