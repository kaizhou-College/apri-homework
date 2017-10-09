package text;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*一，写一个books.xml中写入以下标签
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
		
		Element rootBooks = doc.createElement("books");//创建books
		doc.appendChild(rootBooks);//放进根目录下
		
		Element teaBook = doc.createElement("book");//创建book
		teaBook.setAttribute("id","1001");//给book创建一个’id‘并且给ID设个值‘1001’
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
		
		
		
		// 写入文件   
		TransformerFactory tf=TransformerFactory.newInstance();//公安局
		Transformer tfm = tf.newTransformer();//小分队
		
		DOMSource sur=new DOMSource(doc);//拆
		StreamResult dest=new StreamResult("books.xml");//
		tfm.transform(sur, dest);//
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
