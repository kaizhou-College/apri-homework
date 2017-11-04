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
	/*���ҳ*/
	private int max;
	/*��ǰҳ*/
	private int page;
	/*��ѯ����*/
	private QueryHouse qh;
	private BaseDao<House> db = new BaseDao<House>();
	private HouseDao hd = new HouseDao();
	//�޸��ǲ�ѯ����������Ϣ
	private House house;
	private HouseView hv;
	private List<District> dises;
	public List<District> getDises() {
		return dises;
	}

	public void setDises(List<District> dises) {
		this.dises = dises;
	}
	private Street tempStreet;//���������Ľֵ�
	public String edit() throws InstantiationException, IllegalAccessException{
		//System.err.println("houser id="+house.getId());
		//1,����id��ѯ������Ϣ
		house = hd.findById(house.getId());
		//1.1����Ƿ��ӵĽֵ�
		tempStreet = (Street) new StreetDao().findById2(house.getStreet_id());
		
		//2,��ѯ���еķ�������
		BaseDao<Types> baseDao = new BaseDao<Types>();
		types = baseDao.find(Types.class);
		//3,��ѯ������
		BaseDao<District> disDao = new BaseDao<District>();
		dises = disDao.find(District.class);
		//4,��ѯ�ķ��ӵ��������еĽֵ�
		StreetDao sd = new StreetDao();
		streets = sd.findByDisId(tempStreet.getDistrict_id());
		//5,����Ϣ���ݵ�edit.jsp��ʾ---��������
		return "edit_success";
	}
	//�޸��ύ
	public String update() throws IllegalArgumentException, IllegalAccessException{
		System.out.println("����update"+house);
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

	//��ҳ��ѯ���з��ݵ���Ϣ
	public String list() throws IllegalAccessException, InvocationTargetException  {
		//System.out.println("HouseAction  list.....");
		//0,�޸�ҳ��
		if(page==0){
			page=1;
		}
		//1, ����dao��ҳ��ѯ��1ҳ������Ϣ
		List<House>houses = db.selByPage(House.class, page, DEFAULT_HOUSE_PAGE_SIZE);
		//2,��ѯ���е�1ҳ���ݵ����ͽֵ���Ϣ
		StreetDao sDao = new StreetDao();
		houseViews = new ArrayList<HouseView>();
		for(House h :houses){
			HouseView hv = new HouseView();
			String districtStreet = sDao.findById(h.getStreet_id());
			//���󿽱�
			BeanUtils.copyProperties(hv, h);
			//�������ͽֵ���Ϣ
			hv.setDistrictStreet(districtStreet);
			houseViews.add(hv);
		}
		//3����ѯ���ҳ
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
		//System.out.println("����HouseAction  list");
		int pageSize = DEFAULT_HOUSE_PAGE_SIZE;
		if(page==0){
			page = DEFAULT_HOUSE_PAGE;
		}
		max = db.getMaxPage(House.class,pageSize);
		//��ҳ��ѯ������Ϣ
		List<House> houses = db.selByPage(House.class, page, pageSize);
		//System.out.println(houseViews);
		houseViews = new ArrayList<HouseView>();
		toHouseView(houses);
		//��ѯ�ֵ���������Ϣ
		queryStreetAndTypes();
		return "list_success";
	}*/
	/*�߼���ѯ������Ϣ*/
	public String query() throws IllegalAccessException, InvocationTargetException{
		//System.out.println(qh);
		
//		���ݲ�ѯ��������ѯ������Ϣ
		HouseDao hd = new HouseDao();
		List<House> houses = hd.queryByCretiera(qh);
		houseViews = new ArrayList<HouseView>();
		toHouseView(houses);
		//��ѯ�ֵ���������Ϣ
		queryStreetAndTypes();
		return "list_success";
	}
	private void queryStreetAndTypes()
			throws IllegalAccessException {
		BaseDao<Street> db2 = new BaseDao<Street>();
		//��ѯ���нֵ���Ϣ
		try {
			streets = db2.find(Street.class);
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		//��ѯ���з���������Ϣ
		BaseDao<Types> db3 = new BaseDao<Types>();
		//��ѯ����������Ϣ
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
			//��house���������ֵ������houseView��
			BeanUtils.copyProperties(hv, h);
			System.out.println(hv);
			String ds = new StreetDao().findById(h.getStreet_id());
			hv.setDistrictStreet(ds);
			Types type= new TypesDao().findById(h.getType_id());
			hv.setTypeView(type.getName());
			//��houserView������뼯��
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
