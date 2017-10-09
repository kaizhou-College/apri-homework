package Servlet05;
/*   
<users>--根元素
<user>--子元素
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Work1_2 {
	public static void main(String[] args) {
		//1建筑公司
		DocumentBuilderFactory dbf=null;
		//2建筑小分队
		DocumentBuilder db=null;
		//3.document对象
		Document doc=null;
		//写入文件第一步
		TransformerFactory tf =null;
		//写入文件第二步
		Transformer tfm =null;
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			//3构建document对象
			doc=db.newDocument();
			//3.1创建根元素
			Element rootUsers=doc.createElement("users");
			//把根元素挂到树上
			doc.appendChild(rootUsers);
			//3.2创建根的第一个子元素
			Element userNode=doc.createElement("user");
			//(1)为user设置值如:id
			userNode.setAttribute("id", "1001");
			userNode.setAttribute("sex", "男");
			//(2)为user设置子元素
			Element nameNode = doc.createElement("name");
			nameNode.setTextContent("tom");
			Element birthNode = doc.createElement("birth");
			birthNode.setTextContent("2005-01-01");
			//(3)把子元素挂到user元素上
			userNode.appendChild(nameNode);
			userNode.appendChild(birthNode);
			//(4)再把user挂到users上
			rootUsers.appendChild(userNode);
			
			Element userNode2=doc.createElement("user");
			//(1)为user设置值如:id
			userNode2.setAttribute("id", "1002");
			userNode2.setAttribute("sex", "女");
			//(2)为user设置子元素
			Element nameNode2= doc.createElement("name");
			nameNode2.setTextContent("jerry");
			Element birthNode2 = doc.createElement("birth");
			birthNode2.setTextContent("2008-03-03");
			//(3)把子元素挂到user元素上
			userNode2.appendChild(nameNode2);
			userNode2.appendChild(birthNode2);
			//(4)再把user挂到users上
			rootUsers.appendChild(userNode2);
			//4写入文件
			//(1)城管局
			tf= TransformerFactory.newInstance();
			//(2)城管小分队
			tfm= tf.newTransformer();
			//(3)拆
			DOMSource sur=new DOMSource(doc);
			StreamResult dest=new StreamResult("users.xml");
			tfm.transform(sur, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
