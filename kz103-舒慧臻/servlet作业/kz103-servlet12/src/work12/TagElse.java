package work12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagElse extends BodyTagSupport {
	private boolean test;
	
	@Override
	public int doStartTag() throws JspException {
		//��ȡ����ǩ
		Tag tag = getParent();
		//�ж��Ƿ��и���ǩ
		if(tag==null&&!(tag instanceof IfTag)){
			try {
				throw new Exception("else tag do not use in tagIf tag");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�鿴��ǣ��鿴if and else if�������Ƿ�Ϊtrue
		//�ȵõ�����ǩ������
		IfTag iftag = (IfTag) tag;
		if(iftag.isTagSuccessed()){
			iftag.setBody();//����������ݴ���body
		}else{
			//����ͽ�֮ǰ��ǩ������������
			try {
				iftag.getBodyContent().clear();
			} catch (IOException e) {
				e.printStackTrace();
			}
			iftag.setTagSuccessed();//else��ǩ����������
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
