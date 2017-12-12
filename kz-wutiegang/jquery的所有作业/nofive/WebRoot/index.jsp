<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="comm.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
  </head>
  <body>
   	省:<select id="province">
   			<option value="-1">--请选择省份--</option>
   	  </select>
   	  <%--
   	省:<select id="province2">
   			<option>--请选择省份--</option>
   	  </select>
  --%>	
	     城市 :<select id="city">
	   			<option value="-1">--请选择城市--</option>
	   	  </select>
	     县区 :<select id="district">
	   			<option value="-1">--请选择区县--</option>
	   	  </select>

  </body>
</html>
<script type="text/javascript">
	$(function(){
		$.ajax({
				type:"POST",
				url:"province_pc",
				success:function(data){
					for(var i=0;i<data.query.length;i++){
						$("#province").append("<option value="+data.query[i].pid+">"+data.query[i].pname+"</option>");
					}
				}
			});
		$("#province").change(function(){
			var $value=$("#province option:selected").val();
			$.ajax({
				url:"province_pToc",
				data:{"province.pid":$value},
				success:function(data){
					//$("#city")[0].options.length=1;
					$("#city option:gt(0)").remove();
					$("#district option:gt(0)").remove();
					//$("#city").options.length=1;
					for(var i=0;i<data.city.length;i++){
						$("#city").append("<option value="+data.city[i].cid+">"+data.city[i].cname+"</option>");
						
					}
					
				}
			});			
			
			
		});
		$("#city").change(function(){
			var $value=$("#city option:selected").val();
			$.ajax({
				url:"city_cTod",
				data:{"city.cid":$value},
				success:function(data){
					//$("#city")[0].options.length=1;
					$("#district option:gt(0)").remove();
					//$("#city").options.length=1;
					for(var i=0;i<data.district.length;i++){
						$("#district").append("<option value="+data.district[i].did+">"+data.district[i].dname+"</option>");
						
					}
					
				}
			});			
			
			
		});
		
		
		
	});
	


</script>