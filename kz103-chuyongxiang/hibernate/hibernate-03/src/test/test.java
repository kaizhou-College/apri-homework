package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import entity.Husband;
import entity.Wife;

public class test {
	
	@Test
	public void test(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		

		
//		(1).添加丈夫信息、级联保存自己的妻子信息;
//		Husband husband = new Husband();
//		husband.setName("王富贵");
//		Wife wife=new Wife();
//		wife.setName("田翠花");
//		//互相认识
//		wife.setHusband(husband);
//		husband.setWife(wife);
//		//添加
//		session.save(husband);
		
		/*Person person = (Person) session.get(Person.class,3L);
		System.out.println(person);
		Card card = person.getCard();
		System.out.println(card);*/
		
//		(2).根据丈夫获得妻子的信息、根据妻子获得丈夫的信息(去掉重复数据)
//		Husband husband=(Husband) session.get(Husband.class, 2L);
//		System.out.println(husband);
//		Wife wife=husband.getWife();
//		System.out.println(wife);
		
		
//		Wife wife=(Wife) session.get(Wife.class, 2L);
//		System.out.println(wife);
//		Husband husband=wife.getHusband();
//		System.out.println(husband);
		
//		(3).获取丈夫信息、修改其妻子信息;
		
//		Husband husband=(Husband) session.get(Husband.class, 2L);
//		System.out.println(husband);
//		Wife wife=husband.getWife();
//		wife.setName("wifi");
		
//		(4).获取妻子信息，修改其丈夫信息;
//		Wife wife=(Wife) session.get(Wife.class, 2L);
//		System.out.println(wife);
//		Husband husband=wife.getHusband();
//		husband.setName("忘了爱");
		
		
//		(5).删除一个丈夫，让其妻子成为寡妇;
//		Husband husband=(Husband) session.get(Husband.class, 2L);
//		System.out.println(husband);
//		Wife wife=husband.getWife();
//		husband.setWife(null);
//		session.delete(husband);
		
//		(6).删除一个妻子，让其丈夫成为光棍;
//		Wife wife=(Wife) session.get(Wife.class, 1L);
//		System.out.println(wife);
//		Husband husband=wife.getHusband();
//		husband.setWife(null);
//		session.delete(wife);
		
		
//		(7).为6步骤的光棍再取个老婆回来;
//		Husband husband=(Husband) session.get(Husband.class, 1L);
//		Wife wife=new Wife();
//		wife.setName("wifi");
//		wife.setHusband(husband);
//		husband.setWife(wife);
		
		
//		(8).双宿双飞:查询一个丈夫出来，删除丈夫、把妻子一起删除;
//		Husband husband=(Husband) session.get(Husband.class, 1L);
//		session.delete(husband);
		
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
