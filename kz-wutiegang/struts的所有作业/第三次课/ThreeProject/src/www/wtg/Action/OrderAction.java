package www.wtg.Action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import www.wtg.Dao.BaseDao;
import www.wtg.entity.Orders;

import com.opensymphony.xwork2.Action;

public class OrderAction implements Action,RequestAware,SessionAware,ApplicationAware{
	private Map<String, Object> request;
	private Map<String, Object> sessionMap;
	private Map<String, Object> applicationMap;
	public String execute() throws Exception {
		List<Orders> list = BaseDao.findAll(Orders.class);
		
		request.put("list", list);
		return "success";
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.sessionMap=session;
	}

	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.applicationMap=application;
	}
	
	

	
}
