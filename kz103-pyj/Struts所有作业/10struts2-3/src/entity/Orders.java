package entity;



public class Orders {
	private int ordered;                                
	private String custname;                          
	private String prodname;                           
	private double ordercount;                           
	private String orderdate;
	public Orders() {
		super();
	}
	public Orders(String custname, String prodname, double ordercount,
			String orderdate) {
		super();
		this.custname = custname;
		this.prodname = prodname;
		this.ordercount = ordercount;
		this.orderdate = orderdate;
	}
	public int getOrdered() {
		return ordered;
	}
	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public double getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(double ordercount) {
		this.ordercount = ordercount;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String toString() {
		return "Order [custname=" + custname + ", ordercount=" + ordercount
				+ ", orderdate=" + orderdate + ", ordered=" + ordered
				+ ", prodname=" + prodname + "]";
	}
}
