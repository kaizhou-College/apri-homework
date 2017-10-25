package actions.impl;
/*
 * (3)准备一个ActionForward的对象来封装结果页面的字符串，和是否是转发还是重定向的boolean类型的标志，
   如果是false，表示的转发，否则是重定向,提供get和set方法，有参的构造方法（给属性设值）
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
