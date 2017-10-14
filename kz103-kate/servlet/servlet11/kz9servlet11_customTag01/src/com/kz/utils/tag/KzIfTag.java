package com.kz.utils.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
// 带属性带标签内容的自定义标签
public class KzIfTag extends SimpleTagSupport {
	private boolean test;
	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			JspContext context = getJspContext();
			//得到标签题
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
