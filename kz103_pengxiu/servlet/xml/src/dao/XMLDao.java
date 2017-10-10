package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entity.Role;

public class XMLDao {
	public static List<Role> findAll(){
		ArrayList<Role> list=new ArrayList<Role>();
		Document doc = Dao.createSel("Users.xml");
		NodeList elementsByTagName = doc.getElementsByTagName("user");
		Role role;
		for (int i = 0; i < elementsByTagName.getLength(); i++) {
			Element node =(Element) elementsByTagName.item(i);
			String id = node.getAttribute("id");
			Element noName =(Element) node.getElementsByTagName("name").item(0);
			String Name =noName.getTextContent();
			Element noBirth =(Element) node.getElementsByTagName("birth").item(0);
			String Birth = noBirth.getTextContent();
			role=new Role();
			role.setId(Integer.parseInt(id));
			role.setName(Name);
			role.setBirth(Birth);
			list.add(role);
		}
		return list;
	}
	
	
	
	 public void addRole(Role r){
		 
		 
	 }

	 public void updateRoleById(String id,String name,String birth){
		 Document document = Dao.createSel("Users.xml");
		 NodeList elementsByTagName = document.getElementsByTagName("User");
		 Role role;
		 for (int i = 0; i < elementsByTagName.getLength(); i++) {
			Element node =(Element) elementsByTagName.item(i);
			String UsersID = (String)node.getAttribute("id");
			if(UsersID.equals(id)){
				 Element Nmae =(Element) node.getElementsByTagName("name").item(0);
				 node.setTextContent(name);
				
			}
			 
		}
		 
		 
	 }
	/* public static void main(String[] args) {
		Document document = Dao.createSel("Users.xml");
		 NodeList elementsByTagName = document.getElementsByTagName("user");
		 Role role;
		 for (int i = 0; i < elementsByTagName.getLength(); i++) {
			Element node =(Element) elementsByTagName.item(i);
			String UsersID = (String)node.getAttribute("id");
			if(UsersID.equals("1001")==true){
				node.getElementsByTagName("name").item(0).setTextContent("aaa");;
			}
			System.out.println(UsersID.equals("1001"));
		}
		 Document document = Dao.createDoc();
		 NodeList elementsByTagName = document.getElementsByTagName("user");
		 Role role;
		 for (int i = 0; i < elementsByTagName.getLength(); i++) {
			Element node =(Element) elementsByTagName.item(i);
			String UsersID = (String)node.getAttribute("id");
			if(UsersID=="1001"){
				Element Name =(Element) node.getElementsByTagName("name").item(0);
				Name.removeChild(node);
			}
			System.out.println(UsersID.equals("1001"));
		}
		Dao.writeXML(document, "Users.xml");
	}
*/
	 public void deleteRoleById(String id){
		 
		 
	 }
}
