<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="comm.jsp" %>

<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />
<script language="javascript">
function selectjd(){
		var row = document.mf.qxid.value;//alert(row);
		var col = v[row].length;//alert(col);
		document.mf.jdid.length = 0;
		document.mf.jdid.options[0] = new Option('不限--','0');
		for(var i=0;i<col;i++) {
			if(v[row][i]!=0){
				document.mf.jdid.options[i+1] = new Option(n[row][i],v[row][i]);
			}
		}
	}
	
	function validateTitle(){
		var pass = false;
		if(document.mf.title.value ==""){
			alert("标题不能为空");
			pass = false;
		}else {
			pass = true;
		}
		if(isNaN(document.mf.zj.value)){
			alert("租金不是数字");
			pass = false;
		}
		return pass;
	}

	function vzj() {
		if(isNaN(document.mf.zj.value)){
			var oMsgDiv = document.getElementById("mid");
			oMsgDiv.innerHTML = "<font color='red'>不是一个数字</font>";
		}else{
			var oMsgDiv = document.getElementById("mid");
			oMsgDiv.innerHTML = "";
		}
	}
-->
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
<script>
ajax;
function pickCityGet(){
	createAjax();
	var id=document.getElementById("quxian").value;
	
	var method = "get";//提交方式
	var url = "jd_ajax2?tbl_qx.qx="+id;//请求的资源的url
	ajax.open(method,url,true);//true是异步请求
	ajax.send(null);
	ajax.onreadystatechange=callback;//设置回调函数
	
}
function callback(){//通话
	if(ajax.readyState==4&&ajax.status==200){
		var xmlObj=ajax.responseXML;
		var cityNodes = xmlObj.getElementsByTagName("jd");
		var city = document.getElementById("jdid");
		city.options.length=1;
		for(var i = 0;i<cityNodes.length;i++){
			var  id= cityNodes[i].getAttribute("id");
			var name=cityNodes[i].childNodes[0].childNodes[0].nodeValue;
			var opt = new Option(name,id);
			city.add(opt);
		}
	}
}

function createAjax(){
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
}

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

	<form action="fwxx_addListTbl" method="post" name="mf" onsubmit="return validateTitle()">
		<input type="hidden" name="affirm" value="n"/>
		<table>
			<tr>
				<td colspan="2">发布租房信息：</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
			  <td><strong>标题：</strong></td>
				<td><input type="text" name="tbl_fwxx.title" ></td>
			</tr>
			<tr>
			  <td><strong>区县：</strong></td>
				<td>
					<s:select onchange="pickCityGet()" id="quxian" list="qxList" headerKey="--不限--" headerValue="--不限--"></s:select>
				</td>
			</tr>
			<tr>
			  <td><strong>街道：</strong></td>
				<td><select name="qxjd.jieDao" id="jdid" >
					<option value="">--不限--</option>
				</select></td>
			</tr>
			<tr>
			  <td><strong>租金：</strong></td>
				<td><input type="text" name="tbl_fwxx.zj"/>元/月</td>
			</tr>
			<tr>
			  <td><strong>户型：</strong></td>
				<td><select name="tbl_fwxx.shi">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
				</select>室<select name="tbl_fwxx.ting">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>厅</td>
			</tr>
			<tr>
			  <td><strong>房屋类型：</strong></td>
				<td><select name="tbl_fwxx.lxid">
					<option value=''>--不限--</option>
<option value='1'>地下室</option>
<option value='2'>平房</option>
<option value='3'>普通住宅</option>
<option value='4'>公寓</option>
<option value='5'>别墅</option>

				</select></td>
			</tr>
			<tr>
			  <td><strong>联系电话：</strong></td>
				<td><input type="text" name="tbl_fwxx.telephone"></td>
			</tr>
			<tr>
			  <td><strong>联系人：</strong></td>
				<td><input type="text" name="tbl_fwxx.lxr"></td>
			</tr>
			<tr>
			  <td><strong>房屋信息：</strong></td>
				<td><textarea name="tbl_fwxx.fwxx" rows="10" cols="40"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="center"><input type="submit" value="提交" class="btn"></div>				</td>
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
