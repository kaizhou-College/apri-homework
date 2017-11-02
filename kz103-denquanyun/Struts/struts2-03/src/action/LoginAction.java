package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.BaseDao;
import entity.Orders;

public class LoginAction implements Action{
	private List list;
	private String uname;
	private String password;
	public String execute(){
		System.out.println("name"+uname);
		System.out.println("pwd"+password);
		String query = BaseDao.loginQuery(uname,password);
		System.out.println(query);
		if(query.equals("已有")){
			list = BaseDao.queryAll(Orders.class);
			return "success";
		}else{
			uname="";
			password="";
			System.out.println("进来了");
			return "error";
		}
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
