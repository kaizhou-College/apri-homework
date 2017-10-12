package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProvinceDao;
import entity.Province;

public class ProvinceServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1,��ȡ���е�ʡ�ݵ���Ϣ
		List<Province> pros = new ProvinceDao().listPro();
		//2,ת����city.jsp
		req.setAttribute("pros", pros);
		req.getRequestDispatcher("city.jsp").forward(req, resp);
	}
}
