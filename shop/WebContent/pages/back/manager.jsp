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
<title>用户管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
</head>
<body>
	
<!-- <div class="demoTable"> -->

  站点：
  <div class="layui-inline" style="width: 110px;">
    <form id="form" class="layui-form" lay-filter="from">
		<select name="stId" id="stId" onchange="search()">
			
		</select> 
 	</form>
  </div>
  搜索用户名：
  <div class="layui-inline" style="width: 140px;">
    <input class="layui-input" name="manUser" id="manUser" autocomplete="off">
  </div>
   搜索手机：
  <div class="layui-inline" style="width: 160px;">
    <input class="layui-input" name="manPhone" id="manPhone" autocomplete="off">
  </div>
  搜索身份证号：
  <div class="layui-inline" style="width: 200px;">
    <input class="layui-input" name="manCardid" id="manCardid" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="search()"><i class="layui-icon">&#xe615;</i>搜索</button>
  
  <button data-type="auto" class="layui-btn layui-btn-normal" onclick="showAddOrUpdate('')"><i class="layui-icon">&#xe608;</i>新增</button>

 	
<table class="layui-table" lay-data="{height:383, size:'sm', url:'manager/back/showList.action', page:true, method:'post', id:'idTest',hidden:'true'}"  lay-filter="demo">
	  <thead>
	    <tr>
	      <th lay-data="{field:'stName', width:90}">站点名称</th>
	      <th lay-data="{field:'manUser', width:110, sort: true}">用户名</th>
	      <th lay-data="{field:'manPwd', width:130}">密码</th>
	      <th lay-data="{field:'manPhone', width:160}">手机</th>
	      <th lay-data="{field:'manCardid', width:200, sort: true}">身份证号码</th>
	      <th lay-data="{field:'manRemark', width:240, sort: true}">描述</th>
	      <th lay-data="{fixed: 'right', width:190, align:'center', toolbar: '#barDemo'}"></th>
	    </tr>
	  </thead>
	</table>
 	
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">分配权限</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
	
	<script>
		$(function(){
			showStation();
		});
	
		var table ;
		layui.use('table', function() {
			table = layui.table;
			//监听表格复选框选择
			/* table.on('checkbox(demo)', function(obj) {
				console.log(obj)
			}); */
			//监听工具条
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				if (obj.event === 'detail') {
					allotPrivilege(obj.data.manId);
				} else if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						var data = {"manId":obj.data.manId};
						var url = "manager/back/delete.action";
						$.post(url, data, function(info){
							if(info.state==1){
								layer.msg("删除成功");
								obj.del();
								layer.close(index);
							}
						});
					});
				} else if (obj.event === 'edit') {
					 showAddOrUpdate(obj.data);
				}
			});
		});
		
		function showAddOrUpdate(obj){
			/*
				layer.tab({
				  area: ['600px', '300px'],
				  tab: [{
				    title: 'TAB1', 
				    content: '内容1'
				  }, {
				    title: 'TAB2', 
				    content: '内容2'
				  }, {
				    title: 'TAB3', 
				    content: '内容3'
				  }]
				});
			*/
			var addCen = layer.open({
				   id : "mesFrom"
				  ,type: 2 //Page层类型
				  ,skin: 'layui-layer-molv'//样式
				  ,area: ['85%', '96%']
				  ,title: '管理维护'
				  ,shade: [0.8, '#393D49'] //显示遮罩
				  ,maxmin: true //允许全屏最小化
				  ,anim: 2 //0-6的动画形式，-1不开启
				  ,shadeClose:true//点击也能遮罩层关闭
				  ,content: "pages/back/managerFrom.jsp?manId="+obj.manId+"&stId="+obj.stId
				});
		}
		
		function allotPrivilege(manId){
			var allotCen = layer.open({
				  id : "allotPrivilege"
				  ,type: 2 //Page层类型
				  ,area: ['40%', '70%']
				  ,title: '分配角色'
				  ,shade: [0.8, '#393D49'] //显示遮罩
				  ,maxmin: true //允许全屏最小化
				  ,anim: 2 //0-6的动画形式，-1不开启
				  ,shadeClose:true//点击也能遮罩层关闭
				  ,content: "pages/back/allotRole.jsp?manId="+manId
				});
		}
		
		function search(){
			table.reload('idTest', {
			  url: 'manager/back/showList.action'
			  ,where: {
				  "stId":$("#stId").val()
				  ,"manUser":"%"+$("#manUser").val()+"%"
				  ,"manPhone":"%"+$("#manPhone").val()+"%"
				  ,"manCardid":"%"+$("#manCardid").val()+"%"
			  } //设定异步数据接口的额外参数
			  //,height: 300
			});
		}
		
		function showStation(){
			var url = "manager/back/showAllStation.action";
			$("#stId").html('<option value="">请选择</option>');
			$.post(url, null, function(info){
				for(i=0; i<info.length; i++){
					var obj = info[i];
					$("#stId").append('<option value="'+obj.stId+'">'+obj.stName+'</option>');
				}
				layui.use('form', function() {
					var form = layui.form;
					form.render('select', 'from'); 
				});
			});
		}
		
	</script>
</body>
</html>