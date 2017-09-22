package Servlet01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Work9  extends GenericServlet {
	public Work9() {
		super();
	}
	public void destroy() {
		super.destroy();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
	}

	public void init() throws ServletException {
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
		//先准备一个字节流
			FileInputStream fis = new FileInputStream("E:/a.txt");
		//使用包装流InputStreamReader
			InputStreamReader isr = new InputStreamReader(fis);
		//使用BufferedReader
			BufferedReader br = new BufferedReader(isr);
			while(br.ready()){
				String str = br.readLine();
				out.print(str);
			}
			br.close();
			isr.close();
			fis.close();
	}

}
