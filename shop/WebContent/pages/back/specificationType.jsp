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
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
<title>规格类型</title>
</head>
<body> 
<div class="demoTable">

  关键字：
  <div class="layui-inline">
    <input width="40%" class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="关键字查询">
  </div>
  <button class="layui-btn" data-type="reload">搜索</button>
  <button class="layui-btn" style="margin-right:200px;" onclick="addProType()">新增规格类型</button>
</div>
 
<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>            
          
<script>
var form;
var table;
layui.use(['table','form'], function(){
  form = layui.form
  table = layui.table;
  loadIndex = layer.load();//出现加载层
  //方法级渲染
  table.render({
    elem: '#LAY_table_user'
    ,url: 'SpecificationTypeAction/back/findSpecificationTypeAll.action'
    ,method: 'post'
    ,cols: [[
      {checkbox: true, fixed: true}
      ,{field:'sptName', title: '规格类型名称', width:160, sort: true, fixed: true}
      ,{field:'sptDes', title: '规格类型说明', width:140,templet: '#sptDesTpl'}
      ,{fixed:'right', title: '操作栏',width:250, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
    ]]
    ,id: 'testReload'
    ,page: true
    ,height: 471
    ,done: function(res, curr, count){
    	layer.close(loadIndex);//加载层关闭  
    }
  });
  
//监听工具条
  table.on('tool(user)', function(obj){ //注：tool是工具条事件名，user是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data; //获得当前行数据
    var layEvent = obj.event; //获得 lay-event 对应的值
    var tr = obj.tr; //获得当前行 tr 的DOM对象
    if(layEvent === 'detail'){ //查看
    	var sptId = data.sptId ;
    	loadIndex = layer.load();//出现加载层
    	$.ajax({  
            url: 'SpecificationTypeAction/back/showUpdate.action' ,  
            type: 'post',  
            data: {'sptId':sptId},  
            async: false,  
            cache: false,  
            success: function (returnData) {
            	layer.close(loadIndex);//加载层关闭 
            	layer.open({
  	    		  type: 1,
  	    		  title:'规格详情',
  	    		  area: ['75%', '80%'],
  	    		  shadeClose:true,
  	    		  content:'<div style="margin-top: 10px; margin-right: 10px;">'+
	  	    			  	  '<form class="layui-form">'+
						    	 '<div class="layui-form-item">'+
							      '<label class="layui-form-label">规格名称</label>'+
							      '<div class="layui-input-block">'+
							        '<input type="text" value="'+returnData.sptName+'" class="layui-input" disabled>'+
							      '</div>'+
							    '</div>'+
							    '<div class="layui-form-item">'+
							      '<label class="layui-form-label">规格说明</label>'+
							      '<div class="layui-input-block">'+
							        '<input type="text" value="'+returnData.sptDes+'" class="layui-input" disabled>'+
							      '</div>'+
							    '</div>'+
								'<div id="specifications-number2"></div>'+
	  	    		  		  '</form>'+
	  	    		  	  '</div>'
  	      		});
            	$.each(returnData.ehySpecifications,function(i,item){
                	  $("#specifications-number2").append(''+
                    		  '<div class="layui-form-item" id="sp'+item.spId+'">'+
                		      '<label class="layui-form-label">规格值</label>'+
                		      '<div class="layui-input-block">'+
                		        '<input type="text" value="'+item.spValue+'"class="layui-input" disabled>'+
                		      '</div>'+
                		    '</div>');
                })
            },
            error: function (returnData) {  
            	layer.close(loadIndex);//加载层关闭 
            	layer.msg("数据异常");
            }  
        });
    	
    } else if(layEvent === 'del'){ //删除
      layer.confirm('真的删除行么', function(index){
      layer.close(index);
      loadIndex = layer.load();//出现加载层
    	$.ajax({
    		url: 'SpecificationTypeAction/back/delete.action',
    		type: 'post',
    		data: {'sptId':data.sptId},
    		async: false,  
            cache: false, 
            success: function(data){
          	    layer.close(loadIndex);//加载层关闭 
                if(data.state==1){
                	obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.msg(data.mes);
                }else{
                	layer.msg(data.mes);
                }
            },
            error: function (returnData) {  
            	layer.close(loadIndex);//加载层关闭 
          	    layer.msg("数据异常");
            } 
    	})
        
      });
    } else if(layEvent === 'edit'){ //编辑
    	var sptId = data.sptId ;
    	loadIndex = layer.load();//出现加载层
    	$.ajax({  
            url: 'SpecificationTypeAction/back/showUpdate.action' ,  
            type: 'post',  
            data: {'sptId':sptId},  
            async: false,  
            cache: false,  
            success: function (returnData) {
          	    layer.close(loadIndex);//加载层关闭 
            	//do something
                editSpecificationType(returnData);
                $.each(returnData.ehySpecifications,function(i,item){
              	  $("#specifications-number").append(''+
                  		  '<div class="layui-form-item" id="sp'+item.spId+'">'+
              		      '<label class="layui-form-label"><a href="javascript:void(0)" style="color:#c2c2c2;" onclick="deleteRow(&quot;sp'+item.spId+'&quot;)">X</a>&nbsp;&nbsp;规格值</label>'+
              		      '<div class="layui-input-block">'+
              		        '<input type="text" name="spValue" value="'+item.spValue+'" required  lay-verify="spValue" placeholder="请输入规格类型说明" autocomplete="off" class="layui-input">'+
              		      '</div>'+
              		    '</div>');
                })
                //同步更新缓存对应的值
               
          	  
            },
            error: function (returnData) {
          	    layer.close(loadIndex);//加载层关闭 
          	    layer.msg("数据异常");
            }  
        });
    }
  });
  
  //搜索方法
  var $ = layui.$, active = {
    reload: function(){
  	  layer.close(loadIndex);//加载层关闭 
      table.reload('testReload', {
        where: {
          	
            id: $('#demoReload').val()
          
        }
      });
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
  });
  
  //表单验证
  form.verify({
	  spValue: function(value, item){ //value：表单的值、item：表单的DOM对象
		if(value==null || value==""){
	    	return '规格值不能为空';
	    }
	  }
	});   
  
  //表单提交方式
  form.on('submit(formDemo)', function(data){
	  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
	  $.ajax({  
          url: 'SpecificationTypeAction/back/addOrUpdate.action' ,  
          type: 'post',  
          data: new FormData($( "#sss" )[0]),  
          async: false,  
          cache: false,  
          contentType: false,  
          processData: false,  
          success: function (returndata) {
        	  layer.close(layer.index);
        	  table.reload('testReload');
        	  if(returndata==1){
        		  layer.msg(returndata.mes);
        	  }else{
        		  layer.msg(returndata.mes);
        	  } 
          },
          error: function (returndata) {  
        	  layer.msg("数据异常!");
          }  
      });
	  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
  });
  
});
	//规格类型编辑信息   specifications 规格值
	function editSpecificationType(data){
		var specificationForm = '<div style="margin-top: 20px; margin-right: 20px;">'+
	      '<form class="layui-form" id="sss">'+
	      	  '<input type="hidden" name="sptId" id="sptId" value="'+data.sptId+'">'+
		      '<div class="layui-form-item">'+
		      '<label class="layui-form-label">规格名称</label>'+
		      '<div class="layui-input-block">'+
		        '<input type="text" name="sptName" value="'+data.sptName+'" required  lay-verify="required" placeholder="请输入规格类型名称" autocomplete="off" class="layui-input">'+
		      '</div>'+
		    '</div>'+
		    '<div class="layui-form-item">'+
		      '<label class="layui-form-label">规格说明</label>'+
		      '<div class="layui-input-block">'+
		        '<input type="text" name="sptDes" value="'+data.sptDes+'" required  lay-verify="required" placeholder="请输入规格类型说明" autocomplete="off" class="layui-input">'+
		      '</div>'+
		    '</div>'+
		    '<div class="layui-form-item">'+
		      '<label class="layui-form-label">规格类型</label>'+
		      '<div class="layui-input-block">'+
		        '<input type="radio" name="isva" value="2" title="属性">'+
		        '<input type="radio" name="isva" value="1" title="价格">'+
		      '</div>'+
		    '</div>'+
		    '<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">'+
			  '<legend>规格值</legend>'+
			'</fieldset>'+
			'<div id="specifications-number"></div>'+
			'<div class="layui-form-item">'+
		      '<label class="layui-form-label">新增规格值</label>'+
		      '<div class="layui-input-block">'+
		        '<a href="javascript:void(0)" class="layui-btn layui-bg-gray" style="width:100%;" onclick="addSpecif()">添加规格值</a>'+
		      '</div>'+
		    '</div>'+
		    '<div class="layui-form-item">'+
			    '<div class="layui-input-block">'+
			      '<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>'+
			    '</div>'+
			'</div>'+
	      '</form>'+
	      '</div>';
	      
	      layer.open({
	    		  type: 1,
	    		  title:'编辑规格详情',
	    		  area: ['75%', '80%'],
	    		  shadeClose:true,
	    		  content:specificationForm
	      });
	}
	
	//新增规格类型方法  
	function addProType(){
		
		var data = {'sptId':'','sptName':'','sptDes':''}
		//方便用于编辑格式  定义一个json格式传入方法
		editSpecificationType(data);
		$("#specifications-number").append(''+
        		  '<div class="layui-form-item" id="spDefault">'+
    		      '<label class="layui-form-label"><a href="javascript:void(0)" style="color:#c2c2c2;" onclick="deleteRow(&quot;spDefault&quot;)">X</a>&nbsp;&nbsp;规格值</label>'+
    		      '<div class="layui-input-block">'+
    		        '<input type="text" name="spValue" value="" required  lay-verify="spValue" placeholder="请输入规格值" autocomplete="off" class="layui-input">'+
    		      '</div>'+
    	'</div>');
	}
	//根据规格值进行规格值删除
	function deleteRow(spId){
		$("#"+spId).remove();

	}
	//新增规格值输入框
	var spidData = 1;
	function addSpecif(){
		spidData+=1;
	    	  $("#specifications-number").append(''+
	        		  '<div class="layui-form-item" id="sp'+spidData+'">'+
	    		      '<label class="layui-form-label"><a href="javascript:void(0)" style="color:#c2c2c2;" onclick="deleteRow(&quot;sp'+spidData+'&quot;)">X</a>&nbsp;&nbsp;规格值</label>'+
	    		      '<div class="layui-input-block">'+
	    		        '<input type="text" name="spValue" value="" required  lay-verify="required" placeholder="请输入规格类型说明" autocomplete="off" class="layui-input">'+
	    		      '</div>'+
	    	'</div>');
	}
</script>
<!-- 绑定工具条 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
<!-- 单元格显示样式  -->
<script type="text/html" id="sptDesTpl">
  {{#  if(d.sptDes === '' || d.sptDes === null){ }}
    <span style="color: #FF5722;">没有描述哦</span>
  {{#  } else { }}
    {{ d.sptDes }}
  {{#  } }}
</script>
</body>
</html>