package web.action;


import org.apache.struts2.ServletActionContext;

import biz.UserBiz;
import entity.Tbl_User;

public class UserAction {
	private UserBiz ub = new UserBiz();
	private Tbl_User user;
	public String login(){
		user = ub.login(user);
		if(user!=null){
			ServletActionContext.getRequest().getSession().setAttribute("user",user);
			return "login_success";
		}else{
			return "login_error";
		}
	}
	public Tbl_User getUser() {
		return user;
	}
	public void setUser(Tbl_User user) {
		this.user = user;
	}
	public String insert(){
		int num = ub.insert(user);
		if(num>0){
			ServletActionContext.getRequest().getSession().setAttribute("user",user);
			return "insert_success";
		}else{
			return "insert_error";
		}
	}
	public String exit(){
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "exit_success";
	}
	public String indexlogin(){
		user = ub.login(user);
		if(user!=null){
			ServletActionContext.getRequest().getSession().setAttribute("user",user);
			return "indexlogin_success";
		}else{
			return "indexlogin_error";
		}
	}
	
}
