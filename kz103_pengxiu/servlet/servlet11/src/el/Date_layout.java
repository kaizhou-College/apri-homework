package el;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//2，格式化日期-string   给一个字符串日期返回指定格式的字符串日期
//${kz:dateFormat("2015-10-12",'yyyy年MM月dd日')}

public class Date_layout {
	public static String dateFormat(String date,String Stringlatout) throws ParseException{
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date a=formatter.parse(date);
		
		SimpleDateFormat time=new SimpleDateFormat(Stringlatout);
		return time.format(a);
	}
	public static void main(String[] args) throws ParseException {
		System.out.println(dateFormat("2015-10-12","yyyy年MM月dd日"));
	}
}
