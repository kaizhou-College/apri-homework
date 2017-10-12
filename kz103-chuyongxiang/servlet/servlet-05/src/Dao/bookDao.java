package Dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import enetity.book;

public class bookDao extends DefaultHandler{
	private List<book> bk;
	//文档开始了
	public void startDocument() throws SAXException{
		bk = new ArrayList<book>(0);
	}
	//文档结束了
	public void endDocument() throws SAXException{
		System.out.println("文档结束了");
	}
	//元素开始了 
	public void startElement(String uri, String localName, String  
            name,Attributes attributes) throws SAXException {
	}
	//文本开始了
	public void characters(char[] ch, int start, int length)
	  throws SAXException {
	}
	//元素结束了
	public void endElement(String uri, String localName, String name)
	  throws SAXException {  }
	}
