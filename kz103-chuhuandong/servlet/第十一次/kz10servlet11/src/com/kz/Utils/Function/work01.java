package com.kz.Utils.Function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class work01 {
	public static int getSize(List<Object> list){
		int size = list.size();
		return size;
	}
	public static int getStringSize(String name){
		int size = name.length();
		return size;
	}
	public static String dateToString(String date,String str){
		Date st = null;
		String Nowdate =null;
		try {
			st = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Nowdate = new SimpleDateFormat(str).format(st);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Nowdate;
	}
	public static int indexof(String one,String two){
		int index = one.indexOf(two);
		return index;
	}
}
