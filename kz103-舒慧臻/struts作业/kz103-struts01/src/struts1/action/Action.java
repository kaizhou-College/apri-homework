package struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.impl.ActionForward;
//����һ��ҵ��Ա�Ľӿ�Action�ӿڣ�Ҫ����һ����Ϊ����execute������������������Ӧ����
public interface Action {
	public ActionForward excute(HttpServletRequest req,HttpServletResponse res);

}
