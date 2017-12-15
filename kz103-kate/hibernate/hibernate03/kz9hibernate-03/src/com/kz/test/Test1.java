package com.kz.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.kz.entity.Card;
import com.kz.entity.Person;
public class Test1 {
	//单元测试  jUnit Test
	@Test
	public void test(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//1,添加一个人 同时添加一张卡
		/*Person p = new Person();
		p.setPname("拉登3");
		
		Card card = new Card();
		card.setCname("大王卡7");
		//相互认识
		p.setCard(card);
		card.setPerson(p);
		//添加
		session.save(p);*/
		//如果主的一方配置了级联 cascade="all"，只需要保存人就可以了
		//主动去保存卡
		//session.save(card);
		//2,查人的同时查卡
		/*Person person = (Person) session.get(Person.class,3L);
		System.out.println(person);
		Card card = person.getCard();
		System.out.println(card);*/
		//3,查卡的同时查人
		/*Card c = (Card) session.get(Card.class, 2L);
		System.out.println(c);
		System.out.println(c.getPerson());*/
		//4,查人修改卡
		/*Person person = (Person) session.get(Person.class,3L);
		Card c = person.getCard();
		c.setCname("医保卡2");
		//session.update(c);可以省略  c是持久态对象
		*/
		//5,查卡修改人
//		Card c = (Card) session.get(Card.class, 2L);
//		Person person = c.getPerson();
//		//person持久态对象
//		person.setPname("吴二娃子");
		//5.2查人 改卡
		Person person = (Person) session.get(Person.class,7L);
		person.getCard().setCname("饭卡");
		
		//6,查人删卡
		/*Person person = (Person) session.get(Person.class,3L);
		Card card = person.getCard();
		//System.out.println(card);
		//断关系  主的一方断
		person.setCard(null);
		session.delete(card);*/
		//6,查卡删人
		/*Card c = (Card) session.get(Card.class, 4L);
		Person person = c.getPerson();
		//断关系  主的一方断
		person.setCard(null);
		session.delete(person);*/
		//7,查人删卡删人
		//Person person = (Person) session.get(Person.class,6L);
		//session.delete(person);
		
		//8,查人补卡
		/*Person person = (Person) session.get(Person.class,3L);
		Card card2 = new Card();
		card2.setCname("热水卡");
		//相互认识
		person.setCard(card2);
		card2.setPerson(person);*/
		//不需要 session.save(p);  p是持久态对象
		
		//9,查卡补人？??导致表的关系混乱  不要使用
		/*Card c = (Card) session.get(Card.class, 4L);
		
		Person p = new Person();
		p.setPname("三狗子");
		
		//相互认识
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
