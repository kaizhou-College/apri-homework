package com.kz.dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.kz.entity.Student;

public class SAXDao extends DefaultHandler{
	private List<Student> stus;
	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
	}

	private Student stu ;
	//读元素体事件
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//System.out.println("读元素体事件");
		//System.out.println("元素体为："+new String(ch,start,length));
		String content = new String(ch,start,length);
		if(content!=null&&content.trim().length()>0){//字符串的非空判断标准
			//System.out.println("元素体为："+content);
			//根据类型来判断
			try {
				int age = Integer.parseInt(content);
				//肯定是age
				stu.setAge(age);
			} catch (Exception e) {
				//肯定是name
				stu.setName(content);
			}
		}
	}
	//读结束文档事件
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("读结束文档事件");
	}
	//读结束元素事件
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("读结束元素事件");
		if(qName.equals("student")){
			stus.add(stu);
		}
	}

	//读开始文档事件
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("读开始文档事件");
		stus = new ArrayList<Student>(0);
		
	}

	//读开始元素事件
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//System.out.println("读开始元素事件");
		//System.out.println(uri+"==="+localName+"==="+qName+"=="+attributes);
		
		if(qName.equals("student")){
			String id= attributes.getValue("id");//获取id属性值
			stu = new Student();
			stu.setId(Integer.parseInt(id));
		}
	}
	
}
