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
		//1.��ȡ���е�ʡ�ݵ���Ϣ
		ArrayList<Province> pro=new ProvinceDao().getAllProvince();
		//ת����City.jsp��
		req.setAttribute("pro", pro);
		req.getRequestDispatcher("city.jsp").forward(req, res);
	}
}
