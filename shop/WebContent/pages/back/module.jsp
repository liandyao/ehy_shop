<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模块管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/js/drag-sort.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
<style type="text/css">
	tbody {
   -moz-user-select: -moz-none;
   -khtml-user-select: none;
   -webkit-user-select: none;

   /*
     Introduced in IE 10.
     See http://ie.microsoft.com/testdrive/HTML5/msUserSelect/
   */
   -ms-user-select: none;
   user-select: none;
}
</style>
</head>
<body>
  <div class="layui-inline" style="width: 140px;">
    <form id="form" class="layui-form" lay-filter="from">
		<select name=ehyModId id="ehyModId" onchange="search()">
			<option value="">请选择</option>
		</select> 
 	</form>
  </div>
   模块名称：
  <div class="layui-inline" style="width: 140px;">
    <input class="layui-input" name="modName" id="modName" autocomplete="off">
  </div>
  模块编码：
  <div class="layui-inline" style="width: 140px;">
    <input class="layui-input" name="modCode" id="modCode" autocomplete="off">
  </div>
  模块说明：
  <div class="layui-inline">
    <input class="layui-input" name="modDesc" id="modDesc" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="search()">搜索</button>
  <button data-type="auto" class="layui-btn layui-btn-normal" onclick="showAddOrUpdate('')">新增模块</button>
	<table class="layui-table" lay-data="{height:383, size:'sm', url:'module/back/showList.action', page:true, method:'post', id:'idTest', hidden:'true'}"  lay-filter="demo" id="tab">
	  <thead>
	    <tr>
	      <th lay-data="{field:'ehyModName', width:100}">上级名称</th>
	      <th lay-data="{field:'url', width:250, sort: true}">模块URL</th>
	      <th lay-data="{field:'modName', width:100}">模块名称</th>
	      <th lay-data="{field:'modCode', width:130}">模块编码</th>
	      <th lay-data="{field:'modDesc', width:360}">模块说明</th>
	      <th lay-data="{fixed: 'right', width:180, align:'center', toolbar: '#barDemo'}"></th>
	    </tr>
	  </thead>
	</table>
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-mini" lay-event="zhiding">置顶</a>
  		<a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
	</script>
	<script>
		
		$(function (){
			showSelect();
		});
	
		var table ;
	
		function sort(obj){
			var trs = $("tbody tr");
			var startIndex = obj.attr("data-index");
			for(i=0;i<trs.length;i++){
				$(trs[i]).attr("data-index",i);
			}
			var endIndex = obj.attr("data-index");
			var modId = table.cache.idTest[startIndex].modId;
			var start = table.cache.idTest[startIndex].sort;
			var end = table.cache.idTest[endIndex].sort;
			if(start!=end){
				layer.load();
				var data = {"start":start,
						"end":end,
						"modId":modId};
				var url = "module/back/sortModule.action";
				$.post(url, data, function(info){
					layer.closeAll('loading');
					if(info.state==1){
						table.reload('idTest');
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
	
		
		layui.use('table', function() {
			table = layui.table;
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						var data = {"modId":obj.data.modId};
						var url = "module/back/delete.action";
						$.post(url, data, function(info){
							if(info.state==1){
								layer.msg(info.mes);
								obj.del();
								layer.close(index);
								parent.show();
							}
						});
					});
				} else if (obj.event === 'edit') {
					 showAddOrUpdate(data);
				} else if (obj.event === 'zhiding'){
					if(data.sort!=1){
						var data = {"start":data.sort,
								"end":1,
								"modId":data.modId};
						var url = "module/back/sortModule.action";
						$.post(url, data, function(info){
							if(info.state==1){
								layer.msg("操作成功！");
								table.reload('idTest', {
								  url: 'module/back/showList.action'
								  ,where: {}
								});
								$("tbody").attr({"id":"wrap","class":"wrap"});
								$('#wrap').dragSort();
							}
						});
					}else{
						layer.msg("该行已被置顶，请勿重复操作！");
					}
				}
			});
			$("tbody").attr({"id":"wrap","class":"wrap"});
			$('#wrap').dragSort();
		});
		
		function showAddOrUpdate(obj){
			
			var from = $("#fromStr").html();
			var addCen = layer.open({
		        type: 2//样式
		        ,skin: 'layui-layer-molv'//样式
		        ,area: ['85%', '86%']
		        ,title:"模块维护"//标题
		        ,id: 'mesFrom' //防止重复弹出
		        ,content: "pages/back/moduleFrom.jsp?modId="+obj.modId+"&ehyModId="+obj.ehyModId
		        ,shade: [0.8, '#393D49'] //显示遮罩
		        ,shadeClose:true//点击也能遮罩层关闭
		        ,anim:2//弹出动画
		      });
		}
		
		function search(){
			table.reload('idTest', {
			  url: 'module/back/showList.action'
			  ,where: {
				  "ehyModId":$("#ehyModId").val()
				  //,"url":"%"+$("#url").val()+"%"
				  ,"modName":"%"+$("#modName").val()+"%"
				  ,"modCode":"%"+$("#modCode").val()+"%"
				  ,"modDesc":"%"+$("#modDesc").val()+"%"
			  } //设定异步数据接口的额外参数
			  //,height: 300
			});
			$("tbody").attr({"id":"wrap","class":"wrap"});
			$('#wrap').dragSort();
		}
		
		function showSelect(){
			var url = "module/back/findFirstLevel.action";
			$("#ehyModId").html("<option value=''>请选择</option>");
			$.ajax({
				type : "POST",
				url : url, 
				data : null, 
				async : false,
				success : function(info){
					for(i=0; i<info.length; i++){
						var obj = info[i];
						$("#ehyModId").append("<option value="+obj.modId+">"+obj.modName+"</option>");
					}
				}
			});
			layui.use('form', function() {
				var form = layui.form;
				form.render('select', 'from');
			});
		}
		
	</script>
</body>
</html>