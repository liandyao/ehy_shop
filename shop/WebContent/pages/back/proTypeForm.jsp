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

<link rel="stylesheet" href="res/zTree_v3/css/demo.css" type="text/css">
<link rel="stylesheet" href="res/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!-- zTree -->
<script type="text/javascript" src="res/zTree_v3/js/jquery.ztree.core.min.js"></script>

<title>Insert title here</title>
</head>

<script type="text/javascript">
	
</script>

<body>
<div style="margin-top: 20px; margin-right: 20px;">
	<form class="layui-form" id="sss">
	<input type="hidden" name="proTypeId" id="proTypeId"/>
		
		<div class="content_wrap" style='width:100%;'>
		  <div class="zTreeDemoBackground left" style='width:100%;'>
			 	 <input id="typeId" type="hidden" name="typeId" value="${map.PRO_TYPE_ID}">
			 	 <div class="layui-form-item">
			 	 	<label class="layui-form-label">上级类别</label>
			 	 	<div class="layui-input-block">
			  	 		<input type="text" id="typeName" width="100%" value="${map.PRO_TYPE_NAME}" required  lay-verify="required" onclick="showMenu(); return false;" placeholder="选择类目后自动输入" autocomplete="off" class="layui-input" readonly >
			  	 	</div>
			  	 </div>
			  	 <div id="spNameList" style="margin-top:5px;"></div>
			  	 
			  	 <div class="layui-form-item">
					<label class="layui-form-label">类型编号</label>
					<div class="layui-input-block">
						<input type="text" id="proTypeCode" name="proTypeCode" required lay-verify="proTypeCode"
							placeholder="请输入类型编号" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">类型名称</label>
					<div class="layui-input-block">
						<input type="text" id="proTypeName" name="proTypeName" required lay-verify="required"
							placeholder="请输入类型名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
				    <label class="layui-form-label">站点选项</label>
				    <div class="layui-input-block" id="stationChecked">
				      
				    </div>
			    </div>
				
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				  <legend>类型规格</legend>
				</fieldset>
				
				<div class="layui-form-item">
				    <label class="layui-form-label">规格选项</label>
				    <div class="layui-input-block" id="specificationTypes">
				      
				    </div>
				    
					
			    </div>
			    
			    <div class="layui-form-item">
					<label class="layui-form-label"></label>
					<div class="layui-input-inline">
						<span style="cursor:pointer;" class="layui-badge-rim layui-bg-gray" onclick="addProType()"><i class="layui-icon">&#xe608;</i>新建规格</span>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
		  </div>
		</div>
		<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
		  <ul id="treeDemo" class="ztree" style="margin-top:0;"></ul>
		</div>
	</form>
	</div>
	<script>
	var form ;
	//树结构初始化
	var treeObj ;
	   var setting = {
		    async: {
		        enable: true,//采用异步加载
		        url : "ProductTypeAction/back/proTypeTree.action",
		        dataType : "json"
		    },
		    data : {
		        key : {  
		            name : "name"
		        },
		        simpleData : {
		            enable : true,
		            idKey : "id",
		            rootPid : null 
		        }
		    },
		    callback : {
		    	onClick: zTreeOnClick,//给每个节点点击事件
		        onAsyncSuccess: zTreeOnAsyncSuccess //异步加载完成调用
		    }
		};
	   //给每个节点点击事件
	   function zTreeOnClick(event, treeId, treeNode) {
		   if(treeNode.children==null){
			   $("#typeName").val(treeNode.name);
			   $("#typeId").val(treeNode.id);
			   $("#stationChecked").html('');
		   }else{
			   $("#typeName").val(treeNode.name);
			   $("#typeId").val(treeNode.id);
			   loadIndex = layer.load();//出现加载层
			   if(treeNode.id == 0){
				   var url2 = 'news/back/showListAjax.action';
					$.post(url2,null,function(m){
						layer.close(loadIndex);//加载层关闭 
						$("#stationChecked").html("");
						//$("#se").append("<input   title='全部' name='all' lay-filter='all' type='checkbox'>");
						$(m).each(function(i,item){
							$("#stationChecked").append("<input value='"+item.stId+"' class='station' id='station"+item.stId+"' title="+item.stName+" name='proTypeRemarks' lay-filter='station'  type='checkbox'>");
						})
						form.render();
					});  
			   }else{
				   $("#stationChecked").html('');
			   }
		   }
		};
		//异步加载完成时运行，此方法将所有的节点打开
		function zTreeOnAsyncSuccess(event, treeId, msg) {
		    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		    treeObj.expandAll(true);
		}
	   $(document).ready(function(){
		   treeObj=$.fn.zTree.init($("#treeDemo"), setting);
	   });
	
	
		//Demo
		
		layui.use('form', function() {
			form = layui.form
			,layer = layui.layer
			,layedit = layui.layedit
			,laydate = layui.laydate;
			
			
			
			
			specificationType(form);
			
			//自定义验证规则
			  form.verify({
				proTypeCode: function(value){
			      if(value.length < 5){
			        return '标题至少得5个字符啊';
			      }
			    },
			    spValue: function(value, item){ //value：表单的值、item：表单的DOM对象
					if(value==null || value==""){
				    	return '规格值不能为空';
				    }
				 }
			  });
			
			//监听提交
			form.on('submit(formDemo)', function(data) {
				loadIndex = layer.load();//出现加载层
				$.ajax({  
			          url: 'ProductTypeAction/back/addOrUpdate.action' ,  
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
				        	  parent.layer.msg(returndata.mes);
			        	  }else{
			        		  parent.layer.msg(returndata.mes);
			        	  }  
			        	  
			          },
			          error: function (returndata) { 
			        	  layer.close(loadIndex);//加载层关闭  
			        	  layer.msg('提交失败'); 
			          }  
			     });
				return false;
			});
			
			
			form.on('submit(speFormDemo)', function(data){
				  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
				  $.ajax({  
			          url: 'SpecificationTypeAction/back/addOrUpdate.action' ,  
			          type: 'post',  
			          data: new FormData($( "#specificationTypeForm" )[0]),  
			          async: false,  
			          cache: false,  
			          contentType: false,  
			          processData: false,  
			          success: function (returndata) {
			        	  layer.close(layer.index);
			        	  specificationType();
			          },
			          error: function (returndata) {  
			        	  layer.close(loadIndex);//加载层关闭 
			        	  layer.msg("数据异常!");
			          }  
			      });
				  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			  });
			
			
			
		});
		
		   
		
		
		//得到规格类型信息
		function specificationType(form){
			var url= "SpecificationTypeAction/back/findSpecificationType.action";
			loadIndex = layer.load();//出现加载层
			$.post(url,null,function(data){
				layer.close(loadIndex);//加载层关闭 
				$("#specificationTypes").html("");
				$(data).each(function(i,item){
					$("#specificationTypes").append('<input type="checkbox" value="'+item.sptId+'" id="'+item.sptId+'" name="sptId" title="'+item.sptName+'" lay-skin="primary">');
					
				})
				form.render();
			})
			
			
		}
		
		//加载产品类型信息
		function findProductTypeList(){
			var url2 = 'news/back/showListAjax.action';
			$.post(url2,null,function(m){
				layer.close(loadIndex);//加载层关闭 
				$("#stationChecked").html("");
				//$("#se").append("<input   title='全部' name='all' lay-filter='all' type='checkbox'>");
				$(m).each(function(i,item){
					$("#stationChecked").append("<input value='"+item.stId+"' class='station' id='station"+item.stId+"' title="+item.stName+" name='proTypeRemarks' lay-filter='station'  type='checkbox'>");
				})
				form.render();
			}); 
			
			var url = "ProductTypeAction/back/selectIdOrName.action";
			var data = {
				page : '1',
				limit : '100000'
			};
			$.post(url, data, function(info) {
				$.each(info, function(i, item) {
					$("#bandId").append(
							'<option value="'+item.proTypeId+'">'
									+ item.proTypeName + '</option>');
					
				})
				form.render();//重新渲染
				var id = GetQueryString("id");
				var data = {"proTypeId":id};
				var url = "ProductTypeAction/back/showUpdate.action";
				if(id!=null & id!=""){
					$.post(url, data, function(mes){
						//InsertForm(mes);
						$("#typeId").val(mes.proType.ptId);
						$("#typeName").val(mes.proType.typeName);
						$("#proTypeId").val(mes.proType.proTypeId);
						$("#proTypeCode").val(mes.proType.proTypeCode);
						$("#proTypeName").val(mes.proType.proTypeName);
						
						if(mes.proType.proTypeSpecification !=null && mes.proType.proTypeSpecification !=""){
							$.each(mes.proType.proTypeSpecification,function(i,item){
								var tsId = "#"+item.SPE_ID ;
								$(tsId).attr('checked', true);
							})
						}
						
						if(mes.proType.ptId==0){
							if(mes.proType.proTypeRemark !=null && mes.proType.proTypeRemark !=""){
								var proTypeRemark = mes.proType.proTypeRemark.split(",");
								$.each(proTypeRemark,function(i,item){
									var tsId = "#station"+item;
									$(tsId).attr('checked', true);
								})
							}
						}else{
							$("#stationChecked").html("");
						}
						
						
						
						form.render();//重新渲染
					});
				}
				
				
			})
		}
		
		
		//规格类型编辑信息   specifications 规格值
		function editSpecificationType(){
			var specificationForm = '<div style="margin-top: 20px; margin-right: 20px;">'+
		      '<form class="layui-form" id="specificationTypeForm">'+
			      '<div class="layui-form-item">'+-
			      '<label class="layui-form-label">规格名称</label>'+
			      '<div class="layui-input-block">'+
			        '<input type="text" name="sptName" value="" required  lay-verify="required" placeholder="请输入规格类型名称" autocomplete="off" class="layui-input">'+
			      '</div>'+
			    '</div>'+
			    '<div class="layui-form-item">'+
			      '<label class="layui-form-label">规格说明</label>'+
			      '<div class="layui-input-block">'+
			        '<input type="text" name="sptDes" value="" required  lay-verify="required" placeholder="请输入规格类型说明" autocomplete="off" class="layui-input">'+
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
				      '<button class="layui-btn" lay-submit lay-filter="speFormDemo">立即提交</button>'+
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
			//方便用于编辑格式  定义一个json格式传入方法
			editSpecificationType();
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
		    		        '<input type="text" name="spValue" value="" required  lay-verify="required" placeholder="请输入规格值" autocomplete="off" class="layui-input">'+
		    		      '</div>'+
		    	'</div>');
		}
		
		
		
		
		//初始化加载信息
		$(function(){
			findProductTypeList();
			
		});
		
		function GetQueryString(id){
		     var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
		
		//树形菜单相关方法
	    function showMenu() {
	      var cityObj = $("#typeName");
	      var cityOffset = $("#typeName").offset();
	      $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
	 
	      $("body").bind("mousedown", onBodyDown);
	    }
	    function hideMenu() {
	      $("#menuContent").fadeOut("fast");
	      $("body").unbind("mousedown", onBodyDown);
	    }
	    function onBodyDown(event) {
	      if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
	        hideMenu();
	      }
	    }
		
	</script>
</body>
</html>