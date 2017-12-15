<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
    	
    	$(document).ready(function(){
	  		$("#province").mousedown(function(){
	  			$.ajax({
		  			type:"post",
		  			url:"ajax_sf",
		  			success:function(data){
						var province=document.getElementById("province");
						province.options.length=0;
		  				for(i=0;i<data.listProv.length;i++){
		  					$("#province").append("<option value='"+data.listProv[i].pid+"'>"+data.listProv[i].pname+"</option>");
		  				}
		  			},
		  			error:function(){
		  				alert("请求失败！！！");
		  			}
  				});
    		});
	  		
	  		
	  		$("#province").change(function(){
	  			var id=document.getElementById("province").value;
	  			$.ajax({
		  			type:"post",
		  			url:"ajax_cs",
		  			data:"id="+id,
		  			success:function(data){
	  				var city=document.getElementById("city");
						city.options.length=0;
		  				for(i=0;i<data.listCity.length;i++){
		  					$("#city").append("<option value='"+data.listCity[i].cid+"'>"+data.listCity[i].cname+"</option>");
		  			}
		  				
		  			},
		  			error:function(){
		  				alert("请求失败！！！");
		  			}
  				});
    		});
	  		
	  		$("#city").change(function(){
	  			var id=document.getElementById("city").value;
	  			$.ajax({
		  			type:"post",
		  			url:"ajax_qx",
		  			data:"id="+id,
		  			success:function(data){
	  				var district=document.getElementById("district");
						district.options.length=0;
		  				for(i=0;i<data.listDistrict.length;i++){
		  					$("#district").append("<option value='"+data.listDistrict[i].did+"'>"+data.listDistrict[i].dname+"</option>");
		  				}
		  			},
		  			error:function(){
		  				alert("请求失败！！！");
		  			}
  				});
    		});
	  		
	  		
    	});
    </script>
  </head>
  
  <body>
   	省:<select id="province" >
   			<option>--请选择省份--</option>
   	  </select>
   	  <%--
   	省:<select id="province2">
   			<option>--请选择省份--</option>
   	  </select>
  --%>	
	     城市 :<select id="city">
	   			<option>--请选择城市--</option>
	   	  </select>
	     县区 :<select id="district">
	   			<option>--请选择区县--</option>
	   	  </select>
  
  </body>
</html>
