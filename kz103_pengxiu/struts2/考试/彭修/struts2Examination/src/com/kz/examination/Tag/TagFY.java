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
			out.print("<a href='"+pageUrl+"?indexces=1'>��ҳ&nbsp;</a>");
			out.print("<a href='"+pageUrl+"?indexces="+(pageIndex-1)+"'>&nbsp;��һҳ</a>&nbsp;&nbsp;"+pageIndex+"/"+pageSize+"&nbsp;&nbsp;");
		}else{
			out.print("��ҳ&nbsp;");
			out.print("&nbsp;��һҳ&nbsp;&nbsp;"+pageIndex+"/"+pageSize+"&nbsp;&nbsp;");
		}
		if(pageIndex!=pageSize){
			out.print("<a href='"+pageUrl+"?indexces="+(pageIndex+1)+"'>&nbsp;��һҳ&nbsp;&nbsp;</a>");
			out.print("<a href='"+pageUrl+"?indexces="+pageSize+"'>&nbsp;βҳ</a>");
		}else{
			out.print("&nbsp;��һҳ&nbsp;");
			out.print("&nbsp;βҳ&nbsp;");
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
