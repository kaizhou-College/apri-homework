 package com.wtg.Switch;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Case1 extends BodyTagSupport{
	//�����ƥ���ֵ
	private String value;
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		Tag tag = getParent();
		if (tag==null&&!(tag instanceof Switch)) {
			try {
				throw new Exception("case1��ǩӦ����switch��ǩһ��ʹ��");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Switch switc =(Switch) tag;
		if(switc.getTest().equals(value)){
			
			switc.setTagsuccessed(true);
			//System.out.println("======="+switc.getBodyContent().getString());
		}
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
