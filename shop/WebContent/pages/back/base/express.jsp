<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物流管理</title>
 		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
  	.layui-table-view {
	    position: relative;
	    margin: 10px 18px;
	    overflow: hidden;
	}
	body{
		padding: 10px;
	}
  </style>
</head>
<body> 

<div class="demoTable">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;搜索名称：
  <div class="layui-inline">
    <input class="layui-input" name="name" id="name" autocomplete="off">
  </div>
  编码：
  <div class="layui-inline">
    <input class="layui-input" name="code" id="code" autocomplete="off">
  </div>
   网址：
  <div class="layui-inline">
    <input class="layui-input" name="url" id="url" autocomplete="off">
  </div> 
  <button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
  <button class="layui-btn layui-btn-warm" onclick="add()"><i class="layui-icon">&#xe608;</i>增加物流</button>
</div>



<table class="layui-table" lay-data="{width: 818 , height:475, url:'express/back/showList.action', page:true,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'expreessId', width:140, sort: true, fixed: true},hidden:'true'">ID</th>
      <th lay-data="{field:'name', width:130}">名称</th>
   	  <th lay-data="{field:'code', width:150, sort: true}">编码</th>
      <th lay-data="{field:'url', width:130}">网址</th>
   	  <th lay-data="{field:'logo', width:200, sort: true, templet:'#logoTpl'}">LOGO</th>
      <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>


<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

<!-- 图片 -->
<script type="text/html" id="logoTpl">
	<img alt="暂无图片" src="{{ d.logo }}" />
</script>          
          
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
var table;
layui.use('table', function(){
  table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.id + ' 的查看操作');
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	 obj.del();
        layer.close(index);
        url = "express/back/delete.action?expreessId="+data.expreessId;
        $.post(url,null,function(mes){
        	table.reload('testReload');
        	
        	if(mes.state==1){
				layer.msg(mes.mes);
				tableReload();//重载表格的方法
			}else{
				layer.msg(mes.mes);
			}
        	
            
        },"json")
      
      });
     
	} else if(obj.event === 'edit'){
		layer.open({
			type:2,
			skin: 'layui-layer-molv',//样式
			content:'pages/back/base/expressadd.jsp?expreessId='+data.expreessId,
			area: ['500px', '390px'],
			title: '编辑物流',
		});	

    }
  });
  
 
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#name');
			  var demoReload1 = $('#code');
		      var demoReload2 = $('#url');
		      table.reload('testReload', {
		        where: {
		         
		        	name: demoReload.val(),
		        	code:demoReload1.val(),
		        	url:demoReload2.val()
		        }
		      });
		    }
		  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

function add(){
	
	layer.open({
		type:2,
		skin: 'layui-layer-molv',//样式
		content:'pages/back/base/expressadd.jsp',
		area: ['500px', '390px'],
		title: '增加物流',
	});

}


</script>

</body>
</html>