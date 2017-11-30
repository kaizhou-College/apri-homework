<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.kz.examination.entity.QueryView"%>
<%@include file="comm.jsp"%>
<%@taglib uri="http://px/pageFY"  prefix="px"%>
<HTML>
	<HEAD>
		<TITLE>北京出租房</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">

		<link href="style/mycss.css" rel="stylesheet" type="text/css" />
		<link href="style/texts.css" rel="stylesheet" type="text/css" />
		<link href="style/btn.css" rel="stylesheet" type="text/css" />


	</HEAD>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0>

		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="5">
					<img src="images/top.jpg" width="780" height="213">
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<img src="images/middle1.jpg" width="780" height="47">
				</td>
			</tr>
			<tr>
				<td width="38" background="images/middle2.jpg">
					&nbsp;
				</td>
				<td width="172" valign="top" align="center">

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
							<td width=''>
								<font color='red'>当前用户： <s:property value="login.uname" />
								</font>
							</td>
						</tr>
						<tr>
							<td width='150'>
								<a href="fwxx_list">管理我的租房信息</a>
							</td>
						</tr>
						<tr>
							<td width='100'>
								<a href="fwxx_postJD">发布租房信息</a>
							</td>
						</tr>
						<tr>
							<td width='100'>
								<a href="user_goIndex">[注销]</a>
							</td>
						</tr>
					</table>
					<style>
td {
	border: solid 0px blue;
}

.table_title {
	border: solid 1px #aaa;
	border-width: 0 0 1px 0;
}
</style>
				</td>

				<td width="35" background="images/layout_24.gif">
					&nbsp;
				</td>
				<td width="495" align="center">
					<br />
					<form action="fwxx_pageList" method="post" name="mf">
						<input type="hidden" name="page" value="1" />
						<script>
function fswitch(id) {
	var o = document.getElementById(id);
	if (o) {
		if (o.style.display == "none") {
			o.style.display = "block";
		} else {
			o.style.display = "none";
		}
	}
}
var ajax;
function pickCityGet(){
	createAjax();
	var id=document.getElementById("quxian").value;
	var method = "get";//提交方式
	var url = "jd_ajax?tbl_qx.qxid="+id;//请求的资源的url
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
			
						<div style="text-align: left; width: 88%;">
							<input name="qv.title">
							<input type="submit" value="查询" class="btn">
							<span onclick="fswitch('advSearch');"
								style="cursor: hand; color: blue;">高级搜索</span>
						</div>

						<table width="88%;" id="advSearch"
							style="border: solid 0px #000; display: none;">

							<tr>
								<td>
									区县：
								</td>
								<td>
									<select name="qv.qu" id="quxian" onchange="pickCityGet()">
										<option value="-1">--请选择--</option>
										<s:iterator value="listQX" var="list">
											<option  value="<s:property value='#list.qxid'/>"><s:property value='#list.qx'/></option>
										</s:iterator>
									</select>
								</td>
								<td rowspan="6">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td>
									街道：
								</td>
								<td>
									<select id="jdid" name="qv.jieDao" style="width: 80">
										<option value="-1">
											--不限--
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									租金：
								</td>
								<td>
									<input type="text" name="qv.zhujingStare" size="5" class="unnamed1">
									至
									<input type="text" name="qv.zhujingEnd" size="5" class="unnamed1">
									元/月
								</td>
							</tr>
							<tr>
								<td>
									户型：
								</td>
								<td>
									<select name="qv.shi" style="width: 60">
										<option value="-1">
											不限--
										</option>
										<option value="1">
											1
										</option>
										<option value="2">
											2
										</option>
										<option value="3">
											3
										</option>
										<option value="4">
											4
										</option>
										<option value="5">
											5
										</option>
										<option value="6">
											6
										</option>
										<option value="7">
											7
										</option>
										<option value="8">
											8
										</option>
										<option value="9">
											9
										</option>
									</select>
									室
									<select name="qv.ting" style="width: 60">
										<option value="-1">
											不限--
										</option>
										<option value="1">
											1
										</option>
										<option value="2">
											2
										</option>
										<option value="3">
											3
										</option>
										<option value="4">
											4
										</option>
										<option value="5">
											5
										</option>
									</select>
									厅
								</td>
							</tr>
							<tr>
								<td>
									房屋类型：
								</td>
								<td>
									<input value="1" type="checkbox" name="qv.houseType">
									地下室
									<input value="2"  type="checkbox" name="qv.houseType">
									平房
									<input value="3" type="checkbox" name="qv.houseType">
									普通住宅
									<input value="4" type="checkbox" name="qv.houseType">
									公寓
									<input value="5" type="checkbox" name="qv.houseType">
									别墅
								</td>
							</tr>
							<tr>
								<td>
									发布日期：
								</td>
								<td>
									<select name="qv.publishDate" style="width: 80">
										<option value="-1">
											不限--
										</option>
										<option value="1">
											当天
										</option>
										<option value="2">
											近两天
										</option>
										<option value="3">
											近三天
										</option>
										<option value="7">
											近一周
										</option>
										<option value="14">
											近两周
										</option>
										<option value="30">
											近一月
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan='3'>
									<hr />
								</td>
							</tr>

						</table>
						<table width="88%" cellspacing="0">
							<tr>
								<TD width='250' class="table_title">
									标题
								</TD>
								<TD width='90' align='center' class="table_title">
									月租金
								</TD>
								<TD align='center' class="table_title">
									发布日期
								</TD>
							</tr>
							<s:iterator value="user_list" var="list">
								<tr>
									<td>
										<a href='fwxx_listDetail?tbl_fwxx.fwid=<s:property value='#list.fwid'/>'><s:property value="#list.title"/> </a>
									</td>
									<td align='center' style='height: 30px;'>
										<s:property value="#list.zj"/>
									</td>
									<td align='center'>
										<s:property value="#list.publishdate"/>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td colspan="3" align="center" >
									<px:fy pageIndex="${pageindex}" pageSize="${pageizeZD}" pageUrl="${URL}" ></px:fy>
								</td>
							</tr>
							<tr>
								<td colspan='3'>
									<hr />
								</td>
							</tr>
						</table>
					</form>
				</td>
				<td width="40" background="images/middle4.jpg">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<img src="images/bottom.jpg" width="780" height="82">
				</td>
			</tr>
		</table>
		<P align="center">
			2007 Beijing Aptech Beida Jade Bird Information Technology Co.,Ltd
			版权所有
		</P>
		<br />
	</BODY>
</HTML>