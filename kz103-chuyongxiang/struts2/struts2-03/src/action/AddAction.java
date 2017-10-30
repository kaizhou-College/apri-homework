package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.BaseDao;
import entity.Orders;

public class AddAction {
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
		Orders o= new Orders();
		o.setCustName(custName);
		o.setProdName(prodName);
		o.setOrderCount(orderCount);
		o.setOrderDate("12-6ÔÂ-12");
		System.out.println(BaseDao.insert("AA", o));
		return "OK";
		
	}
}
