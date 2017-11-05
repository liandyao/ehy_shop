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
<title>修改产品页面</title>
		<link rel="stylesheet" href="pages/back/product/css/sp.css">
		
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
			var isclickDiv2 = "0"; //是否点击了分类规格修改 0否  1是
			var isclickDiv3 = "0";//是否点击了滚动图片修改 0否  1是
			var isclickDiv4 = "0";//是否点击了详情图片修改 0否  1是
			var isclickDiv5 = "0";//是否点击了属性修改 0否  1是
			var uploadType =0;//是否上传了产品图片 1 滚动图片 2 详情图片
			var attrIsUpdate =0;//是否修改产品属性，0为进入编辑状态，1为修改
		</script>
		
		<!--上传文件  -->
		<link rel="stylesheet" href="res/css/zyUpload.css">
		<script src="res/js/zyFile.js"></script>
		<script src="res/js/zyUpload.js"></script>
		
		<script type="text/javascript" src="pages/back/product/js/sp.js"></script>
		<style type="text/css">
			#attrTable tbody tr td:first-child{
				text-align:right;
				color:#716b6b;
				width:25%;
			}
			#attrHelp{
				cursor: pointer;
				float:right;
			}
			#attrHelp:hover{
				color:#FF5722;
			}
			#attrTable input{
				height: 22px;
			}
		</style>
</head>
<body>
	<input type="hidden" id="proId" name="proId" value="${map.PRO_ID}">
	
	<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
	  <ul class="layui-tab-title">
	    <li class="layui-this">宝贝基本信息</li>
	    <li onclick="clickDiv2();">宝贝规格价格</li>
	    <li onclick="clickDiv5();">宝贝展示属性</li>
	    <li onclick="clickDiv3();">宝贝滚动图片</li>
	    <li onclick="clickDiv4();">宝贝详情图片</li>
	  </ul>
	  <div class="layui-tab-content">
	  	    <div class="layui-tab-item layui-show">
	  	    	<form class="layui-form layui-form-pane" action="">
	  	    		<div class="layui-form-item">
					    <label class="layui-form-label">宝贝类型</label>
					    <div class="layui-input-block">
					      <input id="typeId" type="hidden" name="proTypeId" value="${map.PRO_TYPE_ID}">
				  		  <input type="text" id="typeName" value="${map.PRO_TYPE_NAME}" onclick="showMenu(); return false;" required  lay-verify="required" placeholder="请选择产品类型" autocomplete="off" class="layui-input" readonly="readonly">
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
					      <input type="text" name="proCode" value="${map.PRO_CODE}" maxlength="50" required  lay-verify="required" placeholder="请输入产品编号" autocomplete="off" class="layui-input">
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">产品名称</label>
					    <div class="layui-input-block">
					      <input type="text" id="proName" name="proName" value="${map.PRO_NAME}" maxlength="50" required  lay-verify="required" placeholder="请输入产品名称" autocomplete="off" class="layui-input">
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">产品重量(g)</label>
					    <div class="layui-input-block">
					      <input type="text" name="proWeight" value="${map.PRO_WEIGHT}" maxlength="50" required  lay-verify="required" placeholder="请输入重量(以克为单位)" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">出厂价格</label>
					    <div class="layui-input-block">
					      <input type="text" name="proFactoryPrice" id="proFactoryPrice" value="${map.PRO_FACTORY_PRICE}" maxlength="10" required  lay-verify="required" placeholder="请输入出厂价格(最多精确到分)" autocomplete="off" class="layui-input" onkeyup="clearNoNum(this)">
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
					      <input type="text" name="proFujian" value="${map.PRO_FUJIAN}" maxlength="500" required  lay-verify="required" placeholder="请输入产品附件" autocomplete="off" class="layui-input">
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">保修政策</label>
					    <div class="layui-input-block">
					      <input type="text" name="proLaw" maxlength="500" value="${map.PRO_LAW}" required  lay-verify="required" placeholder="请输入产品保修政策" autocomplete="off" class="layui-input">
					    </div>
					</div>
					<div class="layui-form-item layui-form-text">
					    <label class="layui-form-label">产品描述</label>
					    <div class="layui-input-block">
					      <textarea id="pemark" name="proRemark" maxlength="700" style="display: none;">${map.PRO_REMARK}</textarea>
					    </div>
					</div>
					<div class="layui-form-item">
					    <div class="layui-input-block" style="margin-left: 0px;">
					      <button id="submitButton" class="layui-btn" lay-submit lay-filter="updateInfo">确定修改</button>
					    </div>
					</div>
	  	    	</form>
	  	    </div>
		    <div class="layui-tab-item">
		    	<div class="sku_btns">
					<a id="add_multi_sku" class="layui-btn layui-btn-small layui-btn-normal"><i class="layui-icon">&#xe615;</i>选择规格</a>
				</div>
				<fieldset class="layui-elem-field layui-field-title">
				    <legend>设置规格</legend>
				</fieldset>
				<div class="sku_guige">
					<!---下列存放动态生成的商品规格：颜色，尺码等-->
					<div class="sku_modellist">
					</div>
				</div>
				<fieldset class="layui-elem-field layui-field-title">
				    <legend>设置规格价格</legend>
				</fieldset>
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
					<div class="sku_add"><input type="text" placeholder="请输入产品规格类型" class="sku_input">
						<a id="sku_addbtn">新建</a>
					</div>
				</div>
				<hr />
				<button class="layui-btn add" onclick="updateSpName()" style="display: none;"><i class="layui-icon">&#xe609;</i>  保存</button>
			</div>
			<div class="layui-tab-item">
				<table class="layui-table" id="attrTable" style="margin: 0px;" lay-size="sm">
				  <thead>
				    <tr>
				      <th colspan="2">属性参数<i id="attrHelp" class="layui-icon">  &#xe60b;</i></th>
				    </tr> 
				  </thead>
				  <tbody>
				    
				  </tbody>
				</table>
				<button style="float: right;margin-top: 5px;" id="updateAttr" class="layui-btn layui-btn-small"><i class="layui-icon">&#xe642;</i>编辑</button>
			</div>
		    <div class="layui-tab-item">
		    	<table id="imgTableOne" class="layui-table">
		    		  <colgroup>
					    <col width="150">
					    <col width="300">
					  </colgroup>
					  <thead>
					    <tr>
					      <th>滚动图片</th>
					      <th>
							<button type="button" class="layui-btn layui-btn-small uploadImg" id="uploadImgOne">
							  <i class="layui-icon">&#xe67c;</i>新增滚动图片
							</button>
						  </th>
					    </tr> 
					  </thead>
					  <tbody>
					  </tbody>
		    	</table>
		    </div>
		    <div class="layui-tab-item">
		    	<table id="imgTableTwo" class="layui-table">
		    		  <colgroup>
					    <col width="150">
					    <col width="300">
					  </colgroup>
					  <thead>
					    <tr>
					      <th>详情图片</th>
					      <th>
							<button type="button" class="layui-btn layui-btn-small uploadImg" id="uploadImgTwo">
							  <i class="layui-icon">&#xe67c;</i>新增详情图片
							</button>
						  </th>
					    </tr> 
					  </thead>
					  <tbody>
					  </tbody>
		    	</table>
		    </div>
	  </div>
	</div>
	<!-- 树 -->
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
		<ul id="treeDemo" class="ztree" style="margin-top:0;"></ul>
	</div>
	<!-- 上传图片的div -->
    <div id="uploadDiv" style="display: none">
    	<div id="proImg" class="demo"></div>
    </div>
	<script>
		//出厂价格改动触发该方法
		var chagePriceValue = $("#proFactoryPrice-hp").val()-0.01;
		
		var form;//表单
		var index;//弹出层
		var layedit;//富文本编辑器
		var textareaIndex;//富文本编辑器的索引
		var proPriceData;
		//选项卡
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
		layui.use('form', function(){
		  form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			//加载所有商品品牌
			var url = "productBand/back/findAll.action";
			$.post(url, null, function(data){
				$(data).each(function(i,element){
					if(element.bandId=="${map.BAND_ID}"){
						$("#bandId").append('<option value="'+element.bandId+'" selected>'+element.name+'</option>');
					}else{
						$("#bandId").append('<option value="'+element.bandId+'">'+element.name+'</option>');
					}
					
					form.render('select');//重新渲染
				});
			});
			//加载该站点的所有运费模板
			var url = "expressTemplate/back/findByStId.action?stId=${map.ST_ID}";
			$.post(url, null, function(data){
				$(data).each(function(i,element){
					if(element.tempId=="${map.PRO_ATTR_01}"){
						$("#proAttr01").append('<option value="'+element.tempId+'" selected>'+element.tempName+'('+element.money+'元)'+'</option>');
					}else{
						$("#proAttr01").append('<option value="'+element.tempId+'">'+element.tempName+'('+element.money+'元)'+'</option>');
					}
					form.render('select');//重新渲染
				});
			});
			
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
				};
				//异步加载完成时运行，此方法将所有的节点打开
				function zTreeOnAsyncSuccess(event, treeId, msg) {
				    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
				    treeObj.expandAll(true);
				}
			   $(document).ready(function(){
				   treeObj=$.fn.zTree.init($("#treeDemo"), setting);
			   });
			
			//表单验证
			form.on('submit(updateInfo)', function(data){
			  console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
			  console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
			  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
			  
			  var formData = data.field;//表单的数据
			  formData.proRemark = layedit.getContent(textareaIndex);//把富文本编辑框的内容加入表单数据中
			  formData.proId = $("#proId").val();
			  console.log(formData)
			  
			  var ts =layer.open({
				  type: 1, 
				  skin: 'layui-layer-molv'//样式
				  ,title:'修改宝贝基本信息'//标题
				  ,area: ['300px', '150px']
				  ,content: '<p style="color:#01AAED;padding-top:5px;padding-left:20px;">温馨提示：正在修改宝贝信息</p><p style="color:#FF5722;padding-left:20px;">确认是否修改？</p>' //这里content是一个普通的String
				,btn: ['确定修改', '算了'] //可以无限个按钮
			  	,yes: function(index, layero){
			  		layer.close(ts);
			  		loadIndex = layer.load();//出现加载层
			  		
			  		var url = "product/back/updateInfo.action";
					$.post(url, formData, function(info){
						layer.close(loadIndex);//加载层关闭  
						if(info>0){
							layer.msg('修改信息成功！');
							chagePriceValue = $("#proFactoryPrice-hp").val()-0.01;
							parent.tableReload();//重载表格的方法
						}else{
							layer.msg('操作失败！');
						}
					});
				  }
			});
			
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
			
		});
		
		
		
		
		//富文本编辑器
		layui.use('layedit', function(){
		  layedit = layui.layedit;
		  textareaIndex = layedit.build('pemark'); //建立编辑器
		});
		
		//点击宝贝类型规格
		function clickDiv2(){
			loadIndex = layer.load();//出现加载层
			//加载该产品类型的所有规格
			$.ajax({ 
				type: "post", 
				url: "proTypeSpecification/back/findAll.action",
				data:{"proTypeId":$("#typeId").val()},
				cache:false, 
				async:false, 
				dataType:"json",
				success: function(info){ 
					 $(".sku_content .sku_list").html("");
					   var flag = false;
					   for(type in info){
						   $(".sku_content .sku_list").append('<span class="sku_item"><a data-id="'+type+'">'+type+'</a></span>');
					   }
					   sizes=info;
				}
			});
		   
			if(isclickDiv2=="0"){
				isclickDiv2="1";//设为已点击
				//加载该产品的所有规格
				$.ajax({ 
					type: "post", 
					url: "productSpecificationValue/back/findAllByProId.action",
					data:{"proId":$("#proId").val()},
					cache:false, 
					async:false, 
					dataType:"json", 
					success: function(info){ 
						$(".sku_guige").show();
						$(".sku_table").show();
						$(".add").show();
						$(".sku_tableHead").html('');
						$(".sku_tablecell").html("");
						var sps = info.valueMap;
						
						var arrs = [];
						for(sptName in sps){
							var spNames = sps[sptName];
							var val = new Array();
							for(i=0;i<spNames.length;i++){
								val[i]=spNames[i].split("@")[0];
							}
							arrs.push(sptName);
							new Skumodel(sptName, val, sptName);
						}
						createTablehead(arrs);
						//把之前选择的属性值全部点击
						$(".sku_models .sku_item a").each(function(i,element){
							$(this).click();
						});
						//给规格值的描述框赋值
						var remarkInput = $(".guigeInput");
						$(remarkInput).each(function(j,element){
							for(sptName in sps){
								var spNames = sps[sptName];
								for(i=0;i<spNames.length;i++){
									if($(this).attr("title").split("@")[1]==spNames[i].split("@")[0]){
										if(spNames[i].split("@")[1]!="null"){
											$(this).val(spNames[i].split("@")[1]);
										}
									}
								}
							}
						});
						//给表格中输入框赋值
						$(".sku_tablecell .sku_cell").each(function(i,element){
							var _this = this;
							var size = $(this).children('div').length;
							var pspGroupName="";
							for(j=0;j<size-3;j++){
								if(pspGroupName==""){
									pspGroupName = $(this).children('div').eq(j).text();
								}else{
									pspGroupName += "@"+$(this).children('div').eq(j).text();
								}
							}
							$(info.priceList).each(function(j,element2){
								var num=0;
								for(k=0;k<pspGroupName.split("@").length;k++){
									for(h=0;h<pspGroupName.split("@").length;h++){
										if(pspGroupName.split("@")[k]==element2.pspGroupName.split("@")[h]){
											num++;
										}
									}
								}
								if(num==element2.pspGroupName.split("@").length){
									$(_this).children('div:last-child').prev().prev().children().val(element2.pspFactoryPrice);
									$(_this).children('div:last-child').prev().children().val(element2.pspPrice);
									$(_this).children('div:last-child').children().val(element2.pspName);
								}
							});
						});
					} 
				});
			}
			//把原本选中的规格类型点击
			$(".sku_modellist_title").each(function(i,element){
				 var _this = this;
				 $(".sku_content .sku_list a").each(function(j,element2){
					 if($(this).text()==$(_this).text()){
						 $(this).click();
					 }
				 });
			 });
			layer.close(loadIndex);//加载层关闭 
		}
		
		//点击保存按钮修改规格信息
		function updateSpName(){
			loadIndex = layer.load();//出现加载层
			 var formData = {};
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
			  
			  formData.proId=$("#proId").val();
			  formData.proName=$("#proName").val();
			  
			  var url = "productSpecificationValue/back/updateValueAndPrice.action";
			  $.post(url, formData, function(info){
				  layer.close(loadIndex);//加载层关闭  
				  if(info==1){
					  layer.msg('修改成功');
				  }else{
					  layer.msg('操作失败！');
				  }
			  });
		};
		
		//点击宝贝展示属性
		function clickDiv5(){
			if(isclickDiv5=="0"){
				loadIndex = layer.load();//出现加载层
				isclickDiv5="1";//设为已点击
				var url = "productAttribute/back/findAllByProId.action";
				var data = {"proId":$("#proId").val()}
				$.post(url, data, function(info){
					$(info).each(function(i,element){
						$("#attrTable tbody").append('<tr><td>'+element.attrName+'</td><td>'+element.attrValue+'</td></tr>');
					});
					layer.close(loadIndex);//加载层关闭 
				});
			}
		}
		//点击编辑/保存按钮
		$("#updateAttr").click(function(){
			if(attrIsUpdate=="0"){
				attrIsUpdate="1";
				$($("#attrTable tbody tr td")).each(function(i,element){
					$(this).html('<input type="text" value="'+$(this).text()+'"class="layui-input"/>')
				});
				$("#attrTable thead tr").append('<th><button id="addAtrr" class="layui-btn layui-btn-warm layui-btn-mini "><i class="layui-icon"></i></button></th>');
				$("#attrTable tbody tr").append('<td width="15"><button class="layui-btn layui-btn-danger layui-btn-mini dropAtrr"><i class="layui-icon"></i></button></td>');
				$(this).html('<i class="layui-icon">&#xe609;</i>保存');
			}else if(attrIsUpdate=="1"){
				var input = $("#attrTable tbody input");
				var flag = true;
				$(input).each(function(i,element){
					$(this).val($(this).val().replace(/\s/g,''));
					if($(this).val()==""){
						flag =false;
					}
				});
				if(flag==true){//如果所有的输入框都输了值
					var ajaxData = {};
					//获取输入的全部属性信息
					var attrList = new Array();
					$($("#attrTable tbody tr")).each(function(i,element){
						var attrName = $(this).children().eq(0).children().val();
						var attrValue = $(this).children().eq(1).children().val();
						attrList[i]=attrName+"@"+attrValue;
					});
					if(attrList.length==0){
						layer.msg('暂无可保存的属性');
						return ;
					}
					loadIndex = layer.load();//出现加载层
					ajaxData.attrList=attrList;
					ajaxData.proId = $("#proId").val();
					ajaxData.proName = $("#proName").val();
					//保存属性
					var url = "productAttribute/back/addList.action";
					$.post(url, ajaxData, function(info){
						attrIsUpdate="0";
						$($("#attrTable tbody tr td")).each(function(i,element){
							var inputValue=$(this).children().val();
							$(this).html(''+inputValue+'');
						});
						$("#attrTable thead tr th:last-child").remove();
						$("#attrTable tbody tr td:last-child").remove();
						$(this).html('<i class="layui-icon">&#xe642;</i>编辑');
						layer.close(loadIndex);//加载层关闭 
						layer.msg('修改成功');
					});
				}else{
					layer.msg('请认真填写(不能留空)');
				}
			}else{
				alert("属性修改：系统出错，请关闭该弹窗，重新编辑")
			}
		});
		//点击增加一行属性
		$(document).on('click',"#addAtrr",function(){
			$("#attrTable tbody").append('<tr><td><input type="text" class="layui-input"/></td><td><input type="text" class="layui-input"/></td><td><button class="layui-btn layui-btn-danger layui-btn-mini dropAtrr"><i class="layui-icon"></i></button></td></tr>');
		});
		//点击删除一行属性
		$(document).on('click',".dropAtrr",function(){
			$(this).parent().parent().remove();
		});
		
		//点击宝贝展示属性的解释
		$("#attrHelp").click(function(){
			layer.open({
		        time: 20000, //20s后自动关闭
		        title:'宝贝展示属性',
		        skin:'layui-layer-molv',
		        btnAlign: 'c',
		        shade: 0,
		        anim: 2,
		        content:'产品展示属性，即为不可选的规格，仅供顾客浏览的信息；例：<br />--适用对象:青年<br />--风格:通勤<br />--图案:纯色<br />--靴款品名:马丁靴',
		        btn: ['知道了']
		      });
		});
		
		//点击宝贝滚动图片
		function clickDiv3(){
			if(isclickDiv3=="0"){
				loadIndex = layer.load();//出现加载层
				isclickDiv3="1";//设为已点击
				
				findImgOne();//加载图片
				layer.close(loadIndex);//加载层关闭  
			}
		}
		//点击宝贝详情图片
		function clickDiv4(){
			if(isclickDiv4=="0"){
				loadIndex = layer.load();//出现加载层
				isclickDiv4="1";//设为已点击
				
				findImgTwo();//加载图片
				layer.close(loadIndex);//加载层关闭  
			}
		}
		
		//向上移动
		function topMove(obj){
			loadIndex = layer.load();//出现加载层
			var tr = obj.parentNode.parentNode;//当前行
			var topTr = tr.previousSibling;//当前行的上一行
			
			var trImgId = tr.children[0].children[0].value;//当前行的图片ID
			var trImgURL = tr.children[0].children[1].src;//当前行的图片路径
			var topTrId = topTr.children[0].children[0].value;//上一行的图片ID
			var topTrImgURL = topTr.children[0].children[1].src;//上一行图片路径
			
			//移动位置
			tr.children[0].children[0].value=topTrId;
			topTr.children[0].children[0].value=trImgId;
			tr.children[0].children[1].src=topTrImgURL;
			topTr.children[0].children[1].src=trImgURL;
			
			var imgId = [trImgId,topTrId];
			var sort = [tr.rowIndex-1,tr.rowIndex];
			var url = "productImg/back/updateSortByImgId.action";
			var data = {"imgId":imgId,"sort":sort}
			$.post(url, data, function(info){
				if(info!=1){
					//如果失败则移动到原来的位置
					tr.children[0].children[0].value=trImgId;
					topTr.children[0].children[0].value=topTrId;
					tr.children[0].children[1].src=trImgURL;
					topTr.children[0].children[1].src=topTrImgURL;
					layer.msg('操作失败！');
				}
				layer.close(loadIndex);//加载层关闭  
			});
		}
		//向下移动
		function downMove(obj){
			loadIndex = layer.load();//出现加载层
			var tr = obj.parentNode.parentNode;//当前行
			var downTr = tr.nextSibling;//当前行的上一行
			var trImgId = tr.children[0].children[0].value;//当前行的图片ID
			var trImgURL = tr.children[0].children[1].src;//当前行的图片路径
			var downTrId = downTr.children[0].children[0].value;//上一行的图片ID
			var downTrImgURL = downTr.children[0].children[1].src;//上一行图片路径
			
			//移动位置
			tr.children[0].children[0].value=downTrId;
			downTr.children[0].children[0].value=trImgId;
			tr.children[0].children[1].src=downTrImgURL;
			downTr.children[0].children[1].src=trImgURL;
			
			var imgId = [trImgId,downTrId];
			var sort = [tr.rowIndex+1,tr.rowIndex];
			var url = "productImg/back/updateSortByImgId.action";
			var data = {"imgId":imgId,"sort":sort}
			$.post(url, data, function(info){
				if(info!=1){
					layer.msg('操作失败！');
					//如果失败则移动到原来的位置
					tr.children[0].children[0].value=trImgId;
					downTr.children[0].children[0].value=downTrId;
					tr.children[0].children[1].src=trImgURL;
					downTr.children[0].children[1].src=downTrImgURL;
				}
				layer.close(loadIndex);//加载层关闭  
			});
			
		}
		//删除图片
		function deleteImg(imgId,type){
			var ts =layer.open({
				  type: 1, 
				  skin: 'layui-layer-molv'//样式
				  ,title:'删除宝贝图片'//标题
				  ,area: ['300px', '150px']
				  ,content: '<p style="color:#01AAED;padding-top:5px;padding-left:20px;">温馨提示：正在删除宝贝图片</p><p style="color:#FF5722;padding-left:20px;">确认是否删除？</p>' //这里content是一个普通的String
				,btn: ['确定删除', '算了'] //可以无限个按钮
			  	,yes: function(index, layero){
			  		layer.close(ts);
			  		loadIndex = layer.load();//出现加载层
			  		//删除图片
			  		var url = "productImg/back/updateIsvaByImgId.action";
			  		var data = {"imgId":imgId}
					$.post(url, data, function(info){
						layer.close(loadIndex);//加载层关闭  
						if(info>0){
							layer.msg('删除成功！');
							if(type==1){
								findImgOne();//重新加载滚动图片
							}else if(type==2){
								findImgTwo();//重新加载详情图片
							}
						}else{
							layer.msg('操作失败！');
						}
					});
				  }
			});
		}
		//图片上传
		$('.uploadImg').on('click', function(){
			var id = $(this).attr("id");
			if(id=="uploadImgOne"){
				uploadType=1;
			}else if(id="uploadImgTwo"){
				uploadType=2;
			}
			
			index = layer.open({
		        type:1//样式
		        ,skin: 'layui-layer-molv'//样式
		        ,area: ['85%', '70%']
		        ,title:'新增图片'//标题
		        ,content: $("#uploadDiv")
		        ,shade: [0.8, '#393D49'] //显示遮罩
		        ,shadeClose:true//点击也能遮罩层关闭
		        ,anim:2//弹出动画
		      });
			
			//把之前的上传图片清除
		  	$("#proImg").html("");
		 	// 初始化上传图片插件
			$("#proImg").zyUpload({
				width            :   "100%",                 // 宽度
				height           :   "100%",                 // 宽度
				itemWidth        :   "120px",                 // 文件项的宽度
				itemHeight       :   "100px",                 // 文件项的高度
				url              :   "productImg/back/addProductImg.action?proId="+$("#proId").val()+"&imgType="+uploadType,  // 上传文件的路径
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
			
		});
		//上传文件成功的回调方法
		function uploadSuccess(){
			if(uploadType==1){
				findImgOne();
			}else if(uploadType==2){
				findImgTwo();
			}
			layer.close(index);//加载层关闭  
		}
		
		//加载滚动图片
		function findImgOne(){
			var url = "productImg/back/findImgByProIdAndImgType.action";
			var data = {"proId":$("#proId").val(),"imgType":1}
			$.post(url, data, function(imgData){
				$("#imgTableOne tbody").html("");
				if(imgData.length==0){
					$("#imgTableOne tbody").html('<i class="layui-icon" style="font-size: 15px; color: #1E9FFF;line-height:5px;">  &#xe69c;  宝贝暂无滚动图片,请点击新增滚动图片</i>');
					return;
				}
				for(i=0;i<imgData.length;i++){
					if(imgData.length==1){
						$("#imgTableOne tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",1)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"</td>"
								+"</tr>");
					}else if(i==0){
						$("#imgTableOne tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",1)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"<button type='button' onclick='downMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe61a;</i>下移</button>"
								+"</td>"
								+"</tr>");
					}else if(i==imgData.length-1){
						$("#imgTableOne tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",1)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"<button type='button' onclick='topMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe619;</i>上移</button>"
								+"</td>"
								+"</tr>");
					}else{
						$("#imgTableOne tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",1)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"<button type='button' onclick='topMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe619;</i>上移</button>"
								+"<button type='button' onclick='downMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe61a;</i>下移</button>"
								+"</td>"
								+"</tr>");
					}
				}
			});
		}
		
		//加载详情图片
		function findImgTwo(){
			var url = "productImg/back/findImgByProIdAndImgType.action";
			var data = {"proId":$("#proId").val(),"imgType":2}
			$.post(url, data, function(imgData){
				$("#imgTableTwo tbody").html("");
				if(imgData.length==0){
					$("#imgTableTwo tbody").html('<i class="layui-icon" style="font-size: 15px; color: #1E9FFF;line-height:5px;">  &#xe69c;  宝贝暂无详情图片,请点击新增详情图片</i>');
					return;
				}
				for(i=0;i<imgData.length;i++){
					if(imgData.length==1){
						$("#imgTableTwo tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",2)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"</td>"
								+"</tr>");
					}else if(i==0){
						$("#imgTableTwo tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",2)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"<button type='button' onclick='downMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe61a;</i>下移</button>"
								+"</td>"
								+"</tr>");
					}else if(i==imgData.length-1){
						$("#imgTableTwo tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",2)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"<button type='button' onclick='topMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe619;</i>上移</button>"
								+"</td>"
								+"</tr>");
					}else{
						$("#imgTableTwo tbody").append("<tr><td>"
								+"<input id='imgId' type='hidden' name='imgId' value='"+imgData[i].imgId+"'>"
								+"<img alt='图片' src='"+imgData[i].imgPath+"'></td>"
								+"<td>"
								+"<button type='button' onclick='deleteImg(\""+imgData[i].imgId+"\",2)' class='layui-btn layui-btn-danger layui-btn-small' id=''><i class='layui-icon'>&#xe640;</i>删除</button>"
								+"<button type='button' onclick='topMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe619;</i>上移</button>"
								+"<button type='button' onclick='downMove(this)' class='layui-btn layui-btn-normal layui-btn-small' id=''><i class='layui-icon'>&#xe61a;</i>下移</button>"
								+"</td>"
								+"</tr>");
					}
				}
			});
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
	    //此方法为上传文件JS中需要的方法 不可删除
	    function isdrop(){}
	</script>   
</body>
</html>