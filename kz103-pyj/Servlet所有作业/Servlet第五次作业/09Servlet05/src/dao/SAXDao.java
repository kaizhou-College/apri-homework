package dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entity.Role;



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
		System.out.println("��Ԫ�����¼�");
		String content = new String(ch, start, length);
		if (content!=null&&content.trim().length()>0) {
			try {
				int id = Integer.parseInt(content);
				String Sid=id+"";
				role.setId(Sid);
			} catch (Exception e) {
				role.setName(content);
			}
		}
	}
	public void endDocument() throws SAXException {
		System.out.println("�������ĵ��¼�");
	}
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("������Ԫ���¼�");
		if (qName.equals("role")) {
			roles.add(role);
		}
	}
	public void startDocument() throws SAXException {
		System.out.println("��ʼ���ĵ��¼�");
		roles=new ArrayList<Role>(0);
	}
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("��ʼ��Ԫ���¼�");
		if (qName.equals("role")) {
			String id=attributes.getValue("id");
			role=new Role();
			role.setId(id);
		}
	}
}
