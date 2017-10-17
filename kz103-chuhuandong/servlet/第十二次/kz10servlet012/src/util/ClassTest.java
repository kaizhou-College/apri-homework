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
			return EVAL_BODY_AGAIN;//���������ǩ��
		}
		return SKIP_BODY;//ִ�����ǩ������EndTag
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;//����ִ��jsp���������
		//SKIP_PAGE  ��ִ��jsp�����������
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;//ֱ�������ǩ��
		//return EVAL_BODY_BUFFERED//��ǩ����뻺��
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
