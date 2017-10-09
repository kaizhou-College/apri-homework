package kz.servlet_zy;
import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class ServletExtends_smzq extends GenericServlet {
	private static final ServletConfig ServletConfig = null;
	public ServletExtends_smzq(){
		System.out.println("创建ServletImplements");
	}
	public void destroy() {
		System.out.println("销毁一般用于收尾");
		
	}
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.ServletConfig;
	}
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.getServletInfo()+"ServletImplements用来测试声明周期的";
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("gd");
	}
}