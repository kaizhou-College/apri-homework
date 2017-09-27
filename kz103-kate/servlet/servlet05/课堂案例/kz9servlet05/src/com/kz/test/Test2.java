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
 * 			<name>�մ���</name>
 * 			<age>38</age>
 * 		</tea>
 * 
 * 		<tea id="22">
 * 			<name>�˴���</name>
 * 			<age>48</age>
 * 		</tea>
 * </teas>
 */

//����ʦ����Ϣ���浽xml�ļ���
public class Test2 {
	public static void main(String[] args) throws Exception{
		//1,������˾
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2,����С�ֶ�
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3,����document����
		Document doc = db.newDocument();
		//3,1������Ԫ��
		Element rootTeas = doc.createElement("teas");
		//����Ԫ�عҵ�����
		doc.appendChild(rootTeas);
		//3.2�������ĵ�1����Ԫ��
		Element teaNode = doc.createElement("tea");
		//1)Ϊtea��������
		teaNode.setAttribute("id", "21");
		//2)Ϊtea������Ԫ��
		
		Element nameNode = doc.createElement("name");
		
		nameNode.setTextContent("�մ���");
		Element ageNode = doc.createElement("age");
		ageNode.setTextContent("38");
		//3)��name��ageԪ�عҵ�teaԪ����
		teaNode.appendChild(nameNode);
		teaNode.appendChild(ageNode);
		//4)��tea�ҵ�teas��
		rootTeas.appendChild(teaNode);
		
		Element teaNode2 = doc.createElement("tea");
		//1)Ϊtea��������
		teaNode2.setAttribute("id", "22");
		//2)Ϊtea������Ԫ��
		Element nameNode2 = doc.createElement("name");
		nameNode2.setTextContent("�˴���");
		Element ageNode2 = doc.createElement("age");
		ageNode2.setTextContent("48");
		//3)��name��ageԪ�عҵ�teaԪ����
		teaNode2.appendChild(nameNode2);
		teaNode2.appendChild(ageNode2);
		//4)��tea�ҵ�teas��
		rootTeas.appendChild(teaNode2);
		//4,д���ļ�(�ǹ�)
		//1)�ǹܾ�
		TransformerFactory tf = TransformerFactory.newInstance();
		//2)�ǹ�С�ֶ�
		Transformer tfm = tf.newTransformer();
		//3)��
		//tfm.transform(doc, "teas.xml");
		DOMSource sur = new DOMSource(doc);
		StreamResult dest = new StreamResult("teas.xml");
		
		tfm.transform(sur,dest);
		
	}
}
