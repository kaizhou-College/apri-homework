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
		//������˾
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//�ɳ�����С�ֶ�
		DocumentBuilder db = dbf.newDocumentBuilder();
		//�ҵ�����
		Document doc = db.newDocument();
		
		//������Ԫ��
		Element rootusers = doc.createElement("users");
		//����Ԫ��׷�ӵ�doc��
		doc.appendChild(rootusers);
		
		//������Ԫ�صĵ�һ����Ԫ��
		Element userNode = doc.createElement("user");
		//Ϊ��Ԫ����������
		userNode.setAttribute("id", "1001");
		userNode.setAttribute("sex", "��");
		//Ϊuser������Ԫ��
		Element nameNode = doc.createElement("name");
		Element birthNode = doc.createElement("birth");
		//Ϊ��Ԫ�������ı�
		nameNode.setTextContent("tom");
		birthNode.setTextContent("2005-01-01");
		//��user����Ԫ��׷�ӵ�users����Ԫ����
		userNode.appendChild(nameNode);
		userNode.appendChild(birthNode);
		//��users��Ԫ��׷�ӵ���Ԫ����
		rootusers.appendChild(userNode);
		
		
		//������Ԫ�صĵڶ�����Ԫ��
		Element userNode2 = doc.createElement("user");
		//Ϊ��Ԫ����������
		userNode2.setAttribute("id", "1002");
		userNode2.setAttribute("sex", "Ů");
		//Ϊuser������Ԫ��
		Element nameNode2 = doc.createElement("name");
		Element birthNode2 = doc.createElement("birth");
		//Ϊ��Ԫ�������ı�
		nameNode2.setTextContent("jerry");
		birthNode2.setTextContent("2008-03-03");
		//��user����Ԫ��׷�ӵ�users����Ԫ����
		userNode2.appendChild(nameNode2);
		userNode2.appendChild(birthNode2);
		//��users��Ԫ��׷�ӵ���Ԫ����
		rootusers.appendChild(userNode2);
		
		
		
		//��д�õ�ֵͨ��transformerFactory��������
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer tfm = tf.newTransformer();
		//�Ƚ��ĵ���xml�ļ���DOMSource��StreamResult������
		DOMSource sur=new DOMSource(doc);
		StreamResult dest=new StreamResult("user.xml");
		tfm.transform(sur, dest);
	}
}
