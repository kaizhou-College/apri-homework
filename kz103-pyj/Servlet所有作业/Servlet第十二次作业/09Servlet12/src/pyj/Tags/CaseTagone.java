package pyj.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class CaseTagone extends BodyTagSupport{
	private int value;


	public int doStartTag() throws JspException {
		Tag tag = getParent();
		//����һ�����case0û����swith��ʹ�õ����
		if(tag==null&&!(tag instanceof Swith)){
			try {
				throw new Exception("tag do not use in tag");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//�õ�����ǩ
		Swith ss=(Swith) tag;
		int valuenum=ss.getValue();
		if(valuenum==value){//�����������
			ss.setFlag();
		}else {
			try {//֮ǰ���Ĳ�������Ҫ��֮ǰ�����ı�ǩ�����
				ss.getBodyContent().clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_BUFFERED;
		//��ʱҲ����ʾ�����뻺���swith�ṹ��������ʾ
	}
	public int isValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
