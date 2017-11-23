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
	//模型驱动
	private QueryUser qu = new QueryUser();
	private List<User>  users;
	private String[] interests;
	
	//文件上传
	private File upload;
	private String uploadFileName;
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
	 * 按条件进行分页显示所有的用户
	 * @return
	 */
	public String list(){
		int max = ub.getMax(qu.getPageSize(),qu);
		qu.setMax(max);
		System.out.println("qu=="+qu);
		//分页查询s_user表
		users = ub.selByPage(User.class,qu.getPage(),qu.getPageSize(),qu);
		//System.out.println(users);
		return "list_success";
	}
	public String edit(){
		//1,根据id查询该用户信息
		user = ub.findById(user.getUserID());
		//处理爱好的显示问题
		//看电影, 旅游, 健身, 购物, 睡觉
		if(user.getInterest()!=null){
			interests = user.getInterest().split(", ");
		}
		//2,跳转到编辑页面显示该用户信息
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
