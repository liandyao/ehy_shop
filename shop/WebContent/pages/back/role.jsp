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
<title>角色管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
</head>
<body>

  角色名：
  <div class="layui-inline">
    <input class="layui-input" name="roleName" id="roleName" autocomplete="off">
  </div>
   角色编码：
  <div class="layui-inline">
    <input class="layui-input" name="roleCode" id="roleCode" autocomplete="off">
  </div>
  角色描述：
  <div class="layui-inline">
    <input class="layui-input" name="roleDesc" id="roleDesc" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="search()">搜索</button>
  
  <button data-type="auto" class="layui-btn layui-btn-normal" onclick="showAddOrUpdate()">新增角色</button>

<table class="layui-table" lay-data="{height:383, size:'sm', url:'role/back/showList.action', page:true, method:'post', id:'idTest', hidden:'true'}"  lay-filter="demo">
	  <thead>
	    <tr>
	      <th lay-data="{field:'roleName', width:120}">角色名称</th>
	      <th lay-data="{field:'roleCode', width:160, sort: true}">角色编码</th>
	      <th lay-data="{field:'roleDesc', width:650}">角色描述</th>
	      <th lay-data="{fixed: 'right', width:190, align:'center', toolbar: '#barDemo'}"></th>
	    </tr>
	  </thead>
	</table>
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">分配模块</a>
  		<a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
	</script>
	<script>
	
		var table ;
		layui.use('table', function() {
			table = layui.table;
			//监听工具条
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				if (obj.event === 'detail') {
					var allotCen = layer.open({
						  id : "mesFrom"
						  ,skin: 'layui-layer-molv'//样式
						  ,type: 2 //Page层类型
						  ,area: ['85%', '70%']
						  ,title: '分配模块'
						  ,shade: [0.8, '#393D49'] //显示遮罩
						  ,shadeClose:true//点击也能遮罩层关闭
						  ,anim:2//弹出动画
						  ,content: "pages/back/allotModule.jsp?roleId="+obj.data.roleId
						});
				} else if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						var data = {"roleId":obj.data.roleId};
						var url = "role/back/delete.action";
						$.post(url, data, function(info){
							if(info.state==1){
								layer.msg("删除成功");
								obj.del();
								layer.close(index);
							}
						});
					});
				} else if (obj.event === 'edit') {
					 showAddOrUpdate(obj.data.roleId);
				}
			});
		});
		
		/*
			增加和修改
		*/
		function showAddOrUpdate(roleId){
			
			var addCen = layer.open({
				   id : "mesFrom"
				  ,skin: 'layui-layer-molv'//样式
				  ,type: 2 //Page层类型
				  ,area: ['85%', '70%']
				  ,title: '维护角色'
				  ,shade: [0.8, '#393D49'] //显示遮罩
				  ,shadeClose:true//点击也能遮罩层关闭
				  ,anim:2//弹出动画
				  ,content: "pages/back/roleFrom.jsp?roleId="+roleId
				});
			
		}
		
		/*
			搜索
		*/
		function search(){
			table.reload('idTest', {
			  url: 'role/back/showList.action'
			  ,where: {
				  "roleName":"%"+$("#roleName").val()+"%"
				  ,"roleCode":"%"+$("#roleCode").val()+"%"
				  ,"roleDesc":"%"+$("#roleDesc").val()+"%"
			  } //设定异步数据接口的额外参数
			  //,height: 300
			});
		}
		
	</script>
</body>
</html>