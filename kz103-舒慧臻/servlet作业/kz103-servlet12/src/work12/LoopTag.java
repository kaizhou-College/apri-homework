package work12;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LoopTag extends BodyTagSupport {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int doAfterBody() throws JspException {
		System.out.println("doAfterBody.......");
		if(count>1){
			count--;
			return EVAL_BODY_AGAIN;//重新执行标签体
		}
		return SKIP_BODY;//标签体执行完毕跳到EndTag
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag.......");
		//控制输出缓存内容到客户端（浏览器）
		return SKIP_BODY;//继续执行jsp后面的内容
		//return SKIP_PAGE;忽略jsp后面的内容
	}

	@Override
	public void doInitBody() throws JspException {
		System.out.println("doInitBody......");
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag......");
		//return EVAL_BODY_INCLUDE;//直接输出标签体
		return EVAL_BODY_BUFFERED;//将标签体提前存入缓存
	}

	@Override
	public BodyContent getBodyContent() {
		System.out.println("BodyContent......");
		return super.getBodyContent();
	}

	@Override
	public JspWriter getPreviousOut() {
		System.out.println("JspWriter.....");
		return super.getPreviousOut();
	}

	@Override
	public void release() {
		System.out.println("release.......");
		super.release();
	}

	@Override
	public void setBodyContent(BodyContent b) {
		System.out.println("setBodyContent......");
		super.setBodyContent(b);
	}
}
