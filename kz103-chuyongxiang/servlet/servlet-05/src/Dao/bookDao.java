package Dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import enetity.book;

public class bookDao extends DefaultHandler{
	private List<book> bk;
	//�ĵ���ʼ��
	public void startDocument() throws SAXException{
		bk = new ArrayList<book>(0);
	}
	//�ĵ�������
	public void endDocument() throws SAXException{
		System.out.println("�ĵ�������");
	}
	//Ԫ�ؿ�ʼ�� 
	public void startElement(String uri, String localName, String  
            name,Attributes attributes) throws SAXException {
	}
	//�ı���ʼ��
	public void characters(char[] ch, int start, int length)
	  throws SAXException {
	}
	//Ԫ�ؽ�����
	public void endElement(String uri, String localName, String name)
	  throws SAXException {  }
	}
