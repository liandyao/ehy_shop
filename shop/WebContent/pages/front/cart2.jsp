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
		<meta http-equiv="keywords" content="E货源,购物车,结算,前台" />
		<meta http-equiv="description" content="E货源网站前台购物车结算、选择收货地址、快递方式页面" />
		<title>E货源--结算页面</title>
		<base href="<%=basePath %>"/>
		<!-- <link rel="stylesheet" type="text/css" href="res/css/cart.css" /> -->
		<script src="res/js/jquery-2.1.4.min.js"></script>
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
				font-size: 14px;
			}
			a{
				text-decoration: none;
			}
			ul{
				list-style: none;
			}
			.content {
			    width: 1200px;
			    height: 100%;
			    margin: 0 auto;
			}
			
			
			#header {
			    height: 100%;
			    width: 100%;
			    margin-bottom: 30px;
			}
			#header .content {
			}
			#header .content .logo {
			    height: 80px;
			}
			#header .content .logo img{
			    max-height: 80px;
			}
			
			#main{
			    height: 100%;
			    width: 100%;
			}
			#main .content{
			}
			#main .content textarea{
				resize: none;
				border: 1px solid #d5d5d5;
				letter-spacing: 1px;
				text-indent: 15px;
				font-size: 13px;
				padding: 5px 0px;
			}
			#main .content textarea:focus{
			    color: black;
			    border-color: #f59942;
			    background-color: #fff;
			    outline: 0;
			}
			#address{
				margin-bottom: 85px;
				width: 100%;
				height: 314px;
			}
			#address p{
				border-bottom: 2px solid #cacaca;
				overflow: hidden;
			}
			#address p .ft{
				float: left;
				font-weight: 600;
				margin-left: 10px;
				font-size: 15px;
			}
			#address p .rt{
				float: right;
				color: blue;
				margin-right: 10px;
				font-size: 15px;
			}
			#address #address-list{
				width: 1080px;
				margin-left: auto;
				margin-right: auto;
				padding-top: 20px;
			}
			#address #address-list li{
				height: 34px;
				line-height: 34px;
				cursor: pointer;
			}
			#address #address-list li.active:nth-child(-n+2){
				border: 1px solid #ff4400;
				background-color: #fff0e9;
				font-weight: 600;
				font-size: 15px;
			}
			#address #address-list li.active span::after{
				content: "寄送至";
			}
			#address #address-list li span:first-child{
				display: inline-block;
			    width: 65px;
			    padding-left: 18px;
			    padding-right: 5px;
			    color: red;
			}
			#address #address-list li#address-temp{
				height: 137px;
				position: relative;
				margin-top: 30px;
			}
			#address-temp input{
				position: absolute;
				line-height: 38px;
				height: 38px;
				transform: translateX(36%);
			}
			#address-temp .txt{
				line-height: normal;
				display: inline-block;
				transform: translateX(36%);
				position: absolute;
				color: #3266cc;
			}
			#address #address-list textarea{
				width: 500px;
				height: 135px;
				position: absolute;
				transform: translateX(18%);
			}
			
			#product{
				width: 100%;
				min-height: 276px;
				margin-bottom: 35px;
			}
			#product table{
				width: 1080px;
				border-collapse: collapse;
			}
			#product table th, td{
				border: 1px solid;
			}
			#product thead th {
			    height: 30px;
			    text-align: center;
			    letter-spacing: 2px;
			}
			#product tbody:nth-of-type(2n-1) tr:first-of-type{
			    height: 30px;
			    border-bottom: 1px solid #eee;
			    background: #fafafa;
			    letter-spacing: 1px;
			}
			#product tbody:nth-of-type(2n-1) tr:nth-child(n+2) {
			    height: 125px;
			    border-bottom: 1px solid #eee;
				letter-spacing: 1px;
			}
			#product tr td:nth-child(-n+2) {
			    padding-left: 30px;
			    padding-right: 0px;
			    overflow: hidden;
			}
			#product tbody tr td:nth-child(n+3){
				padding: 0px;
				text-align: center;
			}
			#product tbody tr div.img {
				float: left;
			    border: 1px solid #ddd;
			    width: 80px;
			    height: 80px;
			    line-height: 80px;
			    text-align: center;
			    padding: 2px;
			}
			#product tbody tr div.txt {
				float: left;
			    height: 80px;
			    width: 110px;
			    margin-left: 10px;
			    position: relative;
			}
			#product tbody tr div.img > img {
			    max-height: 100%;
			    max-width: 100%;
			}
			#product tbody tr div.txt > span {
			    position: absolute;
			    top: 50%;
			    transform: translate(0, -50%);
			}
			#product textarea{
				width: 520px;
				height: 65px;
				vertical-align: middle;
			}
			
			#product .btn{
				text-decoration: none;
				border-radius: 4px;
				background-image: none;
				border: 1px solid;
				vertical-align: middle;
				font-weight: 700;
				line-height: 1.42857143;
				text-align: center;
				white-space: nowrap;
				display: inline-block;
				padding: 6px 12px;
				color: #fff;
			}
			#product .btn-warning {
			    background-color: #fc4302;
			    border-color: #fe452d;
			    height: 50px;
			    font-size: 16px;
			    font-family: "SimHei";
			    letter-spacing: 1px;
			    cursor: pointer;
			}
			#product .btn-warning:hover {
			    color: #fff;
			    background-color: #fe7d52;
			    border-color: #fc4302;
			}
		</style>
		
		<script type="text/javascript">
			$(function(){
				cart2Init();
			});
			function cart2Init(){
				$("#address").on("click","#address-list li",function(){
					$("#address-list li").removeClass("active");
					$(this).addClass("active").find("input");
					$(this).find("input").attr("checked",true);
				});
			}
		</script>
	</head>
	<body>
		<!-- 页眉 start -->
		<div id="header">
			<div class="content">
				<div class="logo">
					<img alt="logo" src="res/images/eLOGO1.jpg" style="max-height: 80px;">
				</div>
			</div>
		</div>
		<!-- 页眉 end -->
		
		<!-- 主体 start -->
		<div id="main">
			<div class="content">
				<div id="address">
					<p>
						<span class="ft">收货地址</span>
						<a href="#" class="rt">管理收货地址</a>
					</p>
					
					<ul id="address-list">
						<li class="active">
							<span></span>
							<input type="radio" value="" name="address"/>
							蓝晶华 17340171558 四川省 成都市 新都区 斑竹园镇 源上湾2区
						</li>
						<li>
							<span></span>
							<input type="radio" value="" name="address"/>
							蓝晶华 15366547895 四川省 成都市 新都区 斑竹园镇 丰收小区
						</li>
						<li>
							<span></span>
							<input type="radio" value="" name="address"/>
							林崇飞 13668984576 广东省 广州市 白云区 丛云路821号三排一档
						</li>
						<li id="address-temp">
							<span></span>
							<input type="radio" value="" name="address"/>
							<div class="txt">
								手动填写<br/>
								临时地址
							</div>
							
							<textarea placeholder="请填写详细地址  如果地址不详细可能导致收不到货"></textarea>
						</li>
					</ul>
				</div>
				
				<div id="product" align="center">
					<table>
						<thead>
							<tr style="border-bottom: 2px solid #eee;">
								<th width="260">店铺宝贝</th>
								<th width="230">商品属性</th>
								<th width="140">单价</th>
								<th width="100">数量</th>
								<th width="140">运费</th>
								<th width="200">小计</th>
							</tr>
							<tr style="border: none;height: 20px;"></tr>
						</thead>
						
						<tbody>
							<tr>
								<td colspan="6">站点：<span>杭州站</span></td>
							</tr>
							<tr>
								<td>
									<div class="img"><img alt="图片" src=""/></div>
									<div class="txt">
										<span class="proName">2016东过膝长靴高筒加绒保暖牛皮鞋带黑真皮磨砂女靴</span>
									</div>
								</td>
								<td class="info">
									颜色分类：浅棕色[单内里,适合秋冬]<br/>
									尺码：37
								</td>
								<td class="price">￥259.00</td>
								<td class="num">1</td>
								<td class="subtotal">￥36.00</td>
								<td>￥1036.00</td>
							</tr>
							<tr>
								<td>
									<div class="img"><img alt="图片" src=""/></div>
									<div class="txt">
										<span class="proName">2016东过膝长靴高筒加绒保暖牛皮鞋带黑真皮磨砂女靴</span>
									</div>
								</td>
								<td class="info">
									颜色分类：浅棕色[单内里,适合秋冬]<br/>
									尺码：37
								</td>
								<td class="price">￥259.00</td>
								<td class="num">1</td>
								<td class="subtotal">￥36.00</td>
								<td>￥1036.00</td>
							</tr>
							<tr>
								<td>
									<div class="img"><img alt="图片" src=""/></div>
									<div class="txt">
										<span class="proName">2016东过膝长靴高筒加绒保暖牛皮鞋带黑真皮磨砂女靴</span>
									</div>
								</td>
								<td class="info">
									颜色分类：浅棕色[单内里,适合秋冬]<br/>
									尺码：37
								</td>
								<td class="price">￥259.00</td>
								<td class="num">1</td>
								<td class="subtotal">￥36.00</td>
								<td>￥1036.00</td>
							</tr>
							<tr>
								<td></td>
								<td>共 3 件产品</td>
								<td>运费 ￥210.00</td>
								<td></td>
								<td>应付金额:</td>
							</tr>
						</tbody>
						
						<tbody>
							<tr style="border: none;height: 50px;"></tr>
						</tbody>
						
						<tbody>
							<tr>
								<td colspan="6">站点：<span>成都站</span></td>
							</tr>
							<tr>
								<td>
									<div class="img"><img alt="图片" src=""/></div>
									<div class="txt">
										<span class="proName">2016东过膝长靴高筒加绒保暖牛皮鞋带黑真皮磨砂女靴</span>
									</div>
								</td>
								<td class="info">
									颜色分类：浅棕色[单内里,适合秋冬]<br/>
									尺码：37
								</td>
								<td class="price">￥259.00</td>
								<td class="num">1</td>
								<td class="subtotal">￥36.00</td>
								<td>￥1036.00</td>
							</tr>
							<tr>
								<td>
									<div class="img"><img alt="图片" src=""/></div>
									<div class="txt">
										<span class="proName">2016东过膝长靴高筒加绒保暖牛皮鞋带黑真皮磨砂女靴</span>
									</div>
								</td>
								<td class="info">
									颜色分类：浅棕色[单内里,适合秋冬]<br/>
									尺码：37
								</td>
								<td class="price">￥259.00</td>
								<td class="num">1</td>
								<td class="subtotal">￥36.00</td>
								<td>￥1036.00</td>
							</tr>
							<tr>
								<td>
									<div class="img"><img alt="图片" src=""/></div>
									<div class="txt">
										<span class="proName">2016东过膝长靴高筒加绒保暖牛皮鞋带黑真皮磨砂女靴</span>
									</div>
								</td>
								<td class="info">
									颜色分类：浅棕色[单内里,适合秋冬]<br/>
									尺码：37
								</td>
								<td class="price">￥259.00</td>
								<td class="num">1</td>
								<td class="subtotal">￥36.00</td>
								<td>￥1036.00</td>
							</tr>
						</tbody>
						
						
						<tfoot>
							<tr style="border: none;height: 50px;"></tr>
							<tr>
								<td colspan="4">
									<span style="letter-spacing: 1px;">有事您留言: </span>
									<textarea ></textarea>
								</td>
								<td colspan="2" align="center">
									<input class="btn btn-warning" type="button" value="提交订单付款"/>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<!-- 主体 end -->
	</body>
</html>