<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String url = request.getRequestURI()+"?"+request.getQueryString(); 
url=url.replace("?null", "");
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="刘东" />
		<meta http-equiv="keywords" content="E货源,公告列表,前台" />
		<meta http-equiv="description" content="E货源网站前台公告列表页面" />
		<title>E货源--公告列表</title>
		<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="res/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="res/css/info.css"/>
		<link rel="stylesheet" href="res/css/glyphicon.css">
		<script src="res/js/jquery-2.1.4.min.js"></script>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css"
			href="res/css/bootstrap-datepicker3.css">
		<script src="res/js/bootstrap.min.js"></script>
		<script src="res/js/news.js"></script>
		<script type="text/javascript" src="res/js/bootstrap-datepicker.min.js"></script>
		<link rel="stylesheet" type="text/css" href="res/css/news.css">
		
	</head>
	<body>
		<div id="header">
			<!-- 锚链接锚点 -->
			<a id="main-top" name="main-top"></a>
			<div class="content">
				<div class="head-top" style="border: 1px solid red;">
					<h1 style="font-size: 20px;text-align: center;">页眉预留区</h1>
				</div>
				<div class="logo">
					<img alt="logo" src="res/images/eLOGO1.jpg" style="max-height: 80px;">
					<div class="login-regist font-color-white">
						<c:if test="${empty login}">
						  	<a href="pages/front/login.jsp">登陆</a>
							<div class="line-height" style="margin: 0 5px;"></div> 
							<a href="pages/front/login.jsp?">注册</a>
						</c:if>
						
						<c:if test="${not empty login}">
						  <span class="glyphicon glyphicon-user"></span>
						  <a href="pages/front/UserCenter/userCenter.jsp">个人中心</a>
						</c:if> 
					</div>
				</div>
				<div class="links-li">
					<ul>
						<li class="text-img"><img alt="text-img" src="res/images/text-img.jpg"/><div class="line-height"></div> </li>
						
					</ul>
				</div>
			</div>
			<div class="line-width bg-color"></div>
		</div>
		
		<!-- 右边工具栏  start  -->
		<div id="toolbar">
			<ul>
				<li>
					<div align="center">
						<div>
							<img src="res/images/buycar.png" /><br/>
							<span class="txt" style="position: relative;top: -3px;">采购车</span>
						</div>
						<div style="margin-top: 5px;">
							<span class="number">0</span>
						</div>
						
					</div>
				</li>
				<li>
					<div align="center">
						<div>
							<img src="res/images/service.png"/><br/>
							<span class="txt">客服</span>
						</div>
					</div>
				</li>
				<li>
					<div align="center">
						<div>
							<img src="res/images/service-tel.png"/><br/>
							<span class="txt">客服</span>
						</div>
					</div>
				</li>
				<li>
					<div align="center">
						<div>
							<a href="<%=url %>#main-top"><span class="glyphicon glyphicon-menu-up" aria-hidden="true"></a></span>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<!-- 右边工具栏  end  -->
		
		
		<div id="main">
			<div class="content">
				<p id="ff"><font color="#ff6100" id="ff">官方</font>动态</p>
				<div class="divcss5-4"></div><!-- 虚线 -->
				<!-- content开始 -->
				<div id="content">
				
				
				</div>
				<!-- content结束 -->
				<!-- 分页开始 -->
					<div class="pages" align="center">
						<nav aria-label="Page navigation">
						  <ul class="pagination" id="ul">
						  		
						  </ul>
						</nav>
					</div>
					<!-- 分页结束 -->
			</div>
		</div>
		
		
		<div id="footer">
			<div class="content">
				<div class="foot-top" style="border: 1px solid red;">
					<h1 style="font-size: 20px;text-align: center;">页脚预留区</h1>
				</div>
			</div>
		</div>
		
		<!-- 遮罩层 -->
		<div id="hide_div"></div>
		
		<!-- 查看公告详细码弹出层  start-->
	<div id="shareDivs" style=" display: none;">
	<div style="width: 65px;height:0%;float: left;line-height: 620px;cursor: pointer;" id="closes">
			<!-- 关闭按钮  start -->
			<img src="res/images/close.png" style="width: 65px;height: 52px;"/>
			<!-- 关闭按钮  start -->
	</div>
			
		<div id="shares"  align="center">
				  <!-- 标题 -->
				  <div id="div"></div>
				  
				  <div id="div2"></div>
		</div>
		
	</div>
	<script type="text/javascript">
	$("#closes").click(function(){
		$("#hide_div").css('display','none');
		$("#shareDivs").css('display','none');
	})
	</script>
	
	</body>
</html>