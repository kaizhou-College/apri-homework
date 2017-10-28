package entity;

public class Orders {
	private int ordered;
	private String custName;
	private String prodName;
	private double orderCount;
	private String orderDate;
	public Orders(int ordered, String custName, String prodName,
			double orderCount, String orderDate) {
		super();
		this.ordered = ordered;
		this.custName = custName;
		this.prodName = prodName;
		this.orderCount = orderCount;
		this.orderDate = orderDate;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [custName=" + custName + ", orderCount=" + orderCount
				+ ", orderDate=" + orderDate + ", ordered=" + ordered
				+ ", prodName=" + prodName + "]";
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
	
}
