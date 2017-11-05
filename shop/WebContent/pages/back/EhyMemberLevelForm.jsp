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
	<div style="margin-top: 20px; margin-right: 20px;">
		<form class="layui-form" id="EhyMemberLevel">
		<input type="hidden" id="levelId"  name="levelId">
		<input type="hidden" id="dicId"  name="dicId">
			<div class="layui-form-item">
				<label class="layui-form-label">会员等级</label>
				<div class="layui-input-block">
					<input name="levelName" id="levelName" lay-verify="levelName" autocomplete="off"
						placeholder="请输入会员等级,例（黄金会员）" class="layui-input" type="text">
				</div>
				
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">优惠比例</label>
				<div class="layui-input-block">
					<input name="scale" lay-verify="scale" id="scale" autocomplete="off"
						placeholder="请输入优惠比例,例 (0.01,1)" class="layui-input" type="text">
				</div>
				
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">我的货架</label>
				<div class="layui-inline">
					<select id="dicRemark" name="dicRemark" lay-verify="dicRemark"  >
						<option value="" >请选择</option> 
						<option value="1" >不允许添加</option>
						<option value="2" >允许添加(本站)</option>
						<option value="3" >允许添加(全站)</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<input type="button" class="layui-btn" lay-submit="" lay-filter="demo1" value="立即提交">
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script>
	 var form;
		layui.use(['form', 'layedit', 'laydate'], function(){
		   form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit
		  
		  ,laydate = layui.laydate;
		  
		  
		  
		 
		 
		  //自定义验证规则
		  form.verify({
			  levelName: function(value){
		    	
	    	  if(value.search("会员")==-1){
		    	return '格式不对，请重新输入，例：xx会员'; 
		      } 
	    	 /*  if(value.length>4){
		    	return '会员等级不能超过4个字符'; 
		      } */
		      if(value.length<4){
		        return '会员等级至少得有4个字符';
		      }
		      if(!/^[\u4e00-\u9fa5]+$/.test(value)){
			    return '会员等级必须是中文汉字';
			  }
		      if(value.substring(value.length-2)!="会员"){
		    	return '格式不对，请重新输入，例：xx会员'; 
		      }
		      
		      var flag;
		    	
	    		$.ajax({
					type : "POST",
					url : 'memberLevel/back/islevelName.action', 
					data : {"levelName":value}, 
					async : false,
					success : function(mes){
						if(mes.state==1){
							flag = '该等级已存在';
						}
					}
				});
		    	
		    	if(flag!=null){
		    		return flag;
		    	}
		    }
		    ,scale: function(value){
	    	 if(value>1){
	    		 return '格式不对，请重新输入，例：1 或 0.95 或 0.8';
	    	 }
	    	 if(!/^\d+(\.\d{1,2})?$/.test(value)){
				return '格式不对，请重新输入，例：1 或 0.95 或 0.8';
			 }
	    	 if(value==""){
	    		return '请输入优惠比例';
	    	 }
		     
		    }
		    ,dicRemark: function(value){
		     if(value<0){
		    	 return '请选择,是否添加我的货架';
		     }
		     if(value=="" || value==null ){
		    	 return '请选择,是否添加我的货架';
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
			  
			  var url="<%=basePath%>/memberLevel/back/addOrUpdate.action";
			  var date =$("#EhyMemberLevel").serialize();
			  /* alert(date); */
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
			
			/* $("#EhyMemberLevel").reset(); */
			var id = GetQueryString("id");
			
			var data = {"levelId":id};
			var url = "<%=basePath%>/memberLevel/back/findById.action";
			if(id!=null & id!=""){
				$.post(url, data, function(mes){
					
					
					$("#levelId").val(mes.LEVEL_ID);
					$("#levelName").val(mes.LEVEL_NAME);
					$("#scale").val(mes.SCALE);
					$("#dicRemark").val(mes.DIC_REMARK);
					$("#dicId").val(mes.DIC_ID);	
					form.render();
				});
			}
		});
		
		function GetQueryString(id){
		     var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
	</script>
</body>
</html>