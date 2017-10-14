package com.kz.utils.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class KzHelloTag extends SimpleTagSupport{//implements SimpleTag {

	public void doTag() throws JspException, IOException {
		System.out.println("doTag.......");
		//ÔÚjspÊä³ö hello world
		getJspContext().getOut().print("hello world");
		
	}

	/*public JspTag getParent() {
		return null;
	}

	public void setJspBody(JspFragment jspFragment) {
		System.out.println("jspFragment==="+jspFragment);
	}

	public void setJspContext(JspContext jspContext) {
		System.out.println("jspContext==="+jspContext);
	}

	public void setParent(JspTag jspTag) {
		System.err.println("jspTag==="+jspTag);
	}
*/
}
