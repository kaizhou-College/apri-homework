package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.impl.ActionForward;

//(2)开发一个业务员的接口Action接口，要求定义一个行为，即execute方法，传入请求与响应对象，
//返回一个结果页面的ActionForward对像。
public interface Action {
	public ActionForward execute(HttpServletRequest req,HttpServletResponse resp);
//	public String execute();
}
