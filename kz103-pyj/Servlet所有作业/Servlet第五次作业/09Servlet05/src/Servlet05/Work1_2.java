package Servlet05;
/*   
<users>--��Ԫ��
<user>--��Ԫ��
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Work1_2 {
	public static void main(String[] args) {
		//1������˾
		DocumentBuilderFactory dbf=null;
		//2����С�ֶ�
		DocumentBuilder db=null;
		//3.document����
		Document doc=null;
		//д���ļ���һ��
		TransformerFactory tf =null;
		//д���ļ��ڶ���
		Transformer tfm =null;
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			//3����document����
			doc=db.newDocument();
			//3.1������Ԫ��
			Element rootUsers=doc.createElement("users");
			//�Ѹ�Ԫ�عҵ�����
			doc.appendChild(rootUsers);
			//3.2�������ĵ�һ����Ԫ��
			Element userNode=doc.createElement("user");
			//(1)Ϊuser����ֵ��:id
			userNode.setAttribute("id", "1001");
			userNode.setAttribute("sex", "��");
			//(2)Ϊuser������Ԫ��
			Element nameNode = doc.createElement("name");
			nameNode.setTextContent("tom");
			Element birthNode = doc.createElement("birth");
			birthNode.setTextContent("2005-01-01");
			//(3)����Ԫ�عҵ�userԪ����
			userNode.appendChild(nameNode);
			userNode.appendChild(birthNode);
			//(4)�ٰ�user�ҵ�users��
			rootUsers.appendChild(userNode);
			
			Element userNode2=doc.createElement("user");
			//(1)Ϊuser����ֵ��:id
			userNode2.setAttribute("id", "1002");
			userNode2.setAttribute("sex", "Ů");
			//(2)Ϊuser������Ԫ��
			Element nameNode2= doc.createElement("name");
			nameNode2.setTextContent("jerry");
			Element birthNode2 = doc.createElement("birth");
			birthNode2.setTextContent("2008-03-03");
			//(3)����Ԫ�عҵ�userԪ����
			userNode2.appendChild(nameNode2);
			userNode2.appendChild(birthNode2);
			//(4)�ٰ�user�ҵ�users��
			rootUsers.appendChild(userNode2);
			//4д���ļ�
			//(1)�ǹܾ�
			tf= TransformerFactory.newInstance();
			//(2)�ǹ�С�ֶ�
			tfm= tf.newTransformer();
			//(3)��
			DOMSource sur=new DOMSource(doc);
			StreamResult dest=new StreamResult("users.xml");
			tfm.transform(sur, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
