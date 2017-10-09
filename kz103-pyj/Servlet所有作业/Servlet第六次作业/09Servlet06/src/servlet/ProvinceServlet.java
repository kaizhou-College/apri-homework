package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Provincedao;
import entity.Province;

public class ProvinceServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//��ȡ���е�ʡ��
		List<Province> pros=new Provincedao().listpro();
		//ת����city.jsp
		req.setAttribute("pros", pros);
		req.getRequestDispatcher("city.jsp").forward(req, res);
		
	}

}
