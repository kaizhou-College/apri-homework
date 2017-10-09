package work05.dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import work05.entity.Role;

public class SAXdao extends DefaultHandler {
	private List<Role> r;
	public List<Role> getRole(){
		return r;
	}
	
	public void setRole(List<Role> r){
		this.r = r;
	}
	
	private Role role;
	
	//��ȡԪ����
	public void charaters(char[] ch,int start,int length){
		String content = new String(ch,start,length);
		//�ַ����ķǿ��жϱ�׼
		if (content != null && content.trim().length()>0) {
			try {
				int pid = Integer.parseInt(content);
				String id=pid+"";
				role.setId(id);
			} catch (Exception e) {
				role.setName(content);
			}
		}
	}
	//�������ĵ��¼�
	@Override
	public void endDocument() throws SAXException {
		
	}


	//������Ԫ���¼�
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
			if(qName.equals("role")){
				r.add(role);
			}
	}
	
	//����ʼ�ĵ��¼�
	@Override
	public void startDocument() throws SAXException {
		r = new ArrayList<Role>(0);
	}
	//����ʼԪ���¼�
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
			if(qName.equals("role")){
				//��ȡid����ֵ
				String id = attributes.getValue("id");
				role = new Role();
				role.setId(id);
			}
	}
	
	

}
