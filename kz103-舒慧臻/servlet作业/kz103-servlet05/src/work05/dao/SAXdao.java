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
	
	//读取元素体
	public void charaters(char[] ch,int start,int length){
		String content = new String(ch,start,length);
		//字符串的非空判断标准
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
	//读结束文档事件
	@Override
	public void endDocument() throws SAXException {
		
	}


	//读结束元素事件
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
			if(qName.equals("role")){
				r.add(role);
			}
	}
	
	//读开始文档事件
	@Override
	public void startDocument() throws SAXException {
		r = new ArrayList<Role>(0);
	}
	//读开始元素事件
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
			if(qName.equals("role")){
				//获取id属性值
				String id = attributes.getValue("id");
				role = new Role();
				role.setId(id);
			}
	}
	
	

}
