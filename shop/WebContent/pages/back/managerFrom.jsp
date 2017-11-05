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
<title>管理用户的表单</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
</head>
<body style="padding:20px 40px 0px 40px;">
	<form class="layui-form" id="mesFrom" method="post" lay-filter="from">
		<input type="hidden" name="manId" id="manId" />
		<div class="layui-form-item">
			<label class="layui-form-label">选择分站</label>
			<div class="layui-input-block">
				<select name="stId" id="stId" lay-verify="required">
					
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户账号</label>
			<div class="layui-input-block">
				<input type="text" name="manUser" id="manUser" lay-verify="manUser|required"
					placeholder="用户账号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" name="manPwd" id="manPwd" required
					lay-verify="required" placeholder="请输入密码" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-block">
				<input type="text" name="manPhone" id="manPhone" required lay-verify="manPhone|required"
					placeholder="手机号码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">身份证号码</label>
			<div class="layui-input-block">
				<input type="text" name="manCardid" id="manCardid" required lay-verify="manCardid|required"
					placeholder="身份证号码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">个人说明</label>
			<div class="layui-input-block">
				<textarea name="manRemark" id="manRemark" placeholder="请输入内容" class="layui-textarea"></textarea>
			</div>
		</div>
		<input type="hidden" name="oper" value="${manager.manUser}" />
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
		
	$(function(){
		var id = GetQueryString("manId");
		findById(id);
		var stId = GetQueryString("stId");
		showStation(stId);
	});
	
	var form;
	layui.use('form', function() {
		form = layui.form;
		form.render('select', 'from');
		
		//自定义验证规则
		form.verify({
			manUser: function(value){
				var flag;
		    	if($("#manId").val()==null || $("#manId").val()==''){
		    		$.ajax({
						type : "POST",
						url : 'manager/back/isManUser.action', 
						data : {"manUser":value}, 
						async : false,
						success : function(info){
							if(info.state==0){
								flag = '用户名已存在';
							}
						}
					});
		    	}
		    	if(flag!=null){
		    		return flag;
		    	}
		    },
		    manPhone: function(value){
		    	if(!checkPhone(value)){
		    		return '手机号码格式错误'; 
		    	}
		    },
		    manCardid: function(value){
		    	if(!IdentityCodeValid(value)){
		    		return '身份证号码格式错误';
		    	}
		    } 
		});
		
		  //监听提交
		  form.on('submit(demo)', function(data){
			  
			  var data = $("#mesFrom").serialize();
			  var url = "manager/back/addOrUpdate.action";
				
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
	
	function showStation(id){
		var url = "manager/back/showAllStation.action";
		$("#stId").html('<option value="">请选择</option>');
		$.post(url, null, function(info){
			for(i=0; i<info.length; i++){
				var obj = info[i];
				if(id==obj.stId){
					$("#stId").append('<option value="'+obj.stId+'" selected="selected">'+obj.stName+'</option>');
				}else{
					$("#stId").append('<option value="'+obj.stId+'">'+obj.stName+'</option>');
				}
			}
			form.render('select', 'from');
		});
	}
	
	/**
	
	*/
	function findById(id){
		var data = {"manId":id};
		var url = "manager/back/findById.action";
		if(id!=null || id!=""){
			$.post(url, data, function(obj){
				$("#manId").val(obj.manId);
				$("#manUser").val(obj.manUser);
				$("#manPwd").val(obj.manPwd);
				$("#manPhone").val(obj.manPhone);
				$("#manCardid").val(obj.manCardid);
				$("#manRemark").val(obj.manRemark);
			});
		}
	}
	
	/**
		得到URL栏的参数
	*/
	function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	
	/*
 	验证身份号码 
	 */
	function IdentityCodeValid(code) { 
	    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
	    var tip = "";
	    var pass= true;
	    
	    if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
	        tip = "身份证号格式错误";
	        pass = false;
	    }
	    
	   else if(!city[code.substr(0,2)]){
	        tip = "地址编码错误";
	        pass = false;
	    }
	    else{
	        //18位身份证需要验证最后一位校验位
	        if(code.length == 18){
	            code = code.split('');
	            //∑(ai×Wi)(mod 11)
	            //加权因子
	            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
	            //校验位
	            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
	            var sum = 0;
	            var ai = 0;
	            var wi = 0;
	            for (var i = 0; i < 17; i++)
	            {
	                ai = code[i];
	                wi = factor[i];
	                sum += ai * wi;
	            }
	            var last = parity[sum % 11];
	            if(parity[sum % 11] != code[17]){
	                tip = "校验位错误";
	                pass =false;
	            }
	        }
	    }
	    return pass;
	}
	
	/*
	 	判断手机号
	 */
	function checkPhone(phone){ 
		var pass = true;
	    if(!(/^1[34578]\d{9}$/.test(phone))){ 
	        pass = false; 
	    } 
	    return pass;
	}
	</script>
</body>
</html>