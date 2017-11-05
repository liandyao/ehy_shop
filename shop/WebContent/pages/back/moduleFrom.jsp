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
		<input type="hidden" name="modId" id="modId" />
		<div class="layui-form-item">
			<label class="layui-form-label">上級模块</label>
			<div class="layui-input-block">
				<select name="ehyModId" id="ehyModId">
				
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">模块编码</label>
			<div class="layui-input-inline">
				<input type="text" name="modCode" id="modCode" required
					lay-verify="required" placeholder="模块编码" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">URL地址</label>
			<div class="layui-input-block">
				<input type="text" name="url" id="url"
					placeholder="网址，若要设置为一级模块可以不填" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">模块名称</label>
			<div class="layui-input-inline">
				<input type="text" name="modName" id="modName" required
					lay-verify="required" placeholder="模块名称" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">模块说明</label>
			<div class="layui-input-block">
				<textarea name="modDesc" id="modDesc" placeholder="请输入内容" class="layui-textarea"></textarea>
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
	var list;
	$(function(){
		var modId = GetQueryString("modId");
		if(modId=='undefined'){
			list = '';
		}else{
			findById(modId);
		}
		var ehyModId = GetQueryString("ehyModId");
		showSelect(ehyModId, modId, list);
	});
	
	function showSelect(ehyModId, modId, list){
		var url = "module/back/findFirstLevel.action";
		$("#ehyModId").html("<option value=''>请选择</option>");
		$.ajax({
			type : "POST",
			url : url, 
			data : null, 
			async : false,
			success : function(info){
				if(list==''){
					for(i=0; i<info.length; i++){
						var obj = info[i];
						if(ehyModId==obj.modId){
							$("#ehyModId").append("<option value="+obj.modId+" selected>"+obj.modName+"</option>");
						}else{
							$("#ehyModId").append("<option value="+obj.modId+">"+obj.modName+"</option>");
						}
					}
				}
			}
		});
		layui.use('form', function() {
			var form = layui.form;
			form.render('select', 'from');
			//自定义验证规则
			form.verify({
				
			});
			
			//监听提交
			form.on('submit(demo)', function(data){
				  
				var data = $("#mesFrom").serialize();
				var url = "module/back/addOrUpdate.action";
					
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
	}
	
	/**
	
	*/
	function findById(id){
		var data = {"modId":id};
		var url = "module/back/findById.action";
		if(id!=null || id!=""){
			$.ajax({
				type : "POST",
				url : url, 
				data : data, 
				async : false,
				success : function(obj){
					$("#modId").val(obj.modId);
					$("#modName").val(obj.modName);
					$("#modDesc").val(obj.modDesc);
					$("#modCode").val(obj.modCode);
					$("#url").val(obj.url);
					list = obj.moduleList;
				}
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