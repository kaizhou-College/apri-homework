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

		<title>My JSP 'list.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<TITLE>青鸟租房 - 首页</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="css/style.css">
		<META name=GENERATOR content="MSHTML 8.00.7601.17514">
	</head>

	<body>
		<s:debug></s:debug>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id=navbar class=wrap>
			<DL class="search clearfix">
				<FORM id=sform method=post action=ManagerAction_gaoji>
					<DT>
						<UL>
							<LI class=bold>
								房屋信息
							</LI>
							<LI>
								标题：
								<INPUT class=text type=text name=qh.title>
								<LABEL class=ui-blue>
									<INPUT value=搜索房屋 type="submit"/>
								</LABEL>
							</LI>
						</UL>
					</DT>
					<DD>
						<UL>
							<LI class=first>
								价格
							</LI>
							<LI>
								<SELECT name=qh.queryPrice >
									<OPTION selected value="-1">
										不限
									</OPTION>
									<OPTION value=1>
										100元以下
									</OPTION>
									<OPTION value=2>
										100元—200元
									</OPTION>
									<OPTION value=3>
										200元以上
									</OPTION>
								</SELECT>
							</LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>
								房屋位置
							</LI>
							<LI>
								<s:select list="slist" listKey="id" listValue="name" name="qh.address" headerKey="-1"headerValue="不限"></s:select>
							</LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>
								房型
							</LI>
							<LI>
								<s:select list="tlist" listKey="id" listValue="name" name="qh.housemodal" headerKey="-1"headerValue="不限"></s:select>
							</LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>
								面积
							</LI>
							<LI>
								<SELECT name=qh.area>
									<OPTION selected value="-1">
										不限
									</OPTION>
									<OPTION value=1>
										40以下
									</OPTION>
									<OPTION value=2>
										40-500
									</OPTION>
									<OPTION value=3>
										500以上
									</OPTION>
								</SELECT>
							</LI>
						</UL>
					</DD>
				</FORM>
			</DL>
		</DIV>
		<DIV class="main wrap">
			<TABLE class=house-list>
				<TBODY>
					<s:iterator value="houseview" var="house">
						<TR>
							<TD class=house-thumb>
								<span><A href="jsp/details.jsp" target="_blank"> <img
											src="images/thumb_house.gif" width="100" height="75" alt="">
								</a>
								</span>
							</TD>
							<TD>
								<DL>
									<DT>
										<A href="jsp/details.jsp" target="_blank"><s:property
												value="#house.title" />
										</A>
									</DT>
									<DD>
										<s:property value="#house.ds" />
										,
										<s:property value="#house.floorage" />
										平米
										<BR>
										联系方式：
										<s:property value="#house.contact" />
									</DD>
								</DL>
							</TD>
							<TD class=house-type>
								<s:property value="#house.type" />
							</TD>
							<TD class=house-price>
								<SPAN><s:property value="#house.price" />
								</SPAN>元/月
							</TD>
						</TR>
					</s:iterator>
				</TBODY>
			</TABLE>
			<DIV class=pager>
				<kz:page max="${max}" url="ManagerAction_query" page="${page}"></kz:page>
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
	</body>
</html>
