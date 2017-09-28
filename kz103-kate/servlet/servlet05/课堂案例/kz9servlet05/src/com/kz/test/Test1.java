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
����xml�ļ�---��Ӧ��document����
<?xml version="1.0" encoding="UTF-8"?>
<students>---root  Element
	<student id="1">----Element(����)
		<name>������</name>---��Ԫ��(��ǩ���ı�����)
		<age>23</age>
	</student>
	
	<student id="2">
		<name>������</name>
		<age>22</age>
	</student>
</students>

 */
//ʹ��dom��������ȡstudent.xml�ļ�
public class Test1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Student> stus = new ArrayList<Student>(0);
		
		//1,������˾
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2,����С�ֶ�
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3,����document����
		Document doc = db.parse(new File("student.xml"));
		//4,��
		NodeList nodeList = doc.getElementsByTagName("student");
		Student stu ;
		for(int i=0;i<nodeList.getLength();i++){
			//��ȡStudentԪ�ص�id����---�ڵ�
			Element stuNode = (Element) nodeList.item(i);
			String stuId = stuNode.getAttribute("id");
			//System.out.println("stuId=="+stuId);
			//��ȡname��ageԪ��
			//getElementsByTagName("name")��ȡִ�нڵ���ӽڵ����
			Element nameNode = (Element) stuNode.getElementsByTagName("name").item(0);
			String stuName = nameNode.getTextContent();
			//System.out.println("name==="+stuName);
			
			Element ageNode = (Element) stuNode.getElementsByTagName("age").item(0);
			String stuAge = ageNode.getTextContent();
			//System.out.println("age==="+stuAge);
			//ÿһ��studentԪ�ض�Ӧһ��student����
			stu = new Student();
			stu.setId(Integer.parseInt(stuId));
			stu.setName(stuName);
			stu.setAge(Integer.parseInt(stuAge));
			//��student������뼯��
			stus.add(stu);
		}
		for(Student t:stus){
			System.out.println(t);
		}
	}
}













