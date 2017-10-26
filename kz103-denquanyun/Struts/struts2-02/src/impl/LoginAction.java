package impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BaseDao;

public class LoginAction{
	private String name;
	private String pwd;
	public void init(HttpServletRequest req, HttpServletResponse resp){
		name = req.getParameter("name");
		pwd=req.getParameter("pwd");
	}
	public String execute(){
		System.out.println(name);
		System.out.println(pwd);
		boolean flag = BaseDao.isExist(name, pwd);
		if(flag){
			return "success";
		}else{
			return "error";
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
