package work05;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import work05.dao.SAXdao;
import work05.dao.XMLDao;
import work05.entity.Role;

public class SAXTest implements XMLDao {
	public static void main(String[] args) throws Exception, Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		SAXdao sd = new SAXdao();
		//∂¡»°
		sp.parse("roles.xml", sd);
		for (Role s : sd.getRole()) {
			System.out.println(s);
		}
	}

	@Override
	public void addRole(Role r) {
		
	}

	@Override
	public void deleteRoleById(String id) {
		
	}

	@Override
	public List findAll() {
		return null;
	}

	@Override
	public void updateRoleById(String id) {
		
	}

}
