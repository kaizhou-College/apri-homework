package Test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Myelseif extends BodyTagSupport{
	private boolean test;
	public Myelseif(){
		init();
	}
	public void init(){
		test=false;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	
	public void release() {
		init();
		super.release();
	}
	public int doStartTag() throws JspException {
		//�жϸ���ǩ�������ǲ���Ϊtrue
		Tag tag = getParent();
		//����һ�����elseifû����if��ʹ�õ����
		if(tag==null&&!(tag instanceof Myif)){
			try {
				throw new Exception("Myelseif tag do not use in Myif tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//�õ�����ǩ
		Myif iftag=(Myif) tag;
		if(iftag.isFlag()){//���if��������
			iftag.setBody();
		}else if(test){//���if����������������else if
			try {//֮ǰ���Ĳ�������Ҫ��֮ǰ�����ı�ǩ�����
				iftag.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
			iftag.setFlag();//elseif��ǩ����
		}
		return EVAL_BODY_BUFFERED;
		//��ʱҲ����ʾ�����뻺���if�ṹ��������ʾ
	}
}
