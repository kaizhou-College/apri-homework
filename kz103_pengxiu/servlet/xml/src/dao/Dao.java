package dao;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Dao {
	public static Document createDoc(){
		Document doc = null;
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return doc;
	}
	public static Document createSel(String filename){
		Document doc = null;
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(new File(filename));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	public static void writeXML(Document doc,String fileName){
		
		TransformerFactory tf=TransformerFactory.newInstance();
		try {
			Transformer tfm = tf.newTransformer();
			DOMSource suo=new DOMSource(doc);
			StreamResult dest=new StreamResult(fileName);
				tfm.transform(suo, dest);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
