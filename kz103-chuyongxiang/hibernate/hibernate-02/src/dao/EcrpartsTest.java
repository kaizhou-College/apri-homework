package dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Ecrparts;

public class EcrpartsTest {
	public static void main(String[] args) {
		//1,读取配置文件  默认就是读取hibernate.hbm.xml
		Configuration cfg = new Configuration().configure();
		//2,构建sessionFactory 会话工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//3,得到会话对象
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//新增
//		Ecrparts e=new Ecrparts();
//		e.setXinghao("凯舟教育-CDMA无线上网卡-睿1200");
//		e.setFruid("62T9562F");
//		e.setGongchang("湖南长沙华瑞有限公司2");
//		e.setChuchangprice(650.0);
//		e.setChuchangdate(new Date());
//		session.save(e);
		
		
		//修改
//		Ecrparts e=(Ecrparts)session.get(Ecrparts.class, 2L);
//		e.setJingxiao("北京大公司");
//		e.setFapiaodate(new Date());
//		e.setFapiaoprice(730.0);
//		e.setBaoxiudate(new Date());
		
		
		//删除
//		Ecrparts e=new Ecrparts();
//		e.setId(3L);
//		session.delete(e);
		
		
		
		
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
































