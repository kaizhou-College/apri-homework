package com.kz.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.kz.entity.role;

public class XMLDao {
	public static List<role> findAll(){
		List<role> list = new ArrayList<role>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc =null;
		try {
			doc = db.parse(new File("role.xml"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NodeList nodeList = doc.getElementsByTagName("role");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element item = (Element) nodeList.item(i);
			String id = item.getAttribute("id");
			Element roleNode = (Element) item.getElementsByTagName("name").item(0);
			String role = roleNode.getTextContent();
			role r = new role(role,id);
			list.add(r);
		}
		return list;
	}
	public static void add(role r){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = db.parse(new File("role.xml"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NodeList rolesNode = doc.getElementsByTagName("roles");
		Element roles = (Element) rolesNode.item(0);
		Element role = doc.createElement("role");
		role.setAttribute("id", r.getId());
		Element name = doc.createElement("name");
		name.setTextContent(r.getName());
		roles.appendChild(role);
		role.appendChild(name);
		DomDao.writeXML(doc,"role.xml");
	}
	public static void updateRoleById(String id,String var){
		 Document doc = DomDao.createDocs("role.xml");
		 NodeList nameNode = doc.getElementsByTagName("role");
		 for (int i = 0; i < nameNode.getLength(); i++) {
			 Element name = (Element) nameNode.item(i);
			 String Id = name.getAttribute("id");
			 if(Id.equals(id)){
				 NodeList nameNodes = doc.getElementsByTagName("name");
				 Element names = (Element) nameNodes.item(0);
				 names.setTextContent(var);
			 }
		}
		 DomDao.writeXML(doc, "role.xml");
		 System.out.println("修改成功");
	}
	public static void deleteRoleById(String id){
		Document doc = DomDao.createDocs("role.xml");
		Element root = (Element) doc.getElementsByTagName("roles").item(0);
		NodeList list = doc.getElementsByTagName("role");
		for (int i = 0; i < list.getLength(); i++) {
			Element item = (Element) list.item(i);
			String ids = item.getAttribute("id");
			if(ids.equals(id)){
				root.removeChild(item);
			}
		}
		DomDao.writeXML(doc, "role.xml");
		System.out.println("刪除成功");
	}
	public static void main(String[] args) {
		deleteRoleById("1001");
	}
}
