<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://fy/pageFY"  prefix="fyy"%>



<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />

</HEAD>
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
    <td width="172" valign="top">

<script language="javascript">
<!--
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
-->
</script>

	<table align="center">
	<tr>
		<td width=''><font color='red'>当前用户：

			stan</font>
		</td>
	</tr>
	<tr>
		<td width='150'><a href="">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="add.jsp">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="login.htm">返回首页</a></td>
	</tr>
	<tr>
		<td width='100'><a href="user_out">[注销]</a></td>
	</tr>
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<table>
		<tr>
			<td width="3%">&nbsp;</td>
			<td width="97%">
			
			
			<table width='450' border='0'>
				<tr>
					<TD>标题</TD>
					<TD width='100' align='center'>月租金</TD>
					<TD width='110'align='center'>发布日期</TD>
					<TD width='50'>&nbsp;</TD>
					<TD width='50'>&nbsp;</TD>
				</tr>
				<tr>
					<td colspan='5'><hr/></td>
				</tr>
				<s:iterator value="fwxx" var="fwxx">
				
				<tr>
					<td><a href="fwxx_toview?fwxx.fwid=<s:property value="#fwxx.fwid"/>"><s:property value="#fwxx.title"/></a></td>
					<td align='center' style='height:30px;'><s:property value="#fwxx.zj"/></td>
					<td align='center'><s:property value="#fwxx.publishdate"/></td>
					<td align='center' style='height:30px;'><a href="fwxx_Delect?fwxx.fwid=<s:property value="#fwxx.fwid"/>">[删除]</a></td>
					<td align='center' style='height:30px;'><a href="fwxx_update?fwxx.fwid=<s:property value="#fwxx.fwid"/>">[修改]</a></td>
				</tr>
				
				</s:iterator> 
				
				
				<tr>
					<td colspan='5'><hr/></td>
				</tr>
				<tr>
				<td><fyy:fy pageIndex="${pageIndex}" pageSize="${pageYS}" pageUrl="fwxx_selectpage4"></fyy:fy></td>
				</tr>
			</table>
			
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
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