<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>运费模版管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
<script src="res/js/drag-sort.js" type="text/javascript"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="demoTable">
 模版名称：
  <div class="layui-inline">
    <input class="layui-input" name="tempName" id="tempName" autocomplete="off">
  </div>
   快递公司：
  <div class="layui-inline">
    <input class="layui-input" name="name" id="name" autocomplete="off">
  </div>
  站点名称：
  <div class="layui-inline">
    <input class="layui-input" name="stName" id="stName" autocomplete="off">
  </div>
  
  <button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
  <button data-type="auto" class="layui-btn layui-btn-normal" onclick="showAddOrUpdate()"><i class="layui-icon">&#xe608;</i>新增</button>
</div>

	<table class="layui-table"
		lay-data="{ height:383,size:'sm',url:'expressTemplate/back/showList.action', page:true,hidden:'true', id:'idTest',method:'post'}"
		lay-filter="demo">
		<thead>
			<tr>
				<th lay-data="{field:'tempName', width:100, align:'center'}">模版名称</th>
				<th lay-data="{field:'name', width:180, align:'center'}">快递公司</th>
				<th lay-data="{field:'stName', width:150, sort: true,align:'center'}">站点名称</th>
				<th lay-data="{field:'money', width:150,sort: true, align:'center'}">运费(单位/元)</th>
				<th lay-data="{field:'remark', width:150, align:'center'}">备注</th> 
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
	
	function sort(obj){
		var trs = $("tbody tr");
		var startIndex = obj.attr("data-index");
		for(i=0;i<trs.length;i++){
			$(trs[i]).attr("data-index",i);
		}
		var endIndex = obj.attr("data-index");
		var tempId = table.cache.idTest[startIndex].tempId;
		var start = table.cache.idTest[startIndex].sort;
		var end = table.cache.idTest[endIndex].sort;
		
		if(start!=end){
			layer.load();
			var data = {"start":start,
					"end":end,
					"tempId":tempId};
			var url = "expressTemplate/back/sortTemplate.action";
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
	
layui.use(['table','laydate'], function(){
  table = layui.table;
  var laydate = layui.laydate;
  
  
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'stick'){
		if(data.sort!=1){
			layer.load();
			var data = {"start":data.sort,
					"end":1,
					"tempId":data.tempId};
			var url = "expressTemplate/back/sortTemplate.action";
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
		
		
	 
		 } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	layer.load();
        var url = "expressTemplate/back/delete.action";
        
        var d ={tempId:data.tempId};
        $.post(url,d,function(mes){
        	layer.closeAll('loading');
        	table.reload('idTest');
        	if(mes.state==1){
        		parent.layer.msg(mes.mes);  
        	}else{
        		parent.layer.msg(mes.mes); 
        	}
        	
        },"json")
       
        layer.close(index);
         
      });
    } else if(obj.event === 'edit'){
   		showAddOrUpdate(data.tempId,data.stId,data.expressId);
    }
  });
  
  
  var $ = layui.$, active = {
		    reload: function(){
		      var tempName = $('#tempName');
		      var name = $('#name');
		      var stName = $('#stName');
		      table.reload('idTest', {
		        where: {
		        	tempName: tempName.val(),
		        	name: name.val(),
		        	stName: stName.val(),
		        }
		      });
		    }
  };
  $('.demoTable .layui-btn').on('click', function(){
	  
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
  $("tbody").attr({"id":"wrap","class":"wrap"});
	$('#wrap').dragSort();

});
function showAddOrUpdate(tempId,stId,expressId){
	
	var from = $("#fromStr").html();
	
	var addCen= layer.open({
        type: 2//样式
        ,skin: 'layui-layer-molv'//样式
        ,area: ['85%', '85%']
	    ,title: '快递模板维护'
	    ,id : "mesFrom"
        ,shade: [0.8, '#393D49'] //显示遮罩
        ,shadeClose:true//点击也能遮罩层关闭
        ,anim:2//弹出动画
        ,maxmin: true //允许全屏最小化
        ,content: 'pages/back/expressTemplateForm.jsp?tempId='+tempId+'&stId='+stId+'&expressId='+expressId
      });
	
}

</script>

</body>
</html>