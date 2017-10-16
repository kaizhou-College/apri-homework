package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyFunction {
/*1，获取集合和数组的长度  给一个集合返回集合的长度
	${kz:size(lists)}  参数是集合*/
	public static int getListLength(List list){
		int num = list.size();
		return num;
	}
	/*2，格式化日期-string   给一个字符串日期返回指定格式的字符串日期
	${kz:dateFormat("2015-10-12",'yyyy年MM月dd日')}
	*/
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

	/*4，indexOf查找  给一个字符串，查找指定字符串的下标
	${kz:indexOf("1#22#22#33",'2')}
	结果为：2*/
	public static int indexOf(String str,String str1){
		int num = str.indexOf(str1);
		return num;
	}
}
