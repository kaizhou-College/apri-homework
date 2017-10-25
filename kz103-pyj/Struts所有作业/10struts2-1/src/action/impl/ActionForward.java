package action.impl;

public class ActionForward {
	private String url;
	private boolean flag=false;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public ActionForward(String url, boolean flag) {
		super();
		this.url = url;
		this.flag = flag;
	}
}
