package actions.impl;
/*
 * (3)׼��һ��ActionForward�Ķ�������װ���ҳ����ַ��������Ƿ���ת�������ض����boolean���͵ı�־��
   �����false����ʾ��ת�����������ض���,�ṩget��set�������вεĹ��췽������������ֵ��
 * */
public class ActionForward {
	private String uri;
	private boolean falg=false;
	public ActionForward(String uri, boolean falg) {
		super();
		this.uri = uri;
		this.falg = falg;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public boolean isFalg() {
		return falg;
	}
	public void setFalg(boolean falg) {
		this.falg = falg;
	}
	
}
