package com.kz.dao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class DomDao {
	//��ѯ
	//���
	//ɾ��(removeChilde())
	//���� setTextContent()
	//�õ�doc����(��ɾ�Ĳ�)
	public Document createDoc(){
		try {
			//1,������˾
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//2,����С�ֶ�
			DocumentBuilder db = dbf.newDocumentBuilder();
			//3,����document����
			Document doc = db.newDocument();
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	//дxml�ļ�(��ӣ�ɾ��������)
	public void writeXml(Document doc,String fileName){
		try {
			//1)�ǹܾ�
			TransformerFactory tf = TransformerFactory.newInstance();
			//2)�ǹ�С�ֶ�
			Transformer tfm = tf.newTransformer();
			//3)��
			//tfm.transform(doc, "teas.xml");
			DOMSource sur = new DOMSource(doc);
			StreamResult dest = new StreamResult(fileName);
			
			tfm.transform(sur,dest);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
