package test;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import enetity.book;

public class work1 {
	public static void main(String[] args) throws Exception{
		ArrayList<book> books=new ArrayList<book>(0);
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=factory.newDocumentBuilder();
		Document doc=db.parse(new File("books.xml"));
		NodeList nodeList=doc.getElementsByTagName("book");
		book bk;
		for(int i=0;i<nodeList.getLength();i++){
			Element bookNode = (Element) nodeList.item(i);
			String bookid = bookNode.getAttribute("id");
			Element nameNode=(Element) bookNode.getElementsByTagName("name").item(0);
			String bookName=nameNode.getTextContent();
			bk = new book();
			bk.setId(Integer.parseInt(bookid));
			bk.setName(bookName);
			books.add(bk);
		}
		for(book b:books){
			System.out.println(b);
		}
	}
}
