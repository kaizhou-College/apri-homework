package com.wtg.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DTS {
	public static String dateFormat(Date date,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	
	}
	/*public static void main(String[] args) {
		String format="2015��07��09��";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		System.out.println(sdf.toLocalizedPattern());
		System.out.println(dateFormat(new Date(), "yyyy��MM��dd��"));
	}*/
}
