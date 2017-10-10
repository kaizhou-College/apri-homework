package com.kz.test;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.kz.entity.Student;


/*
整个xml文件---对应的document对象
<?xml version="1.0" encoding="UTF-8"?>
<students>---root  Element
	<student id="1">----Element(属性)
		<name>二狗子</name>---子元素(标签、文本内容)
		<age>23</age>
	</student>
	
	<student id="2">
		<name>三狗子</name>
		<age>22</age>
	</student>
</students>

 */
//使用dom解析来读取student.xml文件
public class Test1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Student> stus = new ArrayList<Student>(0);
		
		//1,建筑公司
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2,建筑小分队
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3,构建document对象
		Document doc = db.parse(new File("student.xml"));
		//4,读
		NodeList nodeList = doc.getElementsByTagName("student");
		Student stu ;
		for(int i=0;i<nodeList.getLength();i++){
			//读取Student元素的id属性---节点
			Element stuNode = (Element) nodeList.item(i);
			String stuId = stuNode.getAttribute("id");
			//System.out.println("stuId=="+stuId);
			//获取name和age元素
			//getElementsByTagName("name")获取执行节点的子节点对象
			Element nameNode = (Element) stuNode.getElementsByTagName("name").item(0);
			String stuName = nameNode.getTextContent();
			//System.out.println("name==="+stuName);
			
			Element ageNode = (Element) stuNode.getElementsByTagName("age").item(0);
			String stuAge = ageNode.getTextContent();
			//System.out.println("age==="+stuAge);
			//每一个student元素对应一个student对象
			stu = new Student();
			stu.setId(Integer.parseInt(stuId));
			stu.setName(stuName);
			stu.setAge(Integer.parseInt(stuAge));
			//将student对象放入集合
			stus.add(stu);
		}
		for(Student t:stus){
			System.out.println(t);
		}
	}
}













