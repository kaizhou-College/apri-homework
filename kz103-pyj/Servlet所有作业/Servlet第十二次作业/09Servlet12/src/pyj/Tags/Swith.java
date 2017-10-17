package pyj.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Swith extends BodyTagSupport{
	private int value;
	private boolean Flag;
	private String body;//�������������
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isFlag() {
		return Flag;
	}
	public void setFlag() {
		this.Flag = true;
	}
	public String getBody() {
		return body;
	}

	
	public Swith(){
		init();
	}
	public void init(){
		body=null;
		Flag=false;
	}

	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;//��swith��ʱ��û�ж�������ֱ�ӷ��뻺��
	}
	
	public int doEndTag() throws JspException {
		if(body==null&&Flag==true){
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
	public void setBody() {
		if(body==null){
			body=getBodyContent().getString().trim();
		}
		this.body = body;
	}
}
