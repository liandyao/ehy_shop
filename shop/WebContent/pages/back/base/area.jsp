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
<title>地区管理</title>
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
	
  </style>
</head>
<body> 

<div class="demoTable">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;搜索地区：
  <div class="layui-inline">
    <input class="layui-input" name="areaName" id="areaName" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
  <button class="layui-btn layui-btn-normal" onclick="derives()">导出省区</button>
  <button class="layui-btn layui-btn-normal" onclick="findCity()">导出市区</button>
  <button class="layui-btn layui-btn-normal" onclick="findArea()">导出县区</button>
</div>


<script type="text/javascript">
<!-- 导出省区  -->
	function derives(){
		loadIndex = layer.load();//出现加载层
		  url = "area/back/province.action?judge="+1;
		  $.post(url,null,function(mes){
			  layer.close(loadIndex);//加载层关闭  
	        	
	        	if(mes.state==1){
					layer.msg(mes.mes);
				}else{
					layer.msg(mes.mes);
				}
	        	
	            
	        },"json");
	      
	}
	
	<!-- 导出市区  -->
	function findCity(){
			loadIndex = layer.load();//出现加载层
			 url = "area/back/province.action?judge="+2;
		  $.post(url,null,function(mes){
			  layer.close(loadIndex);//加载层关闭  
	        	
	        	if(mes.state==1){
					layer.msg(mes.mes);
				}else{
					layer.msg(mes.mes);
				}
	        	
	            
	        },"json");
	      
	}
	
	<!-- 导出区县  -->
	function findArea(){
		loadIndex = layer.load();//出现加载层
		 url = "area/back/province.action?judge="+3;
		  $.post(url,null,function(mes){
			  layer.close(loadIndex);//加载层关闭  
	        
	        	if(mes.state==1){
					layer.msg(mes.mes);
				}else{
					layer.msg(mes.mes);
				}
	        	
	            
	        },"json");
	      
	}
	
</script>


<table class="layui-table" lay-data="{width: 560, height:476, url:'area/back/showList.action', page:true, limit: 10,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'areaId', width:140, sort: true, fixed: true} ,hidden:'true'">ID</th>
      <th lay-data="{field:'parentId', width:130},hidden:'true'">外键</th>
   	  <th lay-data="{field:'areaName', width:335, sort: true}">地区</th>
      
      <th lay-data="{fixed: 'right', width:220, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-warm layui-btn-mini" lay-event="detail">增加</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
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
    	layer.open({
    		type:2,
			skin: 'layui-layer-molv',//样式
    		content:'pages/back/base/areaadd.jsp?parentId='+data.areaId,
    		area: ['500px', '390px'],
    		title: '增加地区',
    		
    	});
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        
        url = "area/back/delete.action?areaId="+data.areaId;
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
			content:'pages/back/base/areaadd.jsp?areaId='+data.areaId,
			area: ['500px', '390px'],
			title: '编辑地区',
		});
    }
  });
  
 
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#areaName');
		      
		      table.reload('testReload', {
		        where: {
		         
		        	areaName: demoReload.val()
		         
		        }
		      });
		    }
		  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
 
});


</script>

</body>
</html>