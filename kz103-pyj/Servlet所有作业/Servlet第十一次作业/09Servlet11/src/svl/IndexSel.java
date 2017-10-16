package svl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import entity.Users;

public class IndexSel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1,编码
		
		//2,取值:默认值
		int page =1;
		int pagesize =8;
		
		//判断是否带了参数
		String spage = request.getParameter("page");
		if(spage!=null){
			page= Integer.parseInt(spage);
		}
		//3,调dao:分页查询的方法
		List<Users> list =UsersDao.selByPage(pagesize, page);
		//得到总页数
		int max = UsersDao.getMaxPage(pagesize);
		//4,跳到jsp:跳到首页显示第1页数据
		if(list.size()>0){
			request.setAttribute("list",list);
			request.setAttribute("page",page);
			request.setAttribute("max",max);
			request.getRequestDispatcher("index_page.jsp").forward(request, response);
		}
	}
}
