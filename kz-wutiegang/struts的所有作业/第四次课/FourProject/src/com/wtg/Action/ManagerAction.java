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
	// �����������ȳ�ʼ������

	// house��houseview�Ľ�ϵ�һ���¶���
	private List<HouseView> houseview =null;
	private int page;
	private int max;
	//�߼���ѯ�Ķ���
	private QueryHouse qh;
	private List<Street> slist;
	private List<Types> tlist;
	List<District> dlist ;
	private BaseDao <House> db=new BaseDao<House>();
	private int hid;
	private House house ;
	private int diBySid ;

	public String manager() {
		// 3.�����������
		// System.out.println("��������Action��");
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
	//�����Ĳ�ѯ
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
	
	//�޸�
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
			//�����ͱ��в�����������
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
		System.out.println(qh+"==�õĺǺ�=");
		if (page==0) {
			page=1;
		}
		List<House> list = BaseDao.findAll(House.class);
		max=db.MaxPage(House.class, list.size());
		System.out.println("�г���"+max);
		
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
				// ��House���������ֵ������HouseView��
				// BeanUtils�ǿ�����һ����������sun��˾�Լ������
				// ��������Ĳ������ǽ�����Ķ��󸳸�ǰ��Ķ���
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

	
	// 2.����get/set����

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
