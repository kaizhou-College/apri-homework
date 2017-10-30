package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.Basedao;
import dao.UsersDao;

import entity.Orders;
//��������//����
public class OrderAction {
	public String execute(){
		HttpServletRequest req=ServletActionContext.getRequest();
		Orders o=new Orders();
		try {
			List<Orders> list = UsersDao.select(o);
			req.setAttribute("list", list);
			return "yes";
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "no";
	}
}
