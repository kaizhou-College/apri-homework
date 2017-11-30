package pan.biz;

import java.util.List;

import pan.dao.BaseDao;
import pan.dao.FwxxDao;
import pan.dao.UserDao;
import pan.entity.FwxxSenior;
import pan.entity.FwxxView;
import pan.entity.Tbl_fwlx;
import pan.entity.Tbl_fwxx;
import pan.entity.Tbl_jd;
import pan.entity.Tbl_user;

public class TbUserbiz {
	private UserDao ud=new UserDao();
	private BaseDao bd=new BaseDao();
	private FwxxDao fwxxd=new FwxxDao();
	//是否有此人
	public Tbl_user findByNameAndPwd(Tbl_user tbu) {
		try {
			return ud.findByNameAndPwd(tbu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//增加
	public FwxxView addView(Tbl_fwxx tbfwxx) {
		System.out.println(tbfwxx);
		FwxxView fv = new FwxxView();
		fv.setTitle(tbfwxx.getTitle());
		fv.setJd(((Tbl_jd)bd.queryById(Tbl_jd.class,tbfwxx.getJdid())).getJd());
		fv.setZj(tbfwxx.getZj());
		fv.setShi(tbfwxx.getShi());
		fv.setTing(tbfwxx.getTing());
		fv.setFwlx(((Tbl_fwlx)bd.queryById(Tbl_fwlx.class,tbfwxx.getLxid())).getFwlx());
		fv.setTelephone(tbfwxx.getTelephone());
		fv.setTime(tbfwxx.getPublishdate());
		fv.setLxr(tbfwxx.getLxr());
		fv.setFwxx(tbfwxx.getFwxx());
		return fv;
	}
	//修改根据id查询
	public Tbl_fwxx findId(int fwid) {
		return ud.findId(fwid);
	}
	//修改
	public  int  update(Tbl_fwxx tbfwxx) {

		return bd.update(tbfwxx);
	}
	//分页
	public List selectByPage(int pageIndex, int pageSize) {
		return bd.selectByPage(pageIndex, pageSize, Tbl_fwxx.class);
	}
/*	public List querySen(FwxxSenior fs, int pageIndex, int pageSize) {
		return fwxxd.querySen(fs, pageIndex, pageSize);
	}
	public int querySenMax(FwxxSenior fs, int pageSize) {
		int count = fwxxd.getCount(fs);
		return bd.maxPage(count, pageSize);
	}*/
}
