package struts3.entity;

public class Orders {
	private int ordered;//�������                         
	private String custname;// �ͻ�����                    
	private String prodname;//��Ʒ����                
	private double ordercount;//�������                     
	private String orderdate;//�µ�����
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
	@Override
	public String toString() {
		return "Orders [custname=" + custname + ", ordercount=" + ordercount
				+ ", orderdate=" + orderdate + ", ordered=" + ordered
				+ ", prodname=" + prodname + "]";
	}    
	
	
}
