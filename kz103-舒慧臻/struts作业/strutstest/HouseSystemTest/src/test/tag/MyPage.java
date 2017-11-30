package test.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyPage extends SimpleTagSupport {
	private int page;
	private int pageSize;
	private String pageUrl;
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<div align='center'");
		if(page!=1){
			out.print("<a href='"+pageUrl+"?index=1'>首页</a>");
			out.print("&nbsp;");
			out.print("<a href='"+pageUrl+"?index="+(page-1)+"'>上一页</a>");
		}else{
			out.print("<a>首页</a>");
			out.print("&nbsp;");
			out.print("<a>上一页</a>");
		}
		out.print("&nbsp;");
		out.print(page+"/"+pageSize);
		out.print("&nbsp;");
		if(page!=pageSize){
			out.print("<a href='"+pageUrl+"?index="+pageSize+"'>尾页</a>");
			out.print("&nbsp;");
			out.print("<a href='"+pageUrl+"?index="+(page-1)+"'>下一页</a>");
		}else{
			out.print("<a>尾页</a>");
			out.print("&nbsp");
			out.print("<a>下一页");
		}
		out.print("<form action='"+pageUrl+"'>");
		out.print("<input name='index' size='1'/>");
		out.print("		<input type='submit' value='GO'/> ");
		out.print("<form>");
		out.print("</div");
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String getPageUrl() {
		return pageUrl;
	}


	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}


}
