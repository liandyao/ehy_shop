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
<title>Insert title here</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
</head>
<body style="padding:20px 40px 0px 40px;">
<form class="layui-form" id="mesFrom" method="post" lay-filter="from">
		<input type="hidden" name="roleId" id="roleId" />
		<div class="layui-form-item">
			<label class="layui-form-label">角色名称</label>
			<div class="layui-input-inline">
				<input type="text" name="roleName" id="roleName" required
					lay-verify="required" placeholder="角色名称" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色编码</label>
			<div class="layui-input-inline">
				<input type="text" name="roleCode" id="roleCode" required
					lay-verify="required" placeholder="角色编码" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">模块说明</label>
			<div class="layui-input-block">
				<textarea name="roleDesc" id="roleDesc" placeholder="请输入内容" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="button" class="layui-btn" lay-submit="" lay-filter="demo" value="提交">
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
		<input type="hidden" name="oper" value="${manager.manUser}" />
	</form>
	<script type="text/javascript">
	//注意：parent 是 JS 自带的全局对象，可用于操作父页面
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	
	layui.use('form', function() {
		var form = layui.form;
		form.render('select', 'from');
		//自定义验证规则
		form.verify({
			
		});
		
		//监听提交
		form.on('submit(demo)', function(data){
			  
			var data = $("#mesFrom").serialize();
			var url = "role/back/addOrUpdate.action";
				
			$.post(url, data, function(mes){
				if(mes.state==1){
					parent.table.reload('idTest');
					parent.layer.close(index);
					parent.layer.msg(mes.mes);  
		      	}else{
		      		parent.layer.msg(mes.mes); 
		      	}
			});
		});
	});
	
	$(function(){
		var roleId = GetQueryString("roleId");
		findById(roleId);
	});
	
	/**
	
	*/
	function findById(id){
		var data = {"roleId":id};
		var url = "role/back/findById.action";
		if(id!=null || id!=""){
			$.post(url, data, function(obj){
				$("#roleId").val(obj.roleId);
				$("#roleName").val(obj.roleName);
				$("#roleDesc").val(obj.roleDesc);
				$("#roleCode").val(obj.roleCode);
			});
		}
	}
	
	/**
		得到URL栏的参数
	*/
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	</script>
</body>
</html>