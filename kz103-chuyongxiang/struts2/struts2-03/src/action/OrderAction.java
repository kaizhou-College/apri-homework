package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.sun.net.httpserver.Authenticator.Success;

import dao.BaseDao;
import entity.Users;

public class OrderAction implements Action{
	private String name;
	private String pwd;
	private Users user = new Users();
	
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
	
	public String execute() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		HttpServletRequest req=ServletActionContext.getRequest();
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("进入OrderAction 执行execute方法");
		List<Users> cs=BaseDao.select(user);
		for (int i = 0; i < cs.size(); i++) {
			if(cs.get(i).getUserName().equals(name)){
				System.out.println("用户名正确");
				if(cs.get(i).getUserPwd().equals(pwd)){
					System.out.println("密码正确");
					System.out.println("登陆成功");
					return "SUCCESS";
				}else{
					System.out.println("密码错误");
				}
			}else{
				System.out.println("用户名错误");
			}
		}
		return "NO";
	}
}
