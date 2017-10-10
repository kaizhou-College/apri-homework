package com.wtg;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.wtg.entity.Book;

//使用dom解析来读取books.xml文件
public class Test1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Book> books=new ArrayList<Book>(0);
		//找到建筑公司
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//建筑公司派出建筑小分队
		DocumentBuilder db=dbf.newDocumentBuilder();
		//建筑小分队找到对象
		Document doc = db.parse(new File("books.xml"));
		//小分队开始干活(找到干活的地点)
		NodeList nodeList = doc.getElementsByTagName("book");
		Book book;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element stuNode = (Element) nodeList.item(i);
			String stuid = stuNode.getAttribute("id");
			//System.out.println("stuid=="+stuid);
			Element nameNode = (Element) stuNode.getElementsByTagName("name").item(0);
			String stuname = nameNode.getTextContent();
			//System.out.println("stuname=="+stuname);
			//每个book元素对应一个book对象
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
