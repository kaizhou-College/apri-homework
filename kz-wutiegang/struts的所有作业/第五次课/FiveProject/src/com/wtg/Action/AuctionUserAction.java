package com.wtg.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wtg.Dao.BaseDao;
import com.wtg.Dao.UserDao;
import com.wtg.entity.Auction;
import com.wtg.entity.AuctionUser;

public class AuctionUserAction extends ActionSupport{
	private AuctionUser actionuser;

	private String loginCode;
	//待完善private Integer userType;
	//登录验证
	public String ceshi(){
		//System.out.println("uname===="+uname+"upsw======="+upsw);
		try {
			List<AuctionUser> all = BaseDao.findAll(AuctionUser.class);
			for (int i = 0; i < all.size(); i++) {
				if (all.get(i).getUsername().equalsIgnoreCase(actionuser.getUsername())) {
					HttpServletRequest request=ServletActionContext.getRequest();
					request.setAttribute("uname", actionuser.getUsername());
					System.out.println(request.getAttribute("uname"));
					request.setAttribute("upsw", actionuser.getUserpassword());
					boolean admin = UserDao.isAdmin(actionuser.getUsername(), actionuser.getUserpassword());
					if (admin==true) {
						return "admin_success";
					}else{
						return "user_success";
					}
					
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ceshi_file";
	}
	public String Mceshi(){
		//System.out.println("mname===="+actionuser.getUsername()+"mpsw======="+actionuser.getUserpassword());
		try {
			List<AuctionUser> all = BaseDao.findAll(AuctionUser.class);
			for (int i = 0; i < all.size(); i++) {
				if (all.get(i).getUsername().equalsIgnoreCase(actionuser.getUsername())) {
					HttpServletRequest request=ServletActionContext.getRequest();
					HttpSession session = request.getSession();
					session.setAttribute("mname", actionuser.getUsername());
					session.setAttribute("mpsw", actionuser.getUserpassword());
					boolean admin = UserDao.isAdmin(actionuser.getUsername(), actionuser.getUserpassword());
					//System.out.println("ddd=="+admin);
					if (admin==false) {
						return "Muser_success";
					}else{
						return "Madmin_success";
					}
					
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Mceshi_file";
	}
	//页面跳转的注册
	public String Zhuce(){
		return "Zhuce_success";
	}
	public String add(){
		int add=0;
		try {
			add = UserDao.add("seq_auctionuser", actionuser);
			System.out.println(add+"======");
			if (add>0) {
				if (actionuser.getUserisadmin()==1) {
					return "Adminadd_success";
				}else{
					return "add_success";
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "add_file";
	}
	//ajax的判断
	public void checkCode(){
		//System.out.println(loginCode+"    sajhfj ");;
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			PrintWriter out = response.getWriter();
			//从session中拿到code的值
			HttpSession session = request.getSession();
			String code = (String) session.getAttribute("code");
			//把两个值进行比较，看是否相等
			if (code.equalsIgnoreCase(loginCode)) {
				out.print("true");
			}else{
				out.print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//中英文切换
	public String check(){
		return "check_success";
	}
	public AuctionUser getActionuser() {
		return actionuser;
	}
	public void setActionuser(AuctionUser actionuser) {
		this.actionuser = actionuser;
	}
	/*public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}*/
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

}
