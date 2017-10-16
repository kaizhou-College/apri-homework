package com.kz.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*1���Զ����ҳ��ǩ*/
public class QueryByPage extends SimpleTagSupport{

	private int page;
	private int max;
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		StringBuffer str = new StringBuffer();
		str.append("<div align='center'>");
		if(page!=1){
			str.append("<a href='IndexSel?page=1'>��ҳ</a>");
			str.append("<a href='IndexSel?page="+(page-1)+"'>��һҳ</a>");
		}
		str.append(page+"/"+max);
		if(page!=max){
			str.append("<a href='IndexSel?page="+max+"'>ĩҳ</a>");
			str.append("<a href='IndexSel?page="+(page+1)+"'>��һҳ</a>");
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
