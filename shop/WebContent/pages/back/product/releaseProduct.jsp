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
		<link rel="stylesheet" href="pages/back/product/css/sp.css"><!-- 规格的样式 -->
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<!-- zTree -->
  		<link rel="stylesheet" href="res/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="res/css/treeStyle_ouyang.css">
		<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<!-- zTree -->
		<script type="text/javascript" src="res/zTree_v3/js/jquery.ztree.core.min.js"></script>
		
		<!-- 定义变量 -->
		<script type="text/javascript">
			var isUpload1 ="0";//是否上传了产品图片 0否  1是
			var isUpload2 ="0";//是否上传了产品图片 0否  1是
			var isDelete = true;//是否删除原始图片
		</script>
		
		<!--上传文件  -->
		<link rel="stylesheet" href="res/css/zyUpload.css">
		<script src="res/js/zyFile.js"></script>
		<script src="res/js/zyUpload.js"></script>
		<!-- 规格 -->
		<script type="text/javascript" src="pages/back/product/js/sp.js"></script>
		<title>发布产品</title>
		<style type="text/css">
			body{
				padding-left: 10px;
			}
		</style>
	</head>
	<body>
	    <div>
	    	<fieldset class="layui-elem-field layui-field-title">
			  <legend>填写基本信息(必填)</legend>
			</fieldset>
			<form class="layui-form layui-form-pane" action="">
			<blockquote class="layui-elem-quote layui-quote-nm"  style="border-left: 5px solid #2F4056;">
			  <input type="hidden" id="addOrUpdate" name="addOrUpdate" value="add"/>
			  <input type="hidden" id="proId" name="proId" value="${proId}"/>
			  <div class="layui-form-item">
			    <label class="layui-form-label">分站站点</label>
			    <div class="layui-input-block">
			      <input type="hidden" name="stId" id="stId">
			      <input type="text" id="stName" required  lay-verify="required" placeholder="抱歉，无法读取当前站点" autocomplete="off" class="layui-input" disabled>
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">宝贝类型</label>
			    <div class="layui-input-block">
			      <input id="typeId" type="hidden" name="proTypeId">
		  		  <input type="text" id="typeName" onclick="showMenu(); return false;" required  lay-verify="required" placeholder="请选择产品类型" autocomplete="off" class="layui-input" readonly="readonly">
			    </div>
			  </div>
			   <div class="layui-form-item">
			    <label class="layui-form-label">品牌</label>
			    <div class="layui-input-block" id="band">
			      <select id="bandId" name="bandId" lay-verify="required" lay-search>
			      	  <option value="">可搜索选择</option>
					</select>     
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">产品编号</label>
			    <div class="layui-input-block">
			      <input type="text" name="proCode" maxlength="50" required  lay-verify="required" placeholder="请输入产品编号" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">产品名称</label>
			    <div class="layui-input-block">
			      <input type="text" name="proName" maxlength="50" required  lay-verify="required" placeholder="请输入产品名称" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  
			  <div class="layui-form-item">
			    <label class="layui-form-label">产品重量(g)</label>
			    <div class="layui-input-block">
			      <input type="text" name="proWeight" maxlength="50" required  lay-verify="required" placeholder="请输入重量(以克为单位)" autocomplete="off" class="layui-input" oninput="clearNoNum(this)">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">出厂价格</label>
			    <div class="layui-input-block">
			      <input type="text" id="proFactoryPrice" name="proFactoryPrice" maxlength="10" required  lay-verify="required" placeholder="请输入出厂价格(最多精确到分)" autocomplete="off" class="layui-input" oninput="costing(this);">
			      <span class="layui-badge-dot"></span>厂家直销价：<span id="proPrice0">?</span>元
			      <span class="layui-badge-dot layui-bg-orange" style="margin-left: 5px;"></span>市场价：<span id="proPrice">?</span>元
			      <span class="layui-badge-dot layui-bg-blue" style="margin-left: 5px;"></span>银牌/金牌会员价：<span id="proPrice1">?</span>元
			      <span class="layui-badge layui-bg-gray">温馨提示：此处价格仅供参考</span>
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">运费模板</label>
			    <div class="layui-input-block" id="band">
			      <select id="proAttr01" name="proAttr01" lay-verify="required" lay-search>
			      	  <option value="">可搜索选择</option>
					</select>     
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">产品附件</label>
			    <div class="layui-input-block">
			      <input type="text" name="proFujian" maxlength="500" required  lay-verify="required" placeholder="请输入产品附件" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">保修政策</label>
			    <div class="layui-input-block">
			      <input type="text" name="proLaw" maxlength="500" required  lay-verify="required" placeholder="请输入产品保修政策" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">产品描述(可选择输入)</label>
			    <div class="layui-input-block">
			      <textarea id="pemark" name="proRemark" maxlength="700" style="display: none;"></textarea>
			    </div>
			  </div>
			  </blockquote>
			  
			  <fieldset class="layui-elem-field layui-field-title">
			    <legend>选择宝贝规格(可选)</legend>
			  </fieldset>
			  <blockquote class="layui-elem-quote layui-quote-nm" style="border-left: 5px solid #2F4056;">
			    <div id="spNameList">
			    	<div class="sku_btns">
						<a id="add_multi_sku" class="layui-btn layui-btn-small layui-btn-normal"><i class="layui-icon">&#xe615;</i>选择规格</a>
					</div>
					<div class="sku_guige">
						<!---下列存放动态生成的商品规格：颜色，尺码等-->
						<div class="sku_modellist">
						</div>
					</div>
					<!---此处为动态生成的表格内容-->
					<div class="sku_table">
						<!--表格头部-->
						<div class="sku_tableHead clearfix">
						</div>
						<!---表格内信息--->
						<div class="sku_tablecell"></div>
					</div>
					<!---弹窗中间内容-->
					<div class="sku_content">
						<div class="sku_list sku_content_sku_list">
						</div>
						<div class="sku_add"><input type="text" placeholder="请输入商品型号" class="sku_input">
							<a id="sku_addbtn">新建</a>
						</div>
					</div>
			    </div>
			  </blockquote>
			  <fieldset class="layui-elem-field layui-field-title">
			    <legend>上传宝贝图片(可选)</legend>
			  </fieldset>
			    <blockquote id="uploadButton" class="layui-elem-quote layui-quote-nm"  style="border-left: 5px solid #2F4056;">
			      <input type="hidden" id="imgType"><!-- 图片类型 -->
			      <!-- 注意：此超链接ID不可更改，否则无法识别图片类型 -->
				  <a href="javascript:void()" id="upload1" data-method="offset" data-type="auto" class="layui-btn layui-btn-small layui-btn-normal"><i class="layui-icon">&#xe608;</i>上传滚动图片</a>
				  <div id="uploadts1" style="display:inline;"><span class="layui-badge layui-bg-gray">未上传</span></div>
				  <a href="javascript:void()" id="upload2" data-method="offset" data-type="auto" style="margin-left: 40px;" class="layui-btn layui-btn-small layui-btn-normal"><i class="layui-icon">&#xe608;</i>上传详情图片</a>
				  <div id="uploadts2" style="display:inline;"><span class="layui-badge layui-bg-gray">未上传</span></div>
			    </blockquote>
			  <hr>
			  <div class="layui-form-item">
			    <div class="layui-input-block" style="margin-left: 0px;">
			      <button id="submitButton" class="layui-btn" lay-submit lay-filter="formDemo"><i class="layui-icon">&#xe609;</i>立即发布</button>
			    </div>
			  </div>
			</form>
	    </div>
	    <hr class="layui-bg-gray">
	    <!-- 上传图片的div -->
	    <div id="uploadDiv" style="display: none">
	    	<div id="proImg" class="demo"></div>
	    </div>
	    <!-- 树 -->
		<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
			<ul id="treeDemo" class="ztree" style="margin-top:0;"></ul>
		</div>
	</body>
	<script type="text/javascript">
		var form;//表单
		var index;//弹出层
		var loadIndex;//加载层
		var layedit;//富文本编辑器
		var textareaIndex;//富文本编辑器的索引
		var checkboxData="";//复选框中的值
		layui.use('form', function(){
		  form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			//加载所有商品品牌
			loadIndex = layer.load();//出现加载层
			var url = "productBand/back/findAll.action";
			$.post(url, null, function(data){
				$(data).each(function(i,element){
					$("#bandId").append('<option value="'+element.bandId+'">'+element.name+'</option>');
					form.render('select');//重新渲染
				});
			});
			//加载当前站点
			var url = "station/back/selectByPrimaryKey.action";
			$.post(url, null, function(info){
				$("#stId").val(info.stId);
				$("#stName").val(info.stName);
				
				//加载该站点的所有运费模板
				var url = "expressTemplate/back/findByStId.action?stId="+info.stId;
				$.post(url, null, function(data){
					$(data).each(function(i,element){
						$("#proAttr01").append('<option value="'+element.tempId+'">'+element.tempName+'('+element.money+'元)'+'</option>');
						form.render('select');//重新渲染
					});
				});
			});
			layer.close(loadIndex);//加载层关闭  
			//表单验证
			form.on('submit(formDemo)', function(data){
			  loadIndex = layer.load();//出现加载层
			  console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
			  console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
			  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
			  
			  var formData = data.field;//表单的数据
			  formData.proRemark = layedit.getContent(textareaIndex);//把富文本编辑框的内容加入表单数据中
			  
			  
			  //规格值描述的所有信息
			  var guigeRemark = new Array();//所有的规格描述
			  var sptName = $("input[name='guigems']");//所有的规格描述 控件
			  $(sptName).each(function(i,element){
				  guigeRemark[i]=$(this).attr("title")+"@"+$(this).val();
			  });
			  if(guigeRemark.length>0){
				  formData.guigeRemark = guigeRemark;
			  }else{
				  guigeRemark[0]="null";
				  formData.guigeRemark = guigeRemark;
			  }
			 
			  
			  //规格表格的所有信息
			  var spePrice = new Array();//所有的组合规格信息
			  var list = $(".sku_cell");
			  $(list).each(function(i,element){
				var str ="";
				if($(this).css("display")=="block"){
					var list = $(this).children("div");
					$(list).each(function(j,element2){
						if($(this).children("input").length==0){
							if(str==""){
								str=$(this).html();
							}else{
								 str = str+"@"+$(this).html();
							}
						}else{
							str = str+"@"+$(this).children().val();
						}
					});
				}
				spePrice[i]=str;
			  });
			  if(spePrice.length>0){
				  formData.spePrice = spePrice;
			  }else{
				  spePrice[0]="null";
				  formData.spePrice = spePrice;
			  }
			  console.log(formData)
			 
			  
			var url = "product/back/insertSelective.action";
			$.post(url, formData, function(info){
				layer.close(loadIndex);//加载层关闭  
				var ts =layer.open({
					  type: 1, 
					  skin: 'layui-layer-molv'//样式
					  ,title:'<i class="layui-icon" style="font-size: 20px; color: white;">&#xe60c;</i>  发布成功'//标题
					  ,area: ['300px', '150px']
					  ,content: '<p style="color:#01AAED;padding-top:5px;padding-left:20px;">宝贝发布成功，等待上架！</p><p style="color:#FF5722;padding-left:20px;">是否修改该产品信息？</p>' //这里content是一个普通的String
					,btn: ['继续修改', '发布新产品'] //可以无限个按钮
				  	,yes: function(index, layero){
				  		$("#addOrUpdate").val("update");//设置发布产品类型为修改
				  		$("#submitButton").html("确定修改");//更改按钮文本
				  		if(isUpload1=="1"){
		    				$("#uploadts1").html('<span class="layui-badge layui-bg-blue">未修改</span>');
		    			}
				  		if(isUpload2=="1"){
		    				$("#uploadts2").html('<span class="layui-badge layui-bg-blue">未修改</span>');
		    			}
				  		layer.close(ts);
					  }
					  ,btn2: function(index, layero){
						  location.href="product/back/releaseProduct.action";
					    return false
					  }
					  ,cancel: function(){ //点击右上角关闭按钮
						  location.href="product/back/releaseProduct.action";
					}
				});
			});
			  
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
		});
		
		layui.use('layedit', function(){
		  layedit = layui.layedit;
		  textareaIndex = layedit.build('pemark'); //建立编辑器
		});
		layui.use('layer', function(){ //独立版的layer无需执行这一句
		  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
		  
		  //触发事件
		  var active = {
		   offset: function(othis){
		      var type = othis.data('type')
		      ,text = othis.text();
		      
		      index = layer.open({
		        type: 1//样式
		        ,skin: 'layui-layer-molv'//样式
		        ,area: ['85%', '70%']
		        ,title:text//标题
		        ,id: 'layerDemo'+type //防止重复弹出
		        ,content: $("#uploadDiv")
		        ,shade: [0.8, '#393D49'] //显示遮罩
		        ,shadeClose:true//点击也能遮罩层关闭
		        ,anim:2//弹出动画
		      });
		    }
		  };
		  
		  $('#uploadButton a').on('click', function(){
		  	if($(this).attr("id")=="upload1"){
				$("#imgType").val(1);
		    }else if($(this).attr("id")=="upload2"){
				$("#imgType").val(2);
		    }
		  	
		  	//把之前的上传图片清除
		  	$("#proImg").html("");
		 	// 初始化上传图片插件
			$("#proImg").zyUpload({
				width            :   "100%",                 // 宽度
				height           :   "100%",                 // 宽度
				itemWidth        :   "120px",                 // 文件项的宽度
				itemHeight       :   "100px",                 // 文件项的高度
				url              :   "productImg/back/addProductImg.action?proId="+document.getElementById("proId").value+"&imgType="+document.getElementById("imgType").value,  // 上传文件的路径
				multiple         :   true,                    // 是否可以多个文件上传
				dragDrop         :   true,                    // 是否可以拖动上传文件
				del              :   true,                    // 是否可以删除文件
				finishDel        :   true,  				  // 是否在上传文件完成后删除预览
				/* 外部获得的回调接口 */
				onSelect: function(files, allFiles){                    // 选择文件的回调方法
					console.info("当前选择了以下文件：");
					console.info(files);
					console.info("之前没上传的文件：");
					console.info(allFiles);
				},
				onDelete: function(file, surplusFiles){                     // 删除一个文件的回调方法
					console.info("当前删除了此文件：");
					console.info(file);
					console.info("当前剩余的文件：");
					console.info(surplusFiles);
				},
				onSuccess: function(file){                    // 文件上传成功的回调方法
					console.info("此文件上传成功：");
					console.info(file);
				},
				onFailure: function(file){                    // 文件上传失败的回调方法
					console.info("此文件上传失败：");
					console.info(file);
				},
				onComplete: function(responseInfo){           // 上传完成的回调方法
					console.info("文件上传完成");
					console.info(responseInfo);
				}
			});
		  	
		  	
		    var othis = $(this), method = othis.data('method');
		    active[method] ? active[method].call(this, othis) : '';
		    
		  });
		  
		});
		
		//上传文件之前判断是否要清空之前的文件
		function isdrop(){
			if($("#addOrUpdate").val()=="update"){//如果发布完成后的修改
				//第一次修改删除原来图片		  		
		  		if(isDelete && $("#imgType").val()==1){
		  			isDelete=false;
		  			var url = "productImg/back/updateIsvaByProIdAndImgType.action";
					var data = {"proId":$("#proId").val(),"imgType":1}
					$.post(url, data, function(info){
						layer.msg('删除了原来的滚动图片');
					});
		  		}else if(isDelete && $("#imgType").val()==2){
		  			isDelete=false;
		  			var url = "productImg/back/updateIsvaByProIdAndImgType.action";
					var data = {"proId":$("#proId").val(),"imgType":2}
					$.post(url, data, function(info){
						layer.msg('删除了原来的详情图片');
					});
		  		}
		  	}
		}
		//上传文件成功的回调方法
		function uploadSuccess(){
			//显示已上传
    		if($("#imgType").val()==1){
    			if(isUpload1=="1"){
    				$("#uploadts1").html('<span class="layui-badge layui-bg-orange">已修改</span>');
    			}else{
    				$("#uploadts1").html('<span class="layui-badge layui-bg-orange">已上传</span>');
    			}
    			isUpload1="1";
    		}else if($("#imgType").val()==2){
    			if(isUpload2=="1"){
    				$("#uploadts2").html('<span class="layui-badge layui-bg-orange">已修改</span>');
    			}else{
    				$("#uploadts2").html('<span class="layui-badge layui-bg-orange">已上传</span>');
    			}
    			isUpload2="1";
    		}
    		layer.close(index);
		}
		
		//输入出厂价，计算其他几个
		function costing(obj){
			clearNoNum(obj);
			var proFactoryPrice = obj.value;
			if(proFactoryPrice!=""){
				proFactoryPrice = parseFloat(proFactoryPrice)
				$("#proPrice0").html(proFactoryPrice*100*1.2/100);
				$("#proPrice").html(proFactoryPrice*100*1.5/100);
				$("#proPrice1").html(proFactoryPrice*100*1.05/100);
			}else{
				$("#proPrice0").html("?");
				$("#proPrice").html("?");
				$("#proPrice1").html("?");
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
		   hideMenu();//隐藏树
		   //加载该类型的所有规格
		   var url = "proTypeSpecification/back/findAll.action";
		   var data={"proTypeId":treeNode.id};
		   $.post(url, data, function(info){
			   $(".sku_list").html("");
			   var flag = false;
			   for(type in info){
				   flag=true;
				   $(".sku_list").append('<span class="sku_item"><a data-id="'+type+'">'+type+'</a></span>');
			   }
			   if(!flag){
				   layer.msg('注意：该宝贝类型('+treeNode.name+')暂无规格');
			   }
			   sizes=info;
		   });
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
	</script>
</html>