package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import entity.SysUser;

public class SysUserDao {

	//1,读取配置文件  默认就是读取hibernate.hbm.xml
	Configuration cfg = new Configuration().configure();
	//2,构建sessionFactory 会话工厂
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	//3,得到会话对象
	Session session = sessionFactory.openSession();
	
	
	public List<SysUser> getAll(Class clazz){
		System.out.println("进入了dao");
		session.beginTransaction();
		List list=session.createCriteria(clazz).list();
		System.out.println("dao的"+list);
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		return list;
		
	}
	
	
	public SysUser get(int id){
		System.out.println("进入dao");
		session.beginTransaction();
		SysUser sysuser=(SysUser)session.get(SysUser.class,id);
		System.out.println("成功");
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		return sysuser;
		
	}
	
	public void update(SysUser user,int id){
		session.beginTransaction();
		SysUser sysuser=(SysUser)session.get(SysUser.class,id);
		sysuser.setUsername(user.getUsername());
		sysuser.setPassword(user.getPassword());
		System.out.println("成功");
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}


	public void delete(SysUser sysuser) {
		// TODO Auto-generated method stub
		System.out.println("进入了dao");
		System.out.println(sysuser);
		session.beginTransaction();
		session.delete(sysuser);
		
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}

	
	

}
