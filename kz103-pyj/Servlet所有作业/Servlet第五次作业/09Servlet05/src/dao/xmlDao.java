package dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Role;


public class xmlDao {
	//��ѯ����
	public ArrayList<Role> findAll(){
		ArrayList<Role> roles=new ArrayList<Role>(0);
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("roles.xml"));
			NodeList nl = doc.getElementsByTagName("role");
			for (int i = 0; i < nl.getLength(); i++) {
				Element item = (Element) nl.item(i);
				String attribute = item.getAttribute("id");
				Element name = (Element) item.getElementsByTagName("name").item(0);
				String content = name.getTextContent();
				Role role=new Role();
				role.setId(attribute);
				role.setName(content);
				roles.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
		
	}
	//���
	public void addRole(Role r) throws SAXException, IOException{
		
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			//�Ƚ�����Ԫ��
			Document doc = db.parse(new File("roles.xml"));
			//�ٶ�����Ԫ��
			Element rootNode = (Element) doc.getElementsByTagName("roles").item(0);
			//�ٽ���Ҫ������Ԫ���崴����
			Element idNode = doc.createElement("role");
			//��������
			idNode.setAttribute("id", r.getId());
			Element nameNode = doc.createElement("name");
			nameNode.setTextContent(r.getName());
			//��Ԫ��׷����Ԫ����
			idNode.appendChild(nameNode);
			//����Ԫ��׷�ӵ���Ԫ����
			rootNode.appendChild(idNode);
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			
			
			DOMSource ds=new DOMSource(doc);
			StreamResult sr=new StreamResult("roles.xml");
			t.transform(ds, sr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����
	public void updateRoleById(Role role){
		
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("roles.xml"));
			NodeList list = doc.getElementsByTagName("role");
			for (int i = 0; i < list.getLength(); i++) {
				Element ie = (Element) list.item(i);
				String pid = ie.getAttribute("id");
				if (pid.equals(role.getId())) {
					Element nameNode = (Element) ie.getElementsByTagName("name").item(0);
					nameNode.setTextContent(role.getName());
					TransformerFactory tf=TransformerFactory.newInstance();
					Transformer t = tf.newTransformer();
					DOMSource ds=new DOMSource(doc);
					StreamResult sr=new StreamResult("roles.xml");
					t.transform(ds, sr);
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ɾ��
	public void deleteRoleById(String id){
		
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("roles.xml"));
			Element rootNode = (Element) doc.getElementsByTagName("roles").item(0);
			NodeList list = doc.getElementsByTagName("role");
			for (int i = 0; i < list.getLength(); i++) {
				Element ie= (Element) list.item(i);
				String pid = ie.getAttribute("id");
				if (pid.equals(id)) {
					
					Element roleNode = (Element) doc.getElementsByTagName("role").item(i);
					rootNode.removeChild(roleNode);
					
					TransformerFactory tf=TransformerFactory.newInstance();
					Transformer t = tf.newTransformer();
					DOMSource ds=new DOMSource(doc);
					StreamResult sr=new StreamResult("roles.xml");
					t.transform(ds, sr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws SAXException, IOException {
//		for(Role r:new xmlDao().findAll()){
//			System.out.println(r);
//		}
		xmlDao xml=new xmlDao();
//	
//		Role r=new Role("1003", "������");
//		xml.addRole(r);
//		Role r=new Role("1001", "manager");
//		xml.updateRoleById(r);
		xml.deleteRoleById("1001");
	}
}
