package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagCase2 extends BodyTagSupport {
	private String value;
	public int doStartTag() throws JspException {
		Tag tag=getParent();
		if(tag==null&&!(tag instanceof TagSwitch)){
			try {
				throw new Exception("û���ҵ��ְ���");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TagSwitch ts=(TagSwitch) tag;
		if(ts.isTagSuccessed()){
			ts.setBody();
			System.out.println("����������ts");
		}
		System.out.println("value3==="+value);
		if(value==ts.getTest()){
			try {
				System.out.println("������Case3����֮ǰ��");
				ts.getBodyContent().clear();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ts.setTagSuccessed();
		}
		return EVAL_BODY_BUFFERED;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
