package struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.impl.ActionForward;
//开发一个业务员的接口Action接口，要求定义一个行为，即execute方法，传入请求与响应对象
public interface Action {
	public ActionForward excute(HttpServletRequest req,HttpServletResponse res);

}
