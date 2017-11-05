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
		<title>e货源后台管理</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/js/ehy_common.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style>
			/*隐藏首页选项卡的关闭按钮*/
			.layui-tab ul.layui-tab-title li:nth-child(1) i {
			    display: none;
			}
			.layui-tab-item{
				height:100%;
			} 	
			.layui-body{
				z-index:-1;
			}
			.layui-layout-admin .layui-body{
				bottom: 0px; 
			}
			.layui-tab-content{
				padding-bottom: 0px;
			}
			.x-slide_left {
			    width: 17px;
			    height: 61px;
			    background: url(res/images/unfold.png) 0 0 no-repeat;
		        background-position-x: 0px;
		        background-position-y: 0px;
			    position: absolute;
			    top: 200px;
			    left: 0px;
			    cursor: pointer;
			}
		</style>
	</head>
	<body>
		<div class="layui-layout layui-layout-admin">
		  <div class="layui-header">
		    <div class="layui-logo">e  货源</div>
		    <!-- 头部区域（可配合layui已有的水平导航） -->
		    <ul class="layui-nav layui-layout-left">
		      <li class="layui-nav-item"><a href="">控制台</a></li>
		      <li class="layui-nav-item"><a href="javascript:;">商品管理</a></li>
		      <li class="layui-nav-item"><a href="">用户</a></li>
		      <li class="layui-nav-item">
		        <a href="javascript:;">其它系统</a>
		        <dl class="layui-nav-child">
		          <dd><a href="">邮件管理</a></dd>
		          <dd><a href="">消息管理</a></dd>
		          <dd><a href="">授权管理</a></dd>
		        </dl>
		      </li>
		    </ul>
		    <ul class="layui-nav layui-layout-right">
		      <li class="layui-nav-item">
		        <a href="javascript:;">
		          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
		          ${manager.manUser }
		        </a>
		        <dl class="layui-nav-child">
		          <dd><a href="">基本资料</a></dd>
		          <dd><a href="">安全设置</a></dd>
		        </dl> 
		      </li>
		      <li class="layui-nav-item"><a href="manager/back/logout.action">退了</a></li>
		    </ul>
		  </div>
		  
		  <div class="layui-side layui-bg-black x-side">
		    <div class="layui-side-scroll">
		      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		      <ul class="layui-nav layui-nav-tree" id="menuTree">
		      
			  </ul>
		    </div>
		  </div>
		  
		  <div class="layui-body x-main">
		    <!-- 内容主体区域 -->
		    <div id="top-tab" class="layui-tab layui-tab-brief" lay-filter="demo" lay-allowClose="true" style="margin: 0px;height:90%;">
			  <ul class="layui-tab-title">
			    <li class="layui-this" id="close" style="-moz-user-select:none;">首页</li>
			  </ul>
			  <div class="layui-tab-content" style="height:100%;">
			  	<div class="x-slide_left" style="background-position: 0px 0px;"></div>
			    <div class="layui-tab-item layui-show">
			    	首页显示的内容
			    	<iframe name="iframe" width="100%" scrolling="yes" frameborder="0" noresize="noresize" src=""></iframe>
			    </div>
			  </div>
			</div>
		  </div>
		</div>
		
		<script type="text/javascript">
			function showMenuTree(){
				var url = "privilege/back/showMenuTree.action";
				var data = {"manId":"${manager.manId}"};
				
				$.ajax({
					type : "POST",
					url : url, 
					data : data, 
					async : false,
					success : function(info){
						$("#menuTree").html("");
						for(i=0; i<info.length; i++){
							var obj = info[i];
							var str = '';
							str = str + '<li class="layui-nav-item layui-nav-itemed">';
							str = str + '<a  ';
							if(obj.moduleList.length==0){
								str = str + 'id='+obj.modId;
							}
							str = str +' class="tab" href="javascript:;" ';
							if(obj.moduleList.length==0){
								str = str + 'title='+obj.url;
							}
							str = str + '>'+obj.modName+'</a>';
							
							if(obj.moduleList.length>0){
								str = str + '<dl class="layui-nav-child">';
							}
							for(j=0; j<obj.moduleList.length; j++){
								var obj2 = obj.moduleList[j];
								str = str + '<dd><a id='+obj2.modId+' class="tab" href="javascript:;" title='+obj2.url+'>'+obj2.modName+'</a></dd>';
							} 
							if(obj.moduleList.length>0){
								str = str + '</dl>';
							}
							
							$("#menuTree").append(str+'</li>');
						}
						
					}
				});
			}
		</script>
		
		<script>
			$(function(){
				layui.use('element', function(){
				  var element = layui.element;
				  showMenuTree();
				  element.init();
				  	//新增或切换选项卡
					$(".tab").click(function(){
						var tabId =$(this).attr('id');
						var falg = true;
						var li = $("#top-tab li");
						$(li).each(function(i,element){
							if($(this).attr("lay-id")==tabId){
								falg = false;
							}
						});
						if(falg==false){
							element.tabChange('demo',tabId);//切换到指定的Tab项
						}else{
							element.tabAdd('demo', {
							  title: $(this).text()
							  ,content: '<iframe name="iframe" width="100%" height="100%" scrolling="yes" frameborder="0" noresize="noresize" src="'+$(this).attr("title")+'"></iframe>' //支持传入html
							  ,id:$(this).attr('id')
							});
							element.tabChange('demo',tabId);//切换到指定的Tab项
						}
						
					});
				  	//关闭全部选项
				  	$("#close").dblclick(function(){
				  		var li = $("#top-tab li");
						$(li).each(function(i,ele){
							var layId = $(this).attr("lay-id");
							element.tabDelete('demo',layId);
						});
				  	});
				});
				layui.use('layer', function(){
				  var layer = layui.layer;
				  //鼠标放到首页上显示提示信息
				  $('#close').mouseover(function(){
				  	  var that = this;
				  	  layer.tips('双击关闭',"#close",{
				  		tips:2,
				  		time :700
				  	  }); //在元素的事件回调体中，follow直接赋予this即可
				  	});
				});
				
				if($(window).width()<750){
					trun = 0;
					$('.x-slide_left').css('background-position','0px -61px');
				}else{
					trun = 1;
				}
				$('.x-slide_left').click(function(event) {
					if(trun){
						$('.x-side').animate({left: '-200px'},200).siblings('.x-main').animate({left: '0px'},200);
						$(this).css('background-position','0px -61px');
						trun=0;
					}else{
						$('.x-side').animate({left: '0px'},200).siblings('.x-main').animate({left: '200px'},200);
						$(this).css('background-position','0px 0px');
						trun=1;
					}
					
				});
			});
		
		</script>
	</body>
</html>