package www.wtg.Action;

import www.wtg.Dao.BaseDao;
import www.wtg.entity.Orders;

import com.opensymphony.xwork2.Action;

public class deleteAction implements Action{
	
	private int ordered;
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Orders o=new Orders();
		int delete = BaseDao.delete(o, ordered);
		if(delete<0){
			return "删除失败";
		}
		return "success";
	}
	
	public int getOrdered() {
		return ordered;
	}

	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}

	
	
	
	
}
