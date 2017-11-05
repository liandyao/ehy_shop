<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="res/js/jquery-2.1.4.min.js"></script>
<link href="res/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="res/css/bootstrap-datepicker3.css">
<link href="res/css/userCenter.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="res/css/common.css" />
<link rel="stylesheet" type="text/css" href="res/css/share.css" />
<link rel="stylesheet" type="text/css" href="res/css/myOrders.css">
<link
	href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="res/css/common.css" />
<link rel="stylesheet" type="text/css" href="res/css/share.css" />
<link rel="stylesheet" type="text/css" href="res/css/cart.css" />
<script src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/ehy_common.js"></script>
<script type="text/javascript" src="res/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="res/js/myOrder.js"></script>
<script src="res/js/cart.js"></script>
<script type="text/javascript" src="res/js/share.js"></script>
<title>用户中心</title>

<script type="text/javascript">
	$(function() {
		$("#Section1").load("pages/front/myOrders.jsp .bigBox");
		cartInit();
		
	});
	
	function dian() {

		var reg = /^1[3|4|5|7|8][0-9]{9}$/;
		var account = $("#mbPhone").val();
		if (!reg.test(account)) {
			alert("请输入正确的手机号码");
		} else {
		}
	}

	function dians() {
		var reg = /^1[3|4|5|7|8][0-9]{9}$/;
		var account = $("#mbPhones").val();
		if (!reg.test(account)) {
			alert("请输入正确的手机号码");
		} else {
		}
	}

	/*刷新页面  */
	function refresh() {
		parent.location.reload();
	}

	$(function() {
		init();
	});

	function init() {
		var id = getParam("id");
		if (!id)
			id = "Section2";
		var href = "a[href$='#" + id + "']";
		$(href).click();
	}

	//获取参数的方法
	function getParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var url = window.location.search;
		url = decodeURIComponent(url);
		var r = url.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return null;
	}
</script>
</head>
<body>
	<div class="div_share_curtain"></div>
	<!-- 上传图片 -->
	<form id="imgform">
		<input type="file" id="imgInput" name="file" onchange="upload(this)">
	</form>


	<div id="div">
		<div class="links-li">
			<ul>
				<li><img alt="logo"
					src="${pageContext.request.contextPath }/res/images/eLOGO1.jpg"
					style="max-height: 70px;"></li>
				<li><a>用户中心</a></li>
			</ul>
		</div>

		<div style="float: right; margin-top: -30px;" class="spana">
			<!-- <input type="button" value="修改手机号码" class="btn btn-primary" id="updatePwd">
				<input type="button" value="修改登录密码" class="btn btn-primary" id="updatePwds">
				<input type="button" value="修改支付密码" class="btn btn-primary" id="updatePayPwd"> -->

			<ul id="mav" class="nav nav-tabs">
				<li><a><span id="updatePwd">修改手机号码</span></a></li>
				<li><a><span id="updatePwds">修改登录密码</span></a></li>
				<li><a><span id="updatePayPwd">修改支付密码</span></a></li>
				<li><a href="pages/front/UserCenter/address.jsp"><span
						id="updateAddress">管理收货地址</span></a></li>
			</ul>
		</div>

		<div class="div_emp">
			<div class="div_xx">
				个人基础信息<img id="imgs"
					src="${pageContext.request.contextPath }/res/images/icon_edit.png"
					class="bounceInDown">
			</div>
			<div class="div_sss">

				<div class="div_da" align="center">

					<div class="div_bor" id="imageDiv"></div>

				</div>

				<div class="div_text" id="showList">
					<ul>
						<li id="mbName">我的名称：</li>
						<li id="dengji">我的等级：</li>
						<li id="mbAddr">我的地址：</li>
						<li id="mbIsbzj">会员资质：</li>
						<li>银牌会员考核：当前通过： 正在下次考核中</li>
						<li id="invitationCode">我的邀请码：</li>
					</ul>

				</div>
			</div>
		</div>

		<div class="div_baby">
			<div class="div_bb">我的宝贝动态</div>
			<div class="div_sy">
				<div class="div_top"></div>
				<div class="div_body">
					<ul>
						<li>我的收益</li>
					</ul>

					<div class="div_red">
						<li>￥:0</li>
					</div>
					<div class="div_red_down">
						<li>收益提现</li>
					</div>

					<div class="div_red_downs">
						<li>累计收益:￥</li>
					</div>
				</div>

				<div class="div_body2">
					<ul>
						<li>宝贝被浏览</li>
					</ul>

					<div class="div_red">
						<li>人气</li>
					</div>
				</div>

				<div class="div_body3">
					<ul>
						<li>宝贝已成交</li>

					</ul>
					<div class="div_red">
						<li>数量</li>
					</div>
				</div>
				<div class="div_foot"></div>
			</div>
		</div>
		<div class="tab" role="tabpanel" id="tab_a">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" id="mav" role="tablist">
				<li class="span"><a href="#Section1" id="orders1s" aria-controls="order"
					role="tab" data-toggle="tab"><span>我的订单</span></a></li>

				<li class="span"><a href="#Section3" aria-controls="homes"
					role="tab" data-toggle="tab"><span>代理管理中心</span></a></li>
				<li class="span"><a href="#Section4" onclick="orderss" aria-controls="home"
					role="tab" data-toggle="tab"><span>分享的宝贝</span></a></li>
				<li class="span"><a href="#Section5" aria-controls="profile"
					role="tab" data-toggle="tab"><span>我的购物车</span></a></li>
				<li class="span"><a href="#Section6" aria-controls="messages"
					role="tab" data-toggle="tab"><span>我的货架</span></a></li>
				<li class="span"><a href="#Section7" aria-controls="messages"
					role="tab" data-toggle="tab"><span>我的浏览记录</span></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content tabs" id="tab-center">
				<div role="tabpanel" class="tab-pane fade" id="Section1"></div>

				<div role="tabpanel" class="tab-pane fade in active" id="Section3" >
					<div >
						<div style="width: 95%; margin-left: 25px;"  id="Section3_div">
							<span style="margin-left: 20px;  color:#ff4300; font-size: 15px;cursor: pointer;" id="registerTj"  onclick="registerTj()">注册人数统计</span>
							<span style="margin-left: 50px;  font-size: 15px;cursor: pointer;" onclick="orderTj()" id="orderTj">订单数量统计</span>
						</div>
						<div  id="registerTj1"  style="height: 100%; width: 95%; margin-left: 20px; border: 1px dashed #DEDEDE;border-top: hidden;border-right:hidden;border-left:hidden; 
	overflow :auto">
							<div style="margin: 60px; width: 40%;">
								<div style="color: #ff4300;">今日注册人数：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text"  size="7" id="input"  readonly="readonly"></span></div>
							</div>
							<div style="float:right;  margin-top:-100px;width: 50%;height:100%; background-color: #D5D5D5;">
								<div style="width: 100%; text-align: center;" class="zhuce">注册记录</div>
								<div>
									<span style="margin: 72px;">1.小****可&nbsp;&nbsp;&nbsp;2017/9/10</span>
									<span>1.小****可&nbsp;&nbsp;&nbsp;2017/9/10</span>
								
								</div>
							</div>
						</div>
						<div style="height: 60px;margin: 20px; margin: 30px;" id="registerTj2">
							本月注册人数：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text" size="7" id="input"  readonly="readonly"></span>
							<span style="margin-left: 60px;"></span>
							上月注册人数：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text" size="7" id="input"  readonly="readonly"></span>
							<span style="margin:0 30px 0 60px;"></span>
							历史记录：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text" size="7" id="input"  readonly="readonly"></span>
						</div>
						
						
						<div  id="orderTj1"  style="display:none;  height: 100%; width: 95%; margin-left: 20px; border: 1px dashed #DEDEDE;border-top: hidden;border-right:hidden;border-left:hidden; 
	overflow :auto">
							<div style="margin: 60px; width: 40%;">
								<div style="color: #ff4300;">今日订单数：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text" size="7" id="input"  readonly="readonly"></span></div>
							</div>
							<div style="float:right;  margin-top:-100px;width: 50%;height:100%; background-color: #D5D5D5;">
								<div style="width: 100%; text-align: center;" class="zhuce">订单记录</div>
								<div>
									<span style="margin: 72px;">1.小****可&nbsp;&nbsp;&nbsp;2017/9/10</span>
									<span>1.小****可&nbsp;&nbsp;&nbsp;2017/9/10</span>
								
								</div>
							</div>
						</div>
						<div style="display:none;    height: 60px;margin: 20px; margin: 30px;" id="orderTj2">
							本月成交订单人数：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text" size="7" id="input"  readonly="readonly"></span>
							<span style="margin-left: 60px;"></span>
							上月订单数：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text" size="7" id="input"  readonly="readonly"></span>
							<span style="margin:0 30px 0 60px;"></span>
							历史记录：<span style="border:  1px solid #ff4300;border-top: hidden;border-right:hidden;border-left:hidden;"><input type="text" size="7" id="input"  readonly="readonly"></span>
						</div>
					</div>
					
					
					
					
					
				</div>
				
				
				
				
		
				
				
				
				

				<div role="tabpanel" class="tab-pane fade" id="Section4">
					<h3>分享的宝贝</h3>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="Section5">
			
				</div>

				<div role="tabpanel" class="tab-pane fade" id="Section6">
					<h3>我的货架</h3>
				</div>

				<div role="tabpanel" class="tab-pane fade" id="Section7">
					<h3>我的浏览记录</h3>
				</div>
			</div>
		</div>

	</div>
	<div id="hide_div"></div>
	<div id="shareDiv" style="display: none;">
		<div style="width: 65px; height: 0%; float: left; line-height: 620px;"
			id="close">
			<!-- 关闭按钮  start -->
			<img src="res/images/close.png" style="width: 65px; height: 52px;" />
			<!-- 关闭按钮  start -->
		</div>
		<!-- 用户中心分享页面弹出层  start -->
		<div id="share" align="center">
			<form style="margin-top: 30px;" id="memberForm">
				<input type="hidden" name="mbId" id="mbId">
				<table>
					<tr>
						<td>我的名称：</td>
						<td><input type="text" id="mbNames" name="mbName"
							class="form-control"></td>
					</tr>
					<tr>
						<td>我的地址：</td>
						<td><input type="text" id="mbAddrs" name="mbAddr"
							class="form-control"></td>
					</tr>
					<tr>
						<td>登录账号：</td>
						<td><input type="text" id="mbLogins" name="mbLogin"
							class="form-control"></td>
					</tr>
					<tr>
						<td>我的性别：</td>
						<td><select class="form-control" id="mbSexs" name="mbSex">
								<option>男</option>
								<option>女</option>
						</select></td>
					</tr>

					<tr>
						<td>会员生日：</td>
						<td><input type="date" id="mbBirthdays" name="mbBirthday"
							class="form-control"></td>
					</tr>
					<tr>
						<td>身份证号：</td>
						<td><input type="text" id="mbCardIds" name="mbCardId"
							class="form-control"></td>
					</tr>

				</table>
				<input type="button" value="提交" class="btn btn-primary"
					onclick="commit()">
			</form>
		</div>
		<!-- 用户中心分享页面弹出层   end -->
	</div>

	<!-- 修改手机号码弹出层  start-->
	<div id="shareDivs" style="display: none;">
		<div
			style="width: 65px; height: 100%; float: left; line-height: 620px;"
			id="closes">
			<!-- 关闭按钮  start -->
			<img src="res/images/close.png" style="width: 65px; height: 52px;" />
			<!-- 关闭按钮  start -->
		</div>

		<div id="shares" align="center">
			<form style="margin-top: 30px;" id="memberForms">
				<input type="hidden" name="mbId" id="mbId">
				<table>
					<tr align="center" style="margin: 10px;">
						<td>修改手机号码</td>
					</tr>

					<tr>
						<td><input type="text" id="mbPhone" name="mbPhone"
							placeholder="手机号码" onblur="dian()" class="form-control"></td>

					</tr>
					<tr>
						<td><input type="text" id="mbPhoneYzm" name="mbPhoneYzm"
							placeholder="验证码" class="form-control"></td>
						<td><input type="button" class="btn btn-primary"
							value="获取验证码" id="Pho_btn" onclick="phoneYzm()"></td>
					</tr>
					<tr>
						<td><input type="text" id="mbPhones" name="mbPhones"
							onblur="dians()" placeholder="新手机号码" class="form-control"></td>
					</tr>

					<tr>
						<td><input type="password" id="mbLoginPwd" name="mbLoginPwd"
							placeholder="旧密码" class="form-control"></td>

					</tr>
					<tr>
						<td><input type="password" id="mbLoginPwds"
							name="mbLoginPwds" placeholder="新密码" class="form-control"></td>
					</tr>
					<tr>
						<td><input type="password" id="mbLoginPayPwd"
							name="mbLoginPayPwd" placeholder="旧支付密码" class="form-control"></td>
					</tr>
					<tr>
						<td><input type="password" id="mbLoginPayPwds"
							name="mbLoginPayPwds" placeholder="新支付密码" class="form-control"></td>
					</tr>
				</table>
				<input type="button" value="提交" class="btn btn-primary"
					onclick="commits()">
			</form>
		</div>

	</div>
	<div class="div_share"></div>
	<script type="text/javascript">
		$(function() {
			var url = "${pageContext.request.contextPath }/member/front/findMemberById.action";
			$
					.post(
							url,
							null,
							function(member) {
								$("#imageDiv")
										.append(
												"<img id='sss' src='"+member[0].mbRemark+"'width='80px'/>");

								$("#mbName").append(member[0].mbName);
								$("#mbLevel").append(member[0].mbLevel);
								$("#dengji").append(member[0].mbLevel);
								$("#mbAddr").append(member[0].mbAddr);
								$("#mbIsbzj").append(member[0].mbIsbzj);
								$("#invitationCode").append(
										member[0].invitationCode);
							}, "json");

			/* 修改个人资料*/
			$("#imgs")
					.click(
							function() {
								$("#shareDiv").css('display', 'block');
								$("#hide_div").css("display", "block");
								alert("123");
								var url = "${pageContext.request.contextPath }/member/front/findMemberById.action";
								$
										.post(
												url,
												null,
												function(member) {
													alert(member[0].mbName);
													$("#mbId").val(
															member[0].mbId);
													$("#mbNames").val(
															member[0].mbName);
													$("#mbAddrs").val(
															member[0].mbAddr);
													$("#mbSexs").val(
															member[0].mbSex);
													$("#mbLogins").val(
															member[0].mbLogin);
													$("#mbBirthdays")
															.val(
																	member[0].mbBirthday);
													$("#mbCardIds").val(
															member[0].mbCardid);
												}, "json");
							})

			$("#close").click(function() {
				alert("关闭");
				$("#shareDiv").css('display', 'none');
				$("#hide_div").css('display', 'none');

			})

			$("#updatePwd").click(function() {
				$("#shareDivs").css('display', 'block');
				$("#hide_div").css("display", "block");
				$("#mbLoginPwd").css("display", "none");
				$("#mbLoginPwds").css("display", "none");
				$("#mbPhones").css("display", "block");
				$("#mbLoginPayPwd").css("display", "none");
				$("#mbLoginPayPwds").css("display", "none");
			})

			$("#updatePwds").click(function() {
				$("#shareDivs").css('display', 'block');
				$("#hide_div").css("display", "block");
				$("#mbPhones").css("display", "none");
				$("#mbLoginPwd").css("display", "block");
				$("#mbLoginPwds").css("display", "block");
				$("#mbLoginPayPwd").css("display", "none");
				$("#mbLoginPayPwds").css("display", "none");
			})

			$("#updatePayPwd").click(function() {
				$("#shareDivs").css('display', 'block');
				$("#hide_div").css("display", "block");
				$("#mbPhones").css("display", "none");
				$("#mbLoginPwd").css("display", "none");
				$("#mbLoginPwds").css("display", "none");
				$("#mbLoginPayPwd").css("display", "block");
				$("#mbLoginPayPwds").css("display", "block");

			})

			$("#closes").click(function() {
				$("#hide_div").css('display', 'none');
				$("#shareDivs").css('display', 'none');
			})

			$("#closePwd").click(function() {
				$("#shareDivPwd").css('display', 'none');

				$("#hide_div").css('display', 'none');
			})

			$("#imageDiv").click(function() {
				$("#imgInput").click();

			})

		})
		/* 修改会员头像 */
		function upload(obj) {
			//判断文件格式
			photoExt = obj.value.substr(obj.value.lastIndexOf("."))
					.toLowerCase();//获得文件后缀名
			if (photoExt != '.jpg' && photoExt != '.png' && photoExt != '.gif'
					&& photoExt != '.jpg ') {
				alert("只能上传jpg/gif/png格式文件!");
				return false;
			}
			var form = new FormData(document.getElementById("imgform"));
			$
					.ajax({
						url : "${pageContext.request.contextPath }/member/front/updatePhoto.action",
						type : "post",
						data : form,
						processData : false,
						contentType : false,
						success : function(data) {
							if (data.state == 1) {
								$("#sss").attr("src", data.mes);
							} else {
								alert("修改头像失败");
							}
						},
						error : function(e) {
							alert("上传错误！！");
						}
					});
		}

		/*  修改会员信息*/
		function commit() {
			var url = "${pageContext.request.contextPath}/member/front/updateMember.action";
			var data = $("#memberForm").serialize();
			$.post(url, data, function(info) {
				alert(data);
				if (info.state == 1) {
					alert("修改成功");
					setTimeout("refresh()", 500);
				} else if (info.state == 0) {
					alert("修改失败");
				}
			})
		}
		/* 发送验证码 */
		function phoneYzm() {
			var mbPhone = $("#mbPhone").val();//取出用户的填入的号码
			if (mbPhone == "") {
				alert("号码不能为空");
			} else {
				var url = "${pageContext.request.contextPath}/member/front/yzm.action";
				var data = {
					'mbPhone' : mbPhone,
					intercept : true
				};
				$.post(url, data, function(info) {
					if (info.state == 1) {
						countDown(60);
					}
				})

			}
		}

		/*计时  */
		function countDown(secs) {
			var jumpTo = document.getElementById('Pho_btn');
			jumpTo.value = secs + "秒后重新发送";
			if (--secs > 0) {
				setTimeout("countDown(" + secs + ")", 1000);
				jumpTo.disabled = true;
			} else {
			}
		}
		/*判断验证码  */
		function commits() {
			var mbPhoneYzm = $("#mbPhoneYzm").val();//取出用户的填入的验证码
			if (mbPhoneYzm == "") {
				alert("验证码不能为空");
			} else {
				var url = "${pageContext.request.contextPath}/member/front/loginPwdYzm.action";
				var data = {
					"mbPhoneYzm" : mbPhoneYzm
				};
				$.post(url, data, function(mes) {
					if (mes.state == 1) {
						updatePhone();

					} else if (mes.state == 0) {
						alert("您输入的验证码有误");
					}
				})
			}
		}

	 	function registerTj(){
			$("#registerTj").css('color','#ff4300');
			$("#orderTj").css('color','#111');
			
			$("#registerTj1").css('display','block');
			$("#registerTj2").css('display','block');
			$("#orderTj1").css('display','none');

			$("#orderTj2").css('display','none');
		}
		
		function orderTj(){
			$("#orderTj").css('color','#ff4300');
			$("#registerTj").css('color','#111');
			
			$("#registerTj1").css('display','none');
			$("#registerTj2").css('display','none');
			$("#orderTj1").css('display','block');

			$("#orderTj2").css('display','block');
		} 
		
		/* 修改手机号码 */
		function updatePhone() {
			var url = "${pageContext.request.contextPath}/member/front/updatePhone.action";
			var data = $("#memberForms").serialize();
			$.post(url, data, function(info) {
				if (info.state == 1) {
					alert("修改成功");
					setTimeout("refresh()", 500);
				} else if (info.state == 0) {
					alert("修改失败");
				}
			})
		}
	</script>
</body>
</html>