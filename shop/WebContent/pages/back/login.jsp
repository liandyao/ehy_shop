<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录</title>
<meta name="author" content="DeathGhost">
<link rel="stylesheet" type="text/css" href="res/css/styles_login.css" tppabs="res/css/styles_login.css">
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/js/Particleground.js"  tppabs="res/js/Particleground.js"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
		//验证码
		/* createCode(); */
	});
	
	/**
		按键监听
	*/
	document.onkeydown=function(event){   
        var e = event || window.event || arguments.callee.caller.arguments[0];   
        if(e && e.keyCode==13){ //按 Enter，按回车键登录
        	login();
        }
     };    
	
     /**
     	登录
     */
	function login() {
		var url = "<%=basePath%>manager/back/login.action";
		var data = {
			"manUser" : $("#manUser").val(),
			"manPwd" : $("#manPwd").val()
		};
		$.post(url, data, function(info) {
			if (info == 1) {
				location.href = "<%=basePath%>pages/back/homePage.jsp";
			} else {
				$("#manUser").val("");
				$("#manPwd").val("");
				$("#manUser").attr("placeholder","用户名或者密码错误");
				$("#manPwd").attr("placeholder","用户名或者密码错误");
			}
		});
	}
	
</script>
</head>
<body>
	<dl class="admin_login">
		<dt>
			<strong>E货源后台管理系统</strong> <em>Management System</em>
		</dt>
		<dd class="user_icon">
			<input placeholder="账号" class="login_txtbx" type="text" name="manUser" id="manUser">
		</dd>
		<dd class="pwd_icon">
			<input placeholder="密码" class="login_txtbx" type="password" name="manPwd" id="manPwd">
		</dd>
		<!-- <dd class="val_icon">
			<div class="checkcode">
				<input id="J_codetext" placeholder="验证码" maxlength="4"
					class="login_txtbx" type="text">
				<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
			</div>
			<input value="验证码核验" class="ver_btn" onclick="validate();"
				type="button">
		</dd> -->
		<dd>
			<input value="立即登陆" class="submit_btn" type="button" onclick="login()" />
		</dd>
		<!-- <dd> 
			<p>© 2017-2026 e货源 版权所有</p>
		</dd> -->
	</dl>


</body>
</html>