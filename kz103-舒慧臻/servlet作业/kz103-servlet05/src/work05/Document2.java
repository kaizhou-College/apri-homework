package work05;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/***
 *  <users>
      <user id="1001" sex="男">
         <name>tom</name>
         <birth>2005-01-01</birth>
      </user>


      <user id="1002" sex="女">
         <name>jerry</name>
         <birth>2008-03-03</birth>
      </user>
  </users> 
 *
 */
public class Document2 {
	public static void main(String[] args) throws Exception {
		//创建文档
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//文档分支
		DocumentBuilder db = dbf.newDocumentBuilder();
		//文档对象
		Document doc = db.newDocument();
		//创建根元素
		Element rootElement = doc.createElement("users");
		//将根元素归位
		doc.appendChild(rootElement);
		//创建元素
		Element user = doc.createElement("user");
		//设置属性
		user.setAttribute("id", "1001");
		user.setAttribute("sex", "男");
		//设置子元素
		Element nameNode = doc.createElement("name");
		//给子元素赋值
		nameNode.setTextContent("tom");
		//将子元素挂到文档节点上
		user.appendChild(nameNode);
		//将文档节点挂到根元素上
		rootElement.appendChild(user);
		
		//创建一个新的文档根元素（步骤同上）
		Element user2 = doc.createElement("user");
		user2.setAttribute("id", "1002");
		user2.setAttribute("sex", "女");
		
		Element nameNode2 = doc.createElement("name");
		nameNode2.setTextContent("jerry");
		
		user2.appendChild(nameNode2);
		rootElement.appendChild(user2);
		
		//写入文件
		//1)管理文件的
		TransformerFactory tf = TransformerFactory.newInstance();
		//管理文件的分支
		Transformer tfm = tf.newTransformer();
		//拆文件
		DOMSource sur = new DOMSource(doc);
		StreamResult dest = new StreamResult("users.xml");
		tfm.transform(sur, dest);
		
		
		
		
		
		
	}

}
