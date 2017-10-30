package struts3.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import struts3.dao.BaseDao;
import struts3.entity.Orders;

public class UpdateAction{
		private int ordered;//订单编号                         
		private String custname;// 客户名称                    
		private String prodname;//商品名称                
		private double ordercount;//订单金额                     
		private String orderdate;//下单日期
		private Orders or = new Orders();
		public String execute() {
		BaseDao dao = new BaseDao();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		or.setCustname(custname);
		or.setOrdercount(ordercount);
		or.setOrderdate(orderdate);
		or.setOrdered(ordered);
		or.setProdname(prodname);
		int num = dao.Update(or);
		if(num>0){
			return "success";
		}else{
			return "update";
		}
		
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
		public Orders getOr() {
			return or;
		}
		public void setOr(Orders or) {
			this.or = or;
		}
	

}
