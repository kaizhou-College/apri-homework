package com.kz.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.kz.entity.Card;
import com.kz.entity.Person;
public class Test1 {
	//��Ԫ����  jUnit Test
	@Test
	public void test(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//1,���һ���� ͬʱ���һ�ſ�
		/*Person p = new Person();
		p.setPname("����3");
		
		Card card = new Card();
		card.setCname("������7");
		//�໥��ʶ
		p.setCard(card);
		card.setPerson(p);
		//���
		session.save(p);*/
		//�������һ�������˼��� cascade="all"��ֻ��Ҫ�����˾Ϳ�����
		//����ȥ���濨
		//session.save(card);
		//2,���˵�ͬʱ�鿨
		/*Person person = (Person) session.get(Person.class,3L);
		System.out.println(person);
		Card card = person.getCard();
		System.out.println(card);*/
		//3,�鿨��ͬʱ����
		/*Card c = (Card) session.get(Card.class, 2L);
		System.out.println(c);
		System.out.println(c.getPerson());*/
		//4,�����޸Ŀ�
		/*Person person = (Person) session.get(Person.class,3L);
		Card c = person.getCard();
		c.setCname("ҽ����2");
		//session.update(c);����ʡ��  c�ǳ־�̬����
		*/
		//5,�鿨�޸���
//		Card c = (Card) session.get(Card.class, 2L);
//		Person person = c.getPerson();
//		//person�־�̬����
//		person.setPname("�������");
		//5.2���� �Ŀ�
		Person person = (Person) session.get(Person.class,7L);
		person.getCard().setCname("����");
		
		//6,����ɾ��
		/*Person person = (Person) session.get(Person.class,3L);
		Card card = person.getCard();
		//System.out.println(card);
		//�Ϲ�ϵ  ����һ����
		person.setCard(null);
		session.delete(card);*/
		//6,�鿨ɾ��
		/*Card c = (Card) session.get(Card.class, 4L);
		Person person = c.getPerson();
		//�Ϲ�ϵ  ����һ����
		person.setCard(null);
		session.delete(person);*/
		//7,����ɾ��ɾ��
		//Person person = (Person) session.get(Person.class,6L);
		//session.delete(person);
		
		//8,���˲���
		/*Person person = (Person) session.get(Person.class,3L);
		Card card2 = new Card();
		card2.setCname("��ˮ��");
		//�໥��ʶ
		person.setCard(card2);
		card2.setPerson(person);*/
		//����Ҫ session.save(p);  p�ǳ־�̬����
		
		//9,�鿨���ˣ�??���±�Ĺ�ϵ����  ��Ҫʹ��
		/*Card c = (Card) session.get(Card.class, 4L);
		
		Person p = new Person();
		p.setPname("������");
		
		//�໥��ʶ
		p.setCard(c);
		c.setPerson(p);
		session.save(p);*/
		/*Person person = (Person) session.get(Person.class,11L);
		System.out.println(person.getCard());*/
		transaction.commit();
		session.close();
		sf.close();
	}
}
