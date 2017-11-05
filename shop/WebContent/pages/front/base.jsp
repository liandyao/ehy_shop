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
		<meta name="author" content="罗海兵" />
		<meta http-equiv="keywords" content="E货源,模板,前台" />
		<meta http-equiv="description" content="E货源网站前台页眉、页脚模板页面" />
		<title>E货源--布局模板</title>
		<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="res/css/common.css"/>
		<link rel="stylesheet" href="res/css/glyphicon.css">
		<script src="res/js/jquery-2.1.4.min.js"></script>
		<style type="text/css">
			/* 主体内容样式区       start  */
			#main{
				width: 100%;
				margin-bottom: 10px;
				margin-left: auto;
				margin-right: auto;
			}
			#main .content{
				background-color: #eee;
				height: 800px;
			}
		</style>
		<script type="text/javascript">
			$(function() {
				loadStation();
			});
			function link(obj,id){
				$("div.links-li li").removeClass("active");
				$(obj).parents("li").addClass("active");
				$(".links-li li > div").removeClass("active");
				$(obj).parents("li").prev().find("div").addClass("active");	
				loadImages(id);
			}
			function loadStation(){
				var url="station/back/findStation.action";
				var data={"intercept":true,};
				$.post(url,data,function(arr){
					var ul=$("div.links-li > ul")[0];
					$(ul).find("li:not(:first-child)").remove();
					var index=2;
					for(var i=0;i<arr.length;i++){
						if(arr[i].stType==0){
							index=i+index;//记录默认站点所在的节点序号
						} 
						$(ul).append("<li><a href='javascript:void(0);' "+
							"onclick='link(this,&apos;"+arr[i].stId+"&apos;)'>"+arr[i].stName+"</a>"+
							"<div class='line-height'></div></li>");
					} 
					var hq=$(ul).find("li:nth-of-type("+index+") > a")[0];//得到默认站点所在的节点
					$(hq).click();
				},"json");
			}
		</script>
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
							<a href="pages/front/login.jsp?type=regist">注册</a>
						</c:if>
						
						<c:if test="${not empty login}">
						  <span class="glyphicon glyphicon-user"></span>
						  <a href="pages/front/UserCenter/userCenter.jsp">个人中心</a>
						</c:if> 
					</div>
				</div>
				<div class="links-li">
					<ul>
						<li class="text-img"><img alt="text-img" src="res/images/text-img.jpg"/></li>
						
					</ul>
				</div>
			</div>
			<div class="line-width bg-color"></div>
		</div>
		
		<!-- 右边工具栏  start  -->
		<div id="toolbar">
			<ul>
				<li>
					<a href="<%=basePath %>/pages/front/UserCenter/userCenter.jsp#Section5">
						<div align="center">
							<div>
								<img src="res/images/buycar.png" /><br/>
								<span class="txt" style="position: relative;top: -3px;">采购车</span>
							</div>
							<div style="margin-top: 5px;">
								<span class="number">0</span>
							</div>
							
						</div>
					</a>
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
					<a id="ceiling" href="<%=url %>#main-top">
						<div align="center">
							<div>
								<span class="glyphicon glyphicon-menu-up" aria-hidden="true"></span>
							</div>
						</div>
					</a>
				</li>
			</ul>
		</div>
		<!-- 右边工具栏  end  -->
		
		
		<div id="main">
			<div class="content">
			</div>
		</div>
		
		
		<div id="footer">
			<div class="content">
				<div class="foot-top" style="border: 1px solid red;">
					<h1 style="font-size: 20px;text-align: center;">页脚预留区</h1>
				</div>
			</div>
		</div>
		
	</body>
</html>