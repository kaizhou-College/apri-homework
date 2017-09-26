package com.kz.test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.kz.dao.SAXDao;
import com.kz.entity.Student;

public class Test3 {
	public static void main(String[] args) throws Exception, SAXException {
		//1,������˾
		SAXParserFactory spf= SAXParserFactory.newInstance();
		//2,����С�ֶ�
		SAXParser sp = spf.newSAXParser();
		SAXDao sAXDao= new SAXDao();
		//3,��ȡ
		sp.parse("student.xml",sAXDao);
		for(Student s : sAXDao.getStus()){
			System.out.println(s);
		}
		
		
	}
}
