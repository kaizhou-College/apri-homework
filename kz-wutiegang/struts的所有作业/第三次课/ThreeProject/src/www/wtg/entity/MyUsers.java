package www.wtg.entity;

public class MyUsers {
	private int userId;
	private String UserName;
	private String userPWd;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPWd() {
		return userPWd;
	}
	public void setUserPWd(String userPWd) {
		this.userPWd = userPWd;
	}
	@Override
	public String toString() {
		return "MyUsers [UserName=" + UserName + ", userId=" + userId
				+ ", userPWd=" + userPWd + "]";
	}
	
}
