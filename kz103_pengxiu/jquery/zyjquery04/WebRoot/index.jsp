<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/area.js"></script>
    
  </head>
  
  <body>
   	省:<select id="province">
   			<option value="-1">--请选择省份--</option>
   	  </select>
	     城市 :<select id="city">
	   			<option value="-1">--请选择城市--</option>
	   	  </select>
	     县区 :<select id="district">
	   			<option value="-1">--请选择区县--</option>
	   	  </select>
  <script type="text/javascript">
  //最开始页面加载的时候就 省份显示ajax
  	$(document).ready(function(){
  		$.ajax({
  			url:"actionajax_sfList",
  			type:"POST",
  			success:function(data){
  			var province=document.getElementById("province");
  			var city=document.getElementById("city");
  			var district=document.getElementById("district");
			district.options.length=1;
  			city.options.length=1;
  			province.options.length=1;
  				for(var i=0;i<data.sfList.length;i++){
  					$("#province").append("<option value='"+data.sfList[i].sfid+"'>"+data.sfList[i].sf+"</option>");
  				}
  			},
  			error:function(){
  				alert("傻逼请求失败啦!");
  			}
  		});
  	});
  //选中省份后就查询区县的ajax
  		$("#province").change(function(){
  			var id=document.getElementById("province").value;
			$.ajax({
				url:"actionajax_qxList",
				type:"POST",
				data:"id="+id,
				success:function(data){
  				var city=document.getElementById("city");
  				var district=document.getElementById("district");
				district.options.length=1;
  				city.options.length=1;
					for(var i=0;i<data.qxList.length;i++){
  						var opt=new Option(data.qxList[i].qx,data.qxList[i].qxid);
  						city.add(opt);
  					}
				},
				error:function(){
					alert("傻逼请求失败啦!");
				}
			});
  		});
  		
 //选中区县后查询街道的ajax
 	$("#city").change(function(){;
 		var id=document.getElementById("city").value;
		$.ajax({
			url:"actionajax_jdList",
			type:"POST",
			data:"id="+id,
			success:function(data){
			var district=document.getElementById("district");
			district.options.length=1;
			for(var i=0;i<data.jdList.length;i++){
				var opt=new Option(data.jdList[i].jd,data.jdList[i].jdid);
				district.add(opt);
			}
			},
			error:function(){
				alert("傻逼请求失败啦!");
			}
		}); 		
 	});
  </script>
  
  
  
  
  
  
  </body>
</html>
