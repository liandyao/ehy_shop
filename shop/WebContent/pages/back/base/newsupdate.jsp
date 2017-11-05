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
<title>公告修改</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		
	<style type="text/css">
		.layui-input, .layui-textarea {
		    display: block;
		    width: 85%;
		    padding-left: 10px;
		}
		
		.layui-form-select .layui-edge {
			right: 65px;
		}
		
		.layui-form-select dl {
			min-width: 85%;
		}
	</style>
	
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改公告</legend>
</fieldset>
 
 
 <form class="layui-form" id="express" method="post">
	<input type="hidden" id="newsId" name="newsId">
   <div class="layui-form-item">
    <label class="layui-form-label">站点</label>
    <div class="layui-input-block">
     <select name="station" lay-verify="required" id="se" lay-search="">
        
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">公告标题</label>
    <div class="layui-input-block">
      <input name="newsTitle" id="newsTitle" lay-verify="required" placeholder="请输入" autocomplete="off" value="${express.code }" class="layui-input" type="text">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">公告类型</label>
    <div class="layui-input-block">
      <input name="newsType" id="newsType" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">内容</label>
    <div class="layui-input-block">
      <input name="newsContent" id="newsContent" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
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


//设置同步
$.ajaxSetup({
	  async:false
	});



var form;
layui.use(['form', 'layedit', 'laydate'], function(){
  form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
//监听提交
	form.on('submit(demo1)', function(data){
		  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  
		  var url="<%=basePath%>/news/back/Update.action";
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
		
		var iid = GetQueryString("station");
		var url = 'news/back/showListAjax.action';
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){				
				if(iid==m[i].stId){
					$("#se").append('<option value="'+m[i].stId+'" selected>'+m[i].stName+'</option>');
				}else{
					$("#se").append("<option value='"+m[i].stId+"'>"+m[i].stName+"</option>");
				}
			}
		},"json")
		
		
			var id = GetQueryString("newsId");
			var data = {"newsId":id};
			var url = "news/back/findById.action";
				$.post(url, data, function(mes){
					$("#newsId").val(mes.newsId);
					$("#newsTitle").val(mes.newsTitle);
					$("#newsType").val(mes.newsType);
					$("#newsContent").val(mes.newsContent);
				});
			
			
		});
</script>
</body>
</html>