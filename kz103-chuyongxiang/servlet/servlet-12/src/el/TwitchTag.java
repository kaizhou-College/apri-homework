package el;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TwitchTag extends BodyTagSupport {
	private String body;
	private boolean test;
	private int num;
	
	public TwitchTag(){
		init();
	}
	
	@Override
	public int doEndTag() throws JspException {
		if(body==null&&test==true){
			System.out.println("有了有了！");
			setBody();
		}
		if(body!=null){
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return super.doEndTag();
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
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}

	

	public boolean isTest() {
		return test;
	}


	public void setTest() {
		this.test = true;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public void init(){
		body = null;
		test= false;
	}

}
