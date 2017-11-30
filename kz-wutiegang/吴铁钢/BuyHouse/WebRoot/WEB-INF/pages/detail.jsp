<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/command/comm.jsp"%>
<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />
<script   language="javascript">   
	function back(){
		window.history.back();
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

			${uname}</font>
		</td>
	</tr>
	
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495" align="center">

	<table width="450">
	  <tr>
		<td id=listTitle>${tblfwxx.title}</td>
	  </tr>
	  <tr>
	    <td id=listTitle><hr/></td>
	    </tr>
	  <tr>
		<td><strong>电话/手机：</strong>${tblfwxx.telephone}</td>
	  </tr>
	  <tr>
		<td><strong>联系人：</strong>${tblfwxx.lxr}</td>
	  </tr>
	  <tr>
		<td><strong>房屋类型：</strong>${tblfwxx.lxid}</td>
	  </tr>
	  <tr>
		<td><strong>户型：</strong>${tblfwxx.shi}室${tblfwxx.ting}厅</td>
	  </tr>
	  <tr>
		<td><strong>价格：</strong>${tblfwxx.zj}元</td>
	  </tr>
	  <tr>
		<td><strong>地段：</strong>&nbsp;&nbsp;${tblfwxx.jdid}</td>
	  </tr>
	  <tr>
		<td><strong>发布时间：</strong> ${tblfwxx.publishdate}</td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td >${tblfwxx.fwxx}</td>
	  </tr>
	  <tr>
		<td><input type="button" value="后退" class="btn" onclick="back()"></td>
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