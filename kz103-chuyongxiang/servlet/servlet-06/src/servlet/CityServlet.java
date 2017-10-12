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
//����ʡ�ݵ�id��ȡ��Ӧ����
/*
 * <citys>
 * 	<city id="1">
 * 		<name>��ɽ��</name>
 * 	</city>
 * <city id="2">
 * 		<name>�ػʵ���</name>
 * 	</city>
 * <city id="3">
 * 		<name>��̨��</name>
 * 	</city>
 * </citys>
 */
public class CityServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println("����CityServlet");
		//1,��ȡʡ��id
		String spid = req.getParameter("pid");
		int pid = -1;
		if(spid!=null&&spid.trim().length()>0){
			pid = Integer.parseInt(spid);
		}
		//2,�������id��ѯ��
		List<City> citys = new CityDao().findByPid(pid);
		//3,�����е�����Ӧ��ajax(���ı���xml��ʽ���ı�)
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




