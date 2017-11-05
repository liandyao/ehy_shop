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
<title>优惠券管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
<script src="res/js/drag-sort.js" type="text/javascript"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<div class="demoTable">
		站点名称：
		<div class="layui-inline">
			<input class="layui-input" name="stName" id="stName"
				style="width: 150px" autocomplete="off">
		</div>
		优惠券编码：
		<div class="layui-inline">
			<input class="layui-input" name="couponCode" id="couponCode"
				style="width: 150px" autocomplete="off">
		</div>
		开始时间：
		<div class="layui-input-inline">
			<input name="startTime" id="startTime" lay-verify="date"
				placeholder="请选择起始日" style="width: 150px" autocomplete="off"
				class="layui-input" type="text">
		</div>
		结束时间：
		<div class="layui-input-inline">
			<input name="endTime" id="endTime" lay-verify="date"
				placeholder="请选择结束日" style="width: 150px" autocomplete="off"
				class="layui-input" type="text">
		</div>
		<button class="layui-btn" data-type="reload">
			<i class="layui-icon">&#xe615;</i>搜索
		</button>
		<button data-type="auto" class="layui-btn layui-btn-normal"
			onclick="showAddOrUpdate()">
			<i class="layui-icon">&#xe608;</i>新增
		</button>
	</div>

	<table class="layui-table"
		lay-data="{ height:383,size:'sm', url:'coupon/back/showList.action', page:true, id:'idTest',method:'post'}"
		lay-filter="demo">
		<thead>
			<tr>
				<th lay-data="{field:'stName', width:100, align:'center'}">站点名称</th>
				<th lay-data="{field:'couponCode', width:150,  align:'center'}">优惠券编码</th>
				<th lay-data="{field:'couponMoney', width:140, align:'center',sort: true,templet: '#stTypeTpl'}">金额(单位/元)</th>
				<th lay-data="{field:'remark', width:150, align:'center'}">备注</th>
				<th lay-data="{field:'couponMinMoney', width:150, align:'center'}">抵扣金额(单位/元)</th>
				<th lay-data="{field:'startTime', width:130, align:'center'}">开始时间</th>
				<th lay-data="{field:'endTime', width:130, align:'center'}">结束时间</th>
				<th lay-data="{field:'calc', width:150, align:'center'}">计算规则</th>
				<th lay-data="{fixed: 'right', width:170, align:'center', toolbar: '#barDemo'}"></th>
			</tr>
		</thead>
	</table>

	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="stick">置顶</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>


	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		var table;
		
		//拖动排序
		function sort(obj){
			var trs = $("tbody tr");
			var startIndex = obj.attr("data-index");
			for(i=0;i<trs.length;i++){
				$(trs[i]).attr("data-index",i);
			}
			var endIndex = obj.attr("data-index");
			var couponId = table.cache.idTest[startIndex].couponId;
			var start = table.cache.idTest[startIndex].sort;
			var end = table.cache.idTest[endIndex].sort;
			if(start!=end){
				layer.load();
				var data = {"start":start,
						"end":end,
						"couponId":couponId};
				var url = "coupon/back/sortCoupon.action";
				$.post(url, data, function(info){
					layer.closeAll('loading');
					if(info.state==1){
						layer.msg(info.mes);
						table.reload('idTest');
						$("tbody").attr({"id":"wrap","class":"wrap"});
						$('#wrap').dragSort();
					}
				});
			}
			//console.log(sortArr);
		}
		
		layui.use([ 'table', 'laydate' ], function() {
			table = layui.table;
			var laydate = layui.laydate;

			//日期
			laydate.render({
				elem : '#startTime'
			});
			//日期
			laydate.render({
				elem : '#endTime'
			});

			//监听工具条
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				if(obj.event === 'stick'){ //置顶
		    		if(data.sort!=1){
		    			layer.load();
						var data = {"start":data.sort,
								"end":1,
								"couponId":data.couponId};
						var url = "coupon/back/sortCoupon.action";
						$.post(url, data, function(info){
							layer.closeAll('loading');
							if(info.state==1){
								layer.msg(info.mes);
								table.reload('idTest');
								$("tbody").attr({"id":"wrap","class":"wrap"});
								$('#wrap').dragSort();
							}
						});
					}else{
						layer.msg("该行已被置顶，请勿重复操作！");
					}
		    		
		    		
		    	 
		   		 } else if (obj.event === 'del') {//删除
					layer.confirm('真的删除行么', function(index) {
						layer.load();
						var url = "coupon/back/delete.action"; 
						var d = {
							couponId : data.couponId
						};
						$.post(url, d, function(mes) {
							layer.closeAll('loading');
							table.reload('idTest');
							if (mes.state == 1) {
								parent.layer.msg(mes.mes);
							} else {
								parent.layer.msg(mes.mes);
							} 
						}, "json")

						layer.close(index);

					});
				} else if (obj.event === 'edit') {//编辑
					showAddOrUpdate(data.couponId, data.stId); 
				}
			});

			
			var $ = layui.$, active = {
				reload : function() {
					var stName = $('#stName');
					var couponCode = $('#couponCode');
					var startTime = $('#startTime');
					var endTime = $('#endTime');
					table.reload('idTest', {
						where : {
							stName : stName.val(),
							couponCode : couponCode.val(),
							startTime : startTime.val(),
							endTime : endTime.val()
						}
					});
				}
			};
			$('.demoTable .layui-btn').on('click', function() { 
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
			
			 //排序
			 $("tbody").attr({"id":"wrap","class":"wrap"});
			 $('#wrap').dragSort();
	    });
		
		//打开表单
		function showAddOrUpdate(couponId, stId) { 
			var from = $("#fromStr").html(); 
			var addCen = layer.open({
				type : 2//样式
				,
				skin : 'layui-layer-molv'//样式
				,
				area : [ '85%', '80%' ],
				title : '优惠券维护',
				id : "mesFrom",
				shade : [ 0.8, '#393D49' ] //显示遮罩
				,
				shadeClose : true//点击也能遮罩层关闭
				,
				anim : 2//弹出动画
				,
				maxmin : true //允许全屏最小化
				,
				content : 'pages/back/couponForm.jsp?couponId=' + couponId
						+ '&stId=' + stId
			});
		}
	</script> 
</body>
</html>