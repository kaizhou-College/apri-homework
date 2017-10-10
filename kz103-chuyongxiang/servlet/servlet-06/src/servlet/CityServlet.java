package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDao;
import entity.City;
//根据省份的id获取对应的市
/*
 * <citys>
 * 	<city id="1">
 * 		<name>唐山市</name>
 * 	</city>
 * <city id="2">
 * 		<name>秦皇岛市</name>
 * 	</city>
 * <city id="3">
 * 		<name>邢台市</name>
 * 	</city>
 * </citys>
 */
public class CityServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println("进入CityServlet");
		//1,获取省份id
		String spid = req.getParameter("pid");
		int pid = -1;
		if(spid!=null&&spid.trim().length()>0){
			pid = Integer.parseInt(spid);
		}
		//2,根据身份id查询市
		List<City> citys = new CityDao().findByPid(pid);
		//3,将所有的市响应给ajax(纯文本，xml格式的文本)
		StringBuffer xml = new StringBuffer("<citys>");
		for(City city :citys){
			xml.append("<city id='"+city.getCid()+"'>");
			xml.append("<name>"+city.getName()+"</name>");
			xml.append("</city>");
		}
		xml.append("</citys>");
		System.out.println(xml);
		out.print(xml);
		out.close();
	}
}




