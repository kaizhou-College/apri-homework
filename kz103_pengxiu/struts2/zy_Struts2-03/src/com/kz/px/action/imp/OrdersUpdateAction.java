package com.kz.px.action.imp;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.kz.px.dao.SelectDao;
import com.kz.px.dao.UpdateDao;
import com.kz.px.entity.orders;

public class OrdersUpdateAction implements RequestAware {
	/*
	 *   <%--������� ordered    number           ����,����1
�ͻ����� custName  varchar2  20      �ǿ�
��Ʒ���� prodName  varchar2  20      �ǿ�
������� orderCount  number(5,2)      �ǿ�,2λС��
�µ����� orderDate   date          	  �ǿ� --%>*/
	private int ordered;
	private String custName;
	private String prodName;
	private int orderCount;
	private String orderDate;
	private Map<String, Object> req;
	public String execute(){
		orders o=new orders();
		o.setOrdercount(orderCount);
		o.setOrderdate(orderDate);
		o.setCustname(custName);
		o.setOrdered(ordered);
		o.setProdname(prodName);
		int update = UpdateDao.update(o);
		if(update>0){
			req.put("name",custName );
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
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		req=arg0;
	}
	
}
