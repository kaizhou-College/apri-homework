package SwitchTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class CaseThree extends BodyTagSupport {
	private int value;
	@Override
	public int doStartTag() throws JspException {
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof Switchyy)){
			try {
				throw new Exception("This is not your papa!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Switchyy ptag = (Switchyy) tag;
		if(ptag.isFlag()){
			ptag.setBody();
		}else{
			try {
				ptag.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int swinum = ptag.getValue();
		if(swinum==value){//比较俩个value 如果相等就把flag改为true
			ptag.setFlag();
		}
		return EVAL_BODY_BUFFERED;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
