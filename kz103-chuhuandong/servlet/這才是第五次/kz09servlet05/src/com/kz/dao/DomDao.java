package com.kz.dao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class DomDao {
	public static Document createDoc(){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Document createDocs(String filename){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(filename);
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void writeXML(Document doc,String fileName){
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tran = tf.newTransformer();
			DOMSource sur = new DOMSource(doc);
			StreamResult sr = new StreamResult(fileName);
			tran.transform(sur, sr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
