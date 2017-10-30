package action;

import dao.Basedao;
import entity.Orders;

public class DelAction {
	private int ordered;

	public int getOrdered() {
		return ordered;
	}

	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}
	
	public String execute(){
		int num=Basedao.del(Orders.class,ordered);
		if(num>0){
			return "yes";
		}else{
			return "no";
		}
	}

}
