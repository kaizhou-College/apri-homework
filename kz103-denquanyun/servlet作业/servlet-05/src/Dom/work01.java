package Dom;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Entity.Books;

/*
 * <books>
   <book id="1001">
       <name>java</name>
   </book>
   
   <book id="1002">
       <name>c#</name>
   </book>
</books>
 * */
public class work01 {
	public static void main(String[] args) throws Exception {
		ArrayList<Books> booklist = new ArrayList<Books>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("books.xml"));
		NodeList list = doc.getElementsByTagName("book");
		Books book;
		for (int i = 0; i < list.getLength(); i++) {
			Element e = (Element) list.item(i);
			int id = Integer.parseInt(e.getAttribute("id"));
			Element namenode=(Element) e.getElementsByTagName("name").item(0);
			String name = namenode.getTextContent();
			book= new Books(name, id);
			booklist.add(book);
		}
		for (Books b : booklist) {
			System.out.println(b);
		}
	}
}
