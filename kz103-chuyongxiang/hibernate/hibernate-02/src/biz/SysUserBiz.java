package biz;

import java.util.List;

import dao.SysUserDao;
import entity.SysUser;

public class SysUserBiz {

	public static List select(Class clazz) {
		// TODO Auto-generated method stub
		System.out.println("½øbiz");
		System.out.println(clazz);
		SysUserDao sd=new SysUserDao();
		List list=sd.getAll(clazz);
		System.out.println("bizµÄ"+list);
		return list;
	}

	public static SysUser toedit(int id) {
		// TODO Auto-generated method stub
		
		SysUserDao sd=new SysUserDao();
		SysUser sysuser=sd.get(id);
		return sysuser;
	}

	public static void edit(SysUser sysuser, int id) {
		// TODO Auto-generated method stub
		SysUserDao sd=new SysUserDao();
		sd.update(sysuser, id);
		
		
	}

	public static void delete(SysUser sysuser) {
		// TODO Auto-generated method stub
		SysUserDao sd=new SysUserDao();
		sd.delete(sysuser);
		
	}

}
