<%@ page language="java"  import="java.util.*,entity.*,dao.*"  pageEncoding="UTF-8"%>
<%@taglib uri="http://www.yunyunsTag.com/jsp/jstl/core" prefix="yt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script type="text/javascript">
  	function doDel(id){
  		if(confirm("确定删除吗?")){
  			//如果点击了确定：要删除指定id的数据
  			alert(id);
  			location.href="DoDelete?id="+id;
  		}
  	
  	}
  	
  	function DoGo(max){
  			//取出用户输入的页数
  		var jpage = document.getElementById("ipage").value;
  		//alert(typeof(jpage));
  		//jpage是string类型  转为整数
  		if(!isNaN(jpage)){
  			jpage = parseInt(jpage);
  			if(jpage>0&&jpage<=max){
  				location.href="IndexSel?page="+jpage;
  			}else{
  				alert("唐雪松来了.....");
  			}
  		}else{
  				alert("唐雪松又来了.....");
  		}
  		
  	}
   </script>
  </head>
  
 <body>
 <%
   	//1,拿到doSel.jsp带过来的数据：request
   
   //取出当前是第几页数据
    int cur_page= (Integer)request.getAttribute("page");
  	//取出最大页数
  	int max = (Integer)request.getAttribute("max");
   	//2,把数据做成表格
   		List<Users> list = (List<Users>)request.getAttribute("list");//根据键去值;
    %>
    <table border="1" cellspacing="0" align="center" >
    	<tr>
    		<td>用户的编号</td>
    		<td>用户的姓名</td>
    		<td>用户的年龄</td>
    		<td>操作</td>
    	</tr>
    	<%for(int i=0;i<list.size();i++){ 
    		if(i%2==0){
    	%>
	    	<tr bgcolor="#e4e4e4">
	    	<%}else{ %>
	    	<tr>
	    	<%} %>
	    		<td><%=list.get(i).getId() %></td>
	    		<td><%=list.get(i).getName() %></td>
	    		<td><%=list.get(i).getAge()%></td>
	    		<td>
    				<a href="#">详情</a>
    				<!-- 伪链接：调到js的方法中  参数是数字 不需要''  如果不是数字 需要打''-->
    				<a href="javascript:doDel(<%=list.get(i).getId()%>)">删除</a>
    			</td>
	    	</tr>
    	
    	<%} %>
   </table>
 
	<yt:queryByPage max="${max}" page="${page}"></yt:queryByPage>
	
  </body>
</html>
