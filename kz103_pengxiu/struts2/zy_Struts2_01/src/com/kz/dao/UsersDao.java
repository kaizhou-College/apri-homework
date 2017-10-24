package com.kz.dao;

import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Users;

public class UsersDao {
	public static List Insert(){
		List<Users> list=new ArrayList<Users>();
		list.add(new Users("a","123","12-12-12"));
		list.add(new Users("b","122","12-12-12"));
		list.add(new Users("c","133","12-12-12"));
		list.add(new Users("d","144","12-12-12"));
		list.add(new Users("e","13242","12-12-12"));
		
		return list;
	}
	public static void main(String[] args) {
		for (int i = 0; i < Insert().size(); i++) {
			System.out.println(Insert().get(i));
		}
	}
}
