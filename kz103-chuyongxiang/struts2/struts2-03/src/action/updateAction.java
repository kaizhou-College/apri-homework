package action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import dao.BaseDao;

import entity.Orders;


public class updateAction implements RequestAware {
	private int ordered;
	private String custName;
	private String prodName;
	private double orderCount;
	private String orderDate;
	
	private Map<String, Object> req;
	public String execute(){
		Orders o=new Orders();
		o.setOrderCount(orderCount);
		o.setOrderDate(orderDate);
		o.setCustName(custName);
		o.setOrdered(ordered);
		o.setProdName(prodName);
		int update = BaseDao.Update(o);
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
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		req=arg0;
	}
	
}
