package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;

public class LoginAction{
	private String name;
	private String pwd;
	
	public String execute(){
		System.out.println("������LoginAction");
		System.out.println(name);
		System.out.println(pwd);
		boolean flag = BaseDao.select(name, pwd);
		if(flag){
			System.out.println("׼������success.jsp");
			return "success";
		}else{
			System.out.println("׼������login.jsp");
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
