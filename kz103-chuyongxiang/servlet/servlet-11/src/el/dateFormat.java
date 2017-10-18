package el;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateFormat {
	public static String dateFormat(String date,String aa) throws ParseException{
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date a=formatter.parse(date);
		SimpleDateFormat time=new SimpleDateFormat(aa);
		return time.format(a);
	}
	
}
