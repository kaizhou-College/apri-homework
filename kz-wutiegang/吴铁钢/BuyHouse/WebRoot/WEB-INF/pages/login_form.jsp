<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/command/comm.jsp"%>
<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />
<script lang="javascript">
	function login(){
		if( document.myForm.uname.value =="" ){
			alert("用户名不能为空");
			return false;
		}else if(document.myForm.upass.value == ""){
			alert("密码不能为空");
			return false;
		} else {
			return true;
		}
	}
</script>
</HEAD>
<s:debug></s:debug>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="images/top.jpg" width="780" height="213"></td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="images/middle2.jpg">&nbsp;</td>
    <td width="172">
	<table align="center">

		<tr>
		  <td><a href="user_reg">用户注册</a></td>
		</tr>
	</table>
	</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<form action="user_login" method="post" name="myForm" onsubmit="return login()">
	<s:actionerror/><div style="color:red">${tips}</div>
		<table align="center">
			<tr>
				<td colspan="2" align="center">
								
				</td>
			</tr>
			<tr>
				<td>用户登陆：</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="tbluser.uname" value="">
				<s:fielderror fieldName="tbluser.uname" ></s:fielderror>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="tbluser.upass" value="">
				<s:fielderror fieldName="tbluser.upass"></s:fielderror></td>
			</tr>
			<tr>
				<td>
				<input type="hidden" name="sign" value="login"/>
				<input type="submit" value="登陆" class="btn">
				</td>
			</tr>
		</table>
	</form>
	</td>
    <td width="40" background="images/middle4.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
  </tr>
</table>
<P align="center">2007 Beijing Aptech Beida Jade Bird Information Technology Co.,Ltd 版权所有</P>
<br/>
</BODY>
</HTML>