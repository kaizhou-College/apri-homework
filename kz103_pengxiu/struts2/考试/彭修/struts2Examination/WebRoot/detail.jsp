<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include  file="comm.jsp" %>

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
		<td width='150'><a href="fwxx_list">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="fwxx_postJD">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="fwxx_pageList">返回首页</a></td>
	</tr>
	<tr>
		<td width='100'><a href="user_goIndex">[注销]</a></td>
	</tr>
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495" align="center">

	<table width="450">
	  <tr>
		<td id=listTitle>出租健翔桥二居室</td>
	  </tr>
	  <tr>
	    <td id=listTitle><hr/></td>
	    </tr>
	  <tr>
		<td><strong>电话/手机：</strong><s:property value="listFwxx.get(0).telephone"/> </td>
	  </tr>
	  <tr>
		<td><strong>联系人：</strong><s:property value="listFwxx.get(0).telephone"/> </td>
	  </tr>
	  <tr>
		<td><strong>房屋类型：</strong><s:property value="listFwlx.get(0).fwlx"/> </td>
	  </tr>
	  <tr>
		<td><strong>户型：</strong><s:property value="listFwxx.get(0).shi"/> 室<s:property value="listFwxx.get(0).ting"/> 厅</td>
	  </tr>
	  <tr>
		<td><strong>价格：</strong><s:property value="listFwxx.get(0).zj"/> 元</td>
	  </tr>
	  <tr>
		<td>
				<s:property value="jiequ"/>
		</td>
	  </tr>
	  <tr>
		<td><strong>发布时间：</strong><s:property value="listFwxx.get(0).publishdate"/> </td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td ><s:property value="listFwxx.get(0).fwxx"/> </td>
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