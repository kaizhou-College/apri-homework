package web;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.sun.org.apache.regexp.internal.recompile;

import biz.Productbiz;

import entity.Product;

public class ProducAction {
	private int pid;
	private String pname;
	private double price;
	private String pinfo;
	private Product product;
	private List listproduct;
	
	
	
	public String add(){
		System.out.println(pname);
		System.out.println(price);
		System.out.println(pinfo);
		Product product=new Product();
		product.setPname(pname);
		product.setPrice(price);
		product.setPinfo(pinfo);
		System.out.println(product);
		Productbiz.add(product);
		
		return "add_ok";
	}
	
	public String select(){
		Productbiz pb=new Productbiz();
		listproduct=pb.select(Product.class);
		System.out.println(listproduct);
		return "ok";
		
	}
	
	public String delete(){
		Product product=new Product();
		int id=pid;
		System.out.println("这个"+id);
		product.setPid(id);
		System.out.println(product);
		Productbiz.delete(product);
		return "delete_ok";
	}
	
	//去修改页面
	public String toedit(){
		int id=pid;
		System.out.println("这个"+id);
		product=Productbiz.toedit(id);
		System.out.println("看这里看着"+product);
		return "toedit";
	}
	
	//修改
	public String edit(){
		System.out.println(pid);
		System.out.println(pname);
		System.out.println(price);
		System.out.println(pinfo);
		Product product=new Product();
		product.setPname(pname);
		product.setPrice(price);
		product.setPinfo(pinfo);
		int id=pid;
		System.out.println("这aaaa个"+id);
		Productbiz.edit(product,id);
		return "edit_ok";
		
	}
	

	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getPinfo() {
		return pinfo;
	}


	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List getListproduct() {
		return listproduct;
	}

	public void setListproduct(List listproduct) {
		this.listproduct = listproduct;
	}
	
	
	
	
}
