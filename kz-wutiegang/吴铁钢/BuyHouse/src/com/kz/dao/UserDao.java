package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kz.entity.Tbl_user;

public class UserDao {
	//�����û�������û��������뵽���ݿ��в����Ƿ��ж�Ӧ���û�
	public Tbl_user findByUserAndPassword(String uname,String upass){
			Tbl_user user =null;
			String sql="select * from Tbl_user where uname=? and upass=?";
			// �������ݿ�
			System.out.println(sql);
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Class clazz=Tbl_user.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			conn = BaseDao.getConn();
			try {
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, uname);
				pstmt.setString(2, upass);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					user = (Tbl_user) clazz.newInstance();
					for (Field field : fields) {
						Object value = rs.getObject(field.getName());
						if (value instanceof BigDecimal) {
							value = ((BigDecimal) value).intValue();
						}
						if (value instanceof Timestamp) {
							value = ((Timestamp) value).toString();
						}
						if (value == null) {
							continue;
						}
						field.set(user, value);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				BaseDao.closeConn(rs, pstmt, conn);
			}

		return user;
	}
	//��¼��֤��������ݿ����и��û��ͷ���ture ��֮false
	public boolean loginTureOrFalse(String uname,String upass){
		Tbl_user user = findByUserAndPassword(uname, upass);
		if (user!=null) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("uuid", user.getUuid());
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		UserDao userdao=new UserDao();
		System.out.println(userdao.loginTureOrFalse("��С��", "123"));
		//System.out.println(userdao.findByUserAndPassword("��С��", "123"));
	}
}
