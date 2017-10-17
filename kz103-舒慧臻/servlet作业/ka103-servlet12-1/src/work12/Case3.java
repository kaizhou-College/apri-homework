package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Case3 extends BodyTagSupport {
	private String value;
	
	@Override
	public int doStartTag() throws JspException {
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof SwitchTag)){
			try {
				throw new Exception("case3 tag do not use in switch tag");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	
	
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void release(){
		init();
		super.release();
	}
	public Case3(){
		init();
	}
	private void init() {
		
	}
	

}
