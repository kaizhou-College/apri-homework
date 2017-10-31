package com.kz.Action;

import com.kz.entity.*;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.kz.dao.BaseDao;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private HttpServletRequest req;
	private HttpServletResponse res;
	public String execute() throws Exception {
		req = ServletActionContext.getRequest();
		res = ServletActionContext.getResponse();
		PrintWriter out = res.getWriter();
		String name=req.getParameter("name");
		String pwd = req.getParameter("pwd");
		BaseDao bs = new BaseDao();
		Class cls = Users.class;
		List<Users> list = bs.getUser(cls, name);
		System.out.println(list);
		System.out.println(name);
		if(name.trim()!=""){
			if(pwd.trim()!=""){
				if(list.size()>0){
					if(list.get(0).getUserpwd().equals(pwd)){
						out.print("ok");
					}else{
						out.print("pwdisError");
					}
				}else{
					out.print("userisNull");
				}
			}else{
				out.print("pwdisNull");
			}
		}else{
			out.print("nameisNull");
		}
		return null;
	}
}
