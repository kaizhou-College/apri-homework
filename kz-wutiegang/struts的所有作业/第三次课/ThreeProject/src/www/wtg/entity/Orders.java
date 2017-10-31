package www.wtg.entity;

import java.util.Date;

public class Orders {
	private int ordered;
	private String custName;
	private String prodName;
	private double orderCount;
	private Date orderDate;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Orders [custName=" + custName + ", orderCount=" + orderCount
				+ ", orderDate=" + orderDate + ", ordered=" + ordered
				+ ", prodName=" + prodName + "]";
	}
	
}
