package com.kz.biz;

import java.util.List;

import com.kz.dao.UserDao;
import com.kz.entity.QueryUser;
import com.kz.entity.User;

public class UserBiz {
	private UserDao userDao = new UserDao();
	/*
	 * 登录验证
	 */
	public User loginByName(User user) {
		return userDao.findUserByName(user);
	}
	public List<User> list() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	public User view(int userID) {
		
		return userDao.findByID(userID);
	}
	public void save(User user) {

		userDao.insert(user);
		
	}
	public void update(User user, boolean b) {
		userDao.update(user,b);
	}
	public List<User> findByCriteria(QueryUser queryUser) {
		return userDao.findByCriteria(queryUser);
	}

}
