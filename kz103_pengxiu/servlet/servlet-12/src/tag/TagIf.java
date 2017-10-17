package tag;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 * *****************************
 * @类名：KzIfTag.java
 * @描述：TODO${使用一句话描述该类}
 * @author 凯舟.陈超
 * @日期：2017-10-16
 * @version v1.0
 ******************************
 */
public class TagIf extends BodyTagSupport{
	/*用来保存要输出的内容*/
	private String body;
	
	private boolean test;
	//表示是否有条件判断为true
	private boolean tagSuccessed;
	public TagIf(){
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
			System.out.println("if=="+test);
			//System.out.println(getBodyContent().getString());
			setTagSuccessed();//标记if标签的条件为true
			//return EVAL_BODY_INCLUDE;
		}else{
			System.out.println("if===false");
		}
		return EVAL_BODY_BUFFERED;//放入缓存
	}
	@Override
	public int doEndTag() throws JspException {
		/*到最后还有没设置body 说明走else 需要将标签体内容设置到body*/
		if(body==null){
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
	public boolean isTagSuccessed() {
		return tagSuccessed;
	}
	public void setTagSuccessed() {
		this.tagSuccessed = true;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
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
	public void init(){
		body = null;
		tagSuccessed = false;
		test= false;
	}
	
	
}
