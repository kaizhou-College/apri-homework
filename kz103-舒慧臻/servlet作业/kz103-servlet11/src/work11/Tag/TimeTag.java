package work11.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/*0，定义一个日期的标签
		<kztag:kzDate value="" pattern=""></kztag:kzDate>*/
public class TimeTag extends SimpleTagSupport{
	private String value;
	private String pattern;
	public void doTag() throws JspException, IOException {
		
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
