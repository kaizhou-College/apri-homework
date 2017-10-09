package dao;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import entity.Role;

public class xmlDao {
	Document doc=getDoc();
	//²é
	 public List findAll(){
		 
		return null;
		 
	 }
	 private Document getDoc() {
		return null;
	}
	//Ôö
	 public void addRole(Role r){
		 
	 }
	 //¸Ä
	 
	 public void updateRoleById(String id){
		 
	 }
	 //„h
	 public void deleteRoleById(String id) throws Exception{
		Document doc=getDoc();
		doc.getDocumentElement();
		NodeList list = doc.getElementsByTagName("role");
		for (int i = 0; i < list.getLength(); i++) {
			Element node = (Element)list.item(i);
			String ids=node.getAttribute("id");
			if(ids.equals(id)){
				Element root = doc.getDocumentElement();
				root.removeChild(node);
				break;
			}
		}
	 }
}
