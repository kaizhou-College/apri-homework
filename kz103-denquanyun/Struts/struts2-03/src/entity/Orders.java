package entity;

import java.util.Date;

public class Orders {
	private Integer ordered;                                 
	private String custname;  // 客户名称     
	private String prodname;  //商品名称                    
	private Double ordercount;    //价格                             
	private Date orderdate;
	
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [custname=" + custname + ", ordercount=" + ordercount
				+ ", orderdate=" + orderdate + ", ordered=" + ordered
				+ ", prodname=" + prodname + "]";
	}
	public Integer getOrdered() {
		return ordered;
	}
	public void setOrdered(Integer ordered) {
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
	public Double getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(Double ordercount) {
		this.ordercount = ordercount;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	
}
