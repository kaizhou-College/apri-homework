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
	 * ȥ��¼
	 * @return
	 */
	public String toLogin(){
		return "toLogin";
	}
	/**
	 * ��¼
	 * 	��ȥ��action------>dao
	 *  ���ڣ�action------>biz------>dao
	 * @return
	 */
	public String login(){
		//��¼���߼�
		//1,��ѯ���ݿ���֤�û�����������Ƿ���ȷ
		user = ub.findByNameAndPwd(user);
		if(user!=null){
			//2.1,��֤ͨ�������û�����session
			ActionContext.getContext().getSession().put("user", user);
			//3.������վ����ҳ
			return "login_success";
		}else{
			//2,2��ת����¼ҳ��
			return "toLogin";
		}
	}
	/**
	 * ��ҳ��ʾ���е��û�
	 * @return
	 */
	public String list(){
		page = 1;
		pageSize = 5;
		//��ҳ��ѯs_user��
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
