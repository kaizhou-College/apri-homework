package com.wtg.Switch;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Case2 extends BodyTagSupport{
	private String value;
	@Override
	public int doStartTag() throws JspException {
		Tag tag = getParent();
		if (tag==null&&!(tag instanceof Switch)) {
			try {
				throw new Exception("case2标签应该与switch标签一起使用");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Switch swit=(Switch) tag;
		if (swit.isTagsuccessed()) {
			swit.setBody();
			//System.out.println(swit.getBodyContent().getString());
			
		}else if(swit.getTest().equals(value)){
			try {
				swit.getBodyContent().clear();
				//System.out.println("======="+swit.getBodyContent().getString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			swit.setTagsuccessed(true);
		}
		
		// TODO Auto-generated method stub
		return EVAL_BODY_BUFFERED;
		//return EVAL_BODY_INCLUDE;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
