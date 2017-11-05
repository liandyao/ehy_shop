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
<title>优惠券表单</title>
	<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
 
</head>
<body style="padding:20px 40px 0px 40px;">

	<form class="layui-form" id="mesFrom" method="post" lay-filter="from">
		<input type="hidden" id="tempId" name="tempId">
		<div class="layui-form-item">
			<label class="layui-form-label">模版名称</label>
			<div class="layui-input-block">
				<input type="text" name="tempName" id="tempName" lay-verify="required"
					placeholder="请输入模版名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">快递公司</label>
			<div class="layui-input-block">
				<select lay-verify="required" lay-search="" name="expressId" id="expressId">
					
					
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">站点名称</label>
			<div class="layui-input-block">
				<select lay-verify="required" lay-search="" name="stId" id="stId">
					
					
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">运费</label>
			<div class="layui-input-block">
				<input type="text" name="money" id="money" lay-verify="money"
					placeholder="请输入金额" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">备注</label>
		    <div class="layui-input-block">
		      <textarea placeholder="请输入内容" id="remark" name="remark" class="layui-textarea"></textarea>
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
	var form;
	//注意：parent 是 JS 自带的全局对象，可用于操作父页面
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	layui.use(['form','laydate'], function() {
		form = layui.form;
		var laydate = layui.laydate;
		form.render('select', 'from');
		
		var re = /^\d+(\.\d{1,2})?$/; //判断字符串是否为金额格式
		  
		//自定义验证规则
		  form.verify({
			  money: function(value){
			  if(value==""){
					return '必选项不能为空！';
			   }
		      if(!re.test(value)){
		    	return '金额错误，请重新输入！例：1 或 0.5 或 0.55'; 
		      }
		    }
		    
		  });
		
		//监听提交
		  form.on('submit(demo)', function(data){
			  layer.load();
			  var data = $("#mesFrom").serialize();
			  var url = "expressTemplate/back/addOrUpdate.action"; 
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
		var tempId = GetQueryString("tempId");
		var expressId = GetQueryString("expressId");
		var stId = GetQueryString("stId");
		showExpress(expressId);
		showStation(stId);
		showUpdate(tempId);
		
		
	});
	
	function showExpress(expressId){
		$("#expressId").html("");
		var url = "expressTemplate/back/findExpress.action";
		$.post(url, null, function(obj){
			$("#expressId").append('<option value="">请选择</option>');
			$.each(obj.list,function(index,obj){
				if(expressId==obj.expreessId){
					$("#expressId").append('<option value="'+obj.expreessId+'" selected>'+obj.name+'</option>');
				}else{
					$("#expressId").append('<option value="'+obj.expreessId+'" >'+obj.name+'</option>');
				}
     			  
			});
			form.render('select', 'from');
		});
	}
	
	
	function showStation(stId){
		$("#stId").html("");
		var url = "expressTemplate/back/findStation.action";
		$.post(url, null, function(obj){
			$("#stId").append('<option value="">请选择</option>');
			$.each(obj.list,function(index,obj){
				if(stId==obj.stId){
					$("#stId").append('<option value="'+obj.stId+'" selected>'+obj.stName+'</option>');
				}else{
					$("#stId").append('<option value="'+obj.stId+'" >'+obj.stName+'</option>');
				}
     			  
			});
			form.render('select', 'from');
		});
	}
	
	
	function showUpdate(id){
		var data = {"tempId":id};
		var url = "expressTemplate/back/showUpdate.action";
		if(id!=null || id!=""){
			$.post(url, data, function(obj){
				$("#tempId").val(obj.tempId);
				$("#tempName").val(obj.tempName);
				$("#money").val(obj.money);
				$("#remark").text(obj.remark);
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