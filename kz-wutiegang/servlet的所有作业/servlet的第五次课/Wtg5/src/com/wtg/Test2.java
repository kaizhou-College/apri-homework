package com.wtg;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Test2 {
	public static void main(String[] args) throws Exception {
		//建筑公司
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//派出建筑小分队
		DocumentBuilder db = dbf.newDocumentBuilder();
		//找到对象
		Document doc = db.newDocument();
		
		//创建根元素
		Element rootusers = doc.createElement("users");
		//将根元素追加到doc上
		doc.appendChild(rootusers);
		
		//创建根元素的第一个子元素
		Element userNode = doc.createElement("user");
		//为子元素设置属性
		userNode.setAttribute("id", "1001");
		userNode.setAttribute("sex", "男");
		//为user设置子元素
		Element nameNode = doc.createElement("name");
		Element birthNode = doc.createElement("birth");
		//为子元素设置文本
		nameNode.setTextContent("tom");
		birthNode.setTextContent("2005-01-01");
		//将user的子元素追加到users的子元素上
		userNode.appendChild(nameNode);
		userNode.appendChild(birthNode);
		//将users子元素追加到根元素上
		rootusers.appendChild(userNode);
		
		
		//创建根元素的第二个子元素
		Element userNode2 = doc.createElement("user");
		//为子元素设置属性
		userNode2.setAttribute("id", "1002");
		userNode2.setAttribute("sex", "女");
		//为user设置子元素
		Element nameNode2 = doc.createElement("name");
		Element birthNode2 = doc.createElement("birth");
		//为子元素设置文本
		nameNode2.setTextContent("jerry");
		birthNode2.setTextContent("2008-03-03");
		//将user的子元素追加到users的子元素上
		userNode2.appendChild(nameNode2);
		userNode2.appendChild(birthNode2);
		//将users子元素追加到根元素上
		rootusers.appendChild(userNode2);
		
		
		
		//将写好的值通过transformerFactory管理起来
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer tfm = tf.newTransformer();
		//先将文档和xml文件用DOMSource和StreamResult包起来
		DOMSource sur=new DOMSource(doc);
		StreamResult dest=new StreamResult("user.xml");
		tfm.transform(sur, dest);
	}
}
