<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="罗海兵" />
		<meta http-equiv="keywords" content="E货源,登陆,前台" />
		<meta http-equiv="description" content="E货源网站前台登陆页面" />
		<title>E货源--会员登陆</title>
		<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="res/css/memberLogin.css"/>
	</head>
	<body>
		<div id="loginModal">
			<div class="col-left"></div>
			
			<div class="col-right">
				<div class="modal-header">
					<h4 class="modal-title">登陆</h4>
					<span class="modal-close">×</span>
				</div>
				
				<div class="modal-body">
					<section id="box-login" class="box-login v5-input-txt">
						<form action="" id="login_form">
							<ul>
								<li class="marginB10">
									<input type="text" name="mbPhones" class="form-control" placeholder="请输入用户名/手机号"/>
								</li>
								
								<li class="marginB10">
									<input type="password" name="mbLoginPwd" type="password" class="form-control" placeholder="请输入密码"/>
								</li>
							</ul>
						</form>
						<p class="good-tips marginB10">
							还没有账号？
							<a href="javascript:;" target="_blank">立即注册</a>
							<a href="javascript:;" target="_blank">忘记密码？</a>
						</p>
						
						<div class="login-box marginB10">
							<input type="button" id="logins" class="btn" value="登陆"/>
							<div id="login-form-tips" class="tips-error bg-danger" style="display: none;">错误提示</div>
						</div>
						
						<div class="threeLogin">
							<span>其他方式登录</span>
							<a class="nqq" href="javascript:;"></a>
							<a class="nwx" href="javascript:;"></a>
						</div>
					</section>
				</div>
			</div>
		</div>
	</body>
</html>