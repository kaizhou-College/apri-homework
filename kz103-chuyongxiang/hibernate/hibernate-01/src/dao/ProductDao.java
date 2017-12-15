package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


import entity.Product;

public class ProductDao {
	
	//1,读取配置文件  默认就是读取hibernate.hbm.xml
	Configuration cfg = new Configuration().configure();
	//2,构建sessionFactory 会话工厂
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	//3,得到会话对象
	Session session = sessionFactory.openSession();
	
	
	public void adddao(Product clazz){
		System.out.println("进入了dao");
		session.beginTransaction();
		session.save(clazz);
		
		
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
	
	
	public List selectdao(Class clazz){
		System.out.println("进入了dao");
		session.beginTransaction();
		List list=session.createCriteria(clazz).list();
		
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		return list;
		
	}



	public void deletedao(Product clazz) {
		System.out.println("进入了dao");
		System.out.println(clazz);
		session.beginTransaction();
		session.delete(clazz);
		
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
	}


	//Users u = (Users) session.get(Users.class, 4);
	public Product toeditdao(int id) {
		// TODO Auto-generated method stub
		
		System.out.println("进入dao");
		session.beginTransaction();
		Product product=(Product)session.get(Product.class,id);
		System.out.println("成功");
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		return product;
		
	}

	//修改
	public void editdao(Product product,int id) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Product product2=(Product)session.get(Product.class,id);
		product2.setPinfo(product.getPinfo());
		product2.setPname(product.getPname());
		product2.setPrice(product.getPrice());
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
}
