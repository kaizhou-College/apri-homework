package com.kz.el;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
/**
 * setPageContext();
 * setParent();
 * setAttribute();
 * <kztag:loop count="5">  doStart()
		<%=new Date()%>    setBodyContent-->doInitBody-->doAfterBody
	</kztag:loop>		   doEndTag()
	release() 
 * 
 * @author mr.chan
 *
 */
public class KzLoopTag extends BodyTagSupport {
	private int count;
	@Override
	public int doAfterBody() throws JspException {
		System.out.println("doAfterBody.....");
		
		if(count>1){
			count--;
			return EVAL_BODY_AGAIN;//重新执行标签体
		}
		//return EVAL_BODY_AGAIN;//重新执行标签体
		return SKIP_BODY;//标签体执行完毕跳到doEndTag()方法
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag.....");
		//控制输出缓存内容到客户端(浏览器)
		//1,获取标签体的内容
		String body  = getBodyContent().getString();
		try {
			System.out.println("body==="+body);
			//pageContext.getOut().print(body);
			//getPreviousOut().print(body);
			//输出标签体到客户端(浏览器)
			this.bodyContent.getEnclosingWriter().write(body);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;//继续执行jsp页面后面的内容
		//return SKIP_PAGE;//忽略jsp页面后面的内容
	}

	@Override
	public void doInitBody() throws JspException {
		
		System.out.println("doInitBody.....");
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag.......");
		//return EVAL_BODY_INCLUDE;//直接输出标签体
		return EVAL_BODY_BUFFERED;//将表前提放入缓存
	}

	@Override
	public BodyContent getBodyContent() {
		System.out.println("getBodyContent.......");
		return super.getBodyContent();
	}

	@Override
	public JspWriter getPreviousOut() {
		System.out.println("getPreviousOut......");
		return super.getPreviousOut();
	}

	@Override
	public void release() {
		
		System.out.println("release......");
		super.release();
	}

	@Override
	public void setBodyContent(BodyContent b) {
		System.out.println("setBodyContent.......");
		super.setBodyContent(b);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
