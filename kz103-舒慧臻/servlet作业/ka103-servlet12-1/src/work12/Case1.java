package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
 
public class Case1 extends BodyTagSupport {
	private String value;
	public void release(){
		init();
		super.release();
	}
	

	@Override
	public int doStartTag() throws JspException {
		//�жϸ���ǩ�������Ƿ�Ϊtrue
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof SwitchTag)){
			try {
				throw new Exception("case1 tag do not use in switch tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//��ȡ�������ǩ������
		SwitchTag sw = (SwitchTag) tag;
		String values = sw.getValue();
		if(sw.getValue().equals(value)){
			sw.setTagSuccessed();
		}
		return EVAL_BODY_BUFFERED;
	}

	
	
	public String isValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Case1(){
		init();
	}
	private void init() {
		
	}

}
