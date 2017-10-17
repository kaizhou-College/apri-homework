package pyj.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class CaseTagone extends BodyTagSupport{
	private int value;


	public int doStartTag() throws JspException {
		Tag tag = getParent();
		//还有一种如果case0没有在swith中使用的情况
		if(tag==null&&!(tag instanceof Swith)){
			try {
				throw new Exception("tag do not use in tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//得到父标签
		Swith ss=(Swith) tag;
		int valuenum=ss.getValue();
		if(valuenum==value){//如果条件成立
			ss.setFlag();
		}else {
			try {//之前读的不成立就要把之前读到的标签体清空
				ss.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_BUFFERED;
		//此时也不显示，放入缓存等swith结构读完在显示
	}
	public int isValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
