<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>产品管理</title>
		<!-- zTree -->
  		<link rel="stylesheet" href="res/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="res/css/treeStyle_ouyang.css">
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<!-- zTree -->
		<script type="text/javascript" src="res/zTree_v3/js/jquery.ztree.core.min.js"></script>
		<style type="text/css">
			body{
				padding: 5px;
			}
			#sousuo .layui-input{
				height:30px;
			}
			#sousuo td{
				padding-right: 5px;
				padding-top: 5px;
			}
			body .layui-elem-quote{
				padding: 7px;
			}
		</style>
	</head>
	<body>
		<div class="demoTable layui-elem-quote layui-quote-nm">
		  <div class="layui-inline">
		  	<form class="layui-form" id="sousuo" style="float: left;">
		  		<table>
		  			<tr>
		  				<td>
		  					<input class="layui-input" name="priductData" maxlength="50" id="priductData" placeholder="产品编号/名称/品牌" autocomplete="off">
		  				</td>
		  				<td>
		  					<input id="typeId" type="hidden" name="typeId">
		  					<input type="text" id="typeName" onclick="showMenu(); return false;" placeholder="产品类型" autocomplete="off" class="layui-input" readonly="readonly">
		  				</td>
		  				<td>
			  				<select id="stId" name="stId" lay-verify="" width="50px">
							  <option value="">分站站点</option>
							</select>
		  				</td>
		  				<td>
			  				<select id="isva" name="isva" lay-verify="" width="50px">
							  <option value="">是否上架</option>
							  <option value="1">已上架</option>
							  <option value="0">未上架</option>
							</select>
		  				</td>
		  			</tr>
		  			<tr>
		  				<td>
	  					  <div class="layui-inline">
						    <div class="layui-input-inline" style="width: 100px;">
						      <input type="text" id="proFactoryPriceMix" name="proFactoryPriceMix" maxlength="10" placeholder="￥出厂价格" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						    <div class="layui-input-inline">-</div>
						    <div class="layui-input-inline" style="width: 100px;">
						      <input type="text" id="proFactoryPriceMax" name="proFactoryPriceMax" maxlength="10" placeholder="￥出厂价格" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						  </div>
		  				</td>
		  				<td>
	  					  <div class="layui-inline">
						    <div class="layui-input-inline" style="width: 100px;">
						      <input type="text" id="proPriceMix" name="proPriceMix" maxlength="10" placeholder="￥市场价格" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						    <div class="layui-input-inline">-</div>
						    <div class="layui-input-inline" style="width: 100px;">
						      <input type="text" id="proPriceMax" name="proPriceMax" maxlength="10" placeholder="￥市场价格" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						  </div>
		  				</td>
		  				<td>
	  					  <div class="layui-inline">
						    <div class="layui-input-inline" style="width: 100px;">
						      <input type="text" id="proPrice0Mix" name="proPrice0Mix" maxlength="10" placeholder="￥产家直销价" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						    <div class="layui-input-inline">-</div>
						    <div class="layui-input-inline" style="width: 100px;">
						      <input type="text" id="proPrice0Max" name="proPrice0Max" maxlength="10" placeholder="￥产家直销价" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						  </div>
		  				</td>
		  				<td>
	  					  <div class="layui-inline">
						    <div class="layui-input-inline" style="width: 120px;">
						      <input type="text" id="proPrice1Mix" name="proPrice1Mix" maxlength="10" placeholder="￥银/金牌会员价" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						    <div class="layui-input-inline">-</div>
						    <div class="layui-input-inline" style="width: 120px;">
						      <input type="text" id="proPrice1Max" name="proPrice1Max" maxlength="10" placeholder="￥银/金牌会员价" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
						    </div>
						  </div>
		  				</td>
		  			</tr>
		  		</table>
			</form>
			<button style="margin-top: 5px;" class="layui-btn layui-btn-small" data-type="reload">搜索</button>
		  </div>
		</div>
		<ul class="layui-fixbar">
			<li class="layui-icon" lay-type="bar1" id="addProduct">+</li>
		</ul>
		<table class="layui-table" lay-data="{height:400,size:'sm',skin:'row ', url:'product/back/findAll.action',method:'post',page:true,limit:10, id:'tb'}" lay-filter="tb">
		  <thead>
		    <tr>
		      <th lay-data="{field:'proId',hidden}">产品ID</th>
		      <th lay-data="{field:'stId',hidden}">站点ID</th>
		      <th lay-data="{field:'proName', sort: true,fixed:true,width:300,align:'left',templet:'#proNameTpl'}">产品名称</th>
		      <th lay-data="{field:'proCode', sort: true, width:150}">产品编号</th>
		      <th lay-data="{field:'isva', sort: true,width:110,align:'center',templet:'#isvaTpl'}">状态</th>
		      <th lay-data="{field:'proFactoryPrice', sort: true,width:150,align:'center'}">出厂价格(元)</th>
		      <th lay-data="{field:'proPrice', sort: true,width:150,align:'center'}">市场价(元)</th>
		      <th lay-data="{field:'proPrice0', sort: true,width:150,align:'center'}">产家直销价(元)</th>
		      <th lay-data="{field:'proPrice1', sort: true,width:160,align:'center'}">银/金牌会员价(元)</th>
		      <th lay-data="{fixed: 'right', width:250, align:'center', toolbar: '#barDemo1'}"></th>
		    </tr>
		  </thead>
		</table>
		<!-- 树 -->
		<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
			<ul id="treeDemo" class="ztree" style="margin-top:0;"></ul>
		</div>
		<script type="text/html" id="isvaTpl">
  			{{#  if(d.isva==0){ }}
    			<span class="layui-badge-rim layui-bg-gray">暂停销售</span>
  			{{#  } else { }}
    			<span class="layui-badge-rim layui-bg-blue">正常销售</span>
  			{{#  } }}
		</script>
		<script type="text/html" id="proNameTpl">
    		<a href="pages/front/info.jsp?proId={{d.proId}}" target="_blank" class="layui-table-link">{{d.proName}}</a>
		</script>
		<script type="text/html" id="barDemo1">
  			<a class="layui-btn layui-btn-mini" lay-event="update"><i class="layui-icon">&#xe642;</i>编辑</a>
			{{#  if(d.isva==0){ }}
				<a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="add"><i class="layui-icon">&#xe62f;</i>上架</a>
			{{#  } else { }}
				<a class="layui-btn layui-btn-mini layui-btn-warm" lay-event="drop"><i class="layui-icon">&#xe601;</i>下架</a>
			{{#  } }}
			<a class="layui-btn layui-btn-mini layui-btn-primary" lay-event="join">加入展示</a>
		</script>
		<script>
			var form;//表单
			var table;//数据表格
			var loadIndex;//加载层
			layui.use('form', function(){
				form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				//加载所有分站站点
				loadIndex = layer.load();//出现加载层
				var url = "station/back/findStation.action";
				$.post(url, null, function(data){
					$(data).each(function(i,element){
						$("#stId").append('<option value="'+element.stId+'">'+element.stName+'</option>');
						form.render('select');//重新渲染
						layer.close(loadIndex);//加载层关闭  
					});
				});
			});
			//初始化数据表格
			layui.use('table', function(){
			  table = layui.table;
				//监听工具条
			  table.on('tool(tb)', function(obj){//tb是table原始容器的属性 lay-filter="对应的值"
				  var formdata = obj.data; //获得当前行数据
				  var layEvent = obj.event; //获得 lay-event 对应的值
				  if(layEvent === 'drop'){ //下架
					  var ts =layer.open({
						  type: 1, 
						  skin: 'layui-layer-molv'//样式
						  ,title:'下架操作'//标题
						  ,area: ['300px', '150px']
						  ,content: '<p style="color:#01AAED;padding-top:5px;padding-left:20px;">温馨提示：下架之后该商品则暂停销售</p><p style="color:#FF5722;padding-left:20px;">是否对该产品进行下架处理？</p>' //这里content是一个普通的String
						,btn: ['坚持下架', '算了'] //可以无限个按钮
					  	,yes: function(index, layero){
					  		layer.close(ts);
					  		loadIndex = layer.load();//出现加载层
					  		//下架操作
					  		var url = "product/back/upOrDown.action";
					  		var data = {"proId":formdata.proId,"par":2}
							$.post(url, data, function(info){
								layer.close(loadIndex);//加载层关闭  
								if(info>0){
									layer.msg('产品已成功下架！');
									tableReload();//重载表格的方法
								}else{
									layer.msg('操作失败！');
								}
							});
						  }
					});
				  }else if(layEvent === 'add'){//上架
					  var ts =layer.open({
						  type: 1, 
						  skin: 'layui-layer-molv'//样式
						  ,title:'上架操作'//标题
						  ,area: ['300px', '150px']
						  ,content: '<p style="color:#01AAED;padding-top:5px;padding-left:20px;">温馨提示：上架之后该商品则正常销售</p><p style="color:#FF5722;padding-left:20px;">是否对该产品进行上架处理？</p>' //这里content是一个普通的String
						,btn: ['我要上架', '算了'] //可以无限个按钮
					  	,yes: function(index, layero){
					  		layer.close(ts);
					  		//上架操作
					  		loadIndex = layer.load();//出现加载层
					  		var url = "product/back/upOrDown.action";
					  		var data = {"proId":formdata.proId,"par":1}
							$.post(url, data, function(info){
								layer.close(loadIndex);//加载层关闭  
								if(info>0){
									layer.msg('产品已成功上架！');
									tableReload();//重载表格的方法
								}else{
									layer.msg('操作失败！');
								}
							});
						  }
					});
				  }else if(layEvent === 'update'){
					  var ts =layer.open({
						  type: 2, 
						  skin: 'layui-layer-molv'//样式
						  ,anim:1//弹出动画
						  ,shadeClose:true//点击弹出层关闭
						  ,maxmin:true//显示最大最小化
						  ,title:'修改产品信息：'+formdata.proName//标题
						  ,area: ['75%', '80%']
						  ,content: 'product/back/updateProduct.action?proId='+formdata.proId
					}); 
				  }else if(layEvent === 'join'){
					  var ts =layer.open({
				    		type:2,
							skin: 'layui-layer-molv',//样式
							anim:1,//弹出动画
				    		content:'pages/back/proshowadd.jsp?proId='+formdata.proId+"&stId="+formdata.stId,
				    		area: ['75%', '80%'],
				    		title: '加入展示:'+formdata.proName,
				    		
				    	});
				  }
			  });
			  //搜索
			  var $ = layui.$, active = {
			    reload: function(){
			    	loadIndex = layer.load();//出现加载层
			    	tableReload();//重载表格的方法
			    	layer.close(loadIndex);//加载层关闭  
			    }
			  };
			  
			  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
			});
			
			function tableReload(){
				table.reload('tb', {
			        where: {
			        	priductData: $('#priductData').val(),
			        	proTypeId:$("#typeId").val(),
			        	stId:$('#stId').val(),
			        	isva:$('#isva').val(),
			        	proFactoryPriceMix:$('#proFactoryPriceMix').val(),
			        	proFactoryPriceMax:$('#proFactoryPriceMax').val(),
			        	proPriceMix:$('#proPriceMix').val(),
			        	proPriceMax:$('#proPriceMax').val(),
			        	proPrice0Mix:$('#proPrice0Mix').val(),
			        	proPrice0Max:$('#proPrice0Max').val(),
			        	proPrice1Mix:$('#proPrice1Mix').val(),
			        	proPrice1Max:$('#proPrice1Max').val()
			        }
			      });
			}
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
			   $("#typeName").val(treeNode.name);
			   $("#typeId").val(treeNode.id);
			   hideMenu();	
			};
			//异步加载完成时运行，此方法将所有的节点打开
			function zTreeOnAsyncSuccess(event, treeId, msg) {
			    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			    treeObj.expandAll(true);
			}
		   $(document).ready(function(){
			   treeObj=$.fn.zTree.init($("#treeDemo"), setting);
		   });
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
			//限制数字的输入
			function clearNoNum(obj){ 
			    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
			    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
			    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
			    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
			    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
			        obj.value= parseFloat(obj.value); 
			    }
			    if(obj.value.indexOf(".")==0){//第一个字符不能为.
			    	 obj.value="";
			    }
			}
			//跳转新增产品页面
			$("#addProduct").click(function(){
				location.href="product/back/releaseProduct.action";
			});
			$('#addProduct').mouseover(function(){
			  	layer.tips('点我发布新产品',"#addProduct",{
			  		time :700
			  	});
			});
		</script>
	</body>
</html>