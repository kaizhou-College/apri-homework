package util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ClassTest extends BodyTagSupport{
	private int count;
	@Override
	public int doAfterBody() throws JspException {
		if(count>1){
			count--;
			return EVAL_BODY_AGAIN;//重新输出标签体
		}
		return SKIP_BODY;//执行完标签体跳到EndTag
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;//继续执行jsp后面的内容
		//SKIP_PAGE  不执行jsp后面的内容了
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;//直接输出标签体
		//return EVAL_BODY_BUFFERED//标签体放入缓存
	}

	@Override
	public BodyContent getBodyContent() {
		// TODO Auto-generated method stub
		return super.getBodyContent();
	}

	@Override
	public JspWriter getPreviousOut() {
		// TODO Auto-generated method stub
		return super.getPreviousOut();
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		super.release();
	}

	@Override
	public void setBodyContent(BodyContent b) {
		// TODO Auto-generated method stub
		super.setBodyContent(b);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
