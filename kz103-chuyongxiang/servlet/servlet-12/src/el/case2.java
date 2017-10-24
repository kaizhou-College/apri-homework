package el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class case2 extends BodyTagSupport{
	private int num;

	@Override
	public int doStartTag() throws JspException {
		Tag tag=getParent();
		if(tag==null&&!(tag instanceof TwitchTag)){
			try {
				throw new Exception("不在这个tag里面");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TwitchTag twitch=(TwitchTag) tag;
		if(twitch.isTest()){
			System.out.println("11"+twitch.getBodyContent().getString());
			twitch.setBody();
		}else{
			try {
				twitch.getBodyContent().clear();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		int twinum = twitch.getNum();
		if(twinum==num){
			twitch.setTest();
		}
		return EVAL_BODY_BUFFERED;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
