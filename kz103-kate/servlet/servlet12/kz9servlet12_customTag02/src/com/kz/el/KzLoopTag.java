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
			return EVAL_BODY_AGAIN;//����ִ�б�ǩ��
		}
		//return EVAL_BODY_AGAIN;//����ִ�б�ǩ��
		return SKIP_BODY;//��ǩ��ִ���������doEndTag()����
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag.....");
		//��������������ݵ��ͻ���(�����)
		//1,��ȡ��ǩ�������
		String body  = getBodyContent().getString();
		try {
			System.out.println("body==="+body);
			//pageContext.getOut().print(body);
			//getPreviousOut().print(body);
			//�����ǩ�嵽�ͻ���(�����)
			this.bodyContent.getEnclosingWriter().write(body);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;//����ִ��jspҳ����������
		//return SKIP_PAGE;//����jspҳ����������
	}

	@Override
	public void doInitBody() throws JspException {
		
		System.out.println("doInitBody.....");
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag.......");
		//return EVAL_BODY_INCLUDE;//ֱ�������ǩ��
		return EVAL_BODY_BUFFERED;//����ǰ����뻺��
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
