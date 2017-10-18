package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.tag.common.core.SetSupport;

public class SwitchTag extends BodyTagSupport {
	/*��������Ҫ���������*/
	private String body;
	/*p�ж�test��ֵ��ʲô*/
	private String value;
	/*��ʾ�Ƿ��������ж�Ϊtrue*/
	private boolean tagSuccessed;
	public SwitchTag(){
		init();
	}
	public void release(){
		init();
		super.release();
	}
	
	
	@Override
	public int doEndTag() throws JspException {
		/*�������û������body ˵����else ��Ҫ����ǩ���������õ�body*/
		if(body==null&&tagSuccessed==true){
			setBody();
		}
		if(body!=null){
			try {
					this.getBodyContent().getEnclosingWriter().write(body);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}
	@Override
	public int doStartTag() throws JspException {
	
		return EVAL_BODY_BUFFERED;//����
	}
	private void init(){
		body=null;
		value = this.value;
		tagSuccessed = false;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isTagSuccessed() {
		return tagSuccessed;
	}
	public void setTagSuccessed() {
		this.tagSuccessed = true;
	}
	
}
