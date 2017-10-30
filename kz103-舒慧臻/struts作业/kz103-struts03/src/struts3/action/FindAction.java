package struts3.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import struts3.dao.BaseDao;
import struts3.entity.Orders;

//ÊôÐÔÇý¶¯
public class FindAction {
	public void execute() {
		BaseDao dao = new BaseDao();
		Orders or = new Orders();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		List<Orders> list = dao.query(or.getClass());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		req.setAttribute("list", list);
		try {
			req.getRequestDispatcher("success.jsp").forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
