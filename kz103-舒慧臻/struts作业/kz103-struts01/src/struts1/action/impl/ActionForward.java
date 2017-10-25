package struts1.action.impl;
//准备一个ActionForward的对象来封装结果页面的字符串，
//和是否是转发还是重定向的boolean类型的标志，
//如果是false，表示的转发，否则是重定向,提供get和set方法，
//有参的构造方法（给属性设值）
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
