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
		<meta http-equiv="keywords" content="E货源,买家,分享,评价,前台" />
		<meta http-equiv="description" content="E货源网站前台买家分享评价页面" />
		<title>E货源--会员登陆</title>
		<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="res/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="res/css/appraise.css"/>
		<script src="res/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$(".min-img ul li").click(function(){
					$(".min-img ul li").removeClass("active");
					$(this).addClass("active");
				});
			});
		</script>
	</head>
	<body>
		<!-- 页眉  start -->
		<div id="header">
			<div class="content">
				<div class="head-top" style="border: 1px solid red;">
					<h1 style="font-size: 20px;text-align: center;">页眉预留区</h1>
				</div>
				<div class="logo">
					<img alt="logo" src="res/images/eLOGO2.jpg" style="max-height: 80px;">
					<span class="txt">( 发现好宝贝&nbsp;分享好宝贝 )</span>
					<div class="login-regist font-color-white">
						<a href="pages/front/login.jsp">登陆</a>
						<div class="line-height" style="margin: 0 5px;"></div> 
						<a href="pages/front/login.jsp?">注册</a>
					</div>
				</div>
			</div>
		</div>
		<!-- 页眉     end  -->
		
		<!-- 网页主体   start -->
		<div id="main">
			
			<!-- 主显示区容器  start -->
			<div class="content">
				<!-- 头部：第一个大div  start -->
				<div class="top">
					<!-- 宝贝图片参数    start -->
					<div class="parameter">
						<!-- 标题 -->
						<div class="title">厂家提供的宝贝图片参数</div>
						
						<!-- 大图 -->
						<div class="max-img">
							<img alt="" src="res/images/max.jpg" style="max-height: 100%;">
						</div>
						
						<!-- 参数规格  start -->
						<div class="param">
							<!-- 名称 -->
							<div class="name">
								<span class="key">名称：</span>
								<span class="value"></span>
							</div>
							
							<!-- 价格 -->
							<div class="price">
								<span class="key">价格：</span>
								<span class="value">
									厂家直销价￥<em></em>
									/市场价￥<em></em>
								</span>
							</div>
							
							<!-- 材质 -->
							<div class="texture">
								<span class="key">材质：</span>
								<span class="value"></span>
							</div>
							
							<!-- 尺寸 -->
							<div class="size">
								<span class="key">尺寸：</span>
								<span class="value"></span>
							</div>
							
							<!-- 颜色 -->
							<div class="color">
								<span class="key">颜色：</span>
								<span class="value"></span>
							</div>
							
							<!-- 支付方式 -->
							<div class="pay">
								支付方式：微信、支付宝、银行卡
							</div>
							
							<!-- 小图片 -->
							<div class="min-img">
								<ul>
									<li class="active"><img src="res/images/min.jpg" /></li>
									<li><img src="res/images/min.jpg" /></li>
									<li><img src="res/images/min.jpg" /></li>
									<li><img src="res/images/min.jpg" /></li>
									<li><img src="res/images/min.jpg" /></li>
								</ul>
							</div>
						</div>
						<!-- 参数规格    end  -->
						
					</div>
					<!-- 宝贝图片参数    end -->
					
					<!-- 商品展示   start -->
					<div class="goods">
						<div class="title">买家(疯清扬)还购买了</div>
						<div class="list">
							<ul>
								<li>
									<div class="img"><img alt="" src="res/images/min.jpg" /></div>
									<div class="txt">长筒过膝女靴白色加绒<br>高筒靴弹力大小码</div>
								</li>
								<li>
									<div class="img"><img alt="" src="res/images/min.jpg" /></div>
									<div class="txt">长筒过膝女靴白色加绒<br>高筒靴弹力大小码</div>
								</li>
							</ul>
						</div>
					</div>
					<!-- 商品展示        end -->
				</div>
				<!-- 头部：第一个大div   end  -->
				
				<!-- 头部：第二个大div  start -->
				<div class="cont">
					<!-- 实物描述  start -->
					<div class="describe">
						<!-- 标题 -->
						<div class="title">买家对实物的拍照与描述</div>
						
						<!-- 买家对实物的拍照与描述 -->
						<div class="box">
							<!-- 买家描述 -->
							<div class="remark">
								<!-- 买家资料 -->
								<div class="datum">
									<div id="portrait"><img src="res/images/head.jpg" style="max-height: 100%;"></div>
									
									<div id="info">
										<div style="height: 35px;line-height: 35px;margin-bottom: 10px;">
											<span class="txt">买家名称:</span>
											<span class="buyer">疯清扬</span>
											<img src="res/images/buyer.png" alt="咨询买家" style="position: relative;top: 8px;"/>
										</div>
										
										<div>
											<span class="txt">买家等级:</span>
											<span class="grade">★</span>
										</div>
									</div>
								</div>
								
								<div class="list">
									<ul style="margin-left: 20px;">
										<li>
											<span class="txt">买家对产品的评语：</span>
											<span class="comment"></span>
										</li>
										<li>
											<span class="txt">买家对产品的印象：</span>
											<span class="impress"></span>
										</li>
									</ul>
								</div>
								
							</div>
							
							<!-- 砍价 -->
							<div class="bargain">
								<div class="name">(<em>疯清扬</em>)为您努力向卖家去砍价</div>
								<div class="price">最终为您砍价到<em>￥85.2</em></div>
								<div class="save">为您节省<em>￥6.5</em></div>
								<div class="btn-links"  align="center">
									<div class="like btn">喜欢买家<br/>分享的这宝贝</div>
									<div class="buy btn">
										<span style="font-size: 18px;">我要去购买</span>
										<img src="res/images/cart.png" style="position: relative;top: 2px;"/>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 实物描述      end  -->
					
					<!-- 上传照片  start -->
					<div class="photo" style="height: 500px;" align="center">
					
					</div>
					<!-- 上传照片      end  -->
					
					<div class="" style="height: 500px;"></div>
					
					<div class="" style="height: 500px;border-bottom: none;"></div>
				</div>
				<!-- 头部：第二个大div   end  -->
				
			</div>
			<!-- 主显示区容器    end -->
			
		</div>
		<!-- 网页主体     end -->
		
		<!-- 页脚   start -->
		<div id="footer">
			<div class="content">
				<div class="foot-top" style="border: 1px solid red;">
					<h1 style="font-size: 20px;text-align: center;">页脚预留区</h1>
				</div>
			</div>
		</div>
		<!-- 页脚   end   -->
	</body>
</html>