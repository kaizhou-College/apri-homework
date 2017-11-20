package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
			return runner.query(sql, new BeanHandler<User>(User.class),
					user.getLogonName(), user.getLogonPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
