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
		if(ptag.isFlag()){   //�Ƚ����жϿ��ϸ�case�Ƿ��switch��ֵ���
			ptag.setBody();//�����һ��case�ж�Ϊtrue�˾͸�body����ֵ
		}else{
			try {
				ptag.getBodyContent().clear();//���false�����
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�����body�������֮���ٽ����ж� 
		int swinum = ptag.getValue();
		if(swinum==value){//�Ƚ�����value �����ȾͰ�flag��Ϊtrue
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
