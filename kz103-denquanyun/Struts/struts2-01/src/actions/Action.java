package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.impl.ActionForward;

//(2)����һ��ҵ��Ա�Ľӿ�Action�ӿڣ�Ҫ����һ����Ϊ����execute������������������Ӧ����
//����һ�����ҳ���ActionForward����
public interface Action {
	public ActionForward execute(HttpServletRequest req,HttpServletResponse resp);
//	public String execute();
}
