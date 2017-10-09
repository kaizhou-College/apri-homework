package text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/*
 * <users>
      <user id="1001" sex="ÄÐ">
         <name>tom</name>
         <birth>2005-01-01</birth>
      </user>


      <user id="1002" sex="Å®">
         <name>jerry</name>
         <birth>2008-03-03</birth>
      </user>
  </users>*/
public class zy1_xml03 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		 Element users = doc.createElement("users");
		 doc.appendChild(users);
		 
		 Element user = doc.createElement("user");
		 user.setAttribute("id","1001");
		 user.setAttribute("sex","ÄÐ");
		 Element name = doc.createElement("name");
		 name.setTextContent("tom");
		 Element birth = doc.createElement("birth");
		 birth.setTextContent("2005-01-01");
		
		 
		 Element user1 = doc.createElement("user");
		 user1.setAttribute("id","1001");
		 user1.setAttribute("sex","Å®");
		 Element name1 = doc.createElement("name");
		 name1.setTextContent("jerry");
		 Element birth1 = doc.createElement("birth");
		 birth1.setTextContent("2005-01-01");
		 
		 users.appendChild(user);
		 user.appendChild(name);
		 user.appendChild(birth);
		 
		 users.appendChild(user1);
		 user1.appendChild(name1);
		 user1.appendChild(birth1);
		 
		 
		 
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer tfm = tf.newTransformer();
		
		DOMSource dom=new DOMSource(doc);
		StreamResult stt=new StreamResult("Users.xml");
		
		tfm.transform(dom, stt);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
