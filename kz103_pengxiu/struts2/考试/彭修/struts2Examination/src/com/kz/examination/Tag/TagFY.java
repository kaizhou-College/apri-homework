package com.kz.examination.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kz.examination.entity.QueryView;




public class TagFY extends SimpleTagSupport{
	private int pageIndex;
	private int pageSize;
	private String pageUrl;
	public void doTag() throws JspException, IOException {
	JspWriter out=getJspContext().getOut();
		if(pageIndex!=1){
			out.print("<a href='"+pageUrl+"?indexces=1'>首页&nbsp;</a>");
			out.print("<a href='"+pageUrl+"?indexces="+(pageIndex-1)+"'>&nbsp;上一页</a>&nbsp;&nbsp;"+pageIndex+"/"+pageSize+"&nbsp;&nbsp;");
		}else{
			out.print("首页&nbsp;");
			out.print("&nbsp;上一页&nbsp;&nbsp;"+pageIndex+"/"+pageSize+"&nbsp;&nbsp;");
		}
		if(pageIndex!=pageSize){
			out.print("<a href='"+pageUrl+"?indexces="+(pageIndex+1)+"'>&nbsp;下一页&nbsp;&nbsp;</a>");
			out.print("<a href='"+pageUrl+"?indexces="+pageSize+"'>&nbsp;尾页</a>");
		}else{
			out.print("&nbsp;下一页&nbsp;");
			out.print("&nbsp;尾页&nbsp;");
		}
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
