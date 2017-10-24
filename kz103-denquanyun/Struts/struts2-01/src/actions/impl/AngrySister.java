package actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;

public class AngrySister implements Action{

	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) {
		return new ActionForward("index",true);
	}

//	public String execute() {
//		System.out.println("Can you stop angry now?");
//		return "index";
//	}

}
