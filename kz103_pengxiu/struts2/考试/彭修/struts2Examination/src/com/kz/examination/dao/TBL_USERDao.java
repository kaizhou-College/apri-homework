package com.kz.examination.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.kz.examination.entity.Login;
import com.kz.examination.entity.Tbl_User;
import com.kz.examination.utils.Returns;


public class TBL_USERDao {
	public static boolean login(Tbl_User lm){
		boolean login_success=false;
		//��ѯauctionUser��
		List<Tbl_User> list_AuctionUser = BaseDao.Select(new Tbl_User());
		for (int i = 0; i < list_AuctionUser.size(); i++) {
			//�ж�������û����Ƿ���ȷ   �����ȷ ��ִ����һ��  ���ж������Ƿ���ȷ 
			if(list_AuctionUser.get(i).getUname().equals(lm.getUname())){
				if(list_AuctionUser.get(i).getUpass().equals(lm.getUpass())){
					//������������Ͼ͸� login_success��ֵ true
					login_success=true;
				}
			}
		}
		//���� booleanֵ���û����Լ��������Ƿ���ȷ
		return login_success;
	}
	public static int uname(){
		int num=-1;
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("user");
		if(attribute!=null){
			String sql="select uuid from tbl_user where uname='"+attribute+"'";
			Connection conn =new Returns().getConn();
			PreparedStatement st =null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(sql);
				rs = st.executeQuery();
				rs.next();
				num = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(login(new Tbl_User(0,"user","123")));
	}
}
