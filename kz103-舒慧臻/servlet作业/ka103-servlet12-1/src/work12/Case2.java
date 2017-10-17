package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Case2 extends BodyTagSupport {
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
				throw new Exception("case2 tag do not use in switch tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//��ȡ�������ǩ������
		SwitchTag sw = (SwitchTag) tag;
		if(sw.isTagSuccessed()){
			sw.setBody();
		}else{
			try {
				sw.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String values = sw.getValue();
		if(sw.getValue().equals(value)){
			sw.setTagSuccessed();
		}
			return EVAL_BODY_BUFFERED;
	}
	
	public Case2(){
		init();
	}
	private void init() {
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
