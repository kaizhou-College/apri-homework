package com.kz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kz.entity.QueryUser;
import com.kz.entity.User;
import com.kz.util.DataSourceUtils;
import com.kz.web.exception.MyException;

public class UserDao {

	/*
	 * 根据用户名来查找用户
	 */
	public User findUserByName(User user) {
		String sql = "select * from s_user where logonName=? and logonPwd=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils
				.getDataSource());
		try {
			
			return runner.query(sql, new BeanHandler<User>(User.class),
					user.getLogonName(), user.getLogonPwd());
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public List<User> findAll() {
		String sql ="select * from s_user";
		QueryRunner runner = new QueryRunner(DataSourceUtils
				.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 
	 */
	public User findByID(int userID) {
		String sql ="select * fsrom s_user where userid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils
				.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<User>(User.class),
					userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyException("根据用户名查找错误异常");
			
		}
	}

	public void insert(User user) {
		String sql = "insert into s_user values(?,?,?,?,?,?,?,?,?,?,?)";
		String[] args = { user.getUserName(), user.getLogonName(),
				user.getLogonPwd(), user.getSex(), user.getBirthday(),
				user.getEducation(), user.getTelephone(), user.getInterest(),
				user.getPath(), user.getFilename(), user.getRemark() };
		try {
			Connection  conn = DataSourceUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				pst.setString(i+1,args[i]);
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//测试
	public static void main(String[] args) {
		QueryUser user = new QueryUser();
		//user.setUserID(4);
		//user.setLogonName("admin44");
		//user.setLogonPwd("admin44");
		user.setUserName("邱伟林");
		//user.setSex("1");
		/*user.setBirthday("1900-1-1");
		user.setEducation("1");
		user.setTelephone("1");
		user.setInterest("1");*/
		/*user.setPath("234");
		user.setFilename("234");*/
		//user.setRemark("1");
		
		//new UserDao().update(user,false);
		System.out.println(new UserDao().findByCriteria(user));
		
		//System.out.println(new UserDao().findUserByName(user));*/
		
		//System.out.println(new UserDao().findAll());
		//System.out.println(new UserDao().findByID(1));
		//new UserDao().insert(user);
	}

	public int update(User user, boolean b) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int resultNum = -1;
		if(b){//
			// 要更新简历
			String sql = "update s_user set userName= '"
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

			try {
				resultNum = runner.update(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			// 不要更新简历
			String sql = "update s_user set userName= '"
					+ user.getUserName() + "',logonName='"
					+ user.getLogonName() + "', logonPwd ='"
					+ user.getLogonPwd() + "',sex='" + user.getSex()
					+ "',birthday='" + user.getBirthday()
					+ "', education='" + user.getEducation()
					+ "' ,telephone='" + user.getTelephone()
					+ "', interest='" + user.getInterest() + "', remark='"
					+ user.getRemark() + "' where userID = "
					+ user.getUserID();

			try {
				resultNum = runner.update(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultNum;
	}

	public List<User> findByCriteria(QueryUser queryUser) {
		List<User> list = new ArrayList<User>();
		String sql = "select * from s_user where 1=1";
		try {
			if (queryUser!=null&&queryUser.getUserName() != null
					&& queryUser.getUserName().trim().length() > 0) {
				sql += " and userName like '%"+queryUser.getUserName()+"'";
				
			}
			if (queryUser!=null&&queryUser.getSex() != null && queryUser.getSex().trim().length() > 0) {
				sql += " and sex =  '"+queryUser.getSex()+"'";
			}
			if (queryUser!=null&&queryUser.getEducation() != null
					&& queryUser.getEducation().trim().length() > 0) {
				sql += " and education =  '"+queryUser.getEducation()+"'";
			}
			if (queryUser!=null&&queryUser.getIsUpload()!=null
					&& (queryUser.getIsUpload().trim().length()>0)) {
				if(queryUser.getIsUpload().equals("1")){
					sql += " and path is not null";
				}else{
					sql += " and path is null";
				}
			}
			System.out.println(sql);
			QueryRunner runner = new QueryRunner(DataSourceUtils
				.getDataSource());
			return runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
