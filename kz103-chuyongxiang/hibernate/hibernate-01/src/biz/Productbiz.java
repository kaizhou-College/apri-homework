package biz;

import java.util.List;

import dao.ProductDao;
import entity.Product;

public class Productbiz {
	//����
	public static void add(Product clazz){
		System.out.println("������biz");
		ProductDao pd=new ProductDao();
		pd.adddao(clazz);
	}
	//��ѯ
	public  List select(Class clazz){
		System.out.println("������biz");
		ProductDao pd=new ProductDao();
		List list=pd.selectdao(clazz);
		return list;
	}
	
	//ɾ��
	public static void delete(Product clazz){
		System.out.println("������biz");
		System.out.println("biz=============="+clazz);
		ProductDao pd=new ProductDao();
		pd.deletedao(clazz);
	}
	//ȥ�޸�ҳ��
	public static Product toedit(int id) {
		// TODO Auto-generated method stub
		ProductDao pd=new ProductDao();
		Product product=pd.toeditdao(id);
		return product;
	}
	
	//�޸�
	public static void edit(Product product,int id) {
		// TODO Auto-generated method stub
		ProductDao pd=new ProductDao();
		pd.editdao(product,id);
	}
}
