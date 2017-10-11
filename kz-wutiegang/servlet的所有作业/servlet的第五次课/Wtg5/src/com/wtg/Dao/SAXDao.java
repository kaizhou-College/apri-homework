package com.wtg.Dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.wtg.entity.Role;

public class SAXDao extends DefaultHandler{
	private List<Role> roles;
	public List<Role> getRole(){
		return roles;
	}
	public void setRole(List<Role> roles){
		this.roles=roles;
	}
	private Role role;
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		System.out.println("��Ԫ�����¼�");
		String content = new String(ch, start, length);
		if (content!=null&&content.trim().length()>0) {
			try {
				int id = Integer.parseInt(content);
				String Sid=id+"";
				role.setId(Sid);
			} catch (Exception e) {
				// TODO: handle exception
				role.setName(content);
			}
			
		}
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("�������ĵ��¼�");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		System.out.println("������Ԫ���¼�");
		if (qName.equals("role")) {
			roles.add(role);
		}
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("����ʼ�ĵ��¼�");
		roles=new ArrayList<Role>(0);
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		System.out.println("����ʼԪ���¼�");
		if (qName.equals("role")) {
			String id=attributes.getValue("id");
			role=new Role();
			role.setId(id);
		}
	}
		
}
