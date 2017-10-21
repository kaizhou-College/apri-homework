package com.kz.svl;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.dao.BaseDao;
import com.kz.entity.Message;

public class FindMsgServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����");
		//��ҳ��ѯmessage
		//Ĭ��ֵ
		int page = 1;
		String spage = req.getParameter("page");
		if(spage!=null&&spage.trim().length()>0){
			page = Integer.parseInt(spage);
		}
		int pageSize=2;
		BaseDao<Message> db = new BaseDao<Message>();
		//1.1,��ҳ��ѯ����
		List<Message> list = db.queryDataPage(Message.class, page, pageSize);
		//1.2 �õ����ҳ��
		int max = db.queryMaxPage(Message.class, pageSize);
		//2,���������ݵ�jsp:show.jsp
		req.setAttribute("msgs",list);
		//���ҳ��
		req.setAttribute("max",max);
		//��ǰҳ��
		req.setAttribute("page",page);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
		
		
		
		
	}
}
