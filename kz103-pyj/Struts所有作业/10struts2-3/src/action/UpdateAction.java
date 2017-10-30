package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import dao.UsersDao;
import entity.Orders;

public class UpdateAction {
	private int ordered;                                
	private String custname;                          
	private String prodname;                           
	private double ordercount;                           
	private String orderdate;
	private Orders or=new Orders();
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
	public String execute() {
		UsersDao u=new UsersDao();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		or.setCustname(custname);
		or.setOrdercount(ordercount);
		or.setOrderdate(orderdate);
		or.setOrdered(ordered);
		or.setProdname(prodname);
		int num = u.update(or);
		if(num>0){
			return "yes";
		}else{
			return "no";
		}
		
	}
}
