package com.wtg;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.wtg.entity.Book;

//ʹ��dom��������ȡbooks.xml�ļ�
public class Test1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Book> books=new ArrayList<Book>(0);
		//�ҵ�������˾
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//������˾�ɳ�����С�ֶ�
		DocumentBuilder db=dbf.newDocumentBuilder();
		//����С�ֶ��ҵ�����
		Document doc = db.parse(new File("books.xml"));
		//С�ֶӿ�ʼ�ɻ�(�ҵ��ɻ�ĵص�)
		NodeList nodeList = doc.getElementsByTagName("book");
		Book book;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element stuNode = (Element) nodeList.item(i);
			String stuid = stuNode.getAttribute("id");
			//System.out.println("stuid=="+stuid);
			Element nameNode = (Element) stuNode.getElementsByTagName("name").item(0);
			String stuname = nameNode.getTextContent();
			//System.out.println("stuname=="+stuname);
			//ÿ��bookԪ�ض�Ӧһ��book����
			book=new Book();
			book.setId(Integer.parseInt(stuid));
			book.setName(stuname);
			books.add(book);
		}
		for (Book b : books) {
			System.out.println(b);
		}
	}
}
