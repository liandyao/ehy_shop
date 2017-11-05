<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="罗海兵" />
		<meta http-equiv="keywords" content="E货源,首页,前台" />
		<meta http-equiv="description" content="E货源网站前台首页" />
		<title>E货源--首页</title>
		<base href="<%=basePath %>"/>
		<link rel="stylesheet" type="text/css" href="res/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="res/css/index.css"/>
		<link rel="stylesheet" href="res/css/glyphicon.css">
		<script src="res/js/jquery-2.1.4.min.js"></script>
		<script src="res/js/base.js"></script>

		<style type="text/css">
			#closes {
			    position: fixed;
			    margin: 0 auto;
			    top: -3%;
    			left: 16%;
			    z-index: 10001;
			}
			#shares {
			    width: 64%;
				height: 72%;
			    background-color: #fff;
			    position: fixed;
			    border: 1px solid #d3d3d0;
			    top: 18%;
				left: 20%;
				overflow-x: hidden;
				overflow-y:scroll; 
			    z-index: 10001;
			}
			/*设置遮障层  */
			 #hide_div{
			  	background:#111;
			  	width:100%;
			  	height:100%;
			  	border:1px solid white;
			  	position: fixed;
			  	display:none;
			  	top:0px;
			  	left:0px;
			  	z-index:99;
			  	opacity: 0.5;/*背景半透明*/
			 }
			
			#ff{
				font-family: "微软雅黑";
				font-size: 24px;
			}
			
			#ziti{
				font-family: "微软雅黑";
				font-size: 15px;
			}
			
			input{
				font-family: "微软雅黑";
				font-size: 15px;
			}
			
			h1, h2, h3 {
			    font-size: 25px;
			    font-weight: 400;
			}
			 .divcss5-4{
				 border-bottom:1px dashed #b4aaab;
				 height:2px;
			 }
		</style>
		
		<script type="text/javascript">
			//公告
			function shownews(id){
				var url="news/back/shownews.action";
				var data={"intercept":true,"station":id};
				$(".notice .title > a").attr("href","pages/front/news.jsp?stId="+id);
				$.post(url,data,function(arr){
					var ul=$(".menu > .notice > ul")[0];
					$(ul).find("li:not(:first-child)").remove();
					for(var i=0;i<arr.length;i++){
						//字符串省略
						var str=arr[i].newsTitle;
						var s=str;
						if(str.length>8){
							  s=str.substring(0,8)+"...";
							}
						//时间截取
						var str =arr[i].optime ; 
						var sj=str.substring(5,10);
						$(ul).append(
							"<li><a onclick='show(this,&apos;"+arr[i].newsId+"&apos;);'>"+s+"</a><span align='right'>"+sj+"</span></li>"	
						);
					}
				},"json");
			}
			
			//公告详细
			function show(obj,id){
				$("#shareDivs").css("display","block");
				$("#hide_div").css("display","block");
				var url="news/back/findById.action";
				var data={"intercept":true,"newsId":id};
				$.post(url,data,function(mes){
					$("#div").html("<hr /><p><h1>"+mes.newsTitle+"</h1></P>"+
					"<font color='#6d6d6d' id='ziti'>时间:"+mes.optime+"&nbsp;&nbsp;&nbsp;作者:"+mes.oper+"</font><div class='divcss5-4'></div><br />");
                    $("#div2").html("<font color='#6d6d6d' id='ziti'>"+mes.newsContent+"</font>");
				},"json");
			}
			
		
			
			function loadType(id){
				var url="ProductTypeAction/front/findIndexShow.action";
				var data={"intercept":true,"stId":id};
				$(".menu > .box > .list > ul > li").remove();
				$.post(url,data,function(map){
					var li=document.createElement("li");
					$(".menu > .box > .list > ul").prepend(li);
					$(li).append("<b>"+map.typeName+"：</b>");
					for(var i=0,arr=map.list;i<arr.length;i++){
						var obj=arr[i];
						$(li).append(
							"<a href='javascript:void(0);' onclick=loadSpecification(&apos;"+obj.typeId+"&apos;)>"+
							obj.typeName+"</a><div class='line-height'></div>"
						);
					}
					$(li).find("div.line-height:last-child").remove();
				},"json");
			}
			
			function loadSpecification(id){
				var url="proshow/front/findSpecification.action";
				var data={"intercept":true,"stId":id};
				$.post(url,data,function(arr){
					var ul=$(".menu > .box > .list > ul")[0];
					$(ul).find("li:not(:first-child)").remove();
					for(var i=0;i<arr.length && i<5;i++){
						var spt=arr[i];
						var li=document.createElement("li");
						$(ul).append(li);
						$(li).append("<b>"+spt.sptName+"：</b>");
						for(var j=0,list=spt.spList;j<list.length && j<15;j++){
							var obj=list[j];
							$(li).append(
								"<a href='javascript:void(0);' onclick=&apos;"+obj.spId+"&apos;>"+
								obj.spValue+"</a><div class='line-height'></div>"
							);
						}
						$(li).find("div.line-height:last-child").remove();
					}
					
				},"json");
			}
				
			/**
			 * 加载图片
			 * @param id 站点ID
			 * @returns
			 */
			function loadImages(id){
				var url="proshow/front/findAll.action";
				var data={"maxResult":8,"intercept":true,"stId":id};
				$.post(url,data,function(map){
					$("div.show-list ul li").remove();
					for(var i=0,arr=map.proShowList;i<arr.length;i++){
						var obj=arr[i];
						$("div.show-list ul").append(
							"<li>"+
								"<a href='pages/front/info.jsp?proId="+obj.proId+"'>"+
									"<div class='img'>"+
										"<img alt='' src='"+obj.imgPath+"'>"+
									"</div>"+
									"<div class='text'>"+
										"<div class='name'>"+obj.proName+"</div>"+
										"<div class='old-price'>市场价：<em>"+obj.proFactoryPrice+"</em></div>"+
										"<div class='new-price'>厂家直销价：<em>"+obj.proPrice+"</em></div>"+
									"</div>"+
								"</a>"+
							"</li>"	
						);
					}
				},"json");
			}
			
		</script>
	</head>
	<body>
		<!-- 遮罩层 -->
		<div id="hide_div"></div>
		<!-- 页眉 -->
		<div id="header"></div>
		
		<!-- 右边工具栏  start  -->
		<div id="toolbar"></div>
		
		<div id="main">
			<div class="content">
				<div class="poster">
					<h1 style="font-size: 40px;color: #ff6100">海报</h1>
				</div>
				
				<div class="menu">
					<div class="box">
						<div class="title">
							<div>产品信息分类</div>
						</div>
						<div class="list">
							<ul>
								<li>
									<b>女鞋款式：</b>
									<a href="#">凉/拖鞋</a><div class="line-height"></div>
									<a href="#">帆布鞋</a><div class="line-height"></div>
									<a href="#">低帮鞋</a><div class="line-height"></div>
									<a href="#">高帮鞋</a><div class="line-height"></div>
									<a href="#">靴子</a>
								</li>
								<li>
									<b>鞋面材质：</b>
									<a href="#">PU皮</a><div class="line-height"></div>
									<a href="#">帆布</a><div class="line-height"></div>
									<a href="#">绒面</a><div class="line-height"></div>
									<a href="#">网格</a><div class="line-height"></div>
									<a href="#">多材质拼接</a><div class="line-height"></div>
									<a href="#">牛皮</a><div class="line-height"></div>
									<a href="#">羊皮</a><div class="line-height"></div>
									<a href="#">磨砂牛皮</a><div class="line-height"></div>
									<a href="#">磨砂羊皮</a>
								</li>
								<li>
									<b>鞋头款式：</b>
									<a href="#">尖头</a><div class="line-height"></div>
									<a href="#">方头</a><div class="line-height"></div>
									<a href="#">圆头</a>
								</li>
								<li>
									<b>鞋跟款式：</b>
									<a href="#">平跟</a><div class="line-height"></div>
									<a href="#">中跟</a><div class="line-height"></div>
									<a href="#">高跟</a><div class="line-height"></div>
									<a href="#">超高跟</a>
								</li>
								<li>
									<b>鞋底款式：</b>
									<a href="#">平底</a><div class="line-height"></div>
									<a href="#">细跟</a><div class="line-height"></div>
									<a href="#">粗跟</a><div class="line-height"></div>
									<a href="#">坡跟</a><div class="line-height"></div>
									<a href="#">内增高</a><div class="line-height"></div>
									<a href="#">松糕底</a>
								</li>
								<li>
									<b>价格选择：</b>
									<div id="price-range">
										<span class="txt">100-500</span>
										<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
									</div>
									<!-- <input type="text" id="price-range"/> -->
								</li>
							</ul>
						</div>
						<div class="nav" align="center">
							<a href="#">实体货源</a>
							<a href="#">淘宝货源</a>
							<a href="#">天猫货源</a>
							<a href="#">微商货源</a>
							<a href="#">1688货源</a>
							<a href="#">网销货源</a>
						</div>
					</div>
					<div class="notice">
						<ul>
							<li class="title">
								<b class="">公告</b>
								<a href="">更多&gt;&gt;</a>
							</li>
							<li><a href="#">[解析]降价之谜</a></li>
							<li><a href="#">[解析]降价之谜</a></li>
							<li><a href="#">[解析]降价之谜</a></li>
							<li><a href="#">[解析]降价之谜</a></li>
							<li><a href="#">[解析]降价之谜</a></li>
						</ul>
					</div>
				</div>
				
				<div class="search">
					<ul>
						<li class="opt">
							<span class="title">已选择</span>
							<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
							<div class="text">
								<span>帆布鞋</span>
								<i>×</i>
							</div>
						</li>
						<li class="seek">
							<span class="title">搜索本站宝贝</span>
							<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
							<div class="text">
								<input type="text" id="seek-key"/>
								<div onclick="">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</div>
							</div>
						</li>
					</ul>
				</div>
				
				<!-- 商品列表 -->
				<div class="show-list">
					<ul>
						
					</ul>
				</div>
			</div>
		</div>
		
	
		
		
  <!-- 查看公告详细码弹出层  start-->
	<div id="shareDivs" style=" display: none;">
	<div style="width: 65px;height:0%;float: left;line-height: 620px;cursor: pointer;" id="closes">
			<!-- 关闭按钮  start -->
			<img src="res/images/close.png" style="width: 65px;height: 52px;"/>
			<!-- 关闭按钮  start -->
	</div>
			
		<div id="shares"  align="center">
			<br />
				  <!-- 标题 -->
				  <div id="div"></div>
				  
				  <div id="div2"></div>
		</div>
		
	</div>
		
		<!-- 页脚 -->
		<div id="footer"></div>
		
		<script type="text/javascript">
		$("#closes").click(function(){
			$("#hide_div").css('display','none');
			$("#shareDivs").css('display','none');
		})
		
		
		</script>
	</body>
</html>