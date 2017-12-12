<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="comm.jsp"  %>
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

		<title>My JSP 'Manager.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<TITLE>青鸟租房 - 用户管理</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="css/style.css">
		<META name=GENERATOR>
		
	</head>

	<body>


		<BODY>
			<s:debug></s:debug>
			<DIV id=header class=wrap>
				<DIV id=logo>
					<IMG src="images/logo.gif">
				</DIV>
				<DIV class=search>
					<LABEL class="ui-green searchs">
						<a href="ManagerAction_fabu" title="">发布房屋信息</a>
					</LABEL>
					<LABEL class=ui-green>
						<INPUT onclick='document.location="outAction_out"' value="退       出"
							type=button name=search>
					</LABEL>
				</DIV>
			</DIV>
			<DIV class="main wrap">
				<DIV id=houseArea>
					<TABLE class=house-list>
						<TBODY>
							<s:iterator value="houseview" var="house">
							
								<TR>
									<TD class=house-thumb>
										<SPAN><A href="jsp/details.jsp" target="_blank"><img
													src="images/thumb_house.gif" width="100" height="75" alt="">
										</A> </SPAN>
									</TD>
									<TD>
										<DL>
											<DT>
												<A href="ManagerAction_query" target="_blank"><s:property value="#house.title"/></A>
											</DT>
											<DD>
												<s:property value="#house.ds"/>,<s:property value="#house.floorage"/>平米
												<BR>
												联系方式：<s:property value="#house.contact"/>
											</DD>
										</DL>
									</TD>
									<TD class=house-type>
										<LABEL class=ui-green>
											<INPUT onclick=update(<s:property value="#house.id"/>) value="修    改" type=button
												name=search>
										</LABEL>
									</TD>
									<TD class=house-price>
										<LABEL class=ui-green>
											<INPUT onclick="shanchu(<s:property value="#house.id"/>)" value="删    除"
												type=button name=search>
										</LABEL>
									</TD>
								</TR>
							</s:iterator>
						</TBODY>
					</TABLE>
				</DIV>
				<DIV class=pager>
				
					<kz:page max="${max}" url="ManagerAction_manager" page="${page}"></kz:page>
				</DIV>
			</DIV>
			<DIV id=footer class=wrap>
				<DL>
					<DT>
						湖南租房 © 2017 湖南南站  京ICP证1000001号
					</DT>
					<DD>
						关于我们 · 联系方式 · 意见反馈 · 帮助中心
					</DD>
				</DL>
			</DIV>
		</BODY>
</HTML>
<script type="text/javascript">
			function update(id){
				location.href="ManagerAction_edit?hid="+id;
			}
			function shanchu(sid){
				
				location.href="shanchuAction_shanchu?sid="+sid;
			}
		</script>

