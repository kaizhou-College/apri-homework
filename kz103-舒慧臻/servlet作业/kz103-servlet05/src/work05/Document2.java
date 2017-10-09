package work05;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/***
 *  <users>
      <user id="1001" sex="��">
         <name>tom</name>
         <birth>2005-01-01</birth>
      </user>


      <user id="1002" sex="Ů">
         <name>jerry</name>
         <birth>2008-03-03</birth>
      </user>
  </users> 
 *
 */
public class Document2 {
	public static void main(String[] args) throws Exception {
		//�����ĵ�
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//�ĵ���֧
		DocumentBuilder db = dbf.newDocumentBuilder();
		//�ĵ�����
		Document doc = db.newDocument();
		//������Ԫ��
		Element rootElement = doc.createElement("users");
		//����Ԫ�ع�λ
		doc.appendChild(rootElement);
		//����Ԫ��
		Element user = doc.createElement("user");
		//��������
		user.setAttribute("id", "1001");
		user.setAttribute("sex", "��");
		//������Ԫ��
		Element nameNode = doc.createElement("name");
		//����Ԫ�ظ�ֵ
		nameNode.setTextContent("tom");
		//����Ԫ�عҵ��ĵ��ڵ���
		user.appendChild(nameNode);
		//���ĵ��ڵ�ҵ���Ԫ����
		rootElement.appendChild(user);
		
		//����һ���µ��ĵ���Ԫ�أ�����ͬ�ϣ�
		Element user2 = doc.createElement("user");
		user2.setAttribute("id", "1002");
		user2.setAttribute("sex", "Ů");
		
		Element nameNode2 = doc.createElement("name");
		nameNode2.setTextContent("jerry");
		
		user2.appendChild(nameNode2);
		rootElement.appendChild(user2);
		
		//д���ļ�
		//1)�����ļ���
		TransformerFactory tf = TransformerFactory.newInstance();
		//�����ļ��ķ�֧
		Transformer tfm = tf.newTransformer();
		//���ļ�
		DOMSource sur = new DOMSource(doc);
		StreamResult dest = new StreamResult("users.xml");
		tfm.transform(sur, dest);
		
		
		
		
		
		
	}

}
