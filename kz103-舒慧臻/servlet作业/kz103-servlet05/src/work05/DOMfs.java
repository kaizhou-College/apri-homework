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
		//����һ�����ϣ�����dom����������Ԫ��
		ArrayList<Books> book = new ArrayList<Books>();
		//�����ĵ���
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//������֦
		DocumentBuilder db = dbf.newDocumentBuilder();
		//����Ԫ��
		Document doc = db.parse(new File("books.xml"));
		//��ȡ
		NodeList nodeList = doc.getElementsByTagName("book");
		Books bk;
		//����ÿ�������Ԫ��
		for (int i = 0; i < nodeList.getLength(); i++) {
			//��ȡid����
			Element bkNode = (Element)nodeList.item(i);
			String bkid = bkNode.getAttribute("id");
			System.out.println("bkid========="+bkid);
			//��ȡnameԪ��
			//getElementsByTagName("name")��ȡִ�нڵ���ӽڵ����
			Element nameNode = (Element)bkNode.getElementsByTagName("name").item(0);
			String name = nameNode.getTextContent();
			System.out.println("name==========="+name);
			//ÿ��Ԫ�ض�Ӧһ��book����
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
