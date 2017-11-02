package action;

import java.util.List;

import dao.BaseDao;
import entity.Orders;

public class OrderAction {
	private int id;
	private List list;
	public String delete(){
		int num = BaseDao.delete(Orders.class, id);
		if(num>0){
			list= BaseDao.queryAll(Orders.class);
			return "success";
		}else{
			return "error";
		}
	}
	public String update(){
		return null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
