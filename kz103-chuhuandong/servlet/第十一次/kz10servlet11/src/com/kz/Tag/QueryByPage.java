package com.kz.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*1，自定义分页标签*/
public class QueryByPage extends SimpleTagSupport{

	private int page;
	private int max;
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		StringBuffer str = new StringBuffer();
		str.append("<div align='center'>");
		if(page!=1){
			str.append("<a href='IndexSel?page=1'>首页</a>");
			str.append("<a href='IndexSel?page="+(page-1)+"'>上一页</a>");
		}
		str.append(page+"/"+max);
		if(page!=max){
			str.append("<a href='IndexSel?page="+max+"'>末页</a>");
			str.append("<a href='IndexSel?page="+(page+1)+"'>下一页</a>");
		}
		str.append("</div>");
		out.print(str.toString());
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
}
