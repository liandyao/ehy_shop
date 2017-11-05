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
<title>商品展示</title>
 	<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/js/drag-sort.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
  	
	body{
		padding: 10px;
	}

	#sousuo td{
		padding-right: 5px;
		padding-top: 5px;
	}
	#sousuo .layui-input {
 		height: 40px;
	}
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

<div class="demoTable">
			<div class="layui-form" >
				<div class="layui-inline">
					  <input class="layui-input" name="proName" id=proName maxlength="50" placeholder="商品名称" autocomplete="off">
				</div>
				<div class="layui-inline">
					<select id="showType" name="showType" lay-verify="required" lay-search="" width="50px">
							  <option value="">展示类型</option>
							  <option value="1">推荐商品</option>
							  <option value="2">清仓商品</option>
							  <option value="3">特价商品</option>
							  <option value="4">热卖商品</option>
							</select>
				</div>
				<div class="layui-inline">
					<select id="showIsva" name="showIsva" lay-verify="required" lay-search="" width="50px">
							  <option value="">是否展示</option>
							  <option value="1">已展示</option>
							  <option value="0">未展示</option>
							</select>
				</div>
				<div class="layui-inline">
					<select id="stName" name="stName" lay-verify="required" lay-search="" width="50px">
							 <option value="">站点</option>
							  	
					</select>
				</div>
				<button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>

			</div>
		</div>

<table class="layui-table" lay-data="{width: 818, height:473, url:'proshow/back/showList.action', page:true,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'showId', width:140, sort: true, fixed: true},hidden:'true'">ID</th>
      <th lay-data="{field:'proId', width:140, sort: true, fixed: true},hidden:'true'">产品ID</th>
      <th lay-data="{field:'stId', width:140, sort: true, fixed: true},hidden:'true'">站点ID</th>
      <th lay-data="{field:'sort', width:140, sort: true, fixed: true},hidden:'true'">排序</th>
      <th lay-data="{field:'showIsva', width:140, sort: true,templet:'#isva', align:'center'}">是否展示</th>
      <th lay-data="{field:'showType', width:120,templet:'#logoTpl', align:'center'}">展示类型</th>
   	  <th lay-data="{field:'proName', width:150}">产品名称</th>
   	  <th lay-data="{field:'stName', width:200, align:'center'}">站点</th>
      <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>

<!-- 判断展示类型 -->
 <script type="text/html" id="logoTpl">
	  {{#  if(d.showType==1){ }}
    		<span>推荐商品</span>  
  	{{# }else if(d.showType==2) { }}
    	   <span>清仓商品</span>
  	{{#  } else if(d.showType==3) { }}
		   <span>特价商品</span>
	{{#  } else if(d.showType==4) { }}
		   <span>热卖商品</span>
	{{#  } }}
</script>

<!-- 判断是否展示 -->
<script type="text/html" id="isva">
	  {{#  if(d.showIsva==1){ }}
    		<span class="layui-btn layui-btn-small layui-btn-normal">已展示</span>
  	{{# }else if(d.showIsva==0) { }}
    	   <span class="layui-btn layui-btn-primary layui-btn-small">未展示</span>
	{{#  } }}
</script>

<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-mini" lay-event="detail">置顶</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
         
          
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
//同步
 $.ajaxSetup({
	  async:false
	});

$(function(){
	var url = 'news/showListAjax.action';
	$.post(url,null,function(m){
		for(i=0;i<m.length;i++){
			$("#stName").append("<option value='"+m[i].stName+"'>"+m[i].stName+"</option>");
		}
	},"json")
	
}) 


var table;


function sort(obj){
	
	var trs = $("tbody tr");
	var startIndex = obj.attr("data-index");
	for(i=0;i<trs.length;i++){
		$(trs[i]).attr("data-index",i);
	}
	
	var endIndex = obj.attr("data-index");
	var showId = table.cache.testReload[startIndex].showId;
	
	var start = table.cache.testReload[startIndex].sort;
	var end = table.cache.testReload[endIndex].sort;
	if(start!=end){
		layer.load();
		var data = {"start":start,
				"end":end,
				"showId":showId};
		var url = "proshow/back/sortModule.action";
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

layui.use('table', function(){
  table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  var data;
  //监听工具条
  table.on('tool(demo)', function(obj){
    data = obj.data;
    if(obj.event === 'detail'){
    	if(data.sort!=1){
			layer.load();
			var data = {"start":data.sort,
					"end":1,
					"showId":data.showId};
			var url = "proshow/back/sortModule.action";
			$.post(url, data, function(info){
				layer.closeAll('loading');
				if(info.state==1){
					layer.msg(info.mes);
					table.reload('testReload');
					$("tbody").attr({"id":"wrap","class":"wrap"});
					$('#wrap').dragSort();
				}
			});
		}else{
			layer.msg("该行已被置顶，请勿重复操作！");
		}
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	 obj.del();
        layer.close(index);
        url = "proshow/back/delete.action?showId="+data.showId;
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
			content:'pages/back/proshowadd.jsp?showId='+data.showId+'&proId='+data.proId+'&stId='+data.stId,
			area: ['75%', '80%'],
			title: '编辑商品展示',
		});	
		
    }
   
  });

 //所搜
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#proName');
			  var demoReload1 = $('#showType');
		      var demoReload2 = $('#showIsva');
		      var demoReload3 = $('#stName');
		      table.reload('testReload', {
		        where: {
		         
		        	proName: demoReload.val(),
		        	showType:demoReload1.val(),
		        	showIsva:demoReload2.val(),
		        	stName:demoReload3.val()
		        }
		      });
		      $("tbody").attr({"id":"wrap","class":"wrap"});
				$('#wrap').dragSort();
		    }
		  };

  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
    
  });
  $("tbody").attr({"id":"wrap","class":"wrap"});
	$('#wrap').dragSort();
});


</script>

</body>
</html>