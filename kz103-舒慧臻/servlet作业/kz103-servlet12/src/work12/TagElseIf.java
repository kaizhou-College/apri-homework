package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagElseIf extends BodyTagSupport {
	private boolean test;
	public TagElseIf(){
		init();
	}
	private void init(){
		test = false;
	}
	public void release(){
		init();
		super.release();
	}
	/*TagElseIf  没有实体  只需要读取开始部分*/
	@Override
	public int doStartTag() throws JspException {
		//判断父类标签条件是否为true
		Tag tag = getParent();
		//定义一个检测是否有父类的异常
		if(tag==null&&!(tag instanceof IfTag)){
			try {
				throw new Exception("elseIf tag do not use in tagIf tag!1");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//获取父类标签的条件
		IfTag ifTag = (IfTag) tag;
		if(ifTag.isTagSuccessed()){
			//条件成立
			ifTag.setBody();
		}else if(test){
			//if条件不成立  else if条件成立
			try {
				ifTag.getBodyContent().clear();//清除if条件成立时输出的内容
			} catch (IOException e) {
				e.printStackTrace();
			}
			ifTag.setTagSuccessed();//else if标签条件成立
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
