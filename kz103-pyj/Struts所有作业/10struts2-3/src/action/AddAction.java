package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.Basedao;
import entity.Orders;

public class AddAction {
	private String custname;                          
	private String prodname;                           
	private double ordercount;                           
	private String orderdate;
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
	public String execute() throws Exception{
		HttpServletRequest req=ServletActionContext.getRequest();
			req.setCharacterEncoding("utf-8");
		Orders or= new Orders();
		or.setCustname(custname);
		or.setProdname(prodname);
		or.setOrdercount(ordercount);
		or.setOrderdate("27-10ÔÂ-17");
		System.out.println(Basedao.save("seq_users", or));
		return "yes";
	}
}
