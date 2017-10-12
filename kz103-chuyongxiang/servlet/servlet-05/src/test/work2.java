package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
  </users>
 */
public class work2 {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.newDocument();
		Element rootTeas=doc.createElement("users");
		doc.appendChild(rootTeas);
		Element teaNode=doc.createElement("user");
		teaNode.setAttribute("id", "1001");
		teaNode.setAttribute("sex", "ÄÐ");
		Element nameNode=doc.createElement("name");
		nameNode.setTextContent("tom");
		Element birthNode = doc.createElement("birth");
		birthNode.setTextContent("2005-01-01");
		teaNode.appendChild(nameNode);
		teaNode.appendChild(birthNode);
		rootTeas.appendChild(teaNode);
		
		Element teaNode2=doc.createElement("user2");
		teaNode2.setAttribute("id", "1002");
		teaNode2.setAttribute("sex", "Å®");
		Element nameNode2=doc.createElement("name");
		nameNode2.setTextContent("jerry");
		Element birthNode2 = doc.createElement("birth");
		birthNode2.setTextContent("2008-03-03");
		teaNode2.appendChild(nameNode2);
		teaNode2.appendChild(birthNode2);
		rootTeas.appendChild(teaNode2);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tfm = tf.newTransformer();
		DOMSource sur = new DOMSource(doc);
		StreamResult dest = new StreamResult("user.xml");
		tfm.transform(sur,dest);
	}
}












