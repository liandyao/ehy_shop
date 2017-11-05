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
<title>邀请码表单</title>
	<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
 
</head>
<body style="padding:20px 40px 0px 40px;">

	<form class="layui-form" id="mesFrom" method="post" lay-filter="from">
		<input type="hidden" id="inviId" name="inviId">
		<div class="layui-form-item">
			<label class="layui-form-label">站点名称</label>
			<div class="layui-input-block">
				<select lay-verify="required" lay-search="" name="stId" id="stId">
					
					
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邀请码</label>
			<div class="layui-input-block">
				<input type="text" name="code" id="code"  lay-verify="code"
					placeholder="邀请码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">会员名称</label>
			<div class="layui-input-block">
				<select lay-verify="mbId" lay-search="" name="mbId" id="mbId">
					
					
				</select>
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">是否代理人</label>
		    <div class="layui-input-block">
		      <input type="radio" name="isva" value="2" title="是">
		      <input type="radio" name="isva" value="1" title="否 " checked>
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
		 //自定义验证规则
		   form.verify({ 
			   code:function(value){
				   var re  = new RegExp("^[A-Za-z]+$");
				   if(value==""){
						return '必选项不能为空！';
				   }
				   if(!re.test(value)){
					   return '邀请码前缀只能输入字母，如：CD!';
				   }
			   },mbId: function(value){
				var flag;
				if(value==""){
					return '必选项不能为空！';
				}else{
					$.ajax({
						type : "POST",
						url : 'invitationCode/back/isCode.action', 
						data : {"mbId":value}, 
						async : false,
						success : function(info){
							if(info.state==1){
								flag = '该会员已存在邀请码！';
							}
						}
					}); 
			    	if(flag!=null){
			    		return flag;
			    	}
				}
	    		
		      }
		  });
		  //监听提交
		  form.on('submit(demo)', function(data){
			  layer.load();
			  var data = $("#mesFrom").serialize();
				var url = "invitationCode/back/addOrUpdate.action";
				
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
		var inviId = GetQueryString("inviId");
		var stId = GetQueryString("stId");
		var mbId = GetQueryString("mbId");
		StIdOption(stId);
		
		mbIdOption(mbId);
	});
	
	function StIdOption(stId){
		$("#stId").html("");
		var url = "invitationCode/back/findStation.action";
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
	
	function mbIdOption(mbId){
		$("#mbId").html("");
		var url = "invitationCode/back/findMember.action";
		$.post(url, null, function(obj){
			$("#mbId").append('<option value="">请选择</option>');
			$.each(obj.list,function(index,obj){
				if(mbId==obj.mbId){
					$("#mbId").append('<option value="'+obj.mbId+'" selected>'+obj.mbName+'</option>');
				}else{
					$("#mbId").append('<option value="'+obj.mbId+'" >'+obj.mbName+'</option>');
				}
			});
			form.render('select', 'from');
		});
	}
	
	
		function GetQueryString(name)
		{
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
	</script>
	
	
</body>
</html>