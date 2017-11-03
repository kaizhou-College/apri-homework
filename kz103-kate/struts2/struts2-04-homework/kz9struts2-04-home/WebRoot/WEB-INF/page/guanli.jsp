<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="comm.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<TITLE>青鸟租房 - 用户管理</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="${basePath}/css/style.css">
		
		<META name=GENERATOR>
	</HEAD>
	<BODY>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="${basePath}/images/logo.gif">
			</DIV>
			<DIV class=search>
				<LABEL class="ui-green searchs">
					<a href="fabu.htm" title="">发布房屋信息</a>
				</LABEL>
				<LABEL class=ui-green>
					<INPUT onclick='document.location="index.jsp"' value="退       出"
						type=button name=search>
				</LABEL>
			</DIV>
		</DIV>
		<DIV class="main wrap">
			<DIV id=houseArea>
				<TABLE class=house-list>
					<TBODY>
						<s:iterator value="houseViews" var="hv">
						<TR>
							<TD class=house-thumb>
								<SPAN><A href="details.htm" target="_blank"><img
											src="${basePath}/images/thumb_house.gif" width="100" height="75"
											alt="">
								</A>
								</SPAN>
							</TD>
							<TD>
								<DL>
									<DT>
										<A href="details.htm" target="_blank"><s:property value="#hv.title"/> </A>
									</DT>
									<DD>
										<s:property value="#hv.districtStreet"/> ,<s:property value="#hv.floorage"/>平米
										<BR>
										联系方式：<s:property value="#hv.contact"/>
									</DD>
								</DL>
							</TD>
							<TD class=house-type>
								<LABEL class=ui-green>
									
									<INPUT onclick=update(<s:property value="#hv.id"/>) value="修    改" type=button
										name=search>
								
								</LABEL>
							</TD>
							<TD class=house-price>
								<LABEL class=ui-green>
									<INPUT value="删    除" type=button name=search>
								</LABEL>
							</TD>
						</TR>
						</s:iterator>
					</TBODY>
				</TABLE>
			</DIV>
			<DIV class=pager>
				<kz:kzPage max="${max}" url="houser_list" page="${page}"></kz:kzPage>
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
<script type="text/javascript">
	function update(hid){
		//alert(1);
		//根据id查询当前的房屋信息
		location.href="houser_edit?house.id="+hid;
	}

</script>


