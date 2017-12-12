package com.kz.action;


import java.util.List;

import com.kz.dao.BaseDao;
import com.kz.entity.Province;
import com.kz.entity.City;
import com.opensymphony.xwork2.ActionSupport;

public class ProvinceAction extends ActionSupport{
	private List<Province> query;
	private Province province;
	private List<City> city;
	private BaseDao basedao=new BaseDao();
	//根据省查找市province-city
	public String pc(){
		query = basedao.query(Province.class);
		return "pc_success";
	}
	public String pToc(){
		//System.out.println("恭喜进入action"+province.getPid());
		try {
			city = basedao.load(City.class, province.getPid());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pToc_success";
	}
	public List<Province> getQuery() {
		return query;
	}
	public void setQuery(List<Province> query) {
		this.query = query;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
	
	
}
