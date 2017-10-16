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
		//1,����
		
		//2,ȡֵ:Ĭ��ֵ
		int page =1;
		int pagesize =8;
		
		//�ж��Ƿ���˲���
		String spage = request.getParameter("page");
		if(spage!=null){
			page= Integer.parseInt(spage);
		}
		//3,��dao:��ҳ��ѯ�ķ���
		List<Users> list =UsersDao.selByPage(pagesize, page);
		//�õ���ҳ��
		int max = UsersDao.getMaxPage(pagesize);
		//4,����jsp:������ҳ��ʾ��1ҳ����
		if(list.size()>0){
			request.setAttribute("list",list);
			request.setAttribute("page",page);
			request.setAttribute("max",max);
			request.getRequestDispatcher("index_page.jsp").forward(request, response);
		}
	}
}
