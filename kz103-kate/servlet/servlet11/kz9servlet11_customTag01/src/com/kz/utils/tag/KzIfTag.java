package com.kz.utils.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
// �����Դ���ǩ���ݵ��Զ����ǩ
public class KzIfTag extends SimpleTagSupport {
	private boolean test;
	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			JspContext context = getJspContext();
			//�õ���ǩ��
			//====>getJspBody().invoke(context.getOut())
			getJspBody().invoke(null);
		}
	}
	public boolean getTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	
}
