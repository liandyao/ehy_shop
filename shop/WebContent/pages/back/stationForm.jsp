<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>站点表单</title>
	<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
 
</head>
<body style="padding:20px 40px 0px 40px;">

	<form class="layui-form" id="mesFrom" method="post" lay-filter="from">
		<input type="hidden" id="stId" name="stId">
		<div class="layui-form-item">
			<label class="layui-form-label">站点名称</label>
			<div class="layui-input-block">
				<input type="text" name="stName" id="stName"  lay-verify="required"
					placeholder="站点名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">站点编码</label>
			<div class="layui-input-inline">
				<input type="text" name="stCode" id="stCode" 
					lay-verify="stCode" placeholder="站点编码" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">站点类型</label>
			<div class="layui-input-block" >
				<select lay-verify="required" name="stType" id="stType">
					<option value="">请选择</option>
					<option value="0">总站</option>
					<option value="1">分站</option>
				</select>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">邀请码标识</label>
			<div class="layui-input-block">
				<input type="text" name="stFlag" id="stFlag"  lay-verify="stFlag"
					placeholder="站点邀请码标识" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="button" class="layui-btn" lay-submit="" lay-filter="demo" value="提交">
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
	//注意：parent 是 JS 自带的全局对象，可用于操作父页面
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	var form;
	layui.use('form', function() {
		form = layui.form;
		form.render('select', 'from');
		//自定义验证规则
		 var re  = new RegExp("^[A-Za-z]+$");
		 form.verify({
			 stCode: function(value){
				 if(value==""){
						return '必选项不能为空！';
				   }
				 if(!re.test(value)){
					   return '站点编码只能输入字母，如：CD!';
				   }
		    }
		 ,stFlag:function(value){
			 if(value==""){
					return '必选项不能为空！';
			   }
			 if(!re.test(value)){
				   return '邀请码标识只能输入字母，如：CD!';
			   }
		 }
		    
		  });
		//监听提交
		  form.on('submit(demo)', function(data){
			  layer.load();
			  var data = $("#mesFrom").serialize();
				var url = "station/back/addOrUpdate.action";
				$.post(url, data, function(mes){
					layer.closeAll('loading');
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
		var id = GetQueryString("stId");
		showUpdate(id);
	});
	
	function showUpdate(id){
		var data = {"stId":id};
		var url = "station/back/showUpdate.action";
		if(id!=null || id!=""){
			$.post(url, data, function(obj){
				$("#stId").val(obj.stId);
				$("#stName").val(obj.stName);
				$("#stCode").val(obj.stCode); 
				$("#stType").val(obj.stType);
				form.render('select', 'from');
				$("#stFlag").val(obj.stFlag);
			});
		}
	};
	
		
		
		function GetQueryString(name)
		{
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
	</script>
</body>
</html>