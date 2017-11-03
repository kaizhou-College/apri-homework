<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="comm.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>

		<TITLE>青鸟租房 - 首页</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="${basePath}/css/style.css">
		<META name=GENERATOR content="MSHTML 8.00.7601.17514">
		
	</HEAD>
	<BODY>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="${basePath}/images/logo.gif">
			</DIV>
		</DIV>
		<DIV id=navbar class=wrap>
			<DL class="search clearfix">
				<FORM id=sform method=post action=houser_query>
					<DT>
						<UL>
							<LI class=bold>
								房屋信息
							</LI>
							<LI>
								标题：
								<INPUT class=text type=text name=qh.title>
								<LABEL class=ui-blue>
									<INPUT type="submit" value=搜索房屋 />
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
								<SELECT name=qh.queryPrice>
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
								<s:select list="streets" listKey="id" listValue="name" name="qh.street" headerKey="-1" headerValue="不限"></s:select>
							</LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>
								房型
							</LI>
							<LI>
								<s:select list="types" listKey="id" listValue="name" name="qh.type" headerKey="-1" headerValue="不限"></s:select>
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
					<s:iterator value="houseViews" var="house" status="index">
						<s:if test="#index.index%2==0">
							<TR class=odd>
						</s:if>
						<s:else>
							<TR>
						</s:else>

						<TD class=house-thumb>
							<span><A href="details.htm" target="_blank"><img
										src="${basePath}/images/thumb_house.gif" width="100"
										height="75" alt="">
							</a>
							</span>
						</TD>
						<TD>
							<DL>
								<DT>
									<A href="details.htm" target="_blank"><s:property
											value="#house.title" />
									</A>
								</DT>
								<DD>
									<s:property value="#house.districtStreet" />
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
							<s:property value="#house.typeView" />
						</TD>
						<TD class=house-price>
							<SPAN><s:property value="#house.price" /> </SPAN>元/月
						</TD>
						</TR>
					</s:iterator>
				</TBODY>
			</TABLE>
			<kz:kzPage max="${max}" url="houser_list" page="${page}"
				cssClass="pager"></kz:kzPage>

			<!--<DIV class=pager>
<UL>
  <LI class=current><A href="#">首页</A></LI>
  <LI><A href="#">上一页</A></LI>
  <LI><A href="#">下一页</A></LI>
  <LI><A href="#">末页</A></LI></UL><SPAN 
class=total>1/2页</SPAN> </DIV></DIV>
-->
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
	function DoGo(max){
  			//取出用户输入的页数
  		var jpage = document.getElementById("ipage").value;
  		//alert(typeof(jpage));
  		//jpage是string类型  转为整数
  		if(!isNaN(jpage)){
  			jpage = parseInt(jpage);
  			if(jpage>0&&jpage<=max){
  				location.href="houser_list?page="+jpage;
  			}else{
  				alert("唐雪松来了.....");
  			}
  		}else{
  				alert("唐雪松又来了.....");
  		}
  		
  	}

</script>
