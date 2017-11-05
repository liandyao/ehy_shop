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
<body style="padding: 20px 40px 0px 40px;">

	<form class="layui-form" id="mesFrom" method="post" lay-filter="from">
		<input type="hidden" id="couponId" name="couponId">
		<div class="layui-form-item">
			<label class="layui-form-label">站点名称</label>
			<div class="layui-input-block">
				<select lay-verify="required" lay-search="" name="stId" id="stId">


				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">优惠券编码</label>
			<div class="layui-input-block">
				<input type="text" name="couponCode" id="couponCode" required
					lay-verify="couponCode" placeholder="优惠券编码" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">金额</label>
			<div class="layui-input-block">
				<input type="text" name="couponMoney" id="couponMoney" required
					lay-verify="couponMoney" placeholder="金额" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" id="remark" name="remark"
					class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">抵扣金额</label>
			<div class="layui-input-block">
				<input type="text" name="couponMinMoney" id="couponMinMoney"
					required lay-verify="couponMinMoney" placeholder="抵扣金额"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">开始时间</label>
			<div class="layui-input-inline">
				<input name="startTime" id="startTime" lay-verify="date"
					placeholder="请输入起始日" autocomplete="off" class="layui-input"
					type="text">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">结束时间</label>
			<div class="layui-input-inline">
				<input name="endTime" id="endTime" lay-verify="endTime"
					placeholder="请输入结束日" autocomplete="off" class="layui-input"
					type="text">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">计算规则</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" id="calc" name="calc"
					class="layui-textarea"></textarea>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="button" class="layui-btn" lay-submit=""
					lay-filter="demo" value="提交">
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
		
		 //日期
		  laydate.render({
		    elem: '#startTime'
		    ,min: '0'
		  });
		//日期
			
		  laydate.render({
		    elem: '#endTime'
		    ,min:'0'
		  });
		
		 var re = /^\d+(\.\d{1,2})?$/; //判断字符串是否为金额格式
		//自定义验证规则
		  form.verify({
			 couponCode:function(value){
				 if(value==""){
						return '必选项不能为空！';
				   }
				 if(/^[\u4e00-\u9fa5]/.test(value)){
					   return '优惠券编码不能含有中文!';
				   }
		    }
			,couponMoney: function(value){
			  if(value==""){
					return '必选项不能为空！';
			   }
		      if(!re.test(value)){
		    	return '金额错误，请重新输入！例：1 或 0.5 或 0.55'; 
		      }
		    }
		    ,couponMinMoney: function(value){
		       if(value==""){
					return '必选项不能为空！';
			   }
		    	if(!re.test(value)){
			    	return '抵扣金额错误，请重新输入！例：1 或 0.5 或 0.55'; 
			    }
		    },
		    endTime:function(value){
		        if(value==""){
					return '必选项不能为空！';
			    }
		    	if(value<$("#startTime").val()){
		    		return '结束时间必须大于或者等于开始时间';
		    	}
		    }
		  });
		
		//监听提交
		  form.on('submit(demo)', function(data){
			  layer.load();
			  var data = $("#mesFrom").serialize();
			  var url = "coupon/back/addOrUpdate.action";
				
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
		var id = GetQueryString("couponId");
		var stId = GetQueryString("stId");
	
		stIdOption(stId);
		showUpdate(id);
		 
	});
	
	//加载站点下拉框
	function stIdOption(stId){
		$("#stId").html("");
		var url = "coupon/back/findStation.action";
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
	
	//显示修改内容
	function showUpdate(id){
		var data = {"couponId":id};
		var url = "coupon/back/showUpdate.action";
		if(id!=null || id!=""){
			$.post(url, data, function(obj){
				
				var arr=$("#mesFrom")[0].querySelectorAll("input[name]");//查询指定表单之下，所有包含name属性的input
				for(var i=0;i<arr.length;i++){//循环input数组
					for(var name in obj){//遍历目标对象的所有属性
						if(arr[i].name==name){//如果目标对象的属性名等于input的name值
							if((arr[i].type=="radio" || arr[i].type=="checkbox") && arr[i].value!=obj[name]){
								continue;//如果input的类型是单选框或者多选框，并且value值等于目标对象的
							}
							arr[i].value=obj[name];//给该input的value赋值
						}
					}
				}
				
				$("#remark").text(obj.remark);
				$("#calc").text(obj.calc);
			});
		}
	};
	 
	//获取父页面传过来的参数
		function GetQueryString(name)
		{
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
	</script>


</body>
</html>