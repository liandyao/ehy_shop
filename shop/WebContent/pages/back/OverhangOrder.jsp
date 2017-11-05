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
		<title>待发货订单</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style>
			.gary-color{
				background-color: gary;
			}
		</style>
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
		  <button class="layui-btn" data-type="getCheckData">发货</button>
		</div>
		<table class="layui-table" lay-data="{height:383, size:'sm', url:'orderItem/back/showList.action?state=1', page:true, method:'post', id:'idTest'}"  lay-filter="demo" id="tab">
		  <thead>
		    <tr>
		      <th lay-data="{checkbox:true, fixed: true}"></th>
		      <th lay-data="{field:'ordId', width:100, sort: true}">订单号</th>
		      <th lay-data="{field:'stName', width:100, sort: true}">站点名称</th>
		      <th lay-data="{field:'proName', width:100, sort: true}">商品名称</th>
		      <th lay-data="{field:'mbName', width:100, sort: true}">会员名</th>
		      <th lay-data="{field:'ordState', width:100, sort: true, templet:'#stateTemp'}">订单状态</th>
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
					<label class="layui-form-label">快递公司</label>
					<div class="layui-input-inline">
						<select name="modules" lay-verify="required" lay-search=""
							id="ordExpress">
							<option value="">---请选择---</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">订单号</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入标题" class="layui-input" id="ordExpressCode">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input type="button" class="layui-btn" lay-submit="" lay-filter="demo" value="提交">
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
		<script type="text/html" id="stateTemp">
	<span style="color:green">待发货</span>
		</script>
		
		<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">发货</a>
		</script>
		<script type="text/html" id="mxJstime">
		<span>{{ (new Date(d.mxJstime)).Format("yyyy-MM-dd hh:mm:ss") }}<span>
		</script>
		<script type="text/javascript">
		
		var table;
		var laydate;
		var trs;
		var form;
		var arrMX = "";
		var addCen;
		
		$(function (){
			showExpress();
		});
		
		function showExpress(){
			var url = "express/back/showList.action";
			var data = {"page":1,"limit":9999}
			$.post(url, data, function(map){
				 for(i=0; i<map.data.length; i++){
					 var obj = map.data[i]; 
					 $("#ordExpress").append("<option value='"+obj.name+"'>"+obj.name+"</option>");
				 }
				form.render('select');
			});
		}
		
		function showFrom(mxId){
			arrMx = "";
			for(i=0; i<mxId.length; i++){
				arrMX += mxId[i]+",";
			}
			addCen = layer.open({
		        type: 1//样式
		        ,skin: 'layui-layer-molv'//样式
		        ,area: ['85%', '86%']
		        ,title:"发货"//标题
		        ,id: 'mesFrom' //防止重复弹出
		        ,content: $("#fromdiv")
		        ,shade: [0.8, '#393D49'] //显示遮罩
		        ,shadeClose:true//点击也能遮罩层关闭
		        ,anim:2//弹出动画
		      });
		}
		
		layui.use([ 'table', 'laydate', 'form' ], function() {
			table = layui.table;
			//监听表格复选框选择
			table.on('checkbox(demo)', function(obj){
				//console.log(obj);
				$("#from")[0].reset();
			});
			 
			//监听工具条   {"a":{"a":"a"},"b":{"b":"b"}}
			table.on('tool(demo)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			    	layer.alert()
			    } else if(obj.event === 'edit'){
			        layer.alert('编辑行：<br>'+ JSON.stringify(data))
			    }
			});
			  
			var $ = layui.$, active = {
			    getCheckData: function(){ //获取选中数据    
			    var checkStatus = table.checkStatus('idTest')
			    ,data = checkStatus.data;
			    //layer.alert(JSON.stringify(data));
			    var mxId = new Array();
			    for(i=0; i<data.length; i++){
			    	mxId.push(data[i].mxId);
			    }
			    if(mxId.length>0){
			    	for(i=0; i<data.length; i++){
			    		for(j=0; j<data.length; j++){
			    			if(data[i].ordId!=data[j].ordId){
			    				layer.msg("只有同一订单的才能一起发货");
			    				return;
			    			}
			    		}
			    	}
			    	showFrom(mxId);
			    }else{
			    	layer.msg("请勾选订单");
			    }
			}
			    ,getCheckLength: function(){ //获取选中数目
			    var checkStatus = table.checkStatus('idTest')
			    ,data = checkStatus.data;
			    layer.msg('选中了：'+ data.length + ' 个');
			}
			    ,isAll: function(){ //验证是否全选
			    var checkStatus = table.checkStatus('idTest');
			    layer.msg(checkStatus.isAll ? '全选': '未全选')
			    }
			};
			  
		    $('.demoTable .layui-btn').on('click', function(){
		    	var type = $(this).data('type');
		      	active[type] ? active[type].call(this) : '';
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
					reloadRec();
				}
			});
			//日期
			var endTime = laydate.render({
				elem : '#mxEndTime',
				trigger : 'click',
				done : function(value, date, endDate) {
					if(value!=''){
						startTime.config.max.year = date.year;
						startTime.config.max.month = date.month - 1;
						startTime.config.max.date = date.date;
					}else{
						startTime.config.max.year = '2099';
						startTime.config.max.month = '12';
						startTime.config.max.date = '31';
					}
					reloadRec();
				}
			});
			$("tbody:first").attr({"id":"wrap","class":"wrap"});
			reloadRec();
			
			form = layui.form;
			//自定义验证规则
			form.verify({
				
			});
			
			//监听提交 
			form.on('submit(demo)', function(data){
				var data = {"arr":arrMX,"ordExpress":$("#ordExpress").val(),"ordExpressCode":$("#ordExpressCode").val()};
				var url = "orderItem/back/deliverGoods.action";
				$.post(url, data, function(mes){
					$("#from")[0].reset();
					table.reload('idTest');
					if(mes.state==1){
						layer.close(addCen);
						layer.msg(mes.mes);  
			      	}else{
			      		layer.msg(mes.mes); 
			      	}
				});
			});
			
		});
		
		function reloadRec(){
			table.reload('idTest', {
				where : {
					mxStartTime : $('#mxStartTime').val(),
					mxEndTime : $("#mxEndTime").val()==''?'':$("#mxEndTime").val()+" 99:99:99",
					maxMxMoneyFact : $('#maxMxMoneyFact').val()==null?'+':$('#maxMxMoneyFact').val(),
					minMxMoneyFact : $('#minMxMoneyFact').val() 
				}, done: function(res, curr, count){
				    //如果是异步请求数据方式，res即为你接口返回的信息。
				    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
				    console.log(res);
				    
				    //得到当前页码
				    console.log(curr); 
				    
				    //得到数据总量
				    console.log(count);
				 //   changeColor(res.data);
				  }
			});
		}
		
		var $ = layui.$, active = {
			reload : function() {
				reloadRec()
			}
		};
		
		$('.demoTable .layui-btn').on('click', function() {
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});
		
		/**
		
		*/
		/* function changeColor(data){
			//var data = table.cache.idTest;
			for(i=0; i<data.length; i++){
				for(var j=0;j<data.length;j++){
					if(data[i].ordId==data[j].ordId && i!=j){
						$("tr[data-index='"+i+"']").attr("color",data[i].ordId);
					}else{
						$("tr[data-index='"+i+"']").attr("color",data[i].ordId);
					}
				}
			}
			var trs = $("tr[data-index]");
			var arr = new Array();
			for(i=0; i<trs.length; i++){
				arr.push(trs[i].className);
			}
			var moth = arr.length/3*2;
			for(i=0; i<moth; i++){
				arr.pop();
			}
			var color = $("tr[color]")
			for(i=1; i<=arr.length; i++){
				if(color[i].attr("color")==color[i-1].attr("color")){
					color[i].css("background-color","#eff");
					
				}
				if(i%2==0){ 
					color[i].css("background-color","#eff");
				}else{
					color[i].css("background-color","#ffe");
				}
			} 
		}*/
		</script>
	</body>
</html>