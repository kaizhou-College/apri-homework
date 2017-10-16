package com.kz.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class KzElseIfTag extends BodyTagSupport{
	private boolean test ;
	public KzElseIfTag(){
		init();
	}
	private void init() {
		test= false;
	}
	@Override
	public void release() {
		init();
		super.release();
	}
	@Override
	public int doStartTag() throws JspException {
		//条件为true就只直接输出？？？不行
		/*if(test){
			return EVAL_BODY_INCLUDE;
		}*/
		//判断父标签的条件是否为true
		Tag tag = getParent();
		//如果kzelseif标签没有在kziftag标签中使用
		if(tag==null&&!(tag instanceof KzIfTag)){
			try {
				throw new Exception("kzelseif tag do not use in kziftag tag!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//获取到父标签的条件
		KzIfTag ifTag  = (KzIfTag) tag;
		if(ifTag.isTagSuccessed()){//if条件成立
			ifTag.setBody();
			//System.out.println(ifTag.getBodyContent().getString());
		}else if(test){//if条件不成立 else if条件成立
			//System.out.println(ifTag.getBodyContent().getString());
			//要将之前读到的if标签的标签体 清空
			try {
				ifTag.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ifTag.setTagSuccessed();//else if标签条件成立了
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
