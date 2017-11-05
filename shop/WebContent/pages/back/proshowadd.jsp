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
<title>商品展示增加</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/layui/layui.js"></script>
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		
	<style type="text/css">
		
		
		.layui-input, .layui-textarea {
		    display: block;
		    width: 90%;
		    padding-left: 10px;
		}
		.layui-form-label {
			float: left;
			display: block;
			padding: 9px 15px;
			width: 102px;
			font-weight: 400;
			text-align: right;
		}
		
		
		.layui-form-select .layui-edge {
    		right: 80px;
		}
		
		.layui-form-select dl {
			min-width: 92%;
		}
	</style>

	
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>展示管理</legend>
</fieldset>
 
 
 <form class="layui-form" id="proshow" method="post">
 
	<!-- 产品ID --> 
	<input type="hidden" id="proId" name="proId">
   
    
  	<!-- 站点ID -->
  	<input type="hidden" id="stId" name="stId">
  
  	<!-- 展示ID -->
  	<input type="hidden" id="showId" name="showId">
  	
  	<div class="layui-form-item">
    <label class="layui-form-label">展示类型:</label>
    <div class="layui-input-block">
     <select name="showType" id="showType" lay-verify="required" lay-search="">
        <option value='1'>推荐商品</option>
        <option value='2'>清仓商品</option>
        <option value='3'>特价商品</option>
        <option value='4'>热卖商品</option>
      </select>
    </div>
  </div>
  		<div class="layui-form-item">
    <label class="layui-form-label">开始时间:</label>
    <div class="layui-input-block">
        <input class="layui-input" id="showStartTime" name="showStartTime" placeholder="yyyy-MM-dd HH:mm:ss" type="text">
      </div>
    </div>
  		
  <div class="layui-form-item">
    <label class="layui-form-label">结束时间:</label>
    <div class="layui-input-block">
        <input class="layui-input" id="showEndTime" name="showEndTime" placeholder="yyyy-MM-dd HH:mm:ss" type="text">
      </div>
    </div>

    <div class="layui-form-item">
    <label class="layui-form-label">是否展示:</label>
    <div class="layui-input-block">
      <input name="showIsva" id="showIsva" value="1" title="是" checked="" type="radio">
      <input name="showIsva" id="showIsva" value="0" title="否" type="radio">
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
var form;
//同步
$.ajaxSetup({
	  async:false
	});



	layui.use(['form', 'layedit', 'laydate'], function(){
	  form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;

	  
	  
	  
	//监听提交
		form.on('submit(demo1)', function(data){
			  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			  
			  var url="<%=basePath%>/proshow/back/addOrUpdate.action";
			  var date =$("#proshow").serialize();
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
			var id = GetQueryString("proId");
			
			var iid=GetQueryString("stId");
			
			var show=GetQueryString("showId");
			//给产品ID复职
			$("#proId").val(id);
			
			//给站点ID复职
			$("#stId").val(iid);
			
			 var data = {"showId":show};
			var url = "proshow/back/findById.action";
			if(show!=null & show!=""){
				$.post(url, data, function(mes){
					$("#showId").val(mes.showId);
					$("#showStartTime").val(mes.showStartTime);
					$("#showEndTime").val(mes.showEndTime);
					$("#showType").val(mes.showType);//下拉框复职，同步js
					$("#proshow").find("input[type='radio'][name='showIsva'][value="+mes.showIsva+"]").prop("checked","checked");//单选框赋值
					form.render("radio");
				});
			} 
			
		});
	
	
</script>

<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  //时间选择器
  laydate.render({
    elem: '#showEndTime'
    ,type: 'datetime'
    ,min: -0
  });

  
  //时间选择器
  laydate.render({
    elem: '#showStartTime'
    ,type: 'datetime'
    ,min: -0
  });
});
</script>

</body>
</html>