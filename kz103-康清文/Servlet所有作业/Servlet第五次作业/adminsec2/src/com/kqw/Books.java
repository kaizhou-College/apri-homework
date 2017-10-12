package com.kqw;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.kqw.entity.Booksentity;




/**
 * 
 * @author
 * һ��дһ��books.xml��д�����±�ǩ
	<books>
   <book id="1001">
       <name>java</name>
   </book>
   
   <book id="1002">
       <name>c#</name>
   </book>
</books>

1.ʹ��DOM������ʽ������xml��Ԫ��
 */
public class Books {
			public static void main(String[] args) throws Exception {
				ArrayList<Booksentity> boos = new ArrayList<Booksentity>(0);
				
				//1,������˾
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				//2,����С�ֶ�
				DocumentBuilder db = dbf.newDocumentBuilder();
				//3,����document����
				Document doc = db.parse(new File("books.xml"));
				//4,��XML��Ԫ����
				NodeList nodeList = doc.getElementsByTagName("book");
				Booksentity boo ;
				for(int i=0;i<nodeList.getLength();i++){
					//��ȡbookԪ�ص�id����---�ڵ�
					Element booNode = (Element) nodeList.item(i);
					String booId = booNode.getAttribute("id");
					//��ȡid��nameԪ��
					//getElementsByTagName("name")��ȡִ�н� ����ӽڵ����
					Element nameNode = (Element) booNode.getElementsByTagName("name").item(0);
					String booName = nameNode.getTextContent();
				
					
					//ÿһ��bookԪ�ض�Ӧһ��book����
					boo = new Booksentity();
					boo.setId(Integer.parseInt(booId));
					boo.setName(booName);
					boos.add(boo);
				
					
					//��book������뼯��
				}
				for (Booksentity b : boos) {
					System.out.println(b);
				}
			}
		}













