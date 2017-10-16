package com.kz.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class KzElseTag extends BodyTagSupport {
	private boolean test ;

	@Override
	public int doStartTag() throws JspException {
		//1，获取父标签
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof KzIfTag)){
			try {
				throw new Exception("kzelse tag do not use in kziftag tag!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//2,查看标记：if或者else if是否条件为true
		KzIfTag ifTag = (KzIfTag)tag;
		if(ifTag.isTagSuccessed()){
			//System.out.println("else ---"+ifTag.getBodyContent().getString());
			ifTag.setBody();//将输出的内容存入body中
		}else{
			//要将之前读到的if标签的标签体 清空
			try {
				ifTag.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ifTag.setTagSuccessed();//else标签条件成立了
		}
		return EVAL_BODY_BUFFERED;
	}
	
	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	
}
