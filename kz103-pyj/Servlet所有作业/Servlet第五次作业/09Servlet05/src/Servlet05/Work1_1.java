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
	<book id="1001">--element属性
			<name>Java</name>--子元素
 */
public class Work1_1 {
	public static void main(String[] args) {
		//7.1集合
		ArrayList<Book> books=new ArrayList<Book>(0);
		//建筑公司
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db =null;
		Document doc=null;
		NodeList nodeList=null;
		try {
			//1建筑小分队
			db= dbf.newDocumentBuilder();
			//2构建document对象
			doc = db.parse(new File("books.xml"));
			//3读文件
			nodeList = doc.getElementsByTagName("book");
			Book bk;
			for (int i = 0; i < nodeList.getLength(); i++) {
				//4读取book元素的id属性---也叫节点
				Element bookNode = (Element)nodeList.item(i);
				String bookId=bookNode.getAttribute("id");
				//5获取name元素<getElementsByTagName("name").item(0)是获取节点的子节点对象>
				Element nameNode =(Element)bookNode.getElementsByTagName("name").item(0);
				String bookname=nameNode.getTextContent();
				//6每一个book的元素都对应一个Book对象
				bk=new Book();
				bk.setId(Integer.parseInt(bookId));
				bk.setName(bookname);
				//7把bk对象放入集合
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
