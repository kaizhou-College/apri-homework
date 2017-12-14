<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <SCRIPT type="text/javascript">
    	$(document).ready(function(){
    		$("#pid").change(function(){
    		document.getElementById("city").options.length=1;
    		document.getElementById("district").options.length=1;
    			var p = $(this).val();
    			$.ajax({
    				url:"Province_queryByPid",
    				type:"GET",
    				data:{"pid":p},
    				success:function(data){
    					for(var i=0;i<data.clist.length;i++){
    						$("#city").append("<option value="+data.clist[i].dd+">"+data.clist[i].cname+"</option>");
						}
    				}
    			});
    		});
    		$("#city").change(function(){
    		document.getElementById("district").options.length=1;
    			var p = $(this).val();
    			$.ajax({
    				url:"Province_queryByCid",
    				type:"GET",
    				data:{"cid":p},
    				success:function(data){
    					alert(1);
    					for(var i=0;i<data.dlist.length;i++){
    						$("#district").append("<option value="+data.dlist[i].did+">"+data.dlist[i].dname+"</option>");
						}
    				}
    			});
    		});
    	});
    </SCRIPT>
  </head>
  
  <body>
  	省:<s:select list="plist" listKey="pid" listValue="pname" name="pid" headerKey=""  headerValue="--请选择--" ></s:select>
	     城市 :<select id="city">
	   			<option>--请选择城市--</option>
	   	  </select>
	     县区 :<select id="district">
	   			<option>--请选择区县--</option>
	   	  </select>
  
  </body>
</html>
