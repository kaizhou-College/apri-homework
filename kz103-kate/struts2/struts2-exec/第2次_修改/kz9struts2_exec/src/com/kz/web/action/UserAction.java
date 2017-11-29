package com.kz.web.action;
import java.io.File;
import java.util.List;

import sun.security.krb5.internal.UDPClient;

import com.kz.biz.UserBiz;
import com.kz.entity.QueryUser;
import com.kz.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
public class UserAction implements ModelDriven<QueryUser>{
	private User user ;
	private UserBiz ub = new UserBiz();
	//ģ������
	private QueryUser qu = new QueryUser();
	private List<User>  users;
	private String[] interests;
	
	//�ļ��ϴ�
	private File upload;
	private String uploadFileName;
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
	 * ���������з�ҳ��ʾ���е��û�
	 * @return
	 */
	public String list(){
		int max = ub.getMax(qu.getPageSize(),qu);
		qu.setMax(max);
		System.out.println("qu=="+qu);
		//��ҳ��ѯs_user��
		users = ub.selByPage(User.class,qu.getPage(),qu.getPageSize(),qu);
		//System.out.println(users);
		return "list_success";
	}
	public String edit(){
		//1,����id��ѯ���û���Ϣ
		user = ub.findById(user.getUserID());
		//�����õ���ʾ����
		//����Ӱ, ����, ����, ����, ˯��
		if(user.getInterest()!=null){
			interests = user.getInterest().split(", ");
		}
		//2,��ת���༭ҳ����ʾ���û���Ϣ
		return "edit_success";
	}
	public String editSubmit(){
		System.out.println("upload="+upload+",uploadFileName==="+uploadFileName);
		System.out.println("user==="+user);
		int re = ub.updateUser(user,upload,uploadFileName);
		return "editSubmit_success";
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public QueryUser getModel() {
		return qu;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
}
