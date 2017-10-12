package com.wtg.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Dao.CityDao;
import com.wtg.entity.City;

@SuppressWarnings("serial")
public class CityServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/xml;charset=utf-8");
		PrintWriter out=res.getWriter();
		System.out.println("进入CityServlet");
		//获取省份id
		String spid = req.getParameter("pid");
		int pid=-1;
		if(spid!=null&&spid.trim().length()>0){
			pid=Integer.parseInt(spid);
		}
		ArrayList<City> citys=new CityDao().findCity(pid);
		StringBuffer xml=new StringBuffer("<citys>");
		for (City city : citys) {
			xml.append("<city id='"+city.getCid()+"'>");
			xml.append("<name>"+city.getCname()+"</name>");
			xml.append("</city>");
		}
		xml.append("</citys>");
		System.out.println(xml);
		out.print(xml);
		out.close();
	}
}
