package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.impl.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest req,HttpServletResponse res);
}
