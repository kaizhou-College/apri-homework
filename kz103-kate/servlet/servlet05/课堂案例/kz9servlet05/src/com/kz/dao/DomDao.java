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
	//查询
	//添加
	//删除(removeChilde())
	//更新 setTextContent()
	//得到doc对象(增删改查)
	public Document createDoc(){
		try {
			//1,建筑公司
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//2,建筑小分队
			DocumentBuilder db = dbf.newDocumentBuilder();
			//3,构建document对象
			Document doc = db.newDocument();
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	//写xml文件(添加，删除，更新)
	public void writeXml(Document doc,String fileName){
		try {
			//1)城管局
			TransformerFactory tf = TransformerFactory.newInstance();
			//2)城管小分队
			Transformer tfm = tf.newTransformer();
			//3)拆
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
