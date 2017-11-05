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
<title>公告显示</title>
 		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
  	.layui-table-view {
	    margin: 10px 18px;
	    overflow: hidden;
	}
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
	
  </style>
</head>
<body> 

<div class="demoTable">
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class="layui-inline">
		  	<form class="layui-form" id="sousuo" style="float: left;">
		  		<table>
		  			<tr>
		  				<td>
		  				    <input class="layui-input" name="newsTitle" id="newsTitle" maxlength="50" placeholder="标题" autocomplete="off">
		  				</td>
		  				<td>
			  				<input class="layui-input" name="newsType" id="newsType" maxlength="50" placeholder="类型" autocomplete="off">
		  				</td>
		  				<td>
			  				<select id="stName" name="stName" lay-verify="" width="50px">
							  <option value="">站点</option>
							  
							</select>
		  				</td>
		  			</tr>
		  		</table>
			</form>
			<button class="layui-btn" style="margin-top: 5px;" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
		  </div>
		</div>

<table class="layui-table" lay-data="{width: 818, height:475, url:'news/back/showList.action', page:true,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'newsId', width:140, sort: true, fixed: true},hidden:'true'">ID</th>
      <th lay-data="{field:'station', width:140, sort: true, fixed: true},hidden:'true'">站点邀请码</th>
      <th lay-data="{field:'sort', width:100,fixed: true">排序</th>
      <th lay-data="{field:'newsTitle', width:130}">公告标题</th>
   	  <th lay-data="{field:'newsType', width:150, sort: true}">公告类型</th>
      <th lay-data="{field:'newsContent', width:130}">公告正文</th>
   	  <th lay-data="{field:'stName', width:200, sort: true}">站点</th>
      <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>


<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
  {{#  if(d.sort==0){ }}
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">取消置顶</a>
  {{#  } else { }}
    	<a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="update">点击置顶</a>
  {{#  } }}
</script>
         
          
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

//设置同步
$.ajaxSetup({
	  async:false
	});
	
	
$(function(){
	var url = 'news/back/showListAjax.action';
	$.post(url,null,function(m){
		for(i=0;i<m.length;i++){
			$("#stName").append("<option value='"+m[i].stName+"'>"+m[i].stName+"</option>");
		}
	},"json")
	
})


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
    	 var ts =layer.open({
			  type: 1, 
			  skin: 'layui-layer-molv'//样式
			  ,title:'取消置顶操作'//标题
			  ,area: ['300px', '150px']
			  ,content: '<p style="color:#01AAED;padding-top:5px;padding-left:20px;">温馨提示：取消置顶之后,按照时间排序</p><p style="color:#FF5722;padding-left:20px;">是否对该公告进行取消置顶处理？</p>' //这里content是一个普通的String
			,btn: ['坚持取消', '算了'] //可以无限个按钮
		  	,yes: function(index, layero){
		  		layer.close(ts);
		  		loadIndex = layer.load();//出现加载层
    		url = "news/back/Updateid.action?newsId="+data.newsId;
            $.post(url,null,function(mes){
            	table.reload('testReload');
            	
            	if(mes.state==1){
            		layer.msg('公告已取消置顶！');
					tableReload();//重载表格的方法
				}else{
					layer.msg('操作失败！');
				}
            	
            	
            },"json");
            layer.close(loadIndex);//加载层关闭  
		  	 }
		});
    	 
    }else if(obj.event === 'update'){
    	var ts =layer.open({
			  type: 1, 
			  skin: 'layui-layer-molv'//样式
			  ,title:'置顶操作'//标题
			  ,area: ['300px', '150px']
			  ,content: '<p style="color:#01AAED;padding-top:5px;padding-left:20px;">温馨提示：置顶之后,显示在该站点的第一位</p><p style="color:#FF5722;padding-left:20px;">是否对该公告进行置顶处理？</p>' //这里content是一个普通的String
			,btn: ['坚持置顶', '算了'] //可以无限个按钮
		  	,yes: function(index, layero){
		  		layer.close(ts);
		  		loadIndex = layer.load();//出现加载层
  		url = "news/back/UpdateStick.action?newsId="+data.newsId+"&station="+data.station;
          $.post(url,null,function(mes){
          	table.reload('testReload');
          	
          	if(mes.state==1){
          		layer.msg('公告已置顶！');
				tableReload();//重载表格的方法
				}else{
					layer.msg(data.stName+'！！！！该站点已有置顶！');
				}
          	
          	
          },"json");
          layer.close(loadIndex);//加载层关闭  
		  	 }
		});
    }else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	 obj.del();
        layer.close(index);
        url = "news/back/delete.action?newsId="+data.newsId;
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
			content:'pages/back/base/newsupdate.jsp?newsId='+data.newsId+"&station="+data.station,
			area: ['500px', '390px'],
			title: '编辑物公告',
		});	

    }
  });
  
 
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#newsTitle');
			  var demoReload1 = $('#newsType');
		      var demoReload2 = $('#stName');
		      table.reload('testReload', {
		        where: {
		         
		        	newsTitle: demoReload.val(),
		        	newsType:demoReload1.val(),
		        	stName:demoReload2.val()
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