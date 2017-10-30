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
//��3��׼��һ��AddUserActionʵ��Action�ӿڣ�ʵ��execute(),�õ��û���������ͳ������ڣ�����UserDao�е�addUser(User u),
//�������.�����ӳɹ��ͷ�װActionForward��success.jsp,true�������ʧ��ActionForward��error.jsp,true),
//��actionConfig.properties���ú�uri(addUser)��AddUserAction��ϵ
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
