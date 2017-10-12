package com.wtg.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.wtg.Dao.ProvinceDao;
import com.wtg.entity.Province;

public class ProvinceServlet extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取所有的省份的信息
		ArrayList<Province> pro=new ProvinceDao().getAllProvince();
		//转发到City.jsp中
		req.setAttribute("pro", pro);
		req.getRequestDispatcher("city.jsp").forward(req, res);
	}
}
