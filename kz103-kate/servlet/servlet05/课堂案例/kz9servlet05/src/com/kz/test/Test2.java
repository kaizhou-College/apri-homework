package com.kz.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * 
 * <teas>
 * 		<tea id="21">
 * 			<name>苏大妈</name>
 * 			<age>38</age>
 * 		</tea>
 * 
 * 		<tea id="22">
 * 			<name>邓大妈</name>
 * 			<age>48</age>
 * 		</tea>
 * </teas>
 */

//将老师的信息保存到xml文件中
public class Test2 {
	public static void main(String[] args) throws Exception{
		//1,建筑公司
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2,建筑小分队
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3,构建document对象
		Document doc = db.newDocument();
		//3,1创建根元素
		Element rootTeas = doc.createElement("teas");
		//将根元素挂到树上
		doc.appendChild(rootTeas);
		//3.2创建根的第1个子元素
		Element teaNode = doc.createElement("tea");
		//1)为tea设置属性
		teaNode.setAttribute("id", "21");
		//2)为tea设置子元素
		
		Element nameNode = doc.createElement("name");
		
		nameNode.setTextContent("苏大妈");
		Element ageNode = doc.createElement("age");
		ageNode.setTextContent("38");
		//3)将name和age元素挂到tea元素上
		teaNode.appendChild(nameNode);
		teaNode.appendChild(ageNode);
		//4)将tea挂到teas下
		rootTeas.appendChild(teaNode);
		
		Element teaNode2 = doc.createElement("tea");
		//1)为tea设置属性
		teaNode2.setAttribute("id", "22");
		//2)为tea设置子元素
		Element nameNode2 = doc.createElement("name");
		nameNode2.setTextContent("邓大妈");
		Element ageNode2 = doc.createElement("age");
		ageNode2.setTextContent("48");
		//3)将name和age元素挂到tea元素上
		teaNode2.appendChild(nameNode2);
		teaNode2.appendChild(ageNode2);
		//4)将tea挂到teas下
		rootTeas.appendChild(teaNode2);
		//4,写入文件(城管)
		//1)城管局
		TransformerFactory tf = TransformerFactory.newInstance();
		//2)城管小分队
		Transformer tfm = tf.newTransformer();
		//3)拆
		//tfm.transform(doc, "teas.xml");
		DOMSource sur = new DOMSource(doc);
		StreamResult dest = new StreamResult("teas.xml");
		
		tfm.transform(sur,dest);
		
	}
}
