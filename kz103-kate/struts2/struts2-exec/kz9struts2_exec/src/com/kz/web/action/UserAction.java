package com.kz.web.action;
import java.util.List;

import com.kz.biz.UserBiz;
import com.kz.entity.User;
import com.opensymphony.xwork2.ActionContext;
public class UserAction {
	private User user ;
	private UserBiz ub = new UserBiz();
	private int page;
	private int pageSize;
	private List<User>  users;
	/**
	 * 去登录
	 * @return
	 */
	public String toLogin(){
		return "toLogin";
	}
	/**
	 * 登录
	 * 	过去：action------>dao
	 *  现在：action------>biz------>dao
	 * @return
	 */
	public String login(){
		//登录的逻辑
		//1,查询数据库验证用户名和密码的是否正确
		user = ub.findByNameAndPwd(user);
		if(user!=null){
			//2.1,验证通过保存用户名到session
			ActionContext.getContext().getSession().put("user", user);
			//3.跳到网站的主页
			return "login_success";
		}else{
			//2,2跳转到登录页面
			return "toLogin";
		}
	}
	/**
	 * 分页显示所有的用户
	 * @return
	 */
	public String list(){
		page = 1;
		pageSize = 5;
		//分页查询s_user表
		users = ub.selByPage(User.class,page,pageSize);
		System.out.println(users);
		return "list_success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
