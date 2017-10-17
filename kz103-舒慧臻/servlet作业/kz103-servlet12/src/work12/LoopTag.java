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
			return EVAL_BODY_AGAIN;//����ִ�б�ǩ��
		}
		return SKIP_BODY;//��ǩ��ִ���������EndTag
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag.......");
		//��������������ݵ��ͻ��ˣ��������
		return SKIP_BODY;//����ִ��jsp���������
		//return SKIP_PAGE;����jsp���������
	}

	@Override
	public void doInitBody() throws JspException {
		System.out.println("doInitBody......");
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag......");
		//return EVAL_BODY_INCLUDE;//ֱ�������ǩ��
		return EVAL_BODY_BUFFERED;//����ǩ����ǰ���뻺��
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
