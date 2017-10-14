package com.kz.utils.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
	<div align="center">
	<%if(cur_page!=1){ %>
	<a href="IndexSel?page=1">��ҳ</a>
	<a href="IndexSel?page=<%=cur_page-1%>">��һҳ</a>
	<%} %>
	
	��ǰ<%=cur_page%>ҳ/��<%=max%>ҳ
	<input id="ipage" size="1"/>ҳ
	<button onclick="DoGo(<%=max%>)">GO</button>	
	<%if(cur_page!=max){ %>
	<a href="IndexSel?page=<%=max %>">ĩҳ</a>
	<a href="IndexSel?page=<%=cur_page+1%>">��һҳ</a>
	<%} %>
	</div>
 */
public class KzPage_back extends SimpleTagSupport{
	/*��ǰҳ��*/
	private int page;
	/*���ҳ��*/
	private int max;
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		StringBuffer pageHtml = new StringBuffer();
		
		pageHtml.append("<div align='center'>");
		if(page!=1){
			pageHtml.append("<a href='IndexSel?page=1'>��ҳ</a>");
			pageHtml.append("<a href='IndexSel?page="+(page-1)+"'>��һҳ</a>");
		}
		
		pageHtml.append("��ǰ"+page+"ҳ/��"+max+"ҳ");
		pageHtml.append("<input id='ipage' size='1'/>ҳ");
		pageHtml.append("<button onclick='DoGo("+max+")'>GO</button>");
		
		if(page!=max){
			pageHtml.append("<a href='IndexSel?page="+max+"'>ĩҳ</a>");
			pageHtml.append("<a href='IndexSel?page="+(page+1)+"'>��һҳ</a>");
		}
		pageHtml.append("</div>");
		System.out.println(pageHtml.toString());
		out.print(pageHtml.toString());
		
		//out.print("<font color='red' size='100'>"+page+"&nbsp;&nbsp;&nbsp;"+max+"</font>");
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
