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
		

		
//		(1).����ɷ���Ϣ�����������Լ���������Ϣ;
//		Husband husband = new Husband();
//		husband.setName("������");
//		Wife wife=new Wife();
//		wife.setName("��仨");
//		//������ʶ
//		wife.setHusband(husband);
//		husband.setWife(wife);
//		//���
//		session.save(husband);
		
		/*Person person = (Person) session.get(Person.class,3L);
		System.out.println(person);
		Card card = person.getCard();
		System.out.println(card);*/
		
//		(2).�����ɷ������ӵ���Ϣ���������ӻ���ɷ����Ϣ(ȥ���ظ�����)
//		Husband husband=(Husband) session.get(Husband.class, 2L);
//		System.out.println(husband);
//		Wife wife=husband.getWife();
//		System.out.println(wife);
		
		
//		Wife wife=(Wife) session.get(Wife.class, 2L);
//		System.out.println(wife);
//		Husband husband=wife.getHusband();
//		System.out.println(husband);
		
//		(3).��ȡ�ɷ���Ϣ���޸���������Ϣ;
		
//		Husband husband=(Husband) session.get(Husband.class, 2L);
//		System.out.println(husband);
//		Wife wife=husband.getWife();
//		wife.setName("wifi");
		
//		(4).��ȡ������Ϣ���޸����ɷ���Ϣ;
//		Wife wife=(Wife) session.get(Wife.class, 2L);
//		System.out.println(wife);
//		Husband husband=wife.getHusband();
//		husband.setName("���˰�");
		
		
//		(5).ɾ��һ���ɷ��������ӳ�Ϊ�Ѹ�;
//		Husband husband=(Husband) session.get(Husband.class, 2L);
//		System.out.println(husband);
//		Wife wife=husband.getWife();
//		husband.setWife(null);
//		session.delete(husband);
		
//		(6).ɾ��һ�����ӣ������ɷ��Ϊ���;
//		Wife wife=(Wife) session.get(Wife.class, 1L);
//		System.out.println(wife);
//		Husband husband=wife.getHusband();
//		husband.setWife(null);
//		session.delete(wife);
		
		
//		(7).Ϊ6����Ĺ����ȡ�����Ż���;
//		Husband husband=(Husband) session.get(Husband.class, 1L);
//		Wife wife=new Wife();
//		wife.setName("wifi");
//		wife.setHusband(husband);
//		husband.setWife(wife);
		
		
//		(8).˫��˫��:��ѯһ���ɷ������ɾ���ɷ򡢰�����һ��ɾ��;
//		Husband husband=(Husband) session.get(Husband.class, 1L);
//		session.delete(husband);
		
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
