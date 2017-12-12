<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="comm.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<s:debug></s:debug>
<body>
<div class="wrap">
  <!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
          <dl>
          <form action="Auction_update" method="post" enctype="multipart/form-data">
            <dd >
              <label>名称：</label>
              <input type="hidden" value="${action.auctionid }" name="action.auctionid"/>
              <input type="text" class="inputh lf" value="${action.auctionname }" name="action.auctionname"/>
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" class="inputh lf" value="${action.auctionstartprice }"  name="action.auctionstartprice"/>
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>底价：</label>
              <input type="text" class="inputh lf" value="${action.auctionupset }"  name="action.auctionupset"/>
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input type="text" class="inputh lf" value="${action.auctionstarttime }" name="action.auctionstarttime"/>
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" class="inputh lf" value="${action.auctionendtime }" name="action.auctionendtime"/>
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd class="dds">
              <label>描述：</label>
              <textarea name="action.auctiondesc" cols="" rows="" class="textarea">${action.auctiondesc }</textarea>
            </dd>
            <dd>
              <label>修改图片：</label>
			${action.auctionpic}
              <div class="lf salebd"><a href="#"><img src="images/${action.auctionpic}" width="100" height="100" /></a></div>
               <input name="upload" type="file" class="marg10"/>
            </dd>
            <dd class="hegas">
                <input type="submit" value="更新" class="spbg buttombg buttombgs f14 lf buttomb" />
                <a href="Auction_find" class="spbg buttombg buttombgs f14 lf buttomb" />取消</a>
                
            </dd>
            </form>
          </dl>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
</div>
</body>
</html>
