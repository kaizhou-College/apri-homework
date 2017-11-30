package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BaseDao{
	public static Connection getConn(){
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","orcl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (st!=null) {
					st.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn!=null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//测试连接
	public static void main(String[] args) {
		System.out.println(getConn());
	}
	
	
	//查询
	public static List select(Object obj){
		List list=new ArrayList();
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields,true);
		StringBuffer buff=new StringBuffer("select ");
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName()+",");
		}
		StringBuffer sql=new StringBuffer(buff.substring(0,buff.length()-1)+" from "+class1.getSimpleName());
		System.out.println(sql.toString());
		Connection conn = getConn();
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object object;
				try {
					object = class1.newInstance();
				
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value=((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(object, value);
				}
				list.add(object);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs, st, conn);
		}
		
		return list;
	}
	
	//分页查询
	public static List queryByPage(int index,int page,Class clazz){
		/*SELECT * FROM                         
		(SELECT ROWNUM rn ,e.* FROM emp e WHERE ROWNUM<=index*page)
		WHERE rn>index-1*page;*/
		StringBuffer sql =new StringBuffer();
		sql.append("select * from (select rownum rn,t.* from "+clazz.getSimpleName()+" t ");
		sql.append("where rownum<="+index*page+")");
		sql.append(" where rn>"+(index-1)*page);
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
//		System.out.println(sql.toString());
		//建立连接
		List list = new ArrayList(0);
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value ==null){
						continue;
					}
					fields[i].set(obj, value);
				}
				list.add(obj);
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
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//得到总数
	public static int getCount(Class clazz){
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from "+clazz.getSimpleName());
		//得到链接
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		int num =-1;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			rs.next();
			num = rs.getInt(1);
//			System.out.println("总数是"+num);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return num;
	}
	//得到最大页数
	public static int getMax(int size,Class clazz){
		double num=getCount(clazz)/(size*1.0);
		int max = (int) Math.ceil(num);
//		System.out.println("最大页数是"+max);
		
		return max;
	}
	
	
	//删除
	public static int delete(Class clazz,int id){
		int num=-1;
		StringBuffer sql=new StringBuffer(" delete from ");
		Connection conn=BaseDao.getConn();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" where "+fields[0].getName()+"="+id);
		
		PreparedStatement st=null;
		try {
			st = conn.prepareStatement(sql.toString());
			
			num = st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(sql.toString());
		return num;
	}
	
	//新增
	public static int insert(String seq,Object obj){
		int num = -1;
		StringBuffer sql  = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName());
		sql.append(" ("+fields[0].getName());
		try {
			for(int i=1;i<fields.length;i++){
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					sql.append(",");
					sql.append(fields[i].getName());
				}
			}
			sql.append(") values("+seq+".nextval");
			for(int i=1;i<fields.length;i++){
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					sql.append(",?");
				}
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		sql.append(")");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			//1,获取连接
			conn = BaseDao.getConn();
			//2,创建statement对象
			st = conn.prepareStatement(sql.toString());
			//3,给占位符赋值
			int index = 1;//占位符的下标 从1开始
			for(int i=1;i<fields.length;i++){
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					Object value = fields[i].get(obj);
					//从第1列开始赋值
					st.setObject(index, value);
					index++;
				}
			}
			//4, 执行添加
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql.toString());
		return num;
	}
	
	//修改-----软更新
	public  static int update(Object o) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		StringBuffer sql=new StringBuffer("update ");
		Class c = o.getClass();
		sql.append(c.getSimpleName()+" set ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		int count = 0;
		for (int i = 1; i < fields.length; i++) {
			if(fields[i].get(o)!=null){
				count++;
					sql.append(fields[i].getName()+"=?");
				if (i!=fields.length-1) {
					sql.append(",");
				}
			}
		}
		//update House set type_id=?,title=?,description=?,price=?,pubdate=to_date(?,'yyyy-mm-dd'),floorage=?,contact=?,street_id=?
		//去掉最后一个，
		System.out.println("前===="+sql.toString());
		if(sql.substring(sql.length()-1, sql.length()).equals(",")){
			sql = new StringBuffer(sql.substring(0, sql.length()-1));
		}
		System.out.println("后===="+sql.toString());
		sql.append(" where ");
		sql.append(fields[0].getName()+"=?");
		System.out.println(sql.toString());
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			int index=0;
			for (int i = 1; i < fields.length; i++) {
				Object value = fields[i].get(o);
				if(value!=null){
					index++;
					if(value instanceof Date){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						System.out.println("sdf==="+sdf.format((Date)value));
						pstmt.setObject(index,sdf.format((Date)value));
					}else{
						pstmt.setObject(index,value);
					}
				}
			}
			pstmt.setObject(index+1, fields[0].get(o));
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pstmt, conn);
		}
		return num;
	}
}
