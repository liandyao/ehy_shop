<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="罗海兵" />
		<meta http-equiv="keywords" content="E货源,宝贝详情,前台" />
		<meta http-equiv="description" content="E货源网站前台宝贝详情页面" />
		<title>E货源--宝贝详情</title>
		<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="res/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="res/css/info.css"/>
		<link rel="stylesheet" href="res/css/glyphicon.css">
		<link rel="stylesheet" href="res/css/memberLogin.css">
		<script src="res/js/jquery-2.1.4.min.js"></script>
		<script src="res/js/ehy_common.js"></script>
		<script src="res/js/base.js"></script>
		<script src="res/js/info.js"></script>
		<script type="text/javascript">
			$(function(){
				$.get("pages/front/memberLogin.jsp",function(data){
					$("#loginModal").html($(data).filter("#loginModal").html());
					$("#loginModal").on("click","span.modal-close",function(){
						hide();
					});
				});
				$("#loginModal").on("click","#logins",function(){
					 	var url = "member/front/login.action";
						var data =$("#login_form").serialize();
						$.post(url,data,function(info){
							if(info.state==1){
								$("#loginModal .tips-error").css("display","none");
								$("#loginModal .tips-error").text("");
								ehy.isLogin=true;
								hide();
							}else{
								$("#loginModal .tips-error").removeAttr("style");
								$("#loginModal .tips-error").text("用户名或者密码错误");
							}
						})
				 });
			});
			function show(){
				document.getElementById("loginModal").style="display:block;";
				document.getElementById("curtain").style="display:block;";

			}
			function hide(){
				document.getElementById("loginModal").style="display:none;";
				document.getElementById("curtain").style="display:none;";
			}
			function addCart(){
				if(ehy.isLogin){
					var stName=$(".links-li li.active > a").text();
					var proId=getParam("proId");//获取地址栏参数
					var proName=$("#proName").text();
					var proFactoryPrice=$("#proFactoryPrice").text().substr(1);
					var proPrice=$("#proPrice").text().substr(1);
					var cartNum=$("#cartNum").text();
					var arr=$(".details > .specification > .list li.active");
					var spNames="";
					for(var i=0;i<arr.length;i++){
						var value=$(arr[i]).text();
						spNames+=","+value;
					}
					var url="cart/front/add.action";
					var data={"stName":stName,"proId":proId,"proName":proName,"cartPrice":proPrice,"cartNum":cartNum,"spNames":spNames.substr(1)};
					$.post(url,data,function(info){
						if(info>0){
							var span=$("#toolbar span.number")[0];//得到工具栏的购物车节点
							var num=parseInt($(span).text());//得到购物车数量
							$(span).text(num+1);//购物车数量加1
						}else{
							alert("未登录,加入购物车失败");
						}
					});
					
				}else{
					show();	
				}
				
			}
			
			function addShelf(){
				alert("加入货架");
			}
		</script>
	</head>
	<body>
		<!-- 遮盖层 -->
		<div id="curtain" style="display:none;"></div>
		
		<!-- 会员登陆 -->
		<div id="loginModal" style="display:none;"></div>
		
		<!-- header 开始 -->
		<div id="header">
		</div>
		<!-- header 结束 -->
		
		<!-- 右边工具栏  start  -->
		<div id="toolbar">
		</div>
		<!-- 右边工具栏  end  -->
		
		<!-- main 开始 -->
		<div id="main">
			<div class="content">
				<!-- info 开始 -->
				<div class="info">
					<!-- info 开始 -->
					<div class="left">
						<div class="max-img">
							<img alt="max" src="res/images/max.jpg">
						</div>
						
						<div class="min-img">
							<ul>
								<li class="active"><img alt="min" src="res/images/min.jpg"></li>
								<li><img alt="min" src="res/images/min.jpg"></li>
								<li><img alt="min" src="res/images/min.jpg"></li>
								<li><img alt="min" src="res/images/min.jpg"></li>
								<li><img alt="min" src="res/images/min.jpg"></li>
								<li><img alt="min" src="res/images/min.jpg"></li>
							</ul>
						</div>
					</div>
					<!-- info 结束 -->
					
					<!-- right 开始 -->
					<div class="right">
						<!-- 名称：字体加粗加黑 -->
						<div id="proName">产品名称</div>
						
						<!-- 价格：直销价/市场价 -->
						<div class="price">
							<b style="font-weight: 400;">价格：</b>
							<span>厂家直销价<em id="proFactoryPrice">￥85</em></span>
							<span class="market-price">&nbsp;&nbsp;市场价<em id="proPrice">￥120</em></span>
						</div>
						
						<!-- 宝贝信息详情 -->
						<div class="details">
							<!-- 颜色：以图片的形式展示 -->
							<div class="img-color">
								<div class="text">颜色</div>
								<div class="list">
									<ul>
										<li class="active"><img alt="" src="res/images/imgColor_1.jpg"></li>
										<li><img alt="" src="res/images/imgColor_2.jpg"></li>
									</ul>
								</div>
							</div>
							
							<!-- 尺码：提供多个尺码可供选择 -->
							<div class="specification">
								<div class="text">尺码</div>
								<div class="list">
									<ul>
										<li class="active">37</li>
										<li>38</li>
										<li>39</li>
										<li>40</li>
										<li>41</li>
									</ul>
								</div>
								<div class="explain">尺码说明：注意尺码选项的提示，有部分超小超大尺码的鞋不支持退换货</div>
							</div>
							
							<!-- 数量：1~max存货量，以"+"和"-"进行增减 -->
							<div class="number">
								<div class="text">数量</div>
								<div class="box">
									<b class="add" onclick="addOrCut(this)">-</b>
									<span class="num" id="cartNum">1</span>
									<b class="cut" onclick="addOrCut(this)">+</b>
								</div>
							</div>
							
							<!-- 选择商品规程 -->
							<div class="goods">
								<div class="selected">
									<span>已选择：</span>
									<span>黑色</span>
									<span>37</span>
								</div>
								
								<!-- 加入购物车-->
								<div class="cart btn btn-warning" onclick="addCart()">
									<span class="txt">加入购物车</span>
									<img src="res/images/cart.png" style="position: relative;top: 2px;"/>
								</div>
								
								<!-- 放入货架 -->
								<div class="shelf btn btn-primary" onclick="addShelf()">
									<span class="txt">放入我的货架</span>
									<img src="res/images/shelf.png" style="position: relative;top: 2px;"/>
								</div>
							</div>
							
							<!-- 交易:购买方式/支付方式 -->
							<div class="deal">
								<div class="buy">
									<ul>
										<li>
											<i>批</i><span>实体批发</span>
										</li>
										<li>
											<i>团</i><span>企业个人团购</span>
										</li>
										<li>
											<i>销</i><span>网络销售代理</span>
										</li>
									</ul>
								</div>
								<div class="pay">支付方式：微信、支付宝、银行卡</div>
							</div>
						</div>
						
						
					</div>
					<!-- right 结束 -->
				</div>
				<!-- info 结束 -->
				
				<!-- 海报 开始 -->
				<div class="poster">
					<h1 style="font-size: 40px;color: #ff6100">海报</h1>
				</div>
				<!-- 海报 结束 -->
				
				<!-- cont 开始 -->
				<div class="cont">
					<div class="title">
						<div class="dotey active">厂家提供的宝贝详情</div>
						
						<div class="share">
							<div class="red-txt">(这里有真相)</div>
							<div class="big-txt">买家实物解析分享</div>
						</div>
					</div>
					
					<div class="box">
						<div class="specification">
							<ul>
								<li>鞋筒内里材质: 人造短毛绒</li>
								<li>鞋筒面材质: 绒面</li>
								<li>品牌: other/其他</li>
								<li>上市年份季节: 2017年秋季</li>
								<li>帮面材质: 绒面</li>
								<li>鞋筒内里材质: 人造短毛绒</li>
								<li>筒高: 长筒</li>
								<li>鞋头款式: 圆头</li>
								<li>后高跟: 高跟(5-8cm)</li>
								<li>跟底款式: 内增高</li>
								<li>颜色分类: 红色  灰色  黑色</li>
								<li>尺码: 34 35 36 37 38 39</li>
								<li>适用对象: 青年(14-40岁)</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- cont 结束 -->
			</div>
		</div>
		<!-- main 结束 -->
		
		
		
		<!-- footer 开始 -->
		<div id="footer"></div>
		<!-- footer 结束 -->
	</body>
</html>