package impl;

public class ActionForward {
	private String uri;
	private boolean isRedirect=false;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public ActionForward(String uri, boolean isRedirect) {
		super();
		this.uri = uri;
		this.isRedirect = isRedirect;
	}
	
}
