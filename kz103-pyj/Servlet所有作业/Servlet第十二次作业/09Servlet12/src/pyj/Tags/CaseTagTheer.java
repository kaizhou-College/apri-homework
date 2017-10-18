package pyj.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;


public class CaseTagTheer extends BodyTagSupport{
	private int value;

	public int isValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	public int doStartTag() throws JspException {
		//先拿到父标签getParent()
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof Swith)){
			try {
				throw new Exception(" tag do not use in  tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//在看条件是否为true
		Swith ss=(Swith) tag;
		if(ss.isFlag()){//如果条件成立
			ss.setBody();//拿到标签体内容
		}else {
			try {
				ss.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int valuenum=ss.getValue();
		if(valuenum==value){
			ss.setFlag();//如果相等会变成true
		}
		return EVAL_BODY_BUFFERED;
	}
}
