package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.BaseDao;
import entity.Orders;

public class ListAction {
	public String execute(){
		HttpServletRequest req=ServletActionContext.getRequest();
		Orders o=new Orders();
		try {
			List<Orders> list = BaseDao.select(o);
			req.setAttribute("list", list);
			System.out.println("׼����ת����ʾҳ��");
			return "OK";
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "NO";
	}
}
