package el;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Date extends SimpleTagSupport{
	private String value;
	private String pattern;
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date a=null;
		try {
			a=formatter.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat time=new SimpleDateFormat(pattern);
		out.print(time.format(a));
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
}
