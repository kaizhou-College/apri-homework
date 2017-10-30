package com.kz.px.action.imp;

import com.kz.px.dao.DeleteDao;
import com.kz.px.entity.orders;

public class OrdersDeleteAction  {
	private int ordered;
	public String execute(){
			orders o=new orders();
			o.setOrdered(ordered);
			int delete = DeleteDao.delete(o);
			if(delete>0){
				return "success";
			}else{
				return "error";
			}
	}
	public int getOrdered() {
		return ordered;
	}
	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}
}