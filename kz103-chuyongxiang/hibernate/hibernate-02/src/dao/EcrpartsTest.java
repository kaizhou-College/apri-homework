package dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Ecrparts;

public class EcrpartsTest {
	public static void main(String[] args) {
		//1,��ȡ�����ļ�  Ĭ�Ͼ��Ƕ�ȡhibernate.hbm.xml
		Configuration cfg = new Configuration().configure();
		//2,����sessionFactory �Ự����
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//3,�õ��Ự����
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//����
//		Ecrparts e=new Ecrparts();
//		e.setXinghao("���۽���-CDMA����������-�1200");
//		e.setFruid("62T9562F");
//		e.setGongchang("���ϳ�ɳ�������޹�˾2");
//		e.setChuchangprice(650.0);
//		e.setChuchangdate(new Date());
//		session.save(e);
		
		
		//�޸�
//		Ecrparts e=(Ecrparts)session.get(Ecrparts.class, 2L);
//		e.setJingxiao("������˾");
//		e.setFapiaodate(new Date());
//		e.setFapiaoprice(730.0);
//		e.setBaoxiudate(new Date());
		
		
		//ɾ��
//		Ecrparts e=new Ecrparts();
//		e.setId(3L);
//		session.delete(e);
		
		
		
		
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
































