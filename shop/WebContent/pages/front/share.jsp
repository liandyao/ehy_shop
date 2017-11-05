<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="罗海兵" />
<meta http-equiv="keywords" content="E货源,用户中心,分享,前台" />
<meta http-equiv="description" content="E货源网站前台用户中心--分享页面" />
<title>E货源--用户中心分享页面</title>
<base href="<%=basePath %>" />
<script type="text/javascript" src="res/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="res/css/common.css" />
<script type="text/javascript" src="res/js/share.js"></script>
<link rel="stylesheet" type="text/css" href="res/css/share.css" />
<script type="text/javascript">
			function show(){
				document.getElementById("dialogs").style="display:block;";
				document.getElementById("curtain").style="display:block;";
	
			}
			function hide(){
				document.getElementById("dialogs").style="display:none;";
				document.getElementById("curtain").style="display:none;";
			}
		</script>
</head>
<body>


	<!-- 遮盖层 -->
	<div id="curtain" style="display: none;"></div>
	<!-- 弹出按钮 -->
	<input type="button" value="点我弹出表单隐藏层" onclick="show()" />
	<!-- 弹出层 -->
	<div id="dialogs" style="display: none;">
		
		<div class="close">
			<!-- 关闭按钮  start -->
			<img src="res/images/close.png" style="width: 65px; height: 52px;"
				onclick="hide()" />
			<!-- 关闭按钮  start -->
		</div>
		<form id="comment">
		<!-- 用户中心分享页面弹出层  start -->
		<div class="share" style="float: left;">
			<!-- 弹出层内容区   start -->
			<div class="cont">
				<!-- 商品图片、评价、印象、价格收益等主要内容区   start -->
				<div class="main-part">
					<!-- 大图：厂家默认的第一张图片 -->
					<div class="max-img">
						<img src="res/images/max.jpg" />
					</div>

					<!-- 商品信息：评价、印象、价格收益   -->
					<div class="message">
						<!-- 评价 -->
						<div class="estimate">
							<span>对商品的评价</span>
							<textarea name="commDesc" placeholder="请输入商品评价"></textarea>
						</div>

						<!-- 对商品的印象 -->
						<div class="impress">
							<span>对商品的印象(选项)</span>
							<div class="options">
								<!-- 试穿效果 -->
								<div class="try-on">
									<p class="txt" style="position: relative; left: -8px;">试穿效果</p>
									<ul>
										<li>一般</li>
										<li>很好</li>
										<li>非常好</li>
									</ul>
								</div>

								<!-- 尺寸大小 -->
								<div class="try-on">
									<p class="txt">尺寸大小</p>
									<ul>
										<li>偏小</li>
										<li>正常</li>
										<li>偏大</li>
									</ul>
								</div>

								<!-- 舒适程度 -->
								<div class="try-on">
									<p class="txt" style="position: relative; left: -8px;">舒适程度</p>
									<ul>
										<li>一般</li>
										<li>很好</li>
										<li>非常好</li>
									</ul>
								</div>
							</div>
						</div>

						<!-- 价格 -->
						<div class="price">
							厂家直销价￥<em class="factory">111</em> 实际付款￥<em class="actual">111</em>
						</div>

						<!-- 分享价格设置/我的收益 -->
						<div class="set-earn">
							<div class="set-price">
								<div class="range">
									分享价格设置<br /> 参考区间价(￥<em class="min-price">95</em>-￥<em
										class="max-price">110</em>)
								</div>
								<div class="actual">
									<div>￥</div>
									<div>
										<input type="text" value="" />
									</div>
								</div>
							</div>
							<div class="earnings">
								我的收益 <span> ￥<input type="text" style="width: 50px;">
								</span>
							</div>
						</div>
					</div>
				</div>
				<!-- 商品图片、评价、印象、价格收益等主要内容区     end  -->
				
				<!-- 图片上传内容区   start -->
				<div class="upload-img">
					<div class="photo" style="width: 223px; height: 296px; float: left;">
						<div class=""
							style="width: 223px; height: 215px; border: 1px solid #d5d5d5; border-bottom: none;">
							<div
								style="border-bottom: none; line-height: 215px; text-align: center; color: red; font-size: 18px;">上传照片</div>
						</div>
						<textarea name="" style="width: 223px; height: 70px;"
							placeholder="可输入描述文字"></textarea>
					</div>

					<div class="photoAdd"
						style="width: 77px; height: 295px; border: 2px dashed #ebebeb; float: left; margin-left: 20px;">
						<div class=""
							style="width: 77px; height: 249px; border-bottom: 2px dashed #ebebeb; text-align: center; line-height: 300px;">
							<label class="ui_button ui_button_primary" for="xFile"><img
								alt="" src="res/images/upload-img.jpg"></label>
							<form>
								<div id="wrapper" style="display: none;">
									<input name="photo" accept="image/png, image/jpeg, image/gif, image/jpg"  id="xFile" type="file" multiple /><br />
									<div id="image-holder"></div>
								</div>
							</form>
						</div>
						<div class=""
							style="width: 77px; height: 44px; line-height: 40px;">
							<input type="button" onclick="javascript:comment();" value="完成提交" class="btn btn-warning"
								style="padding: 4px; margin: 5px 5px; font-weight: normal;"
								multiple />
						</div>
					</div>
				</div>
				
				<!-- 图片上传内容区      end  -->
			</div>
			<!-- 弹出层内容区   end -->
		</div>
		</form>
	</div>
	<!-- 用户中心分享页面弹出层   end -->
</body>
</html>