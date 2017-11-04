package com.kz.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import com.kz.dao.BaseDao;
import com.kz.dao.HouseDao;
import com.kz.dao.StreetDao;
import com.kz.dao.TypesDao;
import com.kz.entity.District;
import com.kz.entity.House;
import com.kz.entity.HouseView;
import com.kz.entity.QueryHouse;
import com.kz.entity.Street;
import com.kz.entity.Types;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class HouseAction {
	private static final int DEFAULT_HOUSE_PAGE_SIZE = 2;
	private static final int DEFAULT_HOUSE_PAGE = 1;
	private List<Street> streets;
	private List<Types> types;
	private List<HouseView> houseViews;
	/*最大页*/
	private int max;
	/*当前页*/
	private int page;
	/*查询对象*/
	private QueryHouse qh;
	private BaseDao<House> db = new BaseDao<House>();
	private HouseDao hd = new HouseDao();
	//修改是查询单个房屋信息
	private House house;
	private HouseView hv;
	private List<District> dises;
	public List<District> getDises() {
		return dises;
	}

	public void setDises(List<District> dises) {
		this.dises = dises;
	}
	private Street tempStreet;//房子所属的街道
	public String edit() throws InstantiationException, IllegalAccessException{
		//System.err.println("houser id="+house.getId());
		//1,根据id查询房屋信息
		house = hd.findById(house.getId());
		//1.1查出盖房子的街道
		tempStreet = (Street) new StreetDao().findById2(house.getStreet_id());
		
		//2,查询所有的房屋类型
		BaseDao<Types> baseDao = new BaseDao<Types>();
		types = baseDao.find(Types.class);
		//3,查询所有区
		BaseDao<District> disDao = new BaseDao<District>();
		dises = disDao.find(District.class);
		//4,查询改房子的区的所有的街道
		StreetDao sd = new StreetDao();
		streets = sd.findByDisId(tempStreet.getDistrict_id());
		//5,将信息传递到edit.jsp显示---属性驱动
		return "edit_success";
	}
	//修改提交
	public String update() throws IllegalArgumentException, IllegalAccessException{
		System.out.println("进入update"+house);
		int num = db.update(house);
		if(num>0){
			return "update_success";
		}else{
			return "update_failed";
		}
	}
	
	
	public Street getTempStreet() {
		return tempStreet;
	}

	public void setTempStreet(Street tempStreet) {
		this.tempStreet = tempStreet;
	}

	//分页查询所有房屋的信息
	public String list() throws IllegalAccessException, InvocationTargetException  {
		//System.out.println("HouseAction  list.....");
		//0,修改页数
		if(page==0){
			page=1;
		}
		//1, 调用dao分页查询第1页房屋信息
		List<House>houses = db.selByPage(House.class, page, DEFAULT_HOUSE_PAGE_SIZE);
		//2,查询所有第1页房屋的区和街道信息
		StreetDao sDao = new StreetDao();
		houseViews = new ArrayList<HouseView>();
		for(House h :houses){
			HouseView hv = new HouseView();
			String districtStreet = sDao.findById(h.getStreet_id());
			//对象拷贝
			BeanUtils.copyProperties(hv, h);
			//加上区和街道信息
			hv.setDistrictStreet(districtStreet);
			houseViews.add(hv);
		}
		//3，查询最大页
		max = db.getMaxPage(House.class, DEFAULT_HOUSE_PAGE_SIZE);
	
		return "list_success";
	}
	
	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	/*public String list() throws IllegalAccessException, InvocationTargetException{
		//System.out.println("进入HouseAction  list");
		int pageSize = DEFAULT_HOUSE_PAGE_SIZE;
		if(page==0){
			page = DEFAULT_HOUSE_PAGE;
		}
		max = db.getMaxPage(House.class,pageSize);
		//分页查询房屋信息
		List<House> houses = db.selByPage(House.class, page, pageSize);
		//System.out.println(houseViews);
		houseViews = new ArrayList<HouseView>();
		toHouseView(houses);
		//查询街道和类型信息
		queryStreetAndTypes();
		return "list_success";
	}*/
	/*高级查询房屋信息*/
	public String query() throws IllegalAccessException, InvocationTargetException{
		//System.out.println(qh);
		
//		根据查询条件来查询房屋信息
		HouseDao hd = new HouseDao();
		List<House> houses = hd.queryByCretiera(qh);
		houseViews = new ArrayList<HouseView>();
		toHouseView(houses);
		//查询街道和类型信息
		queryStreetAndTypes();
		return "list_success";
	}
	private void queryStreetAndTypes()
			throws IllegalAccessException {
		BaseDao<Street> db2 = new BaseDao<Street>();
		//查询所有街道信息
		try {
			streets = db2.find(Street.class);
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		//查询所有房屋类型信息
		BaseDao<Types> db3 = new BaseDao<Types>();
		//查询所有类型信息
		try {
			types = db3.find(Types.class);
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
	private void toHouseView(List<House> houses) throws IllegalAccessException,
			InvocationTargetException {
		for(House h :houses){
			HouseView hv  = new HouseView();
			//将house对象的属性值拷贝到houseView中
			BeanUtils.copyProperties(hv, h);
			System.out.println(hv);
			String ds = new StreetDao().findById(h.getStreet_id());
			hv.setDistrictStreet(ds);
			Types type= new TypesDao().findById(h.getType_id());
			hv.setTypeView(type.getName());
			//将houserView对象放入集合
			houseViews.add(hv);
		}
	}
	
	public List<HouseView> getHouseViews() {
		return houseViews;
	}
	public void setHouseViews(List<HouseView> houseViews) {
		this.houseViews = houseViews;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}
	public List<Types> getTypes() {
		return types;
	}
	public void setTypes(List<Types> types) {
		this.types = types;
	}
	public QueryHouse getQh() {
		return qh;
	}
	public void setQh(QueryHouse qh) {
		this.qh = qh;
	}
	
	
	
	
}
