package work10.test;

import java.util.List;

import work10.dao.BaseDao;
import work10.entity.UserInfo;

public class Test1 {
	public static void main(String[] args) {
		BaseDao bd = new BaseDao();
		UserInfo ui = new UserInfo();
		/**
		 * private int customerid;              
	private String createtime;         
	private String email;             
	private int language; 
	private String username;             
	private String screenname;                 
	private String password;         
	private int ismale;
	private String birthday;                  
	private String postalcode;              
	private String firstname;             
	private String lastname;             
	private String address;
		 */
		ui.setCreatetime("12-10��-17");
		ui.setEmail("1234565778");
		ui.setLanguage(4);
		ui.setUsername("С��");
		ui.setScreenname("�����ǂ�");
		ui.setPassword("123456");
		ui.setIsmale(1);
		ui.setBirthday("30-9��-98");
		ui.setPostalcode("432201");
		ui.setFirstname("��");
		ui.setLastname("��");
		ui.setAddress("�V�|����");
		System.out.println(bd.save("seq_UserInfo", ui));
		
	}

}
