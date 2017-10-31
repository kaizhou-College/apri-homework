package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ModelDriven;

import dao.Basedao;
import entity.Users;

public class LoginAction implements ModelDriven<Users>{
		private String username;
		private String userpwd;
		private Users user=new Users();
		public Users getModel() {
			return user;
		}
	public String execute(){
		System.out.println("username=="+username+"\t+"+"userpwd=="+userpwd);
		List<Users> list=Basedao.find(Users.class);
		for (int i = 0; i < list.size(); i++) {
			String usersname=list.get(i).getUsername();
			if(user.getUsername().equalsIgnoreCase(username)){
				return "error";
			}
		}
		return "success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
}
