<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../comm/comm.jsp"%>
<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="${basePath}/style/mycss.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/style/texts.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/style/btn.css" rel="stylesheet" type="text/css" />

</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="${basePath}/images/top.jpg" width="780" height="213"></td>
  </tr>
  <tr>
    <td colspan="5"><img src="${basePath}/images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="${basePath}/images/middle2.jpg">&nbsp;</td>
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
	function del(id){
		var choose =confirm("确定删除吗");
		if(choose){
			location.href="fw_del.action?fw.fwid="+id;
		}
	}
</script>

	<table align="center">
	<tr>
		<td width=''><font color='red'>当前用户：

			${user.uname}</font>
		</td>
	</tr>
	<tr>
		<td width='150'><a href="fw_queryByUid.action?uid=${user.uuid}">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="${basePath}/page/post.jsp">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="fw_query.action">返回首页</a></td>
	</tr>
	<tr>
		<td width='100'><a href="user_exit.action">[注销]</a></td>
	</tr>
	</table>
</td>
    <td width="35" background="${basePath}/images/layout_24.gif">&nbsp;</td>
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
				<c:forEach items="${list}" var="list">
					<tr>
						<td><a href='detail.htm'>${list.title}</a></td>
						<td align='center' style='height:30px;'>${list.zj}</td>
						<td align='center'>${list.publishdate}</td>
						<td align='center' style='height:30px;'><a href="javascript:del(${list.fwid})">[删除]</a></td>
						<td align='center' style='height:30px;'><a href="fw_edit.action?fw.fwid=${list.fwid}">[修改]</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan='5'><hr/></td>
				</tr>
			</table>
			
			
			
			
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
	</td>
    <td width="40" background="${basePath}/images/middle4.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5"><img src="${basePath}/images/bottom.jpg" width="780" height="82"></td>
  </tr>
</table>
<P align="center">2007 Beijing Aptech Beida Jade Bird Information Technology Co.,Ltd 版权所有</P>
<br/>
</BODY>
</HTML>