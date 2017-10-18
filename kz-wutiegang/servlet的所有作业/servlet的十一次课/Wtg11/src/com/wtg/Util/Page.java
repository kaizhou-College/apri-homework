package com.wtg.Util;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Page extends SimpleTagSupport{
	
	private int currentPage;
	private int maxPage;
	@Override
	public void doTag() throws JspException, IOException {

		// TODO Auto-generated method stub
		JspWriter out = getJspContext().getOut();
		StringBuffer sql=new StringBuffer("<div align='center'>");
		if(currentPage!=1){
			sql.append("<a href='pageServlet?currentPage=1'>首页</a>");
			sql.append("<a href='pageServlet?currentPage="+(currentPage-1)+"'>上一页</a>");
		}
		sql.append("当前为"+currentPage+"页/共有"+maxPage+"页");
		sql.append("<input size='1' id='ipage'/>页");
		sql.append("<button onclick='DoGo("+maxPage+")'>Go</button>");
		if(currentPage!=maxPage){
			sql.append("<a href='pageServlet?currentPage="+(currentPage+1)+"'>下一页</a>");
			sql.append("<a href='pageServlet?currentPage="+maxPage+"'>末页</a>");
		}
		sql.append("</div>");
		System.out.println(sql.toString());
		out.print(sql.toString());
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
}
