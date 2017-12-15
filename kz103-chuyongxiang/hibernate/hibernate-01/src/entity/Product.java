package entity;

public class Product {
	private int pid;
	private String pname;
	private double price;
	private String pinfo;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pinfo=" + pinfo + ", pname=" + pname
				+ ", price=" + price + "]";
	}
	
	
}
