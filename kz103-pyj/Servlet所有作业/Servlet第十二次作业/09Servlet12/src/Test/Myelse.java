package Test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Myelse extends BodyTagSupport{
	private boolean test;
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public int doStartTag() throws JspException {
		//���õ�����ǩgetParent()
		Tag tag = getParent();
		if(tag==null&&!(tag instanceof Myif)){
			try {
				throw new Exception("Myelse tag do not use in Myif tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//�ڿ�if/elseif�����Ƿ�Ϊtrue
		Myif iftag=(Myif) tag;
		if(iftag.isFlag()){//���if��������
			iftag.setBody();
		}else {//���if����������������else if
			try {//֮ǰ���Ĳ�������Ҫ��֮ǰ�����ı�ǩ�����
				iftag.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
			iftag.setFlag();//elseif��ǩ����
		}
		return EVAL_BODY_BUFFERED;
	}
}
