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
		<meta http-equiv="keywords" content="E货源,登陆,前台" /><!-- 设置搜索引擎关键字 -->
		<meta http-equiv="description" content="E货源网站前台登陆页面" /><!-- 设置内容简介，字数上限76个字 -->
		<title>E货源--会员登陆</title>
		<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="res/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="res/css/cart.css"/>
		<script src="res/js/jquery-2.1.4.min.js"></script>
		<script src="res/js/cart.js"></script>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
		<div id="cartList" align="center">
			<table>
				<thead>
					<tr>
						<th width="260">店铺宝贝</th>
						<th width="216">商品属性</th>
						<th width="120">单价</th>
						<th width="140">数量</th>
						<th width="140">小计</th>
						<th width="100">操作</th>
					</tr>
					<tr style="border: none;height: 20px;"></tr>
				</thead>
				
				<tbody>
					<tr>
						<td colspan="3">站点：<span>成都站</span></td>
						<td colspan="3">加入购物车时间：<span>2017-11-01</span></td>
					</tr>
					<tr>
						<td>
							<div class="aceBox">
								<label>
									<input type="checkbox" class="cartId"/>
									<span class="lbl"></span>
								</label>
							</div>
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
						<td>
							<div class="num-box">
								<span class="span box_item" onclick="addOrCut(this)">-</span>
								<span class="num box_item">1</span>
								<span class="span box_item" onclick="addOrCut(this)">+</span>
							</div>
						</td>
						<td class="subtotal">￥1036.00</td>
						<td>
							<a href="javascript:void(0);">删除</a>
						</td>
					</tr>
				</tbody>
				
				<tfoot>
					<tr style="border: none;height: 20px;"></tr>
					<tr>
						<td colspan="2">
							<div class="aceBox">
								<label>
									<input type="checkbox" id="checkAll"/>
									<span class="lbl top2"></span>
								</label>
							</div>
							<div class="selectAll">全选</div>
							<div>共 <b id="rows">4</b> 件产品，已选择 <b id="opt">0</b> 件产品</div>
						</td>
						<td colspan="2">
							总计（不含运费）：<b class="ft20" id="sum">￥0.00</b><br>
							已节省：<em>￥0.00</em>
						</td>
						<td colspan="2">
							<input class="btn btn-warning" type="button" value="前往结算"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</body>
</html>