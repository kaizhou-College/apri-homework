package Dom;

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

/*
 * 2.构建使用Document对象,构建一个

  <users>
      <user id="1001" sex="男">
         <name>tom</name>
         <birth>2005-01-01</birth>
      </user>


      <user id="1002" sex="女">
         <name>jerry</name>
         <birth>2008-03-03</birth>
      </user>
  </users>
  
 * */
public class work02 {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		Element rootUser = doc.createElement("users");
		doc.appendChild(rootUser);
		Element user = doc.createElement("user");
		user.setAttribute("id","1001");
		user.setAttribute("sex","男");
		Element name = doc.createElement("name");
		name.setTextContent("tom");
		Element birth = doc.createElement("birth");
		birth.setTextContent("2005-01-01");
		user.appendChild(name);
		user.appendChild(birth);
		rootUser.appendChild(user);
		
		Element user2 = doc.createElement("user");
		user2.setAttribute("id","1001");
		user2.setAttribute("sex","男");
		Element name2 = doc.createElement("name");
		name2.setTextContent("tom");
		Element birth2 = doc.createElement("birth");
		birth2.setTextContent("2005-01-01");
		user2.appendChild(name2);
		user2.appendChild(birth2);
		rootUser.appendChild(user2);
		//写入
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tfm = tf.newTransformer();
		DOMSource dom = new DOMSource(doc);
		StreamResult sr = new StreamResult("user.xml");
		tfm.transform(dom,sr);
		
	}
}
