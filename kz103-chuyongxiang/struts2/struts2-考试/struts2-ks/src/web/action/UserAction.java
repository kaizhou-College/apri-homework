package web.action;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDao;
import entity.Tbl_User;


public class UserAction extends ActionSupport {
	private String uname;
	private String upass;
	private Tbl_User user=new Tbl_User();
	
	
	//login_form页面的登陆
	public String login(){
//		System.out.println("进入了登陆方法");
//		System.out.println("name===="+uname);
//		System.out.println("password===="+upass);
		List<Tbl_User> cs=BaseDao.select(user);
		for (int i = 0; i < cs.size(); i++) {
			if(cs.get(i).getUname().equals(uname)){
				if(cs.get(i).getUpass().equals(upass)){
					System.out.println("登陆成功");
					System.out.println(cs);
					ServletActionContext.getRequest().getSession().setAttribute("user1",cs.get(i).getUname());
					ServletActionContext.getRequest().getSession().setAttribute("user2",cs.get(i).getUuid());
					return "login_ok";
				}
			}
		}
		System.out.println("用户名或者密码错误");
		return "login_no";
	}
	
	//index页面的登陆
	public String login2(){
//		System.out.println("进入了登陆方法");
//		System.out.println("name===="+uname);
//		System.out.println("password===="+upass);
		List<Tbl_User> cs=BaseDao.select(user);
		for (int i = 0; i < cs.size(); i++) {
			if(cs.get(i).getUname().equals(uname)){
				if(cs.get(i).getUpass().equals(upass)){
					System.out.println("登陆成功");
					ServletActionContext.getRequest().getSession().setAttribute("user1",cs.get(i).getUname());
					ServletActionContext.getRequest().getSession().setAttribute("user2",cs.get(i).getUuid());
					return "login2_ok";
				}
			}
		}
		System.out.println("用户名或者密码错误");
		return "login2_no";
	}

	//用户注册
	public String zhuce(){
		System.out.println("进入了注册");
		System.out.println("name===="+uname);
		System.out.println("password===="+upass);
		user.setUname(uname);
		user.setUpass(upass);
		int num=BaseDao.insert("SYS_C005294", user);
		System.out.println(num);
		return "zhuce_ok";
	}

	public String out(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "out";
	}

	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getUpass() {
		return upass;
	}



	public void setUpass(String upass) {
		this.upass = upass;
	}



	public Tbl_User getUser() {
		return user;
	}



	public void setUser(Tbl_User user) {
		this.user = user;
	}
	
	
}
