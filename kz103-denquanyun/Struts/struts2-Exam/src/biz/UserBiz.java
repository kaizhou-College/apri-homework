package biz;

import dao.BaseDao;
import dao.UserDao;
import entity.Tbl_User;

public class UserBiz {
	UserDao ud = new UserDao();
	public Tbl_User login(Tbl_User user) {
		return ud.queryLogin(user.getUname(),user.getUpass());
	}
	public int insert(Tbl_User user) {
		return BaseDao.insert("u_id",user);
	}
}
