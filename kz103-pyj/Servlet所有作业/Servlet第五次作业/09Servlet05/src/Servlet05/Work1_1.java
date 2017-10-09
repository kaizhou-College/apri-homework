package Servlet05;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import entity.Book;

/*
<books>--root element
	<book id="1001">--element����
			<name>Java</name>--��Ԫ��
 */
public class Work1_1 {
	public static void main(String[] args) {
		//7.1����
		ArrayList<Book> books=new ArrayList<Book>(0);
		//������˾
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db =null;
		Document doc=null;
		NodeList nodeList=null;
		try {
			//1����С�ֶ�
			db= dbf.newDocumentBuilder();
			//2����document����
			doc = db.parse(new File("books.xml"));
			//3���ļ�
			nodeList = doc.getElementsByTagName("book");
			Book bk;
			for (int i = 0; i < nodeList.getLength(); i++) {
				//4��ȡbookԪ�ص�id����---Ҳ�нڵ�
				Element bookNode = (Element)nodeList.item(i);
				String bookId=bookNode.getAttribute("id");
				//5��ȡnameԪ��<getElementsByTagName("name").item(0)�ǻ�ȡ�ڵ���ӽڵ����>
				Element nameNode =(Element)bookNode.getElementsByTagName("name").item(0);
				String bookname=nameNode.getTextContent();
				//6ÿһ��book��Ԫ�ض���Ӧһ��Book����
				bk=new Book();
				bk.setId(Integer.parseInt(bookId));
				bk.setName(bookname);
				//7��bk������뼯��
				books.add(bk);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
