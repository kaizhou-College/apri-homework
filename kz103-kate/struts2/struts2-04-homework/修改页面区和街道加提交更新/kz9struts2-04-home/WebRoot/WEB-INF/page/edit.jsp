<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="comm.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<TITLE>青鸟租房 -发布房屋信息</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="${basePath}/css/style.css?+Math.random()">
		<META name=GENERATOR content="MSHTML 8.00.7601.17514">
	</HEAD>
	<BODY>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="${basePath}/images/logo.gif">
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
					<FORM id=houser_update method=post name=add.action
						action=houser_update>
						<input type="hidden" value="${house.id}" name="house.id"/>
						<DIV class=infos>
							<TABLE class=field>
								<TBODY>
									<TR>
										<TD class=field>
											标 题：
										</TD>
										<TD>
											<INPUT id=add_action_title class=text type=text name=house.title value="${house.title}">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											户 型：
										</TD>
										<TD>
											<s:select list="types" listKey="id" listValue="name"  value="%{house.type_id}" name="house.type_id"></s:select>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											面 积：
										</TD>
										<TD>
											<INPUT id=add_action_floorage class=text type=text value="${house.floorage}"
												name=house.floorage>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											价 格：
										</TD>
										<TD>
											<INPUT id=add_action_price class=text type=text name=house.price value="${house.price}">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											房产证日期：
										</TD>
										<TD>
											
											<INPUT class=text type=text name=house.pubdate value="<fmt:formatDate value='${house.pubdate}' pattern='yyyy-MM-dd'/>"/>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											位 置：
										</TD>
										<TD>
											区：
											<s:select id="dises" list="dises" listKey="id" listValue="name" value="tempStreet.district_id" onchange="changeDis()" name=""></s:select>
											街：
											<s:select id="street" list="streets" listKey="id" listValue="name" value="%{tempStreet.name}"  name="house.street_id"></s:select>
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
												name=house.contact value="${house.contact}">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											详细信息：
										</TD>
										<TD>
											<TEXTAREA name=house.description> ${house.description}</TEXTAREA>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class=buttons>
								<INPUT value=立即修改
									type=submit>
								
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
	<s:debug></s:debug>
</HTML>
<<script type="text/javascript">
	var ajax;
	function changeDis(){
		//1,获取区的id
		var disId = document.getElementById("dises").value;
		//2,根据区的id查询该区所有的街道(ajax)
		//2.1获取ajax对象
		createAjax();
		//2.2拨
		var method = "get";
		var url = "street_queryById?street.district_id="+disId;
		ajax.open(method,url,true);
		//2.3打
		ajax.send(null);
		//2.4接
		ajax.onreadystatechange=bk;
		
		
	}
/*<streets>
 * 	<street id="1000">
 * 		<name>知春路</name>
 *  </street>
 * <street id="1001">
 * 		<name>中关村大街</name>
 *  </street>
 * <streets>
 */
	function bk(){
		if(ajax.readyState==4 &&ajax.status==200){
			var xmlObj = ajax.responseXML;
			var streetNodes = xmlObj.getElementsByTagName("street");
			
			//获取街道Select
			var street = document.getElementById("street")
			street.options.length=0;
			for(var i=0;i<streetNodes.length;i++){
				var sid	= streetNodes[i].getAttribute("id");
				var sname = streetNodes[i].childNodes[0].childNodes[0].nodeValue;
				//alert(sid+"---------"+sname);
				var opt = new Option(sname,sid);
				street.add(opt)
			}
		}
	}
	function createAjax(){
	 //判断浏览器的版本:IE7或以上 FF...
	 if(window.XMLHttpRequest){
		 ajax = new XMLHttpRequest();
	 }else{
		 ajax = new AtiveXObject("Microsoft.XMLHTTP");
	 }
}
</script>

