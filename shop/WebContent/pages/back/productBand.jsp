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

<link href="res/layui/css/layui.css" rel="stylesheet">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
<title>产品品牌</title>
</head>
<body> 
<div class="demoTable">
  关键字：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload">搜索</button>
  
  <button class="layui-btn"  onclick="addProType('增加品牌信息')">新增品牌</button>
</div>
 
<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>             
          
<script>
	var table ;
	layui.use('table', function() {
		table = layui.table;
		loadIndex = layer.load();//出现加载层
	    //方法级渲染
		table.render({
			loading: true,
			elem : '#LAY_table_user',
			url : 'productBand/back/findProductBandList.action',
			method : 'post',
			cols : [ [ {
				checkbox : true,
				fixed : true
			}, {
				field : 'bandId',
				title : '类型编号',
				width : 140,
				sort : true,
				fixed : true
			}, {
				field : 'name',
				title : '品牌名称',
				width : 200
			}, {
				field : 'type',
				title : '分类',
				width : 140
			}, {
				field : 'logo',
				title : 'logo',
				width : 70,
				templet : '#productBandImage'
			}, {
				fixed : 'right',
				title : '操作',
				width : 150,
				align : 'center',
				toolbar : '#barDemo'
			} ] ],
			id : 'testReload',
			page : true,
			height : 471,
			done: function(res, curr, count){
		    	layer.close(loadIndex);//加载层关闭  
		    }
		});
	      
		//监听工具条
		table.on('tool(user)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值
		  var tr = obj.tr; //获得当前行 tr 的DOM对象
		 
		 if(layEvent === 'del'){ //删除
		    layer.confirm('真的删除行么', function(index){
		      layer.close(index);
		      var url = "productBand/back/delete.action";
		      var data2 = {bandId:data.bandId};
		      //向服务端发送删除指令
		      loadIndex = layer.load();//出现加载层
		      $.post(url,data2,function(info){
			      layer.close(loadIndex);//加载层关闭 
		    	  if(info.state==1){
		    		  obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
		    		  layer.msg(info.mes);   
		    	  }else{
		    		  layer.msg(info.mes);
		    	  }
		      })
		      
		    });
		  } else if(layEvent === 'edit'){ //编辑
		    //do something
		    var title = "编辑品牌信息";
		    addProType(title,data.bandId);
		    
		  }
		});
		
		
		
		
		
		var $ = layui.$, active = {
			reload : function() {
				loadIndex = layer.load();//出现加载层
				table.reload('testReload', {
					where : {

						keyWord : $('#demoReload').val()

					}
				});
			}
		};

		$('.demoTable .layui-btn').on('click', function() {
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});
	});

	function addProType(title,proTypeId) {
		layer.open({
			type : 2,
			content : 'pages/back/productBandForm.jsp?id='+proTypeId,
			area: ['75%', '80%'],
			title : title,
			cancel: function(index, layero){ 
				layer.confirm('是否关闭?',{icon: 3, title:'提示'}, function(index2){
					  //do something
					  layer.close(index);
					  layer.close(index2);
				});   
				return false;
			}
		});
	}
</script>
<script type="text/html" id="productBandImage">
	     <img src="{{d.logo}}" style="width:32px;"/>
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
</body>
</html>