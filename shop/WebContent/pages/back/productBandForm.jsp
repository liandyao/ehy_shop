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

<link href="res/layui/css/layui.css" rel="stylesheet">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>


<title>Insert title here</title>
</head>
<style>
	/*a  upload */
.a-upload {
    padding: 4px 10px;
    height: 20px;
    line-height: 20px;
    position: relative;
    cursor: pointer;
    color: #888;
    background: #fafafa;
    border: 1px solid #ddd;
    border-radius: 4px;
    overflow: hidden;
    display: inline-block;
    *display: inline;
    *zoom: 1
}

.a-upload  input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
    filter: alpha(opacity=0);
    cursor: pointer
}

.a-upload:hover {
    color: #444;
    background: #eee;
    border-color: #ccc;
    text-decoration: none
}
</style>
<script type="text/javascript">
	
</script>
<!-- action="productBand/addOrUpdate.action"enctype="multipart/form-data" method="post" -->
<body>
	<div style="margin-top: 20px; margin-right: 20px;">
	<form class="layui-form" id="sss">
		<input type="hidden" id="bandId" name="bandId"/>
		<div class="layui-form-item">
			<label class="layui-form-label">品牌名称</label>
			<div class="layui-input-block">
				<input type="text" id="name" name="name" required lay-verify="required"
					placeholder="请输入品牌名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">绑定分类</label>
			<div class="layui-input-block">
				<input type="text" id="type"name="type" required lay-verify="required"
					placeholder="请输入分类" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">品牌logo</label>
			<div class="layui-input-block">
				<a href="javascript:;" class="a-upload">
				    <input type="file" name="file" id="">点击这里上传文件
				</a>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo" id="btn-tj">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
		
	</form>
	</div>
	<script>
	    
		
		layui.use('form', function() {
			var form = layui.form;
			//监听提交
			form.on('submit(formDemo)', function(data) {
				//layer.msg(JSON.stringify(data.field));
				loadIndex = layer.load();//出现加载层
				$.ajax({  
			          url: 'productBand/back/addOrUpdate.action' ,  
			          type: 'POST',  
			          data: new FormData($( "#sss" )[0]),  
			          async: false,  
			          cache: false,  
			          contentType: false,  
			          processData: false,  
			          success: function (returndata) {  
			        	  layer.close(loadIndex);//加载层关闭  
			        	  if(returndata.state>0){
			        		  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				        	  parent.layer.close(index);
				        	  parent.table.reload('testReload');
				        	  parent.layer.msg(returndata.info);
			        	  }else{
			        		  parent.layer.msg(returndata.info);
			        	  }  
			          },
			          error: function (returndata) {
			        	  layer.close(loadIndex);//加载层关闭  
			        	  layer.msg('提交失败'); 
			          }  
			     });
				return false;
			});
			//各种基于事件的操作，下面会有进一步介绍
		});
		
		//初始化加载信息
		$(function(){
			var id = GetQueryString("id");
			var data = {"bandId":id};
			var url = "productBand/back/showUpdate.action";
			if(id!=null & id!=""){
				
				$.post(url, data, function(mes){
					$("#name").val(mes.name);
					$("#type").val(mes.type);
					$("#bandId").val(mes.bandId);
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