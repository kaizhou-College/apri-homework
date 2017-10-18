package SwitchTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class CaseTwo extends BodyTagSupport{
	private int value;
	public int doStartTag() throws JspException {
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof Switchyy)){
			try {
				throw new Exception("This is not your papa!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Switchyy ptag = (Switchyy) tag;
		if(ptag.isFlag()){   //先进行判断看上个case是否跟switch的值相等
			ptag.setBody();//如果第一个case判断为true了就给body设置值
		}else{
			try {
				ptag.getBodyContent().clear();//如果false就清空
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//不相等body内容清空之后再进行判断 
		int swinum = ptag.getValue();
		if(swinum==value){//比较俩个value 如果相等就把flag改为true
			ptag.setFlag();
		}
		return EVAL_BODY_BUFFERED;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
