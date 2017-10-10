package com.kz.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.dao.ProvinceDao;
import com.kz.entity.Province;

public class ProvinceServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1,获取所有的省份的信息
		List<Province> pros = new ProvinceDao().listPro();
		//2,转发到city.jsp
		req.setAttribute("pros", pros);
		req.getRequestDispatcher("city.jsp").forward(req, resp);
	}
}
