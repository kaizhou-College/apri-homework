package www.wtg.Action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import www.wtg.Dao.BaseDao;
import www.wtg.entity.Orders;

import com.opensymphony.xwork2.Action;

public class updateAction implements Action,RequestAware{
	private int ordered;
	private Map<String, Object> request;
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Orders o=new Orders();
		List<Orders> list = BaseDao.findAllById(o, ordered);
		Orders orders = list.get(0);
		request.put("orders", orders);
		return "success";
	}

	public int getOrdered() {
		return ordered;
	}

	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
}
