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
<title>物流增加</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		
	<style type="text/css">
		.layui-input, .layui-textarea {
		    display: block;
		    width: 85%;
		    padding-left: 10px;
		}
	</style>
	
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>增加物流</legend>
</fieldset>
 
 
 <form class="layui-form" id="express" method="post">
	<input type="hidden" id="expreessId" name="expreessId">
   <div class="layui-form-item">
    <label class="layui-form-label">物流名称</label>
    <div class="layui-input-block">
      <input name="name" id="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">编码</label>
    <div class="layui-input-block">
      <input name="code" id="code" lay-verify="required" placeholder="请输入" autocomplete="off" value="${express.code }" class="layui-input" type="text">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">网址</label>
    <div class="layui-input-block">
      <input name="url" id="url" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">LOGO</label>
    <div class="layui-input-block">
      <input name="logo" id="logo" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input" type="text">
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
		  
		  var url="<%=basePath%>/express/back/addOrUpdate.action";
		  var date =$("#express").serialize();
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
			var id = GetQueryString("expreessId");
			var data = {"expreessId":id};
			var url = "express/back/findById.action";
			if(id!=null & id!=""){
				$.post(url, data, function(mes){
					$("#expreessId").val(mes.expreessId);
					$("#name").val(mes.name);
					$("#code").val(mes.code);
					$("#url").val(mes.url);
					$("#logo").val(mes.logo);
				});
			}
			
			
		});
</script>
</body>
</html>