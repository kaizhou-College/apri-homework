package com.wtg.Action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.wtg.Dao.BaseDao;
import com.wtg.Dao.HouseDao;
import com.wtg.Dao.StreetDao;
import com.wtg.Dao.TypeDao;
import com.wtg.entity.District;
import com.wtg.entity.House;
import com.wtg.entity.HouseView;
import com.wtg.entity.QueryHouse;
import com.wtg.entity.Street;
import com.wtg.entity.Types;

public class ManagerAction {
	// 属性驱动，先初始化对象

	// house和houseview的结合的一个新对象
	private List<HouseView> houseview =null;
	private int page;
	private int max;
	//高级查询的对象
	private QueryHouse qh;
	private List<Street> slist;
	private List<Types> tlist;
	List<District> dlist ;
	private BaseDao <House> db=new BaseDao<House>();
	private int hid;
	private House house ;
	private int diBySid ;

	public String manager() {
		// 3.调用这个属性
		// System.out.println("进入管理的Action类");
		if (page==0) {
			page=1;
		}
		max= db.MaxPage(House.class, 2);
		List<House> houseList = db.selByPage(House.class, page,2);
		houseview = new ArrayList<HouseView>();
		toHouseView(houseList);
		queryStreetAndType();
		return "success";
	}
	//发布的查询
	public String fabu(){
		try {
			tlist = BaseDao.findAll(Types.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dlist = BaseDao.findAll(District.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			slist=BaseDao.findAll(Street.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("attribute===="+attribute);
		return "fabu_success";
	}
	
	//修改
	public String update() throws IllegalArgumentException, IllegalAccessException{

	//System.out.println(house.getId()+"==========id=========");
	int update = db.update(house, house.getId());
	//System.out.println("update==="+update);
	if (update>0) {
		return "update_success";
	}
		
	return "loser";
	
	}
	
	public String edit(){
		//System.out.println("hid==="+hid);
		house = (House)db.load(House.class, hid);
		try {
			//在类型表中查找所有属性
			tlist = BaseDao.findAll(Types.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dlist = BaseDao.findAll(District.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			slist=BaseDao.findAll(Street.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		diBySid = new StreetDao().findDiBySid(house.getStreet_id());
		return "edit_success";
	}
	
	public String query() throws InstantiationException, IllegalAccessException{
		if (page==0) {
			page=1;
		}
		max= db.MaxPage(House.class, 2);
		List<House> houseList = db.selByPage(House.class, page,2);
		houseview = new ArrayList<HouseView>();
		toHouseView(houseList);
		queryStreetAndType();
		return "q_success";
	}
	public String gaoji() throws InstantiationException, IllegalAccessException{
		System.out.println(qh+"==好的呵呵=");
		if (page==0) {
			page=1;
		}
		List<House> list = BaseDao.findAll(House.class);
		max=db.MaxPage(House.class, list.size());
		System.out.println("市场四"+max);
		
		List<House> content = new HouseDao().findByContent(qh);
		houseview=new ArrayList<HouseView>();
		toHouseView(content);
		queryStreetAndType();
		return "gaoji_success";
	}
	public void queryStreetAndType(){
		try {
			slist=new BaseDao<Street>().findAll(Street.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tlist=new BaseDao<Types>().findAll(Types.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void toHouseView(List<House> houses) {

		try {
			for (House h : houses) {
				HouseView hv = new HouseView();
				// 将House对象的属性值拷贝到HouseView中
				// BeanUtils是拷贝的一个方法，是sun公司自己定义的
				// 括号里面的参数就是将后面的对象赋给前面的对象
				BeanUtils.copyProperties(hv, h);

				String sid = new StreetDao().findById(h.getStreet_id());

				hv.setDs(sid);
				Types types = new TypeDao().findTypeById(h.getType_id());
				hv.setType(types.getName());
				houseview.add(hv);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	// 2.生成get/set方法

	public List<HouseView> getHouseview() {
		return houseview;
	}

	public void setHouseview(List<HouseView> houseview) {
		this.houseview = houseview;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public QueryHouse getQh() {
		return qh;
	}

	public void setQh(QueryHouse qh) {
		this.qh = qh;
	}
	public List<Street> getSlist() {
		return slist;
	}
	public void setSlist(List<Street> slist) {
		this.slist = slist;
	}
	public List<Types> getTlist() {
		return tlist;
	}
	public void setTlist(List<Types> tlist) {
		this.tlist = tlist;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public List<District> getDlist() {
		return dlist;
	}
	public void setDlist(List<District> dlist) {
		this.dlist = dlist;
	}
	public int getDiBySid() {
		return diBySid;
	}
	public void setDiBySid(int diBySid) {
		this.diBySid = diBySid;
	}
	
}
