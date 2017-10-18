package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//1.写一个类实现Servlet接口，然后向客户端输出一段歌词的信息，
//要输出时解决中文乱码问题。

public class Myservlet01  implements Servlet{

	public void destroy() {//销毁
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {//得到配置
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	//初始化
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	//服务
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("我身骑白马 走三关   我改换素衣 回中原    放下西凉 没人管   我一心只想 王宝钏");
	}

}
