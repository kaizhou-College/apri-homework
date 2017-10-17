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
		System.out.println("����tmd���췽��");
		init();
	}
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}
	public int doEndTag() throws JspException {
		if(body==null&&flag==true){
			System.out.println("1");
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
		System.out.println("1"+body+"1");
		if(body==null){
			body = getBodyContent().getString().trim();
		}
		this.body = body;
		System.out.println("2"+body+"2");
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
