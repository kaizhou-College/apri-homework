package XMLDao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.kqw.entity.Booksentity;

public class Xml {
	//得到doc对象
	public static Document creatDoc(String fileName){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(fileName);
			return dom;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Document creatDoc(){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.newDocument();
			return dom;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//写xml文件方法
	public static void writeXml(Document doc,String fileName){
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tfm = tf.newTransformer();
			DOMSource dom = new DOMSource(doc);
			StreamResult st = new StreamResult(fileName);
			tfm.transform(dom,st);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	//查
	 public static List<Booksentity> findAll(){
		 ArrayList<Booksentity> booklist = new ArrayList<Booksentity>();
		 Document doc = creatDoc("books.xml");
		 NodeList list = doc.getElementsByTagName("book");
		 Booksentity book;
		 for (int i = 0; i < list.getLength(); i++) {
			 Element e = (Element) list.item(i);
				int id = Integer.parseInt(e.getAttribute("id"));
				Element namenode=(Element) e.getElementsByTagName("name").item(0);
				String name = namenode.getTextContent();
				book= new Booksentity(id, name);
				booklist.add(book);
		}
		 return booklist;
	 }
	//增
	 public static void Add(Booksentity book){
		 Document doc = creatDoc("books.xml");
		 Element root= (Element) doc.getElementsByTagName("books").item(0);
		 Element booknode = doc.createElement("book");
		 booknode.setAttribute("id",String.valueOf(book.getId()));
		 Element name = doc.createElement("name");
		 name.setTextContent(book.getName());
		 booknode.appendChild(name);
		 root.appendChild(booknode);
		 Xml.writeXml(doc,"books.xml");
		 System.out.println("添加成功");
	 }
	 //删
	 public static void Delete(int id){
		 Document doc = creatDoc("books.xml");
		 Element root = (Element) doc.getElementsByTagName("books").item(0);
		 NodeList list = doc.getElementsByTagName("book");
		 for (int i = 0; i <list.getLength(); i++) {
			Element book = (Element) list.item(i);
			int bid=Integer.parseInt(book.getAttribute("id"));
			if(bid==id){
				root.removeChild(book);
			}
		}
		 writeXml(doc,"books.xml");
		 System.out.println("删除成功");
	 }

	 //修改
	 public static void Update(int id,String content){
		 Document doc = creatDoc("books.xml");
		 Element root = (Element) doc.getElementsByTagName("books").item(0);
		 NodeList list = doc.getElementsByTagName("book");
		 for (int i = 0; i < list.getLength(); i++) {
			Element book = (Element) list.item(i);
			int bid=Integer.parseInt(book.getAttribute("id"));
			if(bid==id){
				Element name = (Element) book.getElementsByTagName("name").item(0);
				name.setTextContent(content);
			}
		 }
	 
	 }
}