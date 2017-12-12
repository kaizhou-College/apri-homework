<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
<!-- main begin-->
 <div class="main">
   <div class="sidebar">
     <p><img src="images/img1.jpg" width="443" height="314" alt="" /></p>
   </div>
   <div class="sidebarg">
     <form action="AuctionUser_ceshi" method="post" target='_blank' >
    <div class="login">
      <dl>
        <dt class="blues">用户登陆</dt>
        <dd><label for="name">用户名：</label><input type="text" class="inputh" id="name" name="actionuser.username"/></dd>
        <dd><label for="password">密 码：</label><input type="password" class="inputh" id="password" name="actionuser.userpassword"/></dd>
        
        <dd class="buttom">
           <input type="submit" value="登 录" class="spbg buttombg f14 lf" />
           <a class="spbg buttombg f14 lf" href="AuctionUser_Zhuce">注 册</a>
           
           <div class="cl"></div>
        </dd>
       
      </dl>
    </div>
    </form>
   </div>
  <div class="cl"></div>
 </div>
</div>
</div>
</body>
</html>
