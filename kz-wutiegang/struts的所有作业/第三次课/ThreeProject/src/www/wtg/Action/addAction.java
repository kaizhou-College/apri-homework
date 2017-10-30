package www.wtg.Action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import www.wtg.Dao.BaseDao;
import www.wtg.entity.Orders;

import com.opensymphony.xwork2.Action;

import freemarker.template.SimpleDate;

public class addAction implements Action{
	private String custName;
	private String prodName;
	private double ordercount;
	private Date orderDate;
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Orders o=new Orders();
		o.setCustName(custName);
		o.setProdName(prodName);
		o.setOrderCount(ordercount);
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM月-yy年");
		String date = sd.format(orderDate);
		
		//o.setOrderDate(date);
		
		int add = BaseDao.add(o, "seq_orders");
		if (add<0) {
			return "新增失败";
		}
		return "success";
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
	public Double getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(Double ordercount) {
		this.ordercount = ordercount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}
