package Test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Myelse extends BodyTagSupport{
	private boolean test;
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public int doStartTag() throws JspException {
		//先拿到父标签getParent()
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof Myif)){
			try {
				throw new Exception("Myelse tag do not use in Myif tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//在看if/elseif条件是否为true
		Myif iftag=(Myif) tag;
		if(iftag.isFlag()){//如果if条件成立
			iftag.setBody();
		}else {//如果if条件不成立就跳到else if
			try {//之前读的不成立就要把之前读到的标签体清空
				iftag.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
			iftag.setFlag();//elseif标签成立
		}
		return EVAL_BODY_BUFFERED;
	}
}
