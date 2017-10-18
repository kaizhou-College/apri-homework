package tag;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import com.sun.media.sound.WaveFileReader;


public class TagSwitch extends BodyTagSupport {
	private String test;
	private String body;
	private boolean tagSuccessed;
	public TagSwitch() {
		init();
	}
	public void release() {
		init();
		super.release();
	}
	public int doEndTag() throws JspException {
		if(body==null){
			setBody();
		}
		if(isTagSuccessed()==false){
			try {
				getBodyContent().getEnclosingWriter().write("不匹配");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(body!=null){
			try {
//				String string = getBodyContent().getString().toString();
//				System.out.println("body=="+body);
//				System.out.println(string.trim());
//				if(string.trim().length()!=body.trim().length()){
					getBodyContent().getEnclosingWriter().write(body.trim());
//				}else{
//					getBodyContent().getEnclosingWriter().write("一个条件都没符合");
//					
//				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getBody() {
		return body;
	}
	public void setBody() {
		if(body==null){
			body=getBodyContent().getString().trim();
		}
	}
	public boolean isTagSuccessed() {
		return tagSuccessed;
	}
	public void setTagSuccessed() {
		this.tagSuccessed = true;
	}
	public void init(){
		test=null;
		body=null;
		tagSuccessed = false;
	}
}
