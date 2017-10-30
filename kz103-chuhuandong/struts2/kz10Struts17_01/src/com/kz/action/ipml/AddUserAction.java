package com.kz.action.ipml;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.text.resources.FormatData;

import com.kz.action.Action;
import com.kz.dao.UserDao;
import com.kz.entity.ActionForward;
import com.kz.entity.Users;
//（3）准备一个AddUserAction实现Action接口，实现execute(),拿到用户名和密码和出生日期，调用UserDao中的addUser(User u),
//添加数据.如果添加成功就封装ActionForward（success.jsp,true），如果失败ActionForward（error.jsp,true),
//在actionConfig.properties配置好uri(addUser)和AddUserAction关系
public class AddUserAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse reponse) {
		ActionForward af= null;
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Users user = new Users(name,pwd);
		System.out.println(user);
		int num = UserDao.addUser(user);
		if(num>0){
			af = new ActionForward("success.jsp",true);
		}else{
			af = new ActionForward("error.jsp",true);
		}
		return af;
	}
	
}
