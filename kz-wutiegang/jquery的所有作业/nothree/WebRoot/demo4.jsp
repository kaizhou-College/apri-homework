<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
 <!--   引入jQuery -->
 <script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
 <script>
 	$(function(){
		$("#CheckedAll").click(function(){
			if($(this).attr("checked")){
				$("input[name='items']").attr("checked",true);
			
			}else{
				$("input[name='items']").attr("checked",false);
			}
			
		});
		var length=0;
		$("input[name='items']").click(function(){
			if($(this).attr("checked")){
				length++;
			}
			if(length>3){
				$("#CheckedAll").attr("checked",true);
			}else{
				$("#CheckedAll").attr("checked",false);
			}
		});
		
		//if($("input[name='items']").attr("checked")){
			//$("#CheckedAll").attr("checked",true);
		//}
		$("#send").click(function(){
			$("input[name='items']:checked").each(function(){
					//alert($(this).val());
				alert(this.value);
			});
		
		});
	
	});
	
	
  </script>
</head>
<body>

<form>
   你爱好的运动是？<input type="checkbox" id="CheckedAll" />全选/全不选<br/>
    <input type="checkbox" name="items" value="足球"/>足球
	<input type="checkbox" name="items" value="篮球"/>篮球
	<input type="checkbox" name="items" value="羽毛球"/>羽毛球
	<input type="checkbox" name="items" value="乒乓球"/>乒乓球<br/>
	<input type="button" id="send" value="提　交"/> 
</form>

</body>
</html>
 