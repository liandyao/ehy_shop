<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单测试</title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="res/css/myOrders.css">
<link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="res/css/bootstrap-datepicker3.css">
<script src="res/js/jquery-2.1.4.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap-datepicker.min.js"></script>


</head>
<body>
	<div class="bigBox">
		<div class="orderBox">
			<div class="ztBox">
				<div onclick="pitchOn(this,0)" class="onddzt" title="red">
					<a href="javascript:void(0)">所有订单</a>
				</div>
				<div onclick="pitchOn(this,10)" class="ddzt">
					<a href="javascript:void(0)">待付款</a>
				</div>
				<div onclick="pitchOn(this,20)" class="ddzt">
					<a href="javascript:void(0)">待发货</a>
				</div>
				<div onclick="pitchOn(this,30)" class="ddzt">
					<a href="javascript:void(0)">待收货</a>
				</div>
				<div onclick="pitchOn(this,40)" class="ddzt">
					<a href="javascript:void(0)">已完成</a>
				</div>
				<div class="ddSeek">
					<div class="gd">
						<a href="javascript:Toggle(0);">更多筛选条件<img class="jt"
							src="res/images/jt_s.png"></a>

					</div>
					<form id="for">
						<div class="forbox">
							<input class="ipt" name="keyword" type="text" placeholder="输入商品标题或订单号进行搜索"
								name=""><input class="ssbt" onclick="reveal(1)" type="button" value="订单搜索">

						</div>
						<div class="hidn">
							<div class="times">
								<input class="start" placeholder="起始日期" name="start" data-provide="datepicker">~<input
									class="terminus"placeholder="结束日期"  name="terminus" data-provide="datepicker">
							</div>
							<div class="fz">
								选择站点：<select class="site" name="site"><option value="">----请选择----</option>
								</select>
							</div>
						</div>
					</form>
				</div>
			</div>
			<table class="top">
				<tbody class="mes">
					<tr class="mestr">
						<th class="baby">宝贝</th>
						<th class="price">单价</th>
						<th class="num">数量</th>
						<th class="sj_price">实付款</th>
						<th class="cz">操作</th>
					</tr>
				</tbody>
			</table>
			<div class="orderb">
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="res/js/myOrder.js"></script>
<script type="text/javascript">
	$(function(){
		zd();
		reveal(1);
	})
</script>
</html>