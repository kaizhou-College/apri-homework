package com.kz.L6;

import java.io.File;

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
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomDao {
	//查询
	//添加
	//删除(removeChilde())
	//学生来说
	public void delete(int stuId){
		Document doc = createDoc("student.xml");
		Element root = (Element) doc.getElementsByTagName("students").item(0);
		NodeList nodes = doc.getElementsByTagName("student");
		for(int i=0;i<nodes.getLength();i++){
			Element element = (Element) nodes.item(i);
			String value = element.getAttribute("id");
			int val = Integer.parseInt(value);
			if(val==stuId){
				root.removeChild(element);
			}
		}
		//写入文件
		writeXml(doc,"student.xml");
		System.out.println("删除成功！！！");
		
	}
	//更新 setTextContent()
	
	//得到doc对象(增删改查)
	public Document createDoc(String fileName){
		try {
			//1,建筑公司
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//2,建筑小分队
			DocumentBuilder db = dbf.newDocumentBuilder();
			//3,构建document对象
			Document doc = db.parse(new File(fileName));
			return doc;
		} catch (Exception e) {
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
	public static void main(String[] args) {
		new DomDao().delete(2);
	}
}
