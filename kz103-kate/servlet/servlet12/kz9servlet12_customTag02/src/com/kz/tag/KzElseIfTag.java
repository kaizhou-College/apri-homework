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
		//����Ϊtrue��ֱֻ���������������
		/*if(test){
			return EVAL_BODY_INCLUDE;
		}*/
		//�жϸ���ǩ�������Ƿ�Ϊtrue
		Tag tag = getParent();
		//���kzelseif��ǩû����kziftag��ǩ��ʹ��
		if(tag==null&&!(tag instanceof KzIfTag)){
			try {
				throw new Exception("kzelseif tag do not use in kziftag tag!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//��ȡ������ǩ������
		KzIfTag ifTag  = (KzIfTag) tag;
		if(ifTag.isTagSuccessed()){//if��������
			ifTag.setBody();
			//System.out.println(ifTag.getBodyContent().getString());
		}else if(test){//if���������� else if��������
			//System.out.println(ifTag.getBodyContent().getString());
			//Ҫ��֮ǰ������if��ǩ�ı�ǩ�� ���
			try {
				ifTag.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ifTag.setTagSuccessed();//else if��ǩ����������
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
