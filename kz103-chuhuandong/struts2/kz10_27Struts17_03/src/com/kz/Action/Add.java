package com.kz.Action;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kz.dao.BaseDao;
import com.kz.entity.orders;

public class Add{
		private String custName;
		private String prodName;
		private double orderCount ;
		private String orderDate;
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
		public double getOrderCount() {
			return orderCount;
		}
		public void setOrderCount(double orderCount) {
			this.orderCount = orderCount;
		}
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		public String execute() throws UnsupportedEncodingException{
			HttpServletRequest req=ServletActionContext.getRequest();
				req.setCharacterEncoding("utf-8");
			orders o= new orders();
			o.setCustname(custName);
			o.setProdname(prodName);
			o.setOrdercount(orderCount);
			o.setOrderdate(new Date());
			System.out.println(BaseDao.insert("HEHE", o));
			return "OK";
		}
}
