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
<title>数据字典</title>
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
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  字典编码：
  <div class="layui-inline">
    <input class="layui-input" name="dicCode" id="dicCode" autocomplete="off">
  </div>
  字典名称：
  <div class="layui-inline">
    <input class="layui-input" name="dicName" id="dicName" autocomplete="off">
  </div>

  字典备注：
  <div class="layui-inline">
    <input class="layui-input" name="dicRemark" id="dicRemark" autocomplete="off">
  </div> 
  <button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
  <button class="layui-btn layui-btn-warm" onclick="add()"><i class="layui-icon">&#xe608;</i>增加数据</button>
</div>



<table class="layui-table" lay-data="{width: 806, height:476, url:'datadic/back/showList.action', page:true, limit: 10,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
    <th lay-data="{field:'dicId', width:140, sort: true, fixed: true},hidden:'true'">ID</th>
      <th lay-data="{field:'dicCode', width:200, sort: true}">字典编码</th>
      <th lay-data="{field:'dicName', width:150}">字典名称</th>  
      <th lay-data="{field:'dicRemark', width:230}">字典备注</th>
      
      <th lay-data="{fixed: 'right', width:220, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>


<script type="text/html" id="barDemo">
{{#  if(d.dicId === '1' || d.dicId === '2' || d.dicId === '3' || d.dicId === '4'  ){ }}
  
{{#  }else{ }}
<a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
{{#  } }}

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
        url = "datadic/back/delete.action?dicId="+data.dicId;
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
			content:'pages/back/base/datadicadd.jsp?dicId='+data.dicId,
			area: ['500px', '390px'],
			title: '编辑数据',
		});	

    }
  });
  
 
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#dicName');
			  var demoReload1 = $('#dicCode');
		      var demoReload2 = $('#dicRemark');
		      table.reload('testReload', {
		        where: {
		         
		        	dicName: demoReload.val(),
		        	dicCode:demoReload1.val(),
		        	dicRemark:demoReload2.val()
		        }
		      });
		    }
		  };
  
  var type;
  $('.demoTable .layui-btn').on('click', function(){
    type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

function add(){
	
	layer.open({
		type:2,
		skin: 'layui-layer-molv',//样式
		content:'pages/back/base/datadicadd.jsp',
		area: ['500px', '390px'],
		title: '增加数据',
	});

}


</script>

</body>
</html>