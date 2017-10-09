package text;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*һ��дһ��books.xml��д�����±�ǩ
<books>
   <book id="1001">
       <name>java</name>
   </book>
   
   <book id="1002">
       <name>c#</name>
   </book>
</books>
 * 
 * 
 */
public class zy1_xml01 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element rootBooks = doc.createElement("books");//����books
		doc.appendChild(rootBooks);//�Ž���Ŀ¼��
		
		Element teaBook = doc.createElement("book");//����book
		teaBook.setAttribute("id","1001");//��book����һ����id�����Ҹ�ID���ֵ��1001��
		Element teaBook1 = doc.createElement("book");
		teaBook1.setAttribute("id","1002");
		Element name = doc.createElement("name");
		name.setTextContent("Java");
		Element name1 = doc.createElement("name");;
		name1.setTextContent("#C");
		
		rootBooks.appendChild(teaBook);
		rootBooks.appendChild(teaBook1);
		teaBook.appendChild(name);
		teaBook1.appendChild(name1);
		
		
		
		// д���ļ�   
		TransformerFactory tf=TransformerFactory.newInstance();//������
		Transformer tfm = tf.newTransformer();//С�ֶ�
		
		DOMSource sur=new DOMSource(doc);//��
		StreamResult dest=new StreamResult("books.xml");//
		tfm.transform(sur, dest);//
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
