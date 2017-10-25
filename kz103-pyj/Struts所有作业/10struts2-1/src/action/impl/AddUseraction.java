package action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.Basedao;
import entity.Users;

public class AddUseraction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		int num = Basedao.Add("seq_users",new Users(name,pwd));
		if(num>0){
			return new ActionForward("success",true);
		}
		return new ActionForward("error",true);
	}
}
