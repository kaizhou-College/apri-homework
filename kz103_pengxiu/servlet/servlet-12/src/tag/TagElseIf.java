package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagElseIf extends BodyTagSupport{
	private boolean test ;
	public TagElseIf(){
		init();
	}
	private void init() {
		test= false;
	}
	@Override
	public void release() {
		init();
		super.release();
	}
	@Override
	public int doStartTag() throws JspException {
		//条件为true就只直接输出？？？不行
		/*if(test){
			return EVAL_BODY_INCLUDE;
		}*/
		//判断父标签的条件是否为true
		Tag tag = getParent();
		//如果kzelseif标签没有在kziftag标签中使用
		if(tag==null&&!(tag instanceof TagIf)){
			try {
				throw new Exception("kzelseif tag do not use in kziftag tag!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		TagIf ifTag  = (TagIf) tag;
		if(ifTag.isTagSuccessed()){
			ifTag.setBody();
		}else if(test){
			try {
				ifTag.getBodyContent().clear();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ifTag.setTagSuccessed();
		}
		return EVAL_BODY_BUFFERED;
	}
	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	
}
