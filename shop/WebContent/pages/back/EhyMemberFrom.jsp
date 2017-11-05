<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
</head>
<body>
	<div style="margin-top: 20px; margin-right: 20px;" >
		<form id="updateMember" class="layui-form">
		<input type="hidden" id="mbId"  name="mbId">
			<div class="layui-form-item">
				<label class="layui-form-label">登录账号</label>
				<div class="layui-input-block">
					<input name="mbLogin" id="mbLogin" lay-verify="mbLogin" autocomplete="off"
						placeholder="请输入登录账号" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">登录密码</label>
				<div class="layui-input-block">
					<input name="mbLoginPwd" lay-verify="mbLoginPwd" id="mbLoginPwd" placeholder="请输入登录密码"
						autocomplete="off" class="layui-input" type="password">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">支付密码</label>
				<div class="layui-input-block">
					<input name="mbPayPwd" lay-verify="mbPayPwd" id="mbPayPwd" placeholder="请输入支付密码"
						autocomplete="off" class="layui-input" type="password">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">微信号</label>
				<div class="layui-input-block">
					<input name="mbWeixin" lay-verify="mbWeixin" id="mbWeixin" placeholder="请输入微信号"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">QQ</label>
				<div class="layui-input-block">
					<input name="mbQq" lay-verify="mbQq" id="mbQq" placeholder="请输入QQ"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-block">
					<input name="mbEmail" lay-verify="mbEmail" id="mbEmail"  placeholder="请输入邮箱"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会员编码</label>
				<div class="layui-input-block">
					<input name="mbCode" lay-verify="mbCode" id="mbCode" placeholder="请输入会员编码"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会员姓名</label>
				<div class="layui-input-block">
					<input name="mbName" lay-verify="mbName" id="mbName" placeholder="请输入会员姓名"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会员性别</label>
				<div class="layui-inline">
					<select id="mbSex" name="mbSex" lay-verify="aihao"  >
						<option value="男" >男</option>
						<option value="女" >女</option>	
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会员生日</label>
				<div class="layui-input-inline">
					<input name="mbBirthday" id="mbBirthday"  lay-verify="mbBirthday"
						placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input"
						type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证号</label>
				<div class="layui-input-block">
					<input name="mbCardid" lay-verify="mbCardid" id="mbCardid" placeholder="请输身份证号"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">会员等级</label>
				<div class="layui-inline">
					<select id="selectMemberLevel" name="levelId">
						
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会员电话</label>
				<div class="layui-input-block">
					<input name="mbPhone" lay-verify="mbPhone" id="mbPhone" placeholder="请输入会员电话"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会员地址</label>
				<div class="layui-input-block">
					<input name="mbAddr" lay-verify="mbAddr" id="mbAddr" placeholder="请输入会员地址"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">来源分站</label>
				<div class="layui-inline">
					<select id="selectStation" name="mbStation" lay-verify="required"  >
						
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邀请码</label>
				<div class="layui-input-block">
					<input name="invitationCode" lay-verify="invitationCode" id="invitationCode" placeholder="请输入邀请码"
						autocomplete="off" class="layui-input" type="text">
				</div>
			</div> 
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script>
	
		$(function(){
			$.ajaxSetup({
				  async:false
				});
				})
	
		var form ;
		layui.use(['form', 'layedit', 'laydate'], function(){
		   form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit
		  ,laydate = layui.laydate;
		  
			//日期
		  laydate.render({
		    elem: '#mbBirthday'
		  });
		  
		 
		 
		  //自定义验证规则
		  form.verify({
			mbLogin: function(value){
			  var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]")  
	    	  if(pattern.test(value)){
		    	return '登录账号不能输入特殊字符'; 
		      } 
			  if(value==""){
		    		return '请输入登录账号';
		      }
			  
			  var flag;
		    	
	    		$.ajax({
					type : "POST",
					url : 'member/back/isMbLogin.action', 
					data : {"mbLogin":value,"mbId":$("#mbId").val()},
					async : false,
					success : function(mes){
						if(mes.state==1){
							flag = '该会员名称已存在';
						}
					}
				});
		    	
		    	if(flag!=null){
		    		return flag;
		    	}
		    }
		    ,mbLoginPwd: function(value){
	    	 if(value.length<8){
	    		 return '密码长度要超过8位';
	    	 }
	    	 if(/^[\u4e00-\u9fa5]+$/.test(value)){
				return '密码不能为中文';
			 }
	    	 if(value==""){
	    		return '请输入密码';
	    	 }
		     
		    }
		    ,mbPayPwd: function(value){
		    	 if(value.length>6){
		    		 return '支付密码的长度只能为6位数字';
		    	 }
		    	 if(value.length<6){
		    		 return '支付密码的长度只能为6位数字';
		    	 }
		    	 if(/^[\u4e00-\u9fa5]+$/.test(value)){
					return '支付密码不能为中文';
				 }
		    	 if(value==""){
		    		return '请输入支付密码';
		    	 }
		    	 if(!/^[0-9]*$/.test(value)){
		    		 return '支付密码只能是数字';
		    	 }
		    	 
		    		 
			    }
		   /*   ,content: function(value){
		      layedit.sync(editIndex);
		    }  */
		  });
		  //监听提交
		  form.on('submit(demo1)', function(data){
			  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			  
			  var url="<%=basePath%>member/back/update.action";
			  var date =$("#updateMember").serialize();
			 
			  $.post(url,date,function(mes){
				   if(mes.state=="1"){  
					   parent.layer.close(index);
					   parent.layer.msg(mes.mes); 
					   parent.table.reload('testReload');
				   }else{
					   parent.layer.close(index);
					   parent.layer.msg(mes.mes); 
					   parent.table.reload('testReload');
				   }
			  },"json");
			 return false;
		  });
		  
		  
		});
		
		
		$(function(){
			selectStation();
			
			selectEhyMemberLevel();
			var id = GetQueryString("id");
			selectMemberById(id);
			
			
		});
		var loadIndex;
		var form;
		layui.use('form', function(){
			form = layui.form;
			
			
		});	
			  //各种基于事件的操作，下面会有进一步介绍
		
		
			 function selectStation(){
				var url = "<%=basePath%>/member/back/selectStation.action";
				$.post(url, null, function(mes){
					$("#selectStation").append('<option value="">请选择</option>');
					for(i=0;i<mes.length;i++){
						$("#selectStation").append('<option value="'+mes[i].stName+'">'+mes[i].stName+'</option>');
					}
					form.render("select");
				});
			
			} 
		
			function selectEhyMemberLevel(){
				
				var url = "<%=basePath%>memberLevel/back/selectEhyMemberLevel.action";
				$.post(url ,null,function(mes){
					
					$("#selectMemberLevel").append('<option value="">请选择</option>');
					for(i=0;i<mes.length;i++){
						$("#selectMemberLevel").append('<option value="'+mes[i].levelId+'">'+mes[i].levelName+'</option>');
					}
					
					form.render("select");
					
				});
			}
			
			function selectMemberById(id){
				
				var data = {"mbId":id};
				var url = "<%=basePath%>/member/back/findById.action";
				if(id!=null & id!=""){
					$.post(url, data, function(mes){
						
						$("#mbId").val(mes.mbId);
						$("#selectMemberLevel").val(mes.levelId);
						$("#mbLogin").val(mes.mbLogin);
						$("#mbLoginPwd").val(mes.mbLoginPwd);
						$("#mbPayPwd").val(mes.mbPayPwd);
						$("#mbWeixin").val(mes.mbWeixin);
						$("#mbQq").val(mes.mbQq);
						$("#mbEmail").val(mes.mbEmail);
						$("#mbCode").val(mes.mbCode);
						$("#mbName").val(mes.mbName);
						$("#mbBirthday").val(mes.mbBirthday);
						$("#mbSex").val(mes.mbSex);
						$("#mbCardid").val(mes.mbCardid);
						$("#mbPhone").val(mes.mbPhone);
						$("#mbAddr").val(mes.mbAddr);
						$("#selectStation").val(mes.mbStation);
						$("#invitationCode").val(mes.invitationCode);
						form.render();
						
						
					});
				}
			}
		
		
		
		
		function GetQueryString(id){
		     var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
	</script>
</body>
</html>