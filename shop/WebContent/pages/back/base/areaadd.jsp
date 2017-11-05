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
<title>地区增加</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/layui/layui.js"></script>
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		
	<style type="text/css">
		.layui-input, .layui-textarea {
		    display: block;
		    width: 85%;
		    padding-left: 10px;
		}
		
		.layui-form-select .layui-edge {
		    position: absolute;
		    right: 64px;
		    top: 50%;
		    margin-top: -3px;
		    cursor: pointer;
		    border-width: 6px;
		    border-top-color: #c2c2c2;
		    border-top-style: solid;
		    transition: all .3s;
		    -webkit-transition: all .3s;
		}
		.layui-form-select dl {
			min-width: 85%;
		}
		
	</style>

	
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>地区管理</legend>
</fieldset>
 
 
 <form class="layui-form" id="area" method="post">
	<input type="hidden" id="areaId" name="areaId">
   
    
  	<!-- 上级ID -->
  	<input type="hidden" id="parentId" name="parentId">
  
  
     <div class="layui-form-item">
    <label class="layui-form-label">地区</label>
    <div class="layui-input-block">
      <input name="areaName" id="areaName" lay-verify="required" placeholder="请输入" autocomplete="off" value="${express.code }" class="layui-input" type="text">
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="button" class="layui-btn" lay-submit="" lay-filter="demo1" value="立即提交">
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>

<!-- 表单验证 -->
<script>

	layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;

	  
	  
	  
	//监听提交
		form.on('submit(demo1)', function(data){
			  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			  
			  var url="<%=basePath%>/area/back/addOrUpdate.action";
			  var date =$("#area").serialize();
			  $.post(url,date,function(mes){
				
				  if(mes.state==1){
					  parent.layer.close(index);
					  parent.layer.msg(mes.mes);
						  parent.table.reload('testReload');
					}else{
						 parent.layer.close(index);
						 parent.layer.msg(mes.mes);
							  parent.table.reload('testReload');
					}
			  },"json");
		});
	});
	

//取网址上的ID
function GetQueryString(id){
    var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

	//当页面加载时运行，给文本复职
	$(function(){
			var id = GetQueryString("parentId");
			
			var iid=GetQueryString("areaId");
			
			//给上级ID复职
			$("#parentId").val(id);
			
			
			var data = {"areaId":iid};
			var url = "area/back/findById.action";
			if(iid!=null & iid!=""){
				$.post(url, data, function(mes){
					$("#areaId").val(mes.areaId);
					$("#parentId").val(mes.parentId);
					$("#areaName").val(mes.areaName);
				});
			}
			
		});
	
	
</script>
</body>
</html>