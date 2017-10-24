import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class cs extends BodyTagSupport{
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("doAfterBody...");
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doStartTag();
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

}
