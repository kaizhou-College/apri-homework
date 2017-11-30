package biz;

import java.util.List;

import dao.BaseDao;
import dao.FwxxDao;
import entity.FwxxDim;
import entity.FwxxView;
import entity.Tbl_Fwlx;
import entity.Tbl_Fwxx;
import entity.Tbl_Jd;
import entity.Tbl_Qx;

public class FwxxBiz {
	private BaseDao bd = new BaseDao();
	private FwxxDao fd = new FwxxDao();
	public List query(int index, int page) {
		return bd.queryByPage(index, page,Tbl_Fwxx.class);
	}
	public int getMax(int page) {
		return bd.getMax(bd.getCount(Tbl_Fwxx.class),page);
	}
	public List queryByUid(int uid) {
		return fd.queryByUid(uid);
	}
	public int insert(Tbl_Fwxx fw) {
		return bd.insert("message_id",fw);
	}
	public FwxxView addView(Tbl_Fwxx fw) {
		FwxxView fv = new FwxxView();
		fv.setQx(((Tbl_Qx)BaseDao.queryById(Tbl_Qx.class,fw.getQxid())).getQx());
		fv.setLxr(fw.getLxr());
		fv.setFwlx(((Tbl_Fwlx)bd.queryById(Tbl_Fwlx.class,fw.getLxid())).getFwlx());
		fv.setJd(((Tbl_Jd)bd.queryById(Tbl_Jd.class,fw.getJdid())).getJd());
		System.out.println(((Tbl_Qx)bd.queryById(Tbl_Qx.class,fw.getQxid())).getQx());
		fv.setTime(fw.getPublishdate());
		fv.setShi(fw.getShi());
		fv.setTing(fw.getTing());
		fv.setZj(fw.getZj());
		fv.setFwxx(fw.getFwxx());
		fv.setTitle(fw.getTitle());
		fv.setTelephone(fw.getTelephone());
		return fv;
	}
	public int del(int fwid) {
		return bd.del(Tbl_Fwxx.class,fwid);
	}
	public Tbl_Fwxx querById(int fwid) {
		// TODO Auto-generated method stub
		return (Tbl_Fwxx) bd.queryById(Tbl_Fwxx.class,fwid);
	}
	public FwxxView upView(Tbl_Fwxx fw) {
		FwxxView fv = new FwxxView();
		fv.setQx(((Tbl_Qx)BaseDao.queryById(Tbl_Qx.class,fw.getQxid())).getQx());
		fv.setLxr(fw.getLxr());
		fv.setFwlx(((Tbl_Fwlx)bd.queryById(Tbl_Fwlx.class,fw.getLxid())).getFwlx());
		fv.setJd(((Tbl_Jd)bd.queryById(Tbl_Jd.class,fw.getJdid())).getJd());
		System.out.println(((Tbl_Qx)bd.queryById(Tbl_Qx.class,fw.getQxid())).getQx());
		fv.setTime(fw.getPublishdate());
		fv.setShi(fw.getShi());
		fv.setTing(fw.getTing());
		fv.setZj(fw.getZj());
		fv.setFwxx(fw.getFwxx());
		fv.setTitle(fw.getTitle());
		fv.setTelephone(fw.getTelephone());
		return fv;
	}
	public int edit(Tbl_Fwxx fw) {
		return bd.update(fw);
	}
	//获取高级查询最大页
	public int getDimMax(FwxxDim fd2, int size) {
		int count = fd.getCount(fd2);
		return bd.getMax(count, size);
	}
	public List queryDim(FwxxDim fd2, int index, int size) {
		return fd.queryByDim(fd2, index, size);
	}
	public FwxxView queryById(Tbl_Fwxx fw1) {
		Tbl_Fwxx fw = (Tbl_Fwxx) bd.queryById(Tbl_Fwxx.class,fw1.getFwid());
		FwxxView fv = new FwxxView();
		fv.setQx(((Tbl_Qx)BaseDao.queryById(Tbl_Qx.class,fw.getQxid())).getQx());
		fv.setLxr(fw.getLxr());
		fv.setFwlx(((Tbl_Fwlx)bd.queryById(Tbl_Fwlx.class,fw.getLxid())).getFwlx());
		fv.setJd(((Tbl_Jd)bd.queryById(Tbl_Jd.class,fw.getJdid())).getJd());
		System.out.println(((Tbl_Qx)bd.queryById(Tbl_Qx.class,fw.getQxid())).getQx());
		fv.setTime(fw.getPublishdate());
		fv.setShi(fw.getShi());
		fv.setTing(fw.getTing());
		fv.setZj(fw.getZj());
		fv.setFwxx(fw.getFwxx());
		fv.setTitle(fw.getTitle());
		fv.setTelephone(fw.getTelephone());
		return fv;
	}
	
}
