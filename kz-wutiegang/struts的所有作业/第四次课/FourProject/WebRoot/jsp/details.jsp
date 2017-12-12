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

		<title>My JSP 'details.jsp' starting page</title>

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
	</head>

	<body>
	<s:debug></s:debug>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="images/logo.gif">
			</DIV>
			<DIV class=search>
				<FORM method=get>
					<INPUT class=text type=text name=keywords>
					<LABEL class="ui-green searchs">
						<a href="list.htm" target="_blank">搜索房屋</a>
					</LABEL>
				</FORM>
			</DIV>
		</DIV>
		<DIV id=navbar class=wrap>
			<DL class="search clearfix">
				<FORM id=sform method=post action=search.action>
					<DT>
						<UL>
							<LI class=bold>
								房屋信息
							</LI>
							<LI>
								标题：
								<INPUT class=text type=text name=title>
								<LABEL class=ui-blue>
									<INPUT onclick=doSearch() value=搜索房屋 type=button name=search>
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
								<SELECT id=price name=queryPrice>
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
								
								<%--<s:select list="slist" listKey="id" listValue="name" name="" headerKey="-1" headerValue="不限"></s:select>
							--%></LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>
								房型
							</LI>
							<LI>
								<%--<s:select list="tlist" listKey="id" listValue="name" name="" headerKey="-1" headerValue="不限"></s:select>
							--%></LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>
								面积
							</LI>
							<LI>
								<SELECT id=floorage name=area>
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
		<DIV id=position class=wrap>
			当前位置：青鸟租房网 - 浏览房源
		</DIV>
		<DIV id=view class="main wrap">
			<DIV class=intro>
				<DIV class=lefter>
					<H1>
						大房子
					</H1>
					<DIV class=subinfo>
						2013-06-28 14:06:33.0
					</DIV>
					<DIV class=houseinfo>
						<P>
							户 型：
							<SPAN>一室一厅</SPAN>
						</P>
						<P>
							面 积：
							<SPAN>100m<SUP>
									2
								</SUP>
							</SPAN>
						</P>
						<P>
							位 置：
							<SPAN>海淀区中关村大街</SPAN>
						</P>
						<P>
							联系方式：
							<SPAN>123456789</SPAN>
						</P>
					</DIV>
				</DIV>
				<DIV class=side>
					<P>
						<A class=bold href="http://localhost:8080/House-2/#">北京青鸟房地产经纪公司</A>
					</P>
					<P>
						资质证书：有
					</P>
					<P>
						内部编号:1000
					</P>
					<P>
						联 系 人：
					</P>
					<P>
						联系电话：
						<SPAN></SPAN>
					</P>
					<P>
						手机号码：
						<SPAN>暂无</SPAN>
					</P>
				</DIV>
				<DIV class=clear></DIV>
				<DIV class=introduction>
					<H2>
						<SPAN><STRONG>房源详细信息</STRONG>
						</SPAN>
					</H2>
					<DIV class=content>
						<P>
							就是好
						</P>
					</DIV>
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


	</body>
</html>
