package com.kz.biz;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kz.dao.BaseDao;
import com.kz.dao.FwxxDao;
import com.kz.dao.QueryFwxxDao;
import com.kz.entity.QueryFwxx;
import com.kz.entity.Tbl_fwxx;
import com.kz.entity.Tbl_user;

public class FwxxBiz {
	private FwxxDao fwxxdao=new FwxxDao();
	private BaseDao basedao=new BaseDao();
	private QueryFwxxDao qfd=new QueryFwxxDao();
	public int MaxPage(Class clazz, int pageSize,Object uid) {
		return fwxxdao.MaxPage(clazz, pageSize, uid);
	}

	public List<Tbl_fwxx> selByPage(Class clazz, int page, int pageSize,Object uid) {
		return fwxxdao.selByPage(clazz, page, pageSize, uid);
	}

	public List<Tbl_fwxx> query(Class<Tbl_fwxx> clazz) {
		return basedao.query(clazz);
	}

	public int delete(Class<Tbl_fwxx> clazz, Integer uuid) {
		
		return basedao.remove(uuid, clazz);
	}

	public List<Tbl_fwxx> findByUQSM(Class<Tbl_fwxx> clazz, int page, int pageSize, QueryFwxx queryfwxx,Object uid) {
		
		return qfd.findByUQSM(clazz, page, pageSize, queryfwxx,uid);
	}

	public int gjMaxPage(Class<Tbl_fwxx> clazz, int page, int pageSize, QueryFwxx queryfwxx,Object uid) {
		
		return qfd.MaxPage(clazz, page, pageSize, queryfwxx,uid);
	}

	public Object findUser() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object uname = session.getAttribute("uname");
		return uname;
	}

	public Object findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object uid = session.getAttribute("uuid");
		return uid;
	}

	public int add(String seq, Tbl_fwxx tblfwxx) throws IllegalArgumentException, IllegalAccessException {
		
		return basedao.add(seq, tblfwxx);
	}
	//根据id查找对象
	public Tbl_fwxx updateById(Class<Tbl_fwxx> clazz, Integer integer) throws InstantiationException, IllegalAccessException {
	
		return (Tbl_fwxx) basedao.load(clazz, integer);
	}
	//更新数据
	public int update(Tbl_fwxx tblfwxx, Integer fwid) throws IllegalArgumentException, IllegalAccessException {
		return basedao.update(tblfwxx, fwid);
	}
	

	
}
