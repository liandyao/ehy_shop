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
<title>会员等级管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>

<script src="res/js/drag-sort.js" type="text/javascript" ></script>
<style type="text/css">


</style>
</head>
<body>
	<div style="margin: 20px;">
		<div class="demoTable">
		<div class="layui-form" id="sousuo">
			搜索会员等级：
			<div class="layui-inline">
				<input class="layui-input" name="levelName" id="levelName"
					autocomplete="off">
			</div>
			我的货架：

			<div class="layui-inline">
				<select id="dicRemark" name="dicRemark" lay-verify="aihao">
					<option value="">请选择</option>
					<option value="1">不允许添加</option>
					<option value="2">允许添加(本站)</option>
					<option value="3">允许添加(全站)</option>
				</select>
			</div>


			<button class="layui-btn" data-type="reload">搜索</button>
			
  			<input type="button" class="layui-btn" style="margin-right:200px;" onclick="addEhyMemberLevel(value)" value="新增会员等级">
		</div>
		</div>
		<table class="layui-table"
			lay-data="{ height:400,size:'sm', url:'<%=basePath%>memberLevel/back/findAll.action',method:'post',id:'testReload', page: true, limit: 10}"
			lay-filter="demo">
			<thead>
				<tr>
				
					<th lay-data="{hidden:'LEVEL_ID',hidden}" rowspan="2">等级ID</th> 
					<th lay-data="{field:'LEVEL_NAME', width:300}" rowspan="2">会员等级</th>
					<th lay-data="{field:'SCALE', width:200}" rowspan="2">优惠比例</th>
					<th lay-data="{field:'DIC_REMARK', width:200,templet:'#sexTpl'}" rowspan="2">我的货架</th>
					<th lay-data="{fixed: 'right', width: 250, align: 'center', toolbar: '#barDemo'}"
						rowspan="2">操作</th>
				</tr>
				<!--  <tr>
      <th lay-data="{field:'province', width:120}">省</th>
      <th lay-data="{field:'city', width:120}">市</th>
      <th lay-data="{field:'zone', width:200}">区</th>
    </tr>  -->
			</thead>
		</table>
	</div>
	<script type="text/html" id="sexTpl">
		
  		

		{{#  if(d.DIC_REMARK === '1'){ }}
    	{{ '不允许添加' }}
		{{# }else if(d.DIC_REMARK === '2'){ }}
    	{{ '允许添加(本站)' }}
		{{# }else if(d.DIC_REMARK === '3'){ }}
    	{{ '允许添加(全站)' }}
		{{# } }}
	</script>
	<script type="text/html" id="barDemo">
 <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
{{#  if(d.SORT===1){ }}
 
{{# }else{ }}
 <a class="layui-btn layui-btn-mini" lay-event="zhiding">置顶</a>
{{# } }}
 <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
{{#  if(d.LEVEL_ID === '1' || d.LEVEL_ID === '2' || d.LEVEL_ID === '3' || d.LEVEL_ID === '4'){ }}
 
{{# }else{ }}
<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">	删除</a>
{{# } }}
</script>
	<script>
	var table ;
	function sort(obj){
		var trs = $("tbody tr");
		var startIndex = obj.attr("data-index");
		for(i=0;i<trs.length;i++){
			$(trs[i]).attr("data-index",i);
		}
		var endIndex = obj.attr("data-index");
		var LEVEL_ID = table.cache.testReload[startIndex].LEVEL_ID;
		var start = table.cache.testReload[startIndex].SORT;
		var end = table.cache.testReload[endIndex].SORT;
		if(start!=end){
			layer.load();
			var data = {"start":start,
					"end":end,
					"levelId":LEVEL_ID};
			var url = "memberLevel/back/sortMemberLevel.action";
			$.post(url, data, function(info){
				layer.closeAll('loading');
				if(info.state==1){
					table.reload('testReload');
					$("tbody").attr({"id":"wrap","class":"wrap"});
					$('#wrap').dragSort();
				}
				/* for(i=0; i<table.cache.idTest.length; i++){
					if(end>start){
						if(table.cache.idTest[i].sort<=end && table.cache.idTest[i].sort>start){
							table.cache.idTest[i].sort-=1;
						}
					}else{
						if(table.cache.idTest[i].sort>=end && table.cache.idTest[i].sort<start){
							table.cache.idTest[i].sort+=1;
						}
					}
					if(table.cache.idTest[i].modId==info.mes){
						table.cache.idTest[i].sort=end;
					}
				}
				console.log(table.cache.idTest); */
			});
		}
	} 
	var dicRemark;
		
		layui.use('table', function() {
			table = layui.table;
			
			//监听工具条
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				if (obj.event === 'detail') {
					if(data.DIC_REMARK=="1"){
						dicRemark="不允许添加";
					}else if(data.DIC_REMARK=="2"){
						dicRemark="允许添加(本站)";
					}else if(data.DIC_REMARK=="3"){
						dicRemark="允许添加(全站)";
					}
					layer.msg(/* '编号：' + data.levelId +  */'会员等级：'+ data.LEVEL_NAME+'<br/>优惠比例：'+data.SCALE+'<br/>我的货架：'+dicRemark);
				} else if (obj.event === 'del') {
					layer.confirm('真的要删除行吗！', function(index) {
						var url="<%=basePath%>/memberLevel/back/deleteRec.action";
						var date ={"levelId":data.LEVEL_ID};
					    $.post(url,date,function(mes){
						   if(mes.state=="1"){  
							   
							   parent.layer.msg(mes.mes);
							   table.reload('testReload');
						   }else{
							  
							   parent.layer.msg(mes.mes);
							   table.reload('testReload');
						   }
					    },"json");
						layer.close(index);
					});
				} else if (obj.event === 'edit') {
					var edit="编辑会员等级";
					var levelId = data.LEVEL_ID;
					addEhyMemberLevel(edit,levelId);
				}else if (obj.event === 'zhiding'){
					
					if(data.sort!=1){
						var data = {"start":data.SORT,
								"end":1,
								"levelId":data.LEVEL_ID};
						var url = "memberLevel/back/sortMemberLevel.action";
						$.post(url, data, function(info){
							if(info.state==1){
								layer.msg("操作成功！");
								table.reload('testReload');
								$("tbody").attr({"id":"wrap","class":"wrap"});
								$('#wrap').dragSort();
							}
						});
					}else{
						layer.msg("该行已被置顶，请勿重复操作！");
					}
				}
			
			});
		
			var $ = layui.$, active = {
				
					reload : function() {
					var demoReload = $('#levelName').val();
					var dicRemark =$('#dicRemark').val();
					table.reload('testReload', {
						where : {
								levelName : demoReload,
								dicRemark:dicRemark
						}
					});
				}
			};
			$('.demoTable .layui-btn').on('click', function() {
				
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
			$("tbody").attr({"id":"wrap","class":"wrap"});
			$('#wrap').dragSort();
		});
		
		function addEhyMemberLevel(obj,levelId){
			
			layer.open({
				type:2,
				skin: 'layui-layer-molv',
				content:'pages/back/EhyMemberLevelForm.jsp?id='+levelId,
				area: ['85%', '70%'],
				title: obj,
			});
		}
		
	</script>
</body>
</html>