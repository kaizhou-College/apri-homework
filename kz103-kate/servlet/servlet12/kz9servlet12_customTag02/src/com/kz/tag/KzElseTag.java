package com.kz.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class KzElseTag extends BodyTagSupport {
	private boolean test ;

	@Override
	public int doStartTag() throws JspException {
		//1����ȡ����ǩ
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof KzIfTag)){
			try {
				throw new Exception("kzelse tag do not use in kziftag tag!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//2,�鿴��ǣ�if����else if�Ƿ�����Ϊtrue
		KzIfTag ifTag = (KzIfTag)tag;
		if(ifTag.isTagSuccessed()){
			//System.out.println("else ---"+ifTag.getBodyContent().getString());
			ifTag.setBody();//����������ݴ���body��
		}else{
			//Ҫ��֮ǰ������if��ǩ�ı�ǩ�� ���
			try {
				ifTag.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ifTag.setTagSuccessed();//else��ǩ����������
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
