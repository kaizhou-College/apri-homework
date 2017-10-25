package impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;
import entity.Users;

import action.Action;

public class AddUserAction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String birthday = req.getParameter("birthday");
		int num = BaseDao.insert("AA",new Users( name,pwd));
		if(num>0){
			return new ActionForward("success", true);
		}else{
			return new ActionForward("error", true);
		}
	}

}
