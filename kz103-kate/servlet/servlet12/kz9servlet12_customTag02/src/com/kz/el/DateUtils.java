package com.kz.el;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**
	 * SimpleDateFormat
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formateDate(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(date);
		
	}
/*	public static void main(String[] args) throws ParseException {
		String str = "2012年2月12日 ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		///String ------>Date
		Date date = sdf.parse(str);
		System.out.println(date.toLocaleString());
	}*/
}
