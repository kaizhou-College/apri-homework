package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagCase1 extends BodyTagSupport {
	private String value;
	public int doStartTag() throws JspException {
		Tag tag=getParent();
		if(tag==null&&!(tag instanceof TagSwitch )){
			try {
				throw new Exception("没有找到爸爸类");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		TagSwitch ts=(TagSwitch) tag;
		if(ts.isTagSuccessed()){
			ts.setBody();
		}else if(value==ts.getTest()){
			try {
				System.out.println("进入了Case1销毁之前的");
				ts.getBodyContent().clear();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ts.setTagSuccessed();
		}
		ts.isTagSuccessed();
		return EVAL_BODY_BUFFERED;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
