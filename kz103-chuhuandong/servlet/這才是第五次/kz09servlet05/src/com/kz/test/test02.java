package com.kz.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kz.dao.DomDao;

//<users>
//    <user id="1001" sex="ÄÐ">
//       <name>tom</name>
//       <birth>2005-01-01</birth>
//    </user>
//
//
//    <user id="1002" sex="Å®">
//       <name>jerry</name>
//       <birth>2008-03-03</birth>
//    </user>
//</users>
public class test02 {
	public static void main(String[] args) {
		Document doc = DomDao.createDoc();
		Element users = doc.createElement("users");
		doc.appendChild(users);
		Element user = doc.createElement("user");
		user.setAttribute("id", "1001");
		user.setAttribute("sex", "ÄÐ");
		Element name = doc.createElement("name");
		name.setTextContent("tom");
		Element birth = doc.createElement("birth");
		birth.setTextContent("2005-01-01");
		users.appendChild(user);
		user.appendChild(name);
		user.appendChild(birth);
		Element user2 = doc.createElement("user");
		user2.setAttribute("id", "1002");
		user2.setAttribute("sex", "Å®");
		Element name2 = doc.createElement("name");
		name2.setTextContent("jerry");
		Element birth2 = doc.createElement("birth");
		birth2.setTextContent("2008-03-03");
		users.appendChild(user2);
		user2.appendChild(name2);
		user2.appendChild(birth2);
		DomDao.writeXML(doc, "user.xml");
	}
}
