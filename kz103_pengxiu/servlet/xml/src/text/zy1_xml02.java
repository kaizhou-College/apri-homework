package text;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entity.Books;

public class zy1_xml02 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("books.xml"));
		NodeList elementsByTagName = doc.getElementsByTagName("book");
		Books books;
		ArrayList<Books> list=new ArrayList<Books>();
		for (int i = 0; i <elementsByTagName.getLength(); i++) {
			Element bookNode =(Element) elementsByTagName.item(i);
			String bookID = bookNode.getAttribute("id");
			Element nameNod =(Element) bookNode.getElementsByTagName("name").item(0);
			String bookname = nameNod.getTextContent();
			books=new Books();
			books.setId(Integer.parseInt(bookID));
			books.setName(bookname);
			list.add(books);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
