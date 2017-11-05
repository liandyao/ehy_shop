<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>已发货订单</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/js/drag-sort.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<script type="text/javascript">
		/**
			格式化日期
		*/
		Date.prototype.Format = function (fmt) { //author: meizz 
		    var o = {
		        "M+": this.getMonth() + 1, //月份 
		        "d+": this.getDate(), //日 
		        "h+": this.getHours(), //小时 
		        "m+": this.getMinutes(), //分 
		        "s+": this.getSeconds(), //秒 
		        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		        "S": this.getMilliseconds() //毫秒 
		    };
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		    return fmt;
		}
		</script>
	</head>
	<body>
		<table class="layui-table" lay-data="{height:383, size:'sm', url:'orderItem/back/showList.action?state=2', page:true, method:'post', id:'idTest'}"  lay-filter="demo" id="tab">
		  <thead>
		    <tr>
		      <th lay-data="{field:'ordId', width:100, sort: true}">订单号</th>
		      <th lay-data="{field:'stName', width:100, sort: true}">站点名称</th>
		      <th lay-data="{field:'proName', width:100, sort: true}">商品名称</th>
		      <th lay-data="{field:'mbName', width:100, sort: true}">会员名</th>
		      <th lay-data="{field:'ordState', width:100, sort: true, templet:'#stateTemp'}">订单状态</th>
		      <th lay-data="{field:'ordExpress', width:100, sort: true, templet:'#ordExpressTemp'}">快递公司</th>
		      <th lay-data="{field:'ordExpressCode', width:100, sort: true, templet:'#ordExpressCodeTemp'}">快递单号</th>
		      <th lay-data="{field:'mxPrice', width:100, sort: true}">价格</th> 
		      <th lay-data="{field:'mxNum', width:100, sort: true}">数量</th>
		      <th lay-data="{field:'mxMoneyFact', width:100, sort: true}">实际付款金额</th>
		      <th lay-data="{field:'mxMoney', width:100, sort: true}">总金额</th>
		      <th lay-data="{field:'mxJstime', width:100, sort: true, templet:'#mxJstime'}">结算时间</th>
		      <th lay-data="{field:'mxIsjs', width:100, sort: true}">是否结算</th>
		      <th lay-data="{field:'mxEmp', width:100, sort: true}">付款人</th>
		      
		      <th lay-data="{fixed: 'right', width:160, align:'center', toolbar: '#barDemo'}"></th>
		    </tr>
		  </thead><!-- <fmt:formatDate value='${obj.createDate}' pattern='yyyy-MM-dd HH:mm:ss'/> -->
		</table>
		<script type="text/html" id="mxJstime">
  	<span>{{ (new Date(d.mxJstime)).Format("yyyy-MM-dd hh:mm:ss") }}<span>
		</script>
		<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
		</script>
		<script type="text/javascript">
		var table;
		layui.use('table', function() {
			table = layui.table;
			//监听工具条
			table.on('tool(demo)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			    	layer.msg('ID：'+ data.mxId + ' 的查看操作');
			    }
			});
		});
		</script>
	</body>
</html>