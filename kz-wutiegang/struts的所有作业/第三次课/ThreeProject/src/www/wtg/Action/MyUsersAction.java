package www.wtg.Action;

import java.util.List;

import www.wtg.Dao.BaseDao;
import www.wtg.entity.MyUsers;
import www.wtg.entity.User;

import com.opensymphony.xwork2.ModelDriven;

public class MyUsersAction implements ModelDriven<User>{
	private String uname;
	private String psw;
	private User user=new User();
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//表单验证
	public String Test(){
		List<MyUsers> list = BaseDao.findAll(MyUsers.class);
		for (int i = 0; i < list.size(); i++) {
			String userName = list.get(i).getUserName();
			if (user.getUname().equalsIgnoreCase(userName)) {
				return "success";
			}
		}
		return "loser";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
}
