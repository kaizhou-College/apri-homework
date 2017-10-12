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
 * 一，写一个books.xml中写入以下标签
	<books>
   <book id="1001">
       <name>java</name>
   </book>
   
   <book id="1002">
       <name>c#</name>
   </book>
</books>

1.使用DOM解析方式，读出xml的元素
 */
public class Books {
			public static void main(String[] args) throws Exception {
				ArrayList<Booksentity> boos = new ArrayList<Booksentity>(0);
				
				//1,建筑公司
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				//2,建筑小分队
				DocumentBuilder db = dbf.newDocumentBuilder();
				//3,构建document对象
				Document doc = db.parse(new File("books.xml"));
				//4,读XML的元素体
				NodeList nodeList = doc.getElementsByTagName("book");
				Booksentity boo ;
				for(int i=0;i<nodeList.getLength();i++){
					//读取book元素的id属性---节点
					Element booNode = (Element) nodeList.item(i);
					String booId = booNode.getAttribute("id");
					//获取id和name元素
					//getElementsByTagName("name")获取执行节 点的子节点对象
					Element nameNode = (Element) booNode.getElementsByTagName("name").item(0);
					String booName = nameNode.getTextContent();
				
					
					//每一个book元素对应一个book对象
					boo = new Booksentity();
					boo.setId(Integer.parseInt(booId));
					boo.setName(booName);
					boos.add(boo);
				
					
					//将book对象放入集合
				}
				for (Booksentity b : boos) {
					System.out.println(b);
				}
			}
		}













