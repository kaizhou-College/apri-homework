package com.kz.biz;

import com.kz.dao.BaseDao;
import com.kz.dao.UserDao;
import com.kz.entity.Tbl_user;

public class UserBiz {
	private UserDao userdao=new UserDao();
	private BaseDao basedao=new BaseDao();
	public Tbl_user findByUserAndPassword(String uname, String upass) {
		// TODO Auto-generated method stub
		return userdao.findByUserAndPassword(uname, upass);
	}

	public boolean loginTureOrFalse(String uname, String upass) {
		// TODO Auto-generated method stub
		boolean boo = userdao.loginTureOrFalse(uname, upass);
		if (boo) {
			return true;
		}
		return false;
	}

	public int add(String seq, Tbl_user tbluser) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		return basedao.add(seq, tbluser);
	}

}
