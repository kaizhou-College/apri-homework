package com.wtg.Switch;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Switch extends BodyTagSupport{
	//�����������ֵ
	private String test;
	//�����������ֵ���
	private boolean tagsuccessed;
	//���ȡ������
	private String body;
	@Override
	public int doStartTag() throws JspException {
		//isTagsuccessed();
		// TODO Auto-generated method stub
		//���뻺����
		return EVAL_BODY_BUFFERED;
		//return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {

		if(isTagsuccessed()==false){
			try {
				getBodyContent().getEnclosingWriter().write("��ƥ��=======");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(body==null){

			setBody();
		}
		if (body!=null) {
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}

	public boolean isTagsuccessed() {
		return tagsuccessed;
	}
	public void setTagsuccessed(boolean tagsuccessed) {
		this.tagsuccessed = tagsuccessed;
		
	}
	public String getBody() {
		return body;
	}
	public void setBody() {
		if(body==null){
			body=getBodyContent().getString().trim();
		}
		this.body = body;
	}
	
	
}
