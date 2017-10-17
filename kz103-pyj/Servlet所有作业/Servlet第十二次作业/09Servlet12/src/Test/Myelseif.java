package Test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Myelseif extends BodyTagSupport{
	private boolean test;
	public Myelseif(){
		init();
	}
	public void init(){
		test=false;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	
	public void release() {
		init();
		super.release();
	}
	public int doStartTag() throws JspException {
		//判断父标签的条件是不是为true
		Tag tag = getParent();
		//还有一种如果elseif没有在if中使用的情况
		if(tag==null&&!(tag instanceof Myif)){
			try {
				throw new Exception("Myelseif tag do not use in Myif tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//得到父标签
		Myif iftag=(Myif) tag;
		if(iftag.isFlag()){//如果if条件成立
			iftag.setBody();
		}else if(test){//如果if条件不成立就跳到else if
			try {//之前读的不成立就要把之前读到的标签体清空
				iftag.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
			iftag.setFlag();//elseif标签成立
		}
		return EVAL_BODY_BUFFERED;
		//此时也不显示，放入缓存等if结构读完在显示
	}
}
