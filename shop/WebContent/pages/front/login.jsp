<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/res/js/jquery-1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/res/js/login.js"></script>


<link href="${pageContext.request.contextPath }/res/css/login2.css"
	rel="stylesheet" type="text/css">



<script type="text/javascript"
	src="${pageContext.request.contextPath }/res/js/jquery.1.9.1.min.js"></script>
<title>登录界面</title>
<style type="text/css">
/* #switch a{
		color: #eee;
	} */
</style>
<script type="text/javascript">

/**
 * 获取URL参数的方法
 * @param name 属性名
 * @returns 如果存在返回对应的值,不存在返回null
 */
function getParam(name) { 
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //设置正则表达式的规则
  var url= window.location.search;//获取URL地址
  url=decodeURIComponent(url);//URL解码
  var r =url.substr(1).match(reg); 
  if (r != null) {  
    return unescape(r[2]); 
  } 
  return null; 
}

 
 function dian(){
	
		var reg = /^1[3|4|5|7|8][0-9]{9}$/;
		var account = $("#phone").val();
		if(!reg.test(account)){
			alert("请输入正确的手机号码或者邮箱");
		}else{
		}
	}
$(function(){
	var type=getParam("type");
	if(type && type=="regist"){
		$('#switch_login').click();
	}
})






</script>
<style type="text/css">
.top {
	border: 0px red solid;
}

.top-img {
	margin-bottom: 10px;
}

.img img {
	border: 0px solid red;
}
</style>
</head>


<body>
	<div class="body">
		<div class="top">
			<div class="img">
				<img src="${pageContext.request.contextPath }/res/images/eLOGO.png"
					width="190"> <img class="top-img"
					src="${pageContext.request.contextPath }/res/images/top_1.jpg"
					width="190"> <img class="top-img"
					src="${pageContext.request.contextPath }/res/images/top_2.jpg"
					width="190"> <img class="top-img"
					src="${pageContext.request.contextPath }/res/images/top_3.jpg"
					width="150"> <img class="top-img"
					src="${pageContext.request.contextPath }/res/images/top_4.jpg"
					width="190">
			</div>
		</div>
		<div class='bgimg'
			style="width: 1199px;height:470px; background-image: url('${pageContext.request.contextPath }/res/images/timg.jpg');50% 0 no-repeat;border:0px red solid;">
			<div class="login" style="margin-top: 76px;margin-right: 98px;">

				<div class="header">
					<div class="switch" id="switch">
						<a class="switch_btn_focus" id="switch_qlogin"
							href="javascript:void(0);" tabindex="7">账户登录</a> <a
							class="switch_btn" id="switch_login" href="javascript:void(0);"
							tabindex="8">账户注册</a>
						<div class="switch_bottom" id="switch_bottom"
							style="position: absolute; width: 64px; left: 10px;"></div>
					</div>
				</div>


				<div class="web_qr_login" id="web_qr_login"
					style="display: block; height: 174px;">

					<!--登录-->
					<div class="web_login" id="web_login">


						<div class="login-box">


							<div class="login_form">
								<form name="loginform" accept-charset="utf-8" id="login_form"
									class="loginForm" method="post">
									<input name="did" value="0" type="hidden"> <input
										name="to" value="log" type="hidden">
									<div class="uinArea" id="uinArea">

										<div class="inputOuter" id="uArea">

											<input id="u" name="mbPhones" class="inputstyle" type="text"
												placeholder="用户名/手机号">
										</div>
									</div>
									<div class="pwdArea" id="pwdArea">

										<div class="inputOuter" id="pArea">

											<input id="p" name="mbLoginPwd" class="inputstyle"
							   					type="password" placeholder="密码">
										</div>
									</div>

									<div style="padding-left: -30px; margin-top: 20px;">
										<input value="登 录" style="width: 240px;" class="button_blue"
											type="button" id="logins">
									</div>
								</form>
							</div>

						</div>

					</div>
					<!--登录end-->
				</div>

				<!--注册-->
				<div class="qlogin" id="qlogin" style="display: none;">

					<div class="web_login">
						<form name="form2" id="regUser" accept-charset="utf-8"
							method="post"
							action="${pageContext.request.contextPath }/member/register.action">
							<input name="intercept" value="true" type="hidden" /> <input
								name="to" value="reg" type="hidden"> <input name="did"
								value="0" type="hidden">
							<ul class="reg_form" id="reg-ul">
								
								<li>

									<div class="inputOuter2">
										<input id="phone" name="mbPhone" maxlength="16"
											class="inputstyle2" type="text" onblur="dian()"
											placeholder="手机号">
									</div>

								</li>

								<li>
									<div class="inputOuter2">
										<input id="passwd" name="mbLoginPwd" maxlength="16"
											class="inputstyle2" type="password" placeholder="登录密码">
									</div>

								</li>
								<li>
									<div class="inputOuter2">
										<input id="passwd2" name="invitationCode" maxlength="16"
											class="inputstyle2" type="text" placeholder="邀请码(选填)">
									</div>

								</li>

								<li>
									<div class="inputOuter2">
										<input style="margin-left: 10px; width: 125px;height: 38px;" id="send_btn"
											class="button_blue" value="点击获取验证码" type="button"
											onclick="show();"> <input id="yzm" name="yzm"
											maxlength="10" class="inputstyle2" type="text"
											placeholder="验证码" style="width: 111px;margin-left:-167px">
									</div>

								</li>

								<li>
									<div class="inputArea">
										<input
											style="margin-top: 10px; margin-left: 10px; width: 244px;"
											class="button_blue" value="同意协议并注册" type="button"
											id="register">
									</div>

								</li>

								<div class="cl"></div>
							</ul>
						</form>


					</div>


					<!--注册end-->
				</div>
			</div>



		</div>
		<div class="down">
		<div class="down-xia">
			<a href="#">关于我们</a><a>|</a> <a href="#">联系我们</a><a>|</a> <a href="#">投诉建议</a><a>|</a>
			<a href="#">合作招商</a> <a href="#" class="a">Copyright@2004-2017e货源ehuoyuan.cn版权所有</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function show(){
		var mbPhone = $("#phone").val();//取出用户的填入的号码
		 if(mbPhone==""){
			swal({
				  title: "号码不能为空!",
				  text: "",
				  timer: 1000,
				  showConfirmButton: true
				});
		}else{
			 var url="${pageContext.request.contextPath}/member/front/yzm.action";
			 var data = {'mbPhone':mbPhone,intercept:true};
			 alert(data);
			$.post(url,data,function(info){
				if(info.state==1){
					alert("验证码发送成功");
					countDown(60);
				}
				
			}) 
			
		} 
	}
		
	
	
	function countDown(secs){     
		var jumpTo = document.getElementById('send_btn');
		jumpTo.value=secs+"秒后重新发送";  
		if(--secs>0){
		    setTimeout("countDown("+secs+")",1000);  
		    jumpTo.disabled=true;
		}else{       
		}     
	}     

	 $(function(){
		 $("#logins").click(function(){
			 var url = "${pageContext.request.contextPath }/member/front/login.action";
				var data =$("#login_form").serialize();
				$.post(url,data,function(info){
					if(info.state==1){
						alert("登陆成功");
						var type=getParam("type");
						if(type && type=="isLogin"){
							window.history.back();
						}else{
							location.href="${pageContext.request.contextPath }/pages/front/index.jsp";
						}
						
					}else{
						alert("登陆失败");
					}
				})
		 })
		
			
		 
		$("#register").click(function(){
			 var url = "${pageContext.request.contextPath }/member/front/register.action";
				var data =$("#regUser").serialize();
				alert(data);
				$.post(url,data,function(info){
					alert(info.state);
					if(info.state==1){
						alert("注册成功");
						location.href="${pageContext.request.contextPath }/pages/front/index.jsp";
					}else if(info.state==0){
						alert("手机号不能为空或者已被注册！");
					}else if(info.state==2){
						alert("邀请码输入错误!");
					}
						
					
				})
		 })
	 })
	 
	
		 
	
</script>

</body>
</html>