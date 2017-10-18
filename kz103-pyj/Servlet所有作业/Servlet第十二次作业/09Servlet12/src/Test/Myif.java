package Test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Myif extends BodyTagSupport{
	private String body;//�������������
	private boolean test;
	private boolean Flag;//�ж��Ƿ��������ɹ�
	public Myif(){
		init();
	}
	
	public void release() {
		init();
		super.release();
	}
	
	public int doStartTag() throws JspException {
		if(test){
			setFlag();//if��ǩ������Ϊtrue
		}
		return EVAL_BODY_BUFFERED;//���ǲ���ʾ�����ȷ��뻺��
	//��if�ṹ�����ڴ�ӡ���
	}
	
	public int doEndTag() throws JspException {
		if(body==null){
			setBody();
		}
		if(body!=null){
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}
	
	public String getBody() {
		return body;
	}
	public void setBody() {
		if(body==null){
			body=getBodyContent().getString().trim();
		}
		this.body = body;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public boolean isFlag() {
		return Flag;
	}
	public void setFlag() {
		this.Flag = true;
	}

	public void init(){
		body=null;
		Flag=false;
		test=false;
	}
}
