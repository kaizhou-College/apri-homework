package biz;

import java.util.List;

import dao.ProductDao;
import entity.Product;

public class Productbiz {
	//增加
	public static void add(Product clazz){
		System.out.println("进入了biz");
		ProductDao pd=new ProductDao();
		pd.adddao(clazz);
	}
	//查询
	public  List select(Class clazz){
		System.out.println("进入了biz");
		ProductDao pd=new ProductDao();
		List list=pd.selectdao(clazz);
		return list;
	}
	
	//删除
	public static void delete(Product clazz){
		System.out.println("进入了biz");
		System.out.println("biz=============="+clazz);
		ProductDao pd=new ProductDao();
		pd.deletedao(clazz);
	}
	//去修改页面
	public static Product toedit(int id) {
		// TODO Auto-generated method stub
		ProductDao pd=new ProductDao();
		Product product=pd.toeditdao(id);
		return product;
	}
	
	//修改
	public static void edit(Product product,int id) {
		// TODO Auto-generated method stub
		ProductDao pd=new ProductDao();
		pd.editdao(product,id);
	}
}
