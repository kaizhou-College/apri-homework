package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IfTag extends BodyTagSupport {
	/*用来保存要输出的内容*/
	private String body;
	/*属性*/
	private boolean test;
	/*表示是否有条件判断为true*/
	private boolean tagSuccessed;
	/*写一个初始化方法以便后边的清除工作*/
	public IfTag(){
		init();
	}
	@Override
	public void release() {
		init();
		super.release();
	}
	
	

	@Override
	public int doStartTag() throws JspException {
		if(test){
			setTagSuccessed();//标记if的标签为true
		}
		return EVAL_BODY_BUFFERED;//先放入缓存，看看判断之后是否需要输出
	}

	@Override
	public int doEndTag() throws JspException {
		/*如果到最后还没有 设置body  就说明else 需要将标签体内容设置到body*/
		if(body==null){
			setBody();
		}
		if(body!=null){//如果得到了body就将所得到的body写出来
			try {
				this.getBodyContent().getEnclosingWriter().write(body);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}

	
	
	
	private void init() {
		body = null;
		tagSuccessed = false;
		test= false;
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
	public boolean isTagSuccessed() {
		return tagSuccessed;
	}
	public void setTagSuccessed() {
		this.tagSuccessed = true;
	}
	

}
