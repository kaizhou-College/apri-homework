package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.tag.common.core.SetSupport;

public class SwitchTag extends BodyTagSupport {
	/*用来保存要输出的内容*/
	private String body;
	/*p判断test得值是什么*/
	private String value;
	/*表示是否有条件判断为true*/
	private boolean tagSuccessed;
	public SwitchTag(){
		init();
	}
	public void release(){
		init();
		super.release();
	}
	
	
	@Override
	public int doEndTag() throws JspException {
		/*到最后还有没有设置body 说明走else 需要将标签体内容设置到body*/
		if(body==null&&tagSuccessed==true){
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
	@Override
	public int doStartTag() throws JspException {
	
		return EVAL_BODY_BUFFERED;//缓存
	}
	private void init(){
		body=null;
		value = this.value;
		tagSuccessed = false;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isTagSuccessed() {
		return tagSuccessed;
	}
	public void setTagSuccessed() {
		this.tagSuccessed = true;
	}
	
}
