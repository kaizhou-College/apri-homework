package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class BaseDao {
		//获取数据库连接
		public static Connection getConn(){
			Connection conn=null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521","scott","abc");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				return conn;
			}
		
		//关闭数据库连接
		public static void closeConn(ResultSet rs,Statement st,Connection conn){
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(st!=null){
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//1.写一个通用的insert语句的方法public int save(Object o)

		public static int save(Object obj,String seq) throws Exception{
			int num = -1;
			StringBuffer sql  = new StringBuffer("insert into ");
			Class clazz = obj.getClass();
			//用clazz得到所有的属性
			Field[] fields = clazz.getDeclaredFields();
			//强力破解
			Field.setAccessible(fields,true);
			sql.append(clazz.getSimpleName());
			sql.append(" values("+seq+".nextval,");
			
			for(int i=1;i<fields.length;i++){
				
					sql.append("?");

				if(i!=fields.length-1){
					sql.append(",");
				}
			}
			sql.append(")");
			System.out.println(sql.toString());
			
			
			//String sql="insert into 表名 values(seq.nextval,?,?,?)";
			
			
			
			Connection conn = null;
			PreparedStatement st = null;
			try {
				conn = BaseDao.getConn();
				st = conn.prepareStatement(sql.toString());
				for (int i = 1; i < fields.length; i++) {
					Object value = fields[i].get(obj);
					st.setObject(i, value);
					System.out.println("值"+value+"次数"+i);
				}
				
				num = st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(null, st, conn);
			}
			return num;
		}
			
		/*通用查询
		 * select 字段名1,字段名2(属性名) from 表名(类名)
		 */
		public static List query(Class clazz){
			List list =null;//new ArrayList();
			StringBuffer sql = new StringBuffer();
			sql.append("select ");
			Field[] fields = clazz.getDeclaredFields();
			//一次性破解封装
			Field.setAccessible(fields, true);
			for(int i=0;i<fields.length;i++){
				sql.append(fields[i].getName());
				if(i!=fields.length-1){
					sql.append(",");
				}
			}
			sql.append(" from "+clazz.getSimpleName());
			//1,得到数据库连接
			Connection conn = BaseDao.getConn();
			PreparedStatement st = null;
			ResultSet rs = null;
			//2,得到statement对象
			try {
				st = conn.prepareStatement(sql.toString());
				//3, 执行查询
				rs = st.executeQuery();
				//4,封装结果集
				list =new ArrayList();
				while(rs.next()){//获取行
					//创建一个学生对象
					Object obj = clazz.newInstance();
					for(Field f:fields){//获取列
						//f.setAccessible(true); 参看 line 59
						Object value = rs.getObject(f.getName());
						if(value instanceof BigDecimal){
							value = ((BigDecimal)value).intValue();
						}
						if(value instanceof Timestamp){
							value = ((Timestamp)value).toString();
						}
						if(value==null){
							continue;
						}
						f.set(obj, value);
					}
					//将对象放入集合
					list.add(obj);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(rs, st, conn);
			}
			System.out.println(sql.toString());
			return list;
		}

		//查询某个类单个数据的方法
		public static Object load(Class c,int id) throws InstantiationException, IllegalAccessException {
			Object obj=null;
			StringBuffer sql=new StringBuffer("select ");
			//得到所有的属性
			Field[] fields = c.getDeclaredFields();
			Field.setAccessible(fields, true);
			//把需要的属性拼接到sql上并且用，号隔开
			for (int i = 0; i < fields.length; i++) {
				sql.append(fields[i].getName());
				if (i!=fields.length-1) {
					sql.append(",");
				}
			}
			sql.append(" from "+c.getSimpleName()+" where "+fields[0].getName()+"=?");
			System.out.println(sql.toString()); 
			//连接数据库
			Connection conn = null;
			PreparedStatement pstmt =null;
			ResultSet rs =null;
			
			try {
				conn = BaseDao.getConn();
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setObject(1, id);	
				rs = pstmt.executeQuery();
				while(rs.next()){
					obj = c.newInstance();
					for (Field field : fields) {
						Object value = rs.getObject(field.getName());
						if (value instanceof BigDecimal) {
							value=((BigDecimal)value).intValue();
						}
						if (value instanceof Timestamp) {
							value=((Timestamp)value).toString();
						}
						if (value==null) {
							continue;
						}
						field.set(obj, value);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(rs, pstmt, conn);
			}
			
			
			return obj;
		}
		
		//修改
		public int update(Object o) throws IllegalArgumentException, IllegalAccessException{
			int num=-1;
			StringBuffer sql=new StringBuffer("update ");
			Class c = o.getClass();
			sql.append(c.getSimpleName()+" set ");
			Field[] fields = c.getDeclaredFields();
			Field.setAccessible(fields, true);
			for (int i = 1; i < fields.length; i++) {
				if (fields[i].get(o)!=null&&!fields[i].get(o).equals(new Integer(0))&&!fields[i].get(o).equals(new Double(0.0))) {
					sql.append(fields[i].getName()+"=?,");
				}

			}
			sql=new StringBuffer(sql.substring(0, sql.length()-1));
			
			sql.append(" where ");
			sql.append(fields[0].getName()+"=?");
			System.out.println(sql.toString());
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = BaseDao.getConn();
				pstmt = conn.prepareStatement(sql.toString());
				//初始化占位符为1
				int index=1;

				for (int i = 1 ; i < fields.length; i++) {
					Object value  = fields[i].get(o);
					if (fields[i].get(o)!=null&&!fields[i].get(o).equals(new Integer(0))&&!fields[i].get(o).equals(new Double(0.0))) {
						pstmt.setObject(index,value);
					}
					index++;
					
				}

				pstmt.setObject(index-1, fields[0].get(o));
				num = pstmt.executeUpdate();
				
				System.out.println(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(null, pstmt, conn);
			}
			return num;
		}
		
		//删除
		public int delete(Class c,int id){
			int number=-1;
			StringBuffer sql=new StringBuffer("delete from "+c.getSimpleName()+" where ");
			Field[] fields = c.getDeclaredFields();
			Field.setAccessible(fields, true);
			sql.append(fields[0].getName()+"=?");
			//System.out.println(sql.toString());
			Connection conn = null;
			PreparedStatement pstmt =null;
			try {
				conn = BaseDao.getConn();
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setObject(1, id);
				number = pstmt.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(null, pstmt, conn);
			}
			System.out.println(sql.toString());
			return number;
		}
	}
