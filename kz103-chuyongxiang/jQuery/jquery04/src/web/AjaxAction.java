package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.BaseDao;
import dao.CityDao;
import dao.DistrictDao;
import entity.City;
import entity.District;
import entity.Province;

public class AjaxAction {
	private List<Province> listProv;
	private List<City> listCity;
	private List<District> listDistrict;
	
	
	public String sf(){
		listProv=BaseDao.select(new Province());
		System.out.println(listProv);
		return "ok";
	}
	
	
	public String cs(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id =Integer.parseInt(request.getParameter("id"));
		listCity=new CityDao().Cityselect(id);
		System.out.println(listCity);
		return "ok";
	}
	
	public String qx(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id =Integer.parseInt(request.getParameter("id"));
		listDistrict=new DistrictDao().Districtselect(id);
		System.out.println(listDistrict);
		return "ok";
	}
	
	
	
	
	
	public List<Province> getListProv() {
		return listProv;
	}
	public void setListProv(List<Province> listProv) {
		this.listProv = listProv;
	}



	public List<City> getListCity() {
		return listCity;
	}



	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}


	public List<District> getListDistrict() {
		return listDistrict;
	}


	public void setListDistrict(List<District> listDistrict) {
		this.listDistrict = listDistrict;
	}
	
	
	
}	
