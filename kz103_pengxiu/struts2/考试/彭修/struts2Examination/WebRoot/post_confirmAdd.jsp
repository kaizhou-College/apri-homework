<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="comm.jsp" %>



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
    <td width="495">
	<s:iterator value="tbl_fwxx" var="tbl_fwxx">
	<table width="460">
	  <tr>
		<td>请确认您要发布的信息：</td>
		<td>&nbsp;</td>
	  </tr>
	  <tr>
		<td colspan="2"><hr/></td>
	  </tr>				  
	  <tr>
		<td><s:property value="#tbl_fwxx.title"/>  <br/></td>
	  </tr>
	  <tr>
		<td><strong>电话/手机：</strong><s:property value="#tbl_fwxx.telephone"/></td>
	  </tr>
	  <tr>
		<td><strong>联系人：</strong><s:property value="#tbl_fwxx.lxr"/></td>
	  </tr>
	  <tr>
		<td><strong>房屋类型：</strong><s:property value="listFwlx.get(0).fwlx"/></td>
	  </tr>
	  <tr>
		<td><strong>户型：</strong><s:property value="#tbl_fwxx.shi"/>室<s:property value="#tbl_fwxx.ting"/>厅</td>
	  </tr>
	  <tr>
		<td><strong>价格：</strong><s:property value="#tbl_fwxx.zj"/>元</td>
	  </tr>
	  <tr>
		<td><strong>地段：</strong><s:property value="jiequ"/></td>
	  </tr>
	  <tr>
		<td><strong>发布时间：</strong><s:property value="#tbl_fwxx.publishdate"/></td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td><s:property value="#tbl_fwxx.fwxx"/></td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td>
		<s:debug></s:debug>
		<form action="fwxx_addTbl" method="POST">
			<table style="display: none;" ><%-- --%>
				<s:iterator value="tbl_fwxx" var="list">
				<tr>
					<td>fwid</td>
					<td> <input name="tbl_fwxx.fwid" value="<s:property  value='#list.fwid' />">  </td>
				</tr>
				<tr>
					<td>uuid</td>
					<td> <input name="tbl_fwxx.uuid" value="<s:property value='#list.uuid' />"></td>
				</tr>
				<tr>
					<td>jdid</td>
					<td> <input name="tbl_fwxx.jdid" value="<s:property value='#list.jdid' />"></td>
				</tr>
				<tr>
					<td>lxid</td>
					<td> <input name="tbl_fwxx.lxid" value="<s:property value='#list.lxid' />"></td>
				</tr>
				<tr>
					<td>shi</td>
					<td> <input name="tbl_fwxx.shi" value="<s:property value='#list.shi' />"></td>
				</tr>
				<tr>
					<td>ting</td>
					<td> <input name="tbl_fwxx.ting" value="<s:property value='#list.ting' />"></td>
				</tr>
				<tr>
					<td>fwxx</td>
					<td> <input name="tbl_fwxx.fwxx" value="<s:property value='#list.fwxx' />"></td>
				</tr>
				<tr>
					<td>zj</td>
					<td> <input name="tbl_fwxx.zj" value="<s:property value='#list.zj' />"></td>
				</tr>
				<tr>
					<td>title</td>
					<td> <input name="tbl_fwxx.title" value="<s:property value='#list.title' />"></td>
				</tr>
				<tr>
					<td>telephone</td>
					<td> <input name="tbl_fwxx.telephone" value="<s:property value='#list.telephone' />"></td>
				</tr>
				<tr>
					<td>lxr</td>
					<td> <input name="tbl_fwxx.lxr" value="<s:property value='#list.lxr' />"></td>
				</tr>
				</s:iterator>
			</table>
			<input type="hidden" name="tbl_fwxx" value="<s:property value='tbl_fwxx'/>"/>
			<input type="hidden" name="title" value="出租健翔桥二居室"/>
			<input type="submit" value="确认提交" class="btn" >&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="返回修改" class="btn" onclick="back()">
		</form>
		</td>
	  </tr>
	</table>
	</s:iterator>
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