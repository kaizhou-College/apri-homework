package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IfTag extends BodyTagSupport {
	/*��������Ҫ���������*/
	private String body;
	/*����*/
	private boolean test;
	/*��ʾ�Ƿ��������ж�Ϊtrue*/
	private boolean tagSuccessed;
	/*дһ����ʼ�������Ա��ߵ��������*/
	public IfTag(){
		init();
	}
	@Override
	public void release() {
		init();
		super.release();
	}
	
	

	@Override
	public int doStartTag() throws JspException {
		if(test){
			setTagSuccessed();//���if�ı�ǩΪtrue
		}
		return EVAL_BODY_BUFFERED;//�ȷ��뻺�棬�����ж�֮���Ƿ���Ҫ���
	}

	@Override
	public int doEndTag() throws JspException {
		/*��������û�� ����body  ��˵��else ��Ҫ����ǩ���������õ�body*/
		if(body==null){
			setBody();
		}
		if(body!=null){//����õ���body�ͽ����õ���bodyд����
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}

	
	
	
	private void init() {
		body = null;
		tagSuccessed = false;
		test= false;
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
	public boolean isTagSuccessed() {
		return tagSuccessed;
	}
	public void setTagSuccessed() {
		this.tagSuccessed = true;
	}
	

}
