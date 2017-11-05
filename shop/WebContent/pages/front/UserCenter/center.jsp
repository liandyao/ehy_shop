<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/res/css/address.css"><!-- 引用外部样式表  -->
<script type="text/javascript" src="${pageContext.request.contextPath }/res/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/res/js/address2.js"></script>



<link href="${pageContext.request.contextPath }/res/css/common.css" rel="stylesheet" type="text/css">
<style type="text/css">
#share{
	width: 500px;
	height: 350px;
	background-color: #fff;
	 position:fixed;
	border: 1px solid #d3d3d0;
	top:200px;
	left:500px;
	z-index:10001; 
	box-shadow:2px 2px 2px #C4C4C4 inset;
	
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
 
 #close{
	 position:fixed;
	margin: 0 auto;
	top:70px;
	left:440px;
	z-index: 10001;
	cursor: pointer;/*把鼠标状态变成手 */
}

tr input{
	margin-top: 10px;
padding: 6px 12px;
border-radius: 4px;
width: 100%;
height: 24px;
text-align: center;
}

.dizhi{
margin: 0 0 0 10px;
font-size: 12px;
background: #ffaa45;
/* padding: 2px; */
color: #fff;
font-weight: 400;
}



</style>


</head>
<body >
<div style="padding: 10px;">
<input value="收货地址" id="adress" name="adress" type="button"  class="btn btn-primary">

<div style="width: 500px;height:auto;  font-size: 15px;"  id="div">
	<div style="width:auto; height: auto; margin: 10px; line-height: 22px; color:#707070" >
		<input type="hidden" name="addId" id="addId">
		<div>
			<h3><span id="xinxi"> </span> </h3>
		</div>
		<div>
			<div>
				<span id="addEmp" name="addEmp"></span>
			</div>
			<div>
				<span></span>
			</div>
			<div>
				<span id="addAddress" name="addAddress"></span>
			</div>
			
			<div>
				<span id="addPhone" name="addPhone"></span>
			</div>
			<div style="float: right; margin-top:5px;"></div>
		</div>
	</div>
</div>


<div id="hide_div"></div>
	<div id="shareDiv"  style="display: none;">
	<div style="width: 65px;height: 0%;float: left;line-height: 620px;" id="close">
			<!-- 关闭按钮  start -->
			<img src="${pageContext.request.contextPath }/res/images/close.png" style="width: 65px;height: 52px;"/>
			<!-- 关闭按钮  start -->
	</div>
	<!-- 用户中心分享页面弹出层  start -->
		<div id="share"  align="center" >
			<form style="margin-top: 30px;" id="memberForm" method="post">
				<input type="hidden" name="addIid"  id="addIid">
				<table>
					<tr>
						<td><input type="text" id="addEmps" name="addEmp" class="form-control" size="40" placeholder="收货人"></td>
					</tr>
					
		 <div class="box" style="background-color:#fff;position: relative;">
			<div class='address' id='address' onclick='onOff()' >
				送至
				<span class='address-item' id="address-item">请选择</span>
				<span class='caret'></span>
			</div>
			<ul id='options' class='menu'>
				<li>
					<p class='title' >
						<span id='titleP' class='txt active' name="addProvince"></span>
						<span id='titleC' class='txt'   name="addCity" style='display: none;'></span>
						<span id='titleD' class='txt' name="addCounty" style='display: none;'></span>
					</p>
					<div class='express' style="background-color: #fff;">
						<div id='provinces' class='cont' style='display:block;'>
						</div>
						<div id='cities' class='cont'>
						</div>
						<div id='district' class='cont'></div>
					</div>
				</li>
			</ul>
		 </div>
	
	
					<tr>
						<td><input type="text" id="addAddresss" name="addAddress"  class="form-control" placeholder="详细地址"></td>
					</tr>
					<tr>
						<td><input type="text" id="addPhones"  name="addPhone"  class="form-control" placeholder="手机号码"></td>
					</tr>
					<tr>
						<td><input type="text" id="addPhone2"  name="addPhone2"  class="form-control" placeholder="备用号码"></td>
					</tr>				
				</table>
					<input type="button" value="提交" class="btn btn-primary" id="button"  onclick="commit()" style="margin: 40px;">
			</form>	
		</div>
		<!-- 用户中心分享页面弹出层   end -->
		
		
		<div id="shareDiv"  style="display: none;">
	<div style="width: 65px;height: 0%;float: left;line-height: 620px;" id="close">
			<!-- 关闭按钮  start -->
			<img src="${pageContext.request.contextPath }/res/images/close.png" style="width: 65px;height: 52px;"/>
			<!-- 关闭按钮  start -->
	</div>
	<!-- 用户中心分享页面弹出层  start -->
		<div id="share"  align="center" >
			<form style="margin-top: 30px;" id="memberForm" method="post">
				<input type="hidden" name="addIid"  id="addIid">
				<table>
					<tr>
						<td><input type="text" id="addEmps" name="addEmp" class="form-control" size="40" placeholder="收货人"></td>
					</tr>
					
		 <div class="box" style="background-color:#fff;position: relative;">
			<div class='address' id='address' onclick='onOff()' >
				送至
				<span class='address-item' id="address-item">请选择</span>
				<span class='caret'></span>
			</div>
			<ul id='options' class='menu'>
				<li>
					<p class='title' >
						<span id='titleP' class='txt active' name="addProvince"></span>
						<span id='titleC' class='txt'   name="addCity" style='display: none;'></span>
						<span id='titleD' class='txt' name="addCounty" style='display: none;'></span>
					</p>
					<div class='express' style="background-color: #fff;">
						<div id='provinces' class='cont' style='display:block;'>
						</div>
						<div id='cities' class='cont'>
						</div>
						<div id='district' class='cont'></div>
					</div>
				</li>
			</ul>
		 </div>
	
	
					<tr>
						<td><input type="text" id="addAddresss" name="addAddress"  class="form-control" placeholder="详细地址"></td>
					</tr>
					<tr>
						<td><input type="text" id="addPhones"  name="addPhone"  class="form-control" placeholder="手机号码"></td>
					</tr>
					<tr>
						<td><input type="text" id="addPhone2"  name="addPhone2"  class="form-control" placeholder="备用号码"></td>
					</tr>				
				</table>
					<input type="button" value="提交" class="btn btn-primary"  onclick="commits()" style="margin: 40px;">
			</form>	
		</div>
		<!-- 用户中心分享页面弹出层   end -->
	</div>
	</div>
	</div>
</body>
<script type="text/javascript">
	
/*刷新页面  */
function refresh(){
	parent.location.reload();
}

	$('#adress').click(function(){
		$("#shareDiv").css("display",'block');
		$("#hide_div").css("display",'block');

		$("#address-item").html("");
		$("#addEmps").val("");
		$("#addAddresss").val("");
		$("#addPhones").val("");
		$("#addPhone2").val("");
	})
	
	$("#close").click(function(){
		$("#shareDiv").css("display",'none');
		$("#hide_div").css("display",'none');
	})
	function commit(){
		var  titleP=$("#titleP").text();
		var  titleC=$("#titleC").text();
		var titleD =$("#titleD").text();
		var he=titleP+","+titleC+","+titleD;
		var url ="${pageContext.request.contextPath }/address/front/addAddress.action?he="+he;
		var data = $("#memberForm").serialize();
		$.post(url , data, function(mes){
			if(mes.state==1){
				setTimeout("refresh()", 500);
			}
		})
	}
	
	function commits(){
		var  titleP=$("#titleP").text();
		var  titleC=$("#titleC").text();
		var titleD =$("#titleD").text();
		var he=titleP+","+titleC+","+titleD;
		var url ="${pageContext.request.contextPath }/address/front/updateAddress.action?he="+he;
		var data = $("#memberForm").serialize();
		$.post(url , data, function(mes){
			if(mes.state==1){
				setTimeout("refresh()", 500);
			}
		})
	}
	
	function show(id){
		$("#address-item").html("");
		
		$("#shareDiv").css("display",'block');
		$("#hide_div").css("display",'block');
		var url = "${pageContext.request.contextPath }/address/front/selectByAddId.action";
		var data ={"addId":id};
		$.post(url,data,function(address){
			$("#addIid").val(id);
			$("#address-item").append(address[0].addProvince,address[0].addCity,address[0].addCounty);
			$("#addEmps").val(address[0].addEmp);
			$("#addAddresss").val(address[0].addAddress);
			$("#addPhones").val(address[0].addPhone);
			$("#addPhone2").val(address[0].addPhone2);
		});
	}
	
	function deletes(id){
		var url = "${pageContext.request.contextPath }/address/front/deleteByPrimaryKey.action";
		var data ={"addId":id};
		$.post(url,data,function(mes){
			if(mes.state==1){
				setTimeout("refresh()", 0);
			}
		});
	}
	
	function defaults(id){
		var url = "${pageContext.request.contextPath }/address/front/updateSortById.action";
		var data ={"addId":id};
		$.post(url,data,function(mes){
			if(mes.state==1){
				setTimeout("refresh()", 0);
			}
		});
	}
	
	
	$(function(){
		
		var url = "${pageContext.request.contextPath }/address/front/selectByMbId.action";
		$.post(url,null,function(member){
			/* var yi=""; */
			$.each(member,function(i,item){
				if(item.sort==1){
					var	yi="默认地址";
				}else{
					var	yi="";
				$("#dizhi").css('background','#ffaa45');

				$("#moren").css('display','none');
				}
				$("#addEmp").append('<div style="width: 500px;height:auto; border: 2px solid #C2C2C2; font-size: 15px; margin-top:10px;"  id="div">'+
								'<div style="width:auto; height: auto; margin: 10px; line-height: 22px; color:#707070" >'+
								'<input type="hidden" name="addId" id="addId" value="'+item.addId+'">'+
								'<div><h3><span id="xinxi" value="">'+item.addEmp+'-'+item.addProvince+'</span>  <span class="dizhi"  id="dizhi" style="background:#fff;">'+yi+'</span></h3></div>'+
								'<div>'+
									'<div>'+
										'<span id="addEmp" name="addEmp" value="">收货人：'+item.addEmp+'</span>'+
									'</div>'+
									'<div>'+
										'<span >所在地区：'+item.addProvince+'-'+item.addCity+'-'+item.addCounty+'</span>'+
									'</div>'+
									'<div>'+
										'<span id="addAddress" name="addAddress" value="">地区：'+item.addAddress+'</span>'+
									'</div>'+
									'<div>'+
										'<span id="addPhone" name="addPhone" value="">手机号：'+item.addPhone+'</span>'+
									'</div>'+
								'</div>'+
								'<div style="float: right;margin-top:-5px; ">'+
									'<a onclick="defaults(&apos;'+item.addId+'&apos;)" id="moren">设为默认</a>'+
									'&nbsp;&nbsp;&nbsp;&nbsp;'+
									'<a id="update"  onclick="show(&apos;'+item.addId+'&apos;);">编辑</a>'+
									'&nbsp;&nbsp;&nbsp;&nbsp;'+
									'<a id="deletes"  onclick="deletes(&apos;'+item.addId+'&apos;);">删除</a>'+
								'</div>'+
								'</div>'
				);
			})
				
		});
	})
	
</script>
</html>