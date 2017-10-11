package com.kz.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kz.dao.DomDao;
//<books>
//<book id="1001">
//    <name>java</name>
//</book>
//
//<book id="1002">
//    <name>c#</name>
//</book>
//</books>
public class test01 {
	public static void main(String[] args) {
		Document doc = DomDao.createDoc();
		Element rootBooks = doc.createElement("books");
		doc.appendChild(rootBooks);
		Element rootBook = doc.createElement("book");
		rootBook.setAttribute("id", "1001");
		Element name = doc.createElement("name");
		name.setTextContent("java");
		Element rootBook2 = doc.createElement("book");
		rootBook2.setAttribute("id", "1002");
		Element name2 = doc.createElement("name");
		name2.setTextContent("c#");
		rootBooks.appendChild(rootBook);
		rootBook.appendChild(name);
		rootBooks.appendChild(rootBook2);
		rootBook2.appendChild(name2);
		DomDao.writeXML(doc, "books.xml");
	}
}
