<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="comm.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'FaBu.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<TITLE>青鸟租房 -发布房屋信息</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="css/style.css">
		<META name=GENERATOR content="MSHTML 8.00.7601.17514">
		<script type="text/javascript">
			var ajax;
			function qu(){
				Ajax();
				var dis=document.getElementById("district").value;
				var method="get";
				var url="daAction_ds?did="+dis+"&"+Math.random();
				ajax.open(method,url,true);
				ajax.send(null);
				ajax.onreadystatechange=ds;
				
			}
		function ds(){
			if(ajax.readyState==4&&ajax.status==200){
				var xml=ajax.responseXML;
				//得到属性
				//alert(xml);
				var street=xml.getElementsByTagName("street");
				//得到街道的对象
				var objstreet=document.getElementById("street");
				//alert("111");
				objstreet.options.length=0;
				//alert("22");
				for(var i=0;i<street.length;i++){
					var id=street[i].getAttribute("id");
					var name=street[i].childNodes[0].childNodes[0].nodeValue;
					
					var opt=new Option(name,id);
					objstreet.add(opt);
				}
				
			}

		}
		
		
			function Ajax() {
				//判断浏览器的版本：ie7或以上
				if (window.XMLHttpRequest) {
					ajax = new XMLHttpRequest();
				} else {
					ajax = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
</script>
	</head>

	<body>
		<s:debug></s:debug>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id=regLogin class=wrap>
			<DIV class=dialog>
				<DL class=clearfix>
					<DT>
						新房屋信息发布
					</DT>
					<DD class=past>
						填写房屋信息
					</DD>
				</DL>
				<DIV class=box>
					<FORM id=add_action method=post name=add.action action=ManagerAction_update>
						<DIV class=infos>
							<TABLE class=field>
								<TBODY>
									<TR>
									
										<TD class=field>
											标 题：
										</TD>
										<TD>
										<input type="hidden" name="house.id" value="${house.id}"/>
											<INPUT id=add_action_title class=text type=text name=house.title
												value="${house.title }">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											户 型：
										</TD>
										<TD>
											<s:select list="tlist" listKey="id" listValue="name" name="house.type_id"
												value="%{house.type_id}"></s:select>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											面 积：
										</TD>
										<TD>
											<INPUT id=add_action_floorage class=text type=text
												value="${house.floorage }" name=house.floorage>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											价 格：
										</TD>
										<TD>
											<INPUT id=add_action_price class=text type=text name=house.price
												value="${house.price }">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											房产证日期：
										</TD>
										<TD>
											<INPUT class=text type=text name=house.pubdate
												value="${house.pubdate }">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											位 置：
										</TD>
										<TD>
											区：
											<s:select id="district" list="dlist" listKey="id" onchange="qu()" name="house.district"
												listValue="name" value="%{diBySid}"></s:select>
											街：

											<s:select id="street" list="slist" listKey="id" name="house.street_id"
												listValue="name" value="%{house.street_id}"></s:select>
										</TD>
									</TR>
									<!-- 
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						-->
									<!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
									<TR>
										<TD class=field>
											联系方式：
										</TD>
										<TD>
											<INPUT id=add_action_contact class=text type=text
												value="${house.contact }" name=house.contact>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											详细信息：
										</TD>
										<TD>
											<TEXTAREA name=house.description>${house.description }</TEXTAREA>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class=buttons>
								<INPUT value=立即修改 type="submit">
							</DIV>
						</DIV>
					</FORM>
				</DIV>
			</DIV>
		</DIV>
		<DIV id=footer class=wrap>
			<DL>
				<DT>
					青鸟租房 © 2010 北大青鸟 京ICP证1000001号
				</DT>
				<DD>
					关于我们 · 联系方式 · 意见反馈 · 帮助中心
				</DD>
			</DL>
		</DIV>
	</BODY>
</HTML>

</body>
</html>

