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
		System.out.println("进入");
		//分页查询message
		//默认值
		int page = 1;
		String spage = req.getParameter("page");
		if(spage!=null&&spage.trim().length()>0){
			page = Integer.parseInt(spage);
		}
		int pageSize=2;
		BaseDao<Message> db = new BaseDao<Message>();
		//1.1,分页查询数据
		List<Message> list = db.queryDataPage(Message.class, page, pageSize);
		//1.2 得到最大页数
		int max = db.queryMaxPage(Message.class, pageSize);
		//2,跳到有数据的jsp:show.jsp
		req.setAttribute("msgs",list);
		//最大页数
		req.setAttribute("max",max);
		//当前页数
		req.setAttribute("page",page);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
		
		
		
		
	}
}
