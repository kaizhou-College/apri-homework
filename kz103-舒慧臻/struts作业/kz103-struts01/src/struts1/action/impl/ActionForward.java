package struts1.action.impl;
//׼��һ��ActionForward�Ķ�������װ���ҳ����ַ�����
//���Ƿ���ת�������ض����boolean���͵ı�־��
//�����false����ʾ��ת�����������ض���,�ṩget��set������
//�вεĹ��췽������������ֵ��
public class ActionForward {
	private String url;
	private boolean isRedirect = false;
	public ActionForward(String url, boolean isRedirect) {
		super();
		this.url = url;
		this.isRedirect = isRedirect;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	

}
