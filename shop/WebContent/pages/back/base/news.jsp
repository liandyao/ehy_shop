<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布公告</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		
	<style type="text/css">
		.layui-input, .layui-textarea {
		    display: block;
		    width: 76%;
		    padding-left: 10px;
		}
		
		.layui-form-select .layui-edge {
			right: 311px;
		}
		.layui-form-select dl {
			min-width: 76%;
		}
		.layui-layer-dialog .layui-layer-padding {
		    padding: 24px 27px 22px 61px;
		    text-align: left;
		}
		
	</style>	
	<script type="text/javascript">
		
		function sx(){
			parent.location.reload();
		}
	</script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>公告增加</legend>
</fieldset>
 
<form class="layui-form" id="news">
  <div class="layui-form-item">
    <label class="layui-form-label">公告标题</label>
    <div class="layui-input-block">
      <input name="newsTitle" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">公告类型</label>
    <div class="layui-input-block">
      <input name="newsType" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  
  
 <div class="layui-form-item">
    <label class="layui-form-label">站点</label>
    <div class="layui-input-block" id="se">
    	
    </div>
  </div>
  



 
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">内容</label>
    <div class="layui-input-block">
      <textarea class="layui-textarea layui-hide" name="newsContent" id="LAY_demo1"></textarea>
    </div>
  </div>
				<div class="layui-input-block">
					<input type="button" class="layui-btn" lay-submit=""  lay-filter="demo1" value="立即提交">
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
</form>
 
<script>
//设置同步
$.ajaxSetup({
	  async:false
	});
		
	var checkbox="";//存储复选框值
	var form;
	      
		
	
		layui.use(['form', 'layedit', 'laydate'], function(){
		  form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit
		  ,laydate = layui.laydate;
		  
		  
		  
		 
		 
		  //全选框
		 /*  form.on('checkbox(all)', function (data) {
			  alert(data.elem.checked);
              var child = $(data.elem).parents('div').find('input[type="checkbox"]:not([name="all"])');
              child.each(function (index, item) {
                  item.checked = data.elem.checked;
              });
              $('div').find('input[type="checkbox"]').attr('checked',true);
              form.render('checkbox');
              checkbox=checkbox+"_"+data.value; //取出复选框，在累加
              alert(checkbox);
    }); */
		  
		  
		  
		  //监听提交
		  form.on('submit(demo1)', function(data){
			
			  var formData = data.field;//表单所有数据
			  
			  var textarea = layedit.getContent(index);//富文本编辑器取值
			  
			  formData.newsContent=textarea;//把富文本编辑器中的值放到表单中
			  
			  
			  checkbox="";
			  var station = $("input[name='station']:checked");
			  $(station).each(function(i,element){
				  if(checkbox==""){
					  checkbox=$(this).val();
				  }else{
					  checkbox+="_"+$(this).val();
				  }
			  });
			  formData.station=checkbox;//把站点ID累加
			 var url="<%=basePath%>/news/back/add.action";
			  
			  $.post(url,formData,function(mes){
				   if(mes.state==1){  
					 
					   layer.msg(mes.mes, {
			      			  icon: 1,
			      			  offset: 'auto', //右下角弹出
			      			  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			      			});
					   setTimeout("sx()", 2000);   
				   }else{
					   layer.msg(mes.mes, {
			      			  icon: 2,
			      			  offset: 'auto', //右下角弹出
			      			  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			      			});
				   }
			  },"json");
		  });
		  
		  
		});
		
		
		//循环出站点复选框
		$(function(){
			var url = 'news/back/showListAjax.action';
			$.post(url,null,function(m){
				//$("#se").append("<input   title='全部' name='all' lay-filter='all' type='checkbox'>");
				for(i=0;i<m.length;i++){
					$("#se").append("<input value="+m[i].stId+"  title="+m[i].stName+" name='station' lay-filter='station'  type='checkbox'>");
				}
				
			},"json"); 
			
			
		});
		
		
	</script>
	
<script>
var layedit;
var index;
layui.use('layedit', function(){
  layedit = layui.layedit
  ,$ = layui.jquery;
  
  //构建一个默认的编辑器
 index = layedit.build('LAY_demo1');
  
 
  
  $('.site-demo-layedit').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
  
  //自定义工具栏
  layedit.build('LAY_demo2', {
    tool: ['face', 'link', 'unlink', '|', 'left', 'center', 'right']
    ,height: 100
  })
});
</script>
</body>
</html>