package Tag;
import java.io 

.IOException;
import java.io 

.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class TagFY extends SimpleTagSupport{
	public int pageIndex;
	public int pageSize;
	private String pageUrl;
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<div align='center'>");
		if(pageIndex!=1){
			out.print("<a href='"+pageUrl+"?index=1'>��ҳ</a>");
			out.print("&nbsp;");
			out.print("<a href='"+pageUrl+"?index="+(pageIndex-1)+"'>��һҳ</a>");
		}else{
			out.print("<a>��ҳ</a>");
			out.print("&nbsp;");
			out.print("<a>��һҳ</a>");
		}
		out.print("&nbsp;");
		out.print(pageIndex+"/"+pageSize);
		out.print("&nbsp;");
		
		if(pageIndex!=pageSize){
			out.print("<a href='"+pageUrl+"?index="+pageSize+"'>βҳ</a>");
			out.print("&nbsp;");
			out.print("<a href='"+pageUrl+"?index="+(pageIndex+1)+"'>��һҳ</a>");
		}else{
			out.print("<a>βҳ</a>");	
			out.print("&nbsp;");
			out.print("<a>��һҳ</a>");
		}
		out.print("<form action='"+pageUrl+"'>");
		out.print("<input name='index' size='1' >");
		out.print("	<input type='submit' value='GO'> ");
		out.print("</form>");
		out.print("</div>");
		
	}
	

	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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