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
	/*TagElseIf  û��ʵ��  ֻ��Ҫ��ȡ��ʼ����*/
	@Override
	public int doStartTag() throws JspException {
		//�жϸ����ǩ�����Ƿ�Ϊtrue
		Tag tag = getParent();
		//����һ������Ƿ��и�����쳣
		if(tag==null&&!(tag instanceof IfTag)){
			try {
				throw new Exception("elseIf tag do not use in tagIf tag!1");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//��ȡ�����ǩ������
		IfTag ifTag = (IfTag) tag;
		if(ifTag.isTagSuccessed()){
			//��������
			ifTag.setBody();
		}else if(test){
			//if����������  else if��������
			try {
				ifTag.getBodyContent().clear();//���if��������ʱ���������
			} catch (IOException e) {
				e.printStackTrace();
			}
			ifTag.setTagSuccessed();//else if��ǩ��������
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
