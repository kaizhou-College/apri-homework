package SwitchTag;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Switchyy extends BodyTagSupport{
	private int value;
	private boolean flag;  //���Լ���value��case��value���бȽ� ����flag ��ʼֵfalse
	private String body;
	
	public Switchyy(){
		init();
	}
	
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}
	public int doEndTag() throws JspException {
		if(flag==false){
			body="";
		}
		if(body==null&&flag==true){
			setBody();
	}
		if(body!=null){
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag() {
		this.flag = true;
	}

	public String getBody() {
		return body;
	}

	public void setBody() {
		if(body==null){
			body = getBodyContent().getString().trim();
		}
		this.body = body;
	}
	@Override
	public BodyContent getBodyContent() {
		// TODO Auto-generated method stub
		return super.getBodyContent();
	}
	@Override
	public void setBodyContent(BodyContent b) {
		// TODO Auto-generated method stub
		super.setBodyContent(b);
	}
	public void init(){
		body = null;
		flag=false;
	}
}
