package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagElse extends BodyTagSupport {
	public int doStartTag() throws JspException {
		Tag tag=getParent();
		if(tag==null&&!(tag instanceof TagIf)){
			try {
				throw new Exception("没有找到爸爸类");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TagIf ti=(TagIf) tag;
		if(ti.isTagSuccessed()){
			ti.setBody();
		}else{
			try {
				ti.getBodyContent().clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ti.setTagSuccessed();
		
		return EVAL_BODY_BUFFERED;
	}
	
}
