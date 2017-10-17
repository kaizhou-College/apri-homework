package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagElse extends BodyTagSupport {
	private boolean test;
	
	@Override
	public int doStartTag() throws JspException {
		//获取父标签
		Tag tag = getParent();
		//判断是否有父标签
		if(tag==null&&!(tag instanceof IfTag)){
			try {
				throw new Exception("else tag do not use in tagIf tag");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//查看标记：查看if and else if的条件是否为true
		//先得到父标签的条件
		IfTag iftag = (IfTag) tag;
		if(iftag.isTagSuccessed()){
			iftag.setBody();//将输出的内容存入body
		}else{
			//否则就将之前标签体的内容清除掉
			try {
				iftag.getBodyContent().clear();
			} catch (IOException e) {
				e.printStackTrace();
			}
			iftag.setTagSuccessed();//else标签条件成立了
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
