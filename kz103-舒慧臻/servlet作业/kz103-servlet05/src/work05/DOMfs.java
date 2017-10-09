package work05;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import work05.entity.Books;

public class DOMfs {
	/***
	 * <books>
   <book id="1001">
       <name>java</name>
   </book>
   
   <book id="1002">
       <name>c#</name>
   </book>
</books>
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//创建一个集合，接收dom解析读出的元素
		ArrayList<Books> book = new ArrayList<Books>();
		//创建文档树
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//创建树枝
		DocumentBuilder db = dbf.newDocumentBuilder();
		//创建元素
		Document doc = db.parse(new File("books.xml"));
		//读取
		NodeList nodeList = doc.getElementsByTagName("book");
		Books bk;
		//遍历每个块里的元素
		for (int i = 0; i < nodeList.getLength(); i++) {
			//读取id属性
			Element bkNode = (Element)nodeList.item(i);
			String bkid = bkNode.getAttribute("id");
			System.out.println("bkid========="+bkid);
			//获取name元素
			//getElementsByTagName("name")获取执行节点的子节点对象
			Element nameNode = (Element)bkNode.getElementsByTagName("name").item(0);
			String name = nameNode.getTextContent();
			System.out.println("name==========="+name);
			//每个元素对应一个book对象
			bk = new Books();
			bk.setId(Integer.parseInt(bkid));
			bk.setName(name);                              
			book.add(bk);
		}
		for (Books bks : book) {
			System.out.println(bks);
		}
		
		
	}

}
