<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ok.jsp' starting page</title>
    <script type="text/javascript">
    	function SB(){
    		alert("大佬好棒棒");
    		window.location="fw_queryByUid.action?uid=${user.uuid}";
    	}
    	window.onload=SB;
    </script>
  </head>
  <body>
  </body>
</html>
