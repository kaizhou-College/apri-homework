package pyj.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;


public class CaseTagTheer extends BodyTagSupport{
	private int value;

	public int isValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	public int doStartTag() throws JspException {
		//���õ�����ǩgetParent()
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof Swith)){
			try {
				throw new Exception(" tag do not use in  tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//�ڿ������Ƿ�Ϊtrue
		Swith ss=(Swith) tag;
		if(ss.isFlag()){//�����������
			ss.setBody();//�õ���ǩ������
		}else {
			try {
				ss.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int valuenum=ss.getValue();
		if(valuenum==value){
			ss.setFlag();//�����Ȼ���true
		}
		return EVAL_BODY_BUFFERED;
	}
}
