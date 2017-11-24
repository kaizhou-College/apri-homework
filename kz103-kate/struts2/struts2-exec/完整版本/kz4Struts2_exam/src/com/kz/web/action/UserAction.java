package com.kz.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.kz.biz.UserBiz;
import com.kz.entity.QueryUser;
import com.kz.entity.User;
import com.kz.util.DownloadUtils;
import com.kz.util.FileNameUtils;
import com.kz.web.exception.MyException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
/**
 * 
 * <p>Title: UserAction</p>
 * <p>Description: {针对User表的action}</p>
 * <p>Company: www.kaizhouedu.com</p> 
 * @author	凯舟.陈超
 * @date	2017-5-23
 * @version 1.0
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动
	private User user = new User();
	//属性驱动
	private QueryUser queryUser;
	private UserBiz userBiz = new UserBiz();
	//文件上传
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	private List<User> users;
	
	public User getModel(){
		return user;
	}
	@InputConfig(resultName="login_input")
	public String login(){
		//System.out.println("进入login。。。。");
		//System.out.println(user);
		//1,查询数据库是否有该用户？web-->biz--->dao
		User tempUser = userBiz.loginByName(user);
		if(tempUser==null){
			//用户名密码错误---重新登录 同时要在登录页面展示错误的信息
			//<s:actionError>
			this.addActionError("用户名或者密码错误！");
			//<s:actionFiledError>
			//this.addFieldError(fieldName, errorMessage)
			return LOGIN;
		}
		//登录成功--要将登录人的信息保存到session
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return "login_success";
	}
	public String find(){
		//criteria:条件  标准
		users = userBiz.findByCriteria(queryUser);
		if(users==null){
			// 没有查询到数据,1.携带错误信息  2，在哪里展示错误信息
			// TODO Auto-generated catch block
		}
		return "list_success";
	}
	public String list(){
		//查询数据库的s_user表：web--biz--dao
		users = userBiz.list();//值栈
		if(users==null){
			// 没有查询到数据,1.携带错误信息  2，在哪里展示错误信息
			// TODO Auto-generated catch block
		}
		return "list_success";
	}
	// 添加: 修改验证出错的result的默认值input为我们自己定义的名字
	@InputConfig(resultName="save_input")
	public String save(){
		//user对象中的filename属性和path属性没有值？
		if(upload!=null){//要上传简历
			System.out.println(upload+"\t"+uploadContentType+"\t"+uploadFileName);
			//path的值：d:\\upload\\随机文件名
			String newFileName = FileNameUtils.getUUIDName(uploadFileName);
			user.setPath("d:\\upload\\"+newFileName);
			//filename的值：uploadFileName
			user.setFilename(uploadFileName);
			// 文件上传的操作
			try {
				FileUtils.copyFile(upload, new File("d:\\upload\\"+newFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//将用户的信息添加到数据库：web--biz---dao
		userBiz.save(user);
		return "save_success";
	}
	//查看单个员工的信息
	public String view() {
		String str =null;
		//System.out.println(str.length());
		try {
			System.out.println(10/0);
			user = userBiz.view(user.getUserID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("查询单个用户出错！！"+this.getClass().getSimpleName());
		}
		//e.printStackTrace();
		if(user==null){
			//throw new MyException("查询当个用户的时候产出了异常!"+this.getClass().getSimpleName());
		}
		return "view_success";
	}
	public String edit(){
		System.out.println("进入修改.....");
		if(upload!=null){//上传简历
			System.out.println(upload+"\t"+uploadContentType+"\t"+uploadFileName);
			//path的值：d:\\upload\\随机文件名
			String newFileName = FileNameUtils.getUUIDName(uploadFileName);
			user.setPath("d:\\upload\\"+newFileName);
			//filename的值：uploadFileName
			user.setFilename(uploadFileName);
			//获取旧简历的用户
			User oldUser = userBiz.view(user.getUserID());
			//删除旧简历
			try{
				File file = new File(oldUser.getPath());
				if(file!=null){
					file.delete();//删除旧简历
				}
			}catch (Exception e) {
				//TODO 旧用户本来就没有简历
			}
			// 文件上传的操作
			try {
				FileUtils.copyFile(upload, new File("d:\\upload\\"+newFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//更新新简历
			userBiz.update(user,true);//需要更新 path和filename字段
		}else{
			userBiz.update(user,false);//不需要更新 path和filename字段
		}
		//跳转查询的方法   显示所有用户的信息
		return list();
	}
	//查询当个运功信息为了修改
	public String findForEdit(){
		user = userBiz.view(user.getUserID());
		if(user==null){
			//TODO 判断根据id获取用户为null
		}
		return "edit_success";
	}
	//下载简历
	public String download(){
		return "download_success";
	}
	//${inputStream}
	public InputStream getInputStream(){
		if(user.getPath()!=null){
			try {
				//1,直接改数据库  2，将\替换\\
				String path = user.getPath().replace("\\", "/");
				return new FileInputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//${contentType} 下载的文件的内容类型
	public String getContentType(){
		if(user.getPath()!=null){
			//path=d:\\upload\\f7377bd4-aa19-4be7-94bf-5ff00127f96d.png
			return ServletActionContext.getServletContext().getMimeType(user.getPath().substring(user.getPath().lastIndexOf("\\")+1));
		}
		return null;
	}
	//${downloadFileName}
	public String getDownloadFileName(){
		if(user.getPath()!=null){
			//浏览器会对中文进行加密----解码
			String agent = ServletActionContext.getRequest().getHeader("User-Agent");
			try {
				return DownloadUtils.getDownloadFileName(agent, user.getPath().substring(user.getPath().lastIndexOf("\\")+1));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public QueryUser getQueryUser() {
		return queryUser;
	}
	public void setQueryUser(QueryUser queryUser) {
		this.queryUser = queryUser;
	}
	
	
	
	
	
	
}
