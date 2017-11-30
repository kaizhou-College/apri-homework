<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />
<script   language="javascript">   
function back()   
{   
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
<s:iterator value="fwxx3" var="fwxx3">
	<table align="center">
	
	<tr>
		<td width=''><font color='red'>当前用户：

			stan</font>
		</td>
	</tr>
	<tr>
		<td width='150'><a href="my.htm">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="post.htm">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="login.htm">返回首页</a></td>
	</tr>
	<tr>
		<td width='100'><a href="index.htm">[注销]</a></td>
	</tr>
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<table width="460">
	  <tr>
		<td>请确认您要发布的信息：</td>
		<td>&nbsp;</td>
	  </tr>
	  <tr>
		<td colspan="2"><hr/></td>
	  </tr>	
	  
	  <tr>
		<td>${fwxx3.title}<br/></td>
	  	
	  </tr>
	  <tr>
		<td><strong>电话/手机：</strong>${fwxx3.telephone}</td>
	  </tr>
	  <tr>
		<td><strong>联系人：</strong>${fwxx3.lxr}</td>
	  </tr>
	  <tr>
		<td><strong>房屋类型：</strong>${fwxx3.lxid}</td>
	  </tr>
	  <tr>
		<td><strong>户型：</strong>${fwxx3.shi}室${fwxx3.ting}厅</td>
	  </tr>
	  <tr>
		<td><strong>价格：</strong>${fwxx3.zj}</td>
	  </tr>
	  <tr>
		<td><strong>地段：</strong>${jd.jd}</td>
	  </tr>
	  <tr>
		<td><strong>发布时间：</strong>${fwxx3.publishdate}</td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td>${fwxx3.fwxx}</td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td>
		<form action="fwxx_add" method="POST">
		
			<input type="hidden" name="fwid" value="${fwxx3.fwid}"/>
			<input type="hidden" name="title" value="${fwxx3.title}"/>
	  		<input type="hidden" name="telephone" value="${fwxx3.telephone}"/>
	  		<input type="hidden" name="lxr" value="${fwxx3.lxr}"/>
	  		<input type="hidden" name="lxid" value="${fwxx3.lxid}"/>
	  		<input type="hidden" name="shi" value="${fwxx3.shi}"/>
	  		<input type="hidden" name="ting" value="${fwxx3.ting}"/>
	  		<input type="hidden" name="zj" value="${fwxx3.zj}"/>
	  		<input type="hidden" name="jdid" value="${jd.jdid}"/>
	  		<input type="hidden" name="publishdate" value="${fwxx3.publishdate}"/>
	  		<input type="hidden" name="fwxxx" value="${fwxx3.fwxx}"/>
	  		<input  name="uuid" value="${user2}"/>
	  	
			<input type="submit" value="确认提交" class="btn" >&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="返回修改" class="btn" onclick="back()">
		</form>
		</td>
	  </tr>
	</table>
	</td>
    <td width="40" background="images/middle4.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
  </tr>
</table>
</s:iterator>
<P align="center">2007 Beijing Aptech Beida Jade Bird Information Technology Co.,Ltd 版权所有</P>
<br/>
</BODY>
</HTML>
<s:debug></s:debug>