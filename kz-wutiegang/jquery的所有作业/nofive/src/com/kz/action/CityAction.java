package com.kz.action;

import java.util.List;

import com.kz.dao.BaseDao;
import com.kz.entity.City;
import com.kz.entity.District;
import com.opensymphony.xwork2.ActionSupport;

public class CityAction extends ActionSupport{
	private City city;
	private List<District> district;
	private BaseDao basedao=new BaseDao();
	public String cTod(){
		 try {
			 district=basedao.load(District.class, city.getCid());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cTod_success";
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	public List<District> getDistrict() {
		return district;
	}

	public void setDistrict(List<District> district) {
		this.district = district;
	}


}
