package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Citydao;
import entity.City;

public class CityServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("����cityservlet");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//��ʡ�ݵ�id
		String spid=req.getParameter("pid");
		int pid=-1;
		if(spid!=null&&spid.trim().length()>0){
			pid=Integer.parseInt(spid);
		}
		//����id����
		List<City> citys=new Citydao().Byid(pid);
		//������Ӧ��ajax
		StringBuffer xml=new StringBuffer("<citys>");
		for (City city : citys) {
			xml.append("<city id='"+city.getCid()+"'>");
			xml.append("<name>"+city.getCname()+"</name>");
			xml.append("</city>");
		}
		xml.append("</citys>");
		//System.out.println(xml);
		out.print(xml);
		out.close();
	}
}
