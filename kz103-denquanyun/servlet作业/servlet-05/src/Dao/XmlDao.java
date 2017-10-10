package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Entity.Books;
/*
 *  ��XMLDao��������·���
 public List findAll();

 public void addRole(Role r);

 public void updateRoleById(String id);

 public void deleteRoleById(String id);

 ��������ķ���

 * */
public class XmlDao {
	//�õ�doc����
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
	//дxml�ļ�����
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
	//��
	 public static List<Books> findAll(){
		 ArrayList<Books> booklist = new ArrayList<Books>();
		 Document doc = creatDoc("books.xml");
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
		 return booklist;
	 }
	//��
	 public static void Add(Books book){
		 Document doc = creatDoc("books.xml");
		 Element root= (Element) doc.getElementsByTagName("books").item(0);
		 Element booknode = doc.createElement("book");
		 booknode.setAttribute("id",String.valueOf(book.getId()));
		 Element name = doc.createElement("name");
		 name.setTextContent(book.getName());
		 booknode.appendChild(name);
		 root.appendChild(booknode);
		 XmlDao.writeXml(doc,"books.xml");
		 System.out.println("��ӳɹ�");
	 }
	 //ɾ
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
		 System.out.println("ɾ���ɹ�");
	 }
	 //�޸�
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
		 writeXml(doc,"books.xml");
		 System.out.println("�޸ĳɹ�");
	 }
	 public static void main(String[] args) {
		 Books book = new Books("��Ů���������ɵ�",15);
		Update(1001,"HeyGuys");
	}
}
