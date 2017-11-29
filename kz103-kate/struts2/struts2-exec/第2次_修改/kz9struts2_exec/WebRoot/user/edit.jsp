<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/comm.jsp" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${basePath}/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${basePath}/js/public.js"></script>
		<script language="javascript" src="${basePath}/js/check.js"></script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="${basePath}/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="${basePath}/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${basePath}/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="${basePath}/jquery/jquery.datepick-zh-CN.js"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#birthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
	<body>
		<form id="user_save_do" name="Form1" action="user_editSubmit" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<input type="hidden" name="user.userID" value="${user.userID}" id="userID"/>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑用户</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						登录名：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="user.logonName" value="${user.logonName}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="password" name="user.logonPwd" value="${user.logonPwd}" id="logonPwd"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						用户姓名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="user.userName" value="${user.userName}" id="userAction_save_do_userName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						性别：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<!-- %表示{}里面的符号OGNL表达式 -->
						<s:radio list="{'男','女'}" name="user.sex" value="%{user.sex}" id="sex"></s:radio>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						学历：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						<s:select name="user.education" id="education" list="{'博士','硕士','研究生','本科','专科','高中'}" value="%{user.education}"></s:select>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						出生日期：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="user.birthday" size="20" value="${user.birthday}" readonly="readonly" id="birthday"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="user.telephone" value="${user.telephone}" id="telephone"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						兴趣爱好：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
					   <s:checkboxlist list="{'看电影','旅游','健身','购物','睡觉'}" value="%{interests}" name="user.interest"></s:checkboxlist>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						简历资料：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<input type="file" name="upload" size="30" value="" id="userAction_save_do_upload"/>
						<img src="/img/${user.path}" width="80px" height="50px"/>
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						备注：
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<textarea name="user.remark" cols="30" rows="3" id="userAction_save_do_remark" style="WIDTH: 96%">${user.remark}</textarea>
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${basePath}/images/shim.gif">
					</td>
				</TR>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" name="submit" value="&#30830;&#23450;" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
		<s:debug></s:debug>




	</body>
</HTML>