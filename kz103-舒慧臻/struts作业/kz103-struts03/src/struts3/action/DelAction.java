package struts3.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import struts3.dao.BaseDao;
import struts3.entity.Orders;

public class DelAction {
	private int ordered;
	
	public String execute() {
		BaseDao dao = new BaseDao();
		int num = dao.del(Orders.class, ordered);
		System.out.println(ordered);
		if(num>0){
			return "success";
		}else{
			return "update";
		}
	}
	
	public int getOrdered() {
		return ordered;
	}
	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}

}
