package tag;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 * *****************************
 * @������KzIfTag.java
 * @������TODO${ʹ��һ�仰��������}
 * @author ����.�³�
 * @���ڣ�2017-10-16
 * @version v1.0
 ******************************
 */
public class TagIf extends BodyTagSupport{
	/*��������Ҫ���������*/
	private String body;
	
	private boolean test;
	//��ʾ�Ƿ��������ж�Ϊtrue
	private boolean tagSuccessed;
	public TagIf(){
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
			System.out.println("if=="+test);
			//System.out.println(getBodyContent().getString());
			setTagSuccessed();//���if��ǩ������Ϊtrue
			//return EVAL_BODY_INCLUDE;
		}else{
			System.out.println("if===false");
		}
		return EVAL_BODY_BUFFERED;//���뻺��
	}
	@Override
	public int doEndTag() throws JspException {
		/*�������û����body ˵����else ��Ҫ����ǩ���������õ�body*/
		if(body==null){
			setBody();
		}
		if(body!=null){
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}
	public boolean isTagSuccessed() {
		return tagSuccessed;
	}
	public void setTagSuccessed() {
		this.tagSuccessed = true;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public String getBody() {
		return body;
	}
	public void setBody() {
		if(body==null){
			body = getBodyContent().getString().trim();
		}
		this.body = body;
	}
	public void init(){
		body = null;
		tagSuccessed = false;
		test= false;
	}
	
	
}
