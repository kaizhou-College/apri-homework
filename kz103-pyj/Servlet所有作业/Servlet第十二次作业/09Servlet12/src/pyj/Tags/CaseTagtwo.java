package pyj.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class CaseTagtwo extends BodyTagSupport{
	private int value;
	public int doStartTag() throws JspException {
		//判断父标签的条件是不是为true
		Tag tag = getParent();
		//还有一种如果case没有在swith中使用的情况
		if(tag==null&&!(tag instanceof Swith)){
			try {
				throw new Exception(" tag do not use in tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//得到父标签
		Swith ss=(Swith) tag;
		if(ss.isFlag()){//如果条件成立
			ss.getBody();
		}else {//如果条件不成立就跳到下一个case
			try {//之前读的不成立就要把之前读到的标签体清空
				ss.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int valuenum=ss.getValue();
		if(valuenum==value){//如果条件成立就变成true
			ss.setFlag();
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
