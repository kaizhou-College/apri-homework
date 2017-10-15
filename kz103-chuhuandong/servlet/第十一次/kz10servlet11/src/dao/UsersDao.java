package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.registry.infomodel.User;

import entity.Users;
//���ķ��������

public class UsersDao {
	public static int add(Users us){
		int num = 0 ;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = BaseDao.getConn();
			String sql = "insert into users values(u_seq.nextval,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, us.getName());
			pst.setInt(2,us.getAge());
			num = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		return num;
	}
	//ɾ��
	public static int del(int id){
		int num = 0 ;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = BaseDao.getConn();
			String sql = "delete emp where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			num = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		return num;
	}
	//����id��ѯ���Բ���Ҳ���Բ鵱��
	/*id=0  :��ȫ��  ���ؼ���
	 * 	select *��from users
	 *id>0 : �鵥��  ���ؼ���
	 *	select * from users where id=?
	 * 
	 */
	public static List<Users> selById(int id){
		List<Users> list = new ArrayList<Users>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			String sql ="select *��from emp";
			if(id>0){
				sql = "select * from emp where id=?";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, id);
			}else{
				pst=conn.prepareStatement(sql);
			}
			
			rs = pst.executeQuery();
			while(rs.next()){
				Users us = new Users();
				us.setId(rs.getInt("id"));
				us.setName(rs.getString("name"));
				us.setAge(rs.getInt("sal"));
				//�Ѷ�����뼯��
				list.add(us);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		
		return list;
	}
	
	public static int update(Users us){
		int num = 0 ;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = BaseDao.getConn();
			String sql = "update users set name=?,age=? where id =?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(3, us.getId());
			pst.setString(1, us.getName());
			pst.setInt(2, us.getAge());
			
			num = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		return num;
		
		
	}
	
	//��ҳ��ѯ
	public static List<Users> selByPage(int pagesize,int page){
		List<Users> list = new ArrayList<Users>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pagesize;
		int max = page*pagesize;
		
		try {
			conn = BaseDao.getConn();
			String sql  ="select * from" +
					"(select rownum num,t.* from emp t)" +
					" where num>"+min+" and num<="+max;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Users us = new Users();
				us.setId(rs.getInt("num"));
				us.setName(rs.getString("ename"));
				us.setAge(rs.getInt("sal"));
				//�Ѷ�����뼯��
				list.add(us);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		
		return list;
	}
	//�õ���ҳ���ķ���  ��ҳ��=������/ÿҳ������
	public static int getMaxPage(int pagesize){
		int max = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			String sql  ="select count(*) from emp";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.next();
			int size = rs.getInt(1);
			//size=27  pagesize=5  max=6ҳ!=27/5=5
			//size=27 pagesize=9   max=3ҳ=27/9=3
			max =(size-1)/pagesize+1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		return max;
		
	}
	//����
	public static void main(String[] args) {
		//System.out.println(add(new Users("Mr��",12)));
		//System.out.println(del(30));
		//System.out.println(selById(21).getName());
		/*Users us = new Users("����",12);
		us.setId(34);
		System.out.println(update(us));*/
		
		List<Users> list=selByPage(4,2);
	
	    for (Users users : list) {
			System.out.println(users);
		}
	
	    System.out.println(getMaxPage(7));
	}
	
	
}









