package com.kz.dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.kz.entity.Student;

public class SAXDao extends DefaultHandler{
	private List<Student> stus;
	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
	}

	private Student stu ;
	//��Ԫ�����¼�
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//System.out.println("��Ԫ�����¼�");
		//System.out.println("Ԫ����Ϊ��"+new String(ch,start,length));
		String content = new String(ch,start,length);
		if(content!=null&&content.trim().length()>0){//�ַ����ķǿ��жϱ�׼
			//System.out.println("Ԫ����Ϊ��"+content);
			//�����������ж�
			try {
				int age = Integer.parseInt(content);
				//�϶���age
				stu.setAge(age);
			} catch (Exception e) {
				//�϶���name
				stu.setName(content);
			}
		}
	}
	//�������ĵ��¼�
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("�������ĵ��¼�");
	}
	//������Ԫ���¼�
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("������Ԫ���¼�");
		if(qName.equals("student")){
			stus.add(stu);
		}
	}

	//����ʼ�ĵ��¼�
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("����ʼ�ĵ��¼�");
		stus = new ArrayList<Student>(0);
		
	}

	//����ʼԪ���¼�
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//System.out.println("����ʼԪ���¼�");
		//System.out.println(uri+"==="+localName+"==="+qName+"=="+attributes);
		
		if(qName.equals("student")){
			String id= attributes.getValue("id");//��ȡid����ֵ
			stu = new Student();
			stu.setId(Integer.parseInt(id));
		}
	}
	
}
