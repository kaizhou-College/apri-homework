package action;

import dao.BaseDao;
import entity.Orders;

public class DeleteAction {
	private int ordered;

	public int getOrdered() {
		return ordered;
	}

	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}
	
	public String execute(){
		System.out.println("ordered=="+ordered);
		System.out.println("正在执行删除");
		int num=BaseDao.delete(Orders.class,ordered);
		System.out.println("num=="+num);
		if(num>0){
			System.out.println("成功了");
			return "OK";
		}else{
			System.out.println("失败了");
			return "NO";
		}
	}
}
