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
		<title>售后处理</title>
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
		<div class="demoTable">
		    时间：
		  <div class="layui-input-inline">
		        <input name="mxStartTime" id="mxStartTime" lay-verify="date" placeholder="请选择起始日"  autocomplete="off" class="layui-input" type="text">
		      </div>
		   ~
		  <div class="layui-input-inline">
		        <input name="mxEndTime" id="mxEndTime" lay-verify="date" placeholder="请选择结束日"  autocomplete="off" class="layui-input" type="text">
		      </div>
		      实际付款金额:
		      <div class="layui-input-inline">
		        <input name="minMxMoneyFact" id="minMxMoneyFact" lay-verify="number" placeholder="请选择起金额"  autocomplete="off" class="layui-input" type="number">
		      </div>
		   ~
		  <div class="layui-input-inline">
		        <input name="maxMxMoneyFact" id="maxMxMoneyFact" lay-verify="number" placeholder="请选择结束金额"  autocomplete="off" class="layui-input" type="number">
		      </div>
		  <button class="layui-btn" data-type="reload"><!-- <i class="layui-icon">&#xe615;</i> -->搜索</button>
		  <button class="layui-btn" data-type="" onclick="showFrom()">资金结算</button>
		</div>
		<table class="layui-table" lay-data="{height:383, size:'sm', url:'orderItem/back/showList.action?state=3', page:true, method:'post', id:'idTest', hidden:'true'}"  lay-filter="demo" id="tab">
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
		  </thead>
		</table>
		<div style="display:none; padding:40px;" id="fromdiv">
			<form class="layui-form" action="" id="from">
				<div class="layui-form-item">
					<label class="layui-form-label" style="width:120px;">自上次结算日期:</label>
					<div class="layui-input-inline">
						<input name="statrTime" id="startTime" autocomplete="off" disabled="disabled" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label" style="width:120px;">结算截止日期：</label>
					<div class="layui-input-inline">
						<input name="endTime" id="endTime" placeholder="请选择起始日" lay-verify="date" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label" style="width:120px;">描述：</label>
					<div class="layui-input-inline">
						<textarea name="mrRemark" id="mrRemark" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input type="button" class="layui-btn" lay-submit="" lay-filter="demo" value="提交">
						<button type="reset" class="layui-btn layui-btn-primary" >重置</button>
					</div>
				</div>
			</form>
		</div>
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
	</script>
	<script type="text/html" id="mxJstime">
  <span>{{ (new Date(d.mxJstime)).Format("yyyy-MM-dd hh:mm:ss") }}<span>
	</script>
	<script type="text/html" id="stateTemp">
  {{#  if(d.ordState == 0){ }}
    <span style="color: #F581B1;">已删除</span>
  {{#  } else if(d.ordState == 1) { }}
    <span style="color: #F581B1;">申请退货</span>
  {{#  } else if(d.ordState == 2) { }}
    <span style="color: #F581B1;">已退货</span>
  {{#  } else if(d.ordState == 10) { }}
    <span style="color: #F581B1;">已签收</span>
  {{#  } else if(d.ordState == 40){ }}
  	<span style="color:green">已完成</span>
  {{#  } }}
	</script>
	<script type="text/javascript">
	
	var table;
	var addCen;
	var form;
	
	function findMaxTime(){
		var url = "moneyRecord/back/findMaxTime.action";
		$.post(url, null, function(info){
			if(info.state>0){
				$("#startTime").attr("placeholder",info.mes);
			}else{
				layer.mes("发生一个未知错误，请刷新页面后重试！");
			}
		});
	}
	
	layui.use(['table','laydate','form'], function() {
		table = layui.table;
		
		//监听表格复选框选择
		table.on('checkbox(demo)', function(obj){
			console.log(obj)
		});
		
		//监听工具条
		table.on('tool(demo)', function(obj){
		  var data = obj.data;
		  if(obj.event === 'detail'){
		    layer.msg('ID：'+ data.mxId + ' 的查看操作');
		  } else if(obj.event === 'edit'){
		    layer.alert('编辑行：<br>'+ JSON.stringify(data))
		  }
		});
		
		laydate = layui.laydate;
		//日期
		var startTime = laydate.render({
			elem : '#mxStartTime',
			trigger : 'click',
			done : function(value, date, endDate) {
				if(value!=''){
					endTime.config.min.year = date.year;
					endTime.config.min.month = date.month - 1;
					endTime.config.min.date = date.date;
				}else{
					endTime.config.min.year = '1900';
					endTime.config.min.month = '01';
					endTime.config.min.date = '01';
				}
			}
		});
		//日期
		var endTime = laydate.render({
			elem : '#mxEndTime',
			trigger : 'click',
			max : new Date().Format("yyyy-MM-dd hh:mm:ss")
		});
		
		laydate.render({
			elem : "#endTime",
			trigger : 'click',
			max : new Date().Format("yyyy-MM-dd hh:mm:ss")
		});
		
		form = layui.form;
		
		//监听提交
		form.on('submit(demo)', function(data){
			  
			var data = $("#from").serialize();
			var url = "moneyRecord/back/jeiSuan.action";
				
			$.post(url, data, function(mes){
				if(mes.state==1){
					layer.msg(mes.mes);
					layer.close(addCen);
		      	}else if(mes.state==2){
		      		layer.msg(mes.mes);
		      	}else{
		      		layer.msg(mes.mes);
		      	}
			});
		});
		
	});
	
	function showFrom(){
		findMaxTime();
		addCen = layer.open({
	        type: 1//样式
	        ,skin: 'layui-layer-molv'//样式
	        ,area: ['65%', '86%']
	        ,title:"总结资金"//标题
	        ,id: 'mesFrom' //防止重复弹出
	        ,content: $("#fromdiv")
	        ,shade: [0.8, '#393D49'] //显示遮罩
	        ,shadeClose:true//点击也能遮罩层关闭
	        ,anim:2//弹出动画
	      });
	}
	
	</script>
	</body>
</html>