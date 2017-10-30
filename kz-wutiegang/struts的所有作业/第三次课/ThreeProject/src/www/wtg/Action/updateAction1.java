package www.wtg.Action;

import www.wtg.Dao.BaseDao;
import www.wtg.entity.Orders;

import com.opensymphony.xwork2.Action;

public class updateAction1 implements Action{
	private int id;
	private String prodName;
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Orders o=new Orders();
		o.setProdName(prodName);
		
		int update = BaseDao.update(o, id);
		
		if (update<0) {
			return "更新失败";
		}
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
}
