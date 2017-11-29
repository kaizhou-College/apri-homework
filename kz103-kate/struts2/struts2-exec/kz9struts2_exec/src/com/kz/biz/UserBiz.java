package com.kz.biz;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.kz.dao.BaseDao;
import com.kz.dao.UserDao;
import com.kz.entity.User;
import com.kz.utils.MD5Utils;

public class UserBiz {
	private UserDao ud =new UserDao();
	public User findByNameAndPwd(User user) {
		//生成密码摘要信息（加密 md5）
		try {
			user.setLogonPwd(MD5Utils.EncoderByMd5(user.getLogonPwd()));
			return ud.findByNameAndPwd(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public List<User> selByPage(Class<User> class1, int page, int pageSize) {
		return new BaseDao().selByPage(class1, page, pageSize);
	}
	public static void main(String[] args) {
		System.out.println(new BaseDao().selByPage(User.class,1, 5));
	}

}
