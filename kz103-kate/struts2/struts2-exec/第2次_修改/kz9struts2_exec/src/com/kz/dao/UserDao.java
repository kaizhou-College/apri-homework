package com.kz.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kz.entity.User;
import com.kz.utils.DataSourceUtils;

public class UserDao {

	public User findByNameAndPwd(User user) {
		try {
			String sql = "select * from s_user where logonName=? and logonPwd=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils
					.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class), user
					.getLogonName(), user.getLogonPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findById(int userID) {
		String sql = "select * from s_user where userid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<User>(User.class), userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		//System.out.println(new UserDao().findById(2));
		System.out.println("睡觉".split(",")[0]);
		
	}

	public int updateUser(User user, boolean isUpload) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int resultNum = -1;
		String sql = null;
		if(isUpload){
			sql = "update s_user set userName= '"
				+ user.getUserName() + "',logonName='"
				+ user.getLogonName() + "', logonPwd ='"
				+ user.getLogonPwd() + "',sex='" + user.getSex()
				+ "',birthday='" + user.getBirthday()
				+ "', education='" + user.getEducation()
				+ "' ,telephone='" + user.getTelephone()
				+ "', interest='" + user.getInterest() + "', path='"
				+ user.getPath() + "' ,filename='" + user.getFilename()
				+ "', remark='" + user.getRemark() + "' where userID = "
				+ user.getUserID();
		}else{//不上传简历
			sql =  "update s_user set userName= '"
				+ user.getUserName() + "',logonName='"
				+ user.getLogonName() + "', logonPwd ='"
				+ user.getLogonPwd() + "',sex='" + user.getSex()
				+ "',birthday='" + user.getBirthday()
				+ "', education='" + user.getEducation()
				+ "' ,telephone='" + user.getTelephone()
				+ "', interest='" + user.getInterest() + "', remark='"
				+ user.getRemark() + "' where userID = "
				+ user.getUserID();
		}
		try {
			resultNum = runner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultNum;
	}


}
