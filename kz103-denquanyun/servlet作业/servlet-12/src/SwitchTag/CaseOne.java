package SwitchTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
public class CaseOne extends BodyTagSupport{
	private int value;
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
		int swinum = ptag.getValue();
		if(swinum==value){//�Ƚ�����value �����ȾͰ�flag��Ϊtrue
			ptag.setFlag();
		}else{
			try {
				ptag.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
