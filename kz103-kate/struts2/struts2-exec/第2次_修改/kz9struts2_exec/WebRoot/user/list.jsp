<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/comm.jsp" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${basePath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${basePath}/js/public.js"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "${basePath}/user/add.jsp";
			}
			function DoGo(max){
				alert(11);
				//获取文本框输入的值
				var newPage = document.getElementById("ipage").value;
				//设置到隐藏框
				document.getElementById("hpage").value=newPage;
				alert(document.getElementById("hpage").value);
				document.getElementById("Form1").submit()
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${basePath}/user_list" method="post">
			<input type="hidden" id="hpage" name="page" value="${page}"/>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 条 件</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										用户姓名
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<input type="text" name="userName" size="15" value="${userName}" id="Form1_userName" class="bg"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										性别：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'男','女'}" name="sex"  value="%{sex}" headerKey=" "  headerValue="--选择性别--"></s:select>
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										学历：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'博士','研究生','本科','专科','高中'}" name="education" value="%{education}" headerKey=" " headerValue="--选择学历--"></s:select>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										是否上传简历
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="#{'1':'有','0':'无'}"  name="isUpload" headerKey="-1" headerValue="--是否上传--"></s:select>

									</td>
								</tr>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<button type="submit" id="search" name="search" value="&#26597;&#35810;" class="button_view">
&#26597;&#35810;
</button>

										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" name="reset" value="&#37325;&#32622;" class="button_view"/>

									</td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用 户 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										登录名
									</td>
									<td align="center" width="17%">
										用户姓名
									</td>
									<td align="center" width="8%">
										性别
									</td>
									<td align="center" width="23%">
										联系电话
									</td>
									<td width="11%" align="center">
										学历
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										查看
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<s:iterator value="users">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">
										${logonName}
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">
										<s:property value="userName"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">
										<s:property value="sex"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23%">
										<s:property value="telephone"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										<s:property value="education"/>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<a href="${basePath}/user_edit?user.userID=${userID}"> <img
												src="${basePath}/images/i_edit.gif" border="0"
												style="CURSOR: hand"> </a>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<a href="${basePath}/user/view.jsp?userID=15"> <img
												src="${basePath}/images/button_view.gif" border="0"
												style="CURSOR: hand"> </a>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<a href="${basePath}/user/list.jsp?userID=15"> <img
												src="${basePath}/images/i_del.gif" width="16" height="16"
												border="0" style="CURSOR: hand"> </a>
									</td>
								</tr>
							</s:iterator>
							</table>
							<kz:kzPage max="${max}" url="user_list" page="${page}"></kz:kzPage>
						</td>
					</tr>
					
				</TBODY>
			</table>
		</form>
		<s:debug></s:debug>
	</body>
</HTML>

