package com.wtg.Switch;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Case3 extends BodyTagSupport{
	private String value;
	@Override
	public int doStartTag() throws JspException {
		Tag tag = getParent();
		if (tag==null&&(tag instanceof Switch)) {
			try {
				throw new Exception("case2标签应该与switch标签一起使用");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Switch switc = (Switch) tag;
		if (switc.isTagsuccessed()) {
			switc.setBody();
			//System.out.println(switc.getBodyContent().getString());
		}else if(switc.getTest().equals(value)){
			try {
				switc.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switc.setTagsuccessed(true);
		}
		
		// TODO Auto-generated method stub
		return EVAL_BODY_BUFFERED;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
