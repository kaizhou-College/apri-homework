package Test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Myif extends BodyTagSupport{
	private String body;//保存输出的内容
	private boolean test;
	private boolean Flag;//判断是否有条件成功
	public Myif(){
		init();
	}
	
	public void release() {
		init();
		super.release();
	}
	
	public int doStartTag() throws JspException {
		if(test){
			setFlag();//if标签的条件为true
		}
		return EVAL_BODY_BUFFERED;//但是不显示出来先放入缓存
	//等if结构走完在打印结果
	}
	
	public int doEndTag() throws JspException {
		if(body==null){
			setBody();
		}
		if(body!=null){
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (Exception e) {
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
			body=getBodyContent().getString().trim();
		}
		this.body = body;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public boolean isFlag() {
		return Flag;
	}
	public void setFlag() {
		this.Flag = true;
	}

	public void init(){
		body=null;
		Flag=false;
		test=false;
	}
}
