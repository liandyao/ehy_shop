<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>会员管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
<style type="text/css">
#updateImg{
	display: none;
}
</style>
</head>
<body>
	<form id="update">
		<input type="file" name="file" class="layui-btn" id="updateImg" onchange="uploadFile(this)" /> 
		<input type="hidden" id="memberId" name="mbId" />
	</form>
	<div style="margin: 5px;">
		<div class="demoTable">
			<div class="layui-form" >
				会员姓名：
				<div class="layui-input-inline">
					<input class="layui-input" name="mbName" id="mbName"
						autocomplete="off" >
				</div>
				会员电话：
				<div class="layui-inline">
					<input class="layui-input" name="mbPhone" id="mbPhone"
						autocomplete="off">
				</div>
				会员等级：
				<div  class="layui-input-inline" style="width: 104px;">
					<select id="selectMemberLevel" name="levelId" lay-verify="required" lay-search=""  >
						

					</select>
				</div>
				是否缴纳保证金：
				<div class="layui-input-inline" style="width: 86px;">
					<select id="mbIsbzj" name="mbIsbzj" lay-filter="aihao" >
						<option value="">请选择</option>
						<option value="1" >已缴纳</option>
						<option value="0" >未缴纳</option>

					</select>
				</div>
				<button class="layui-btn" data-type="reload">搜索</button>

			</div>
		</div>
		<table class="layui-table"
			lay-data="{ height:400,size:'sm', url:'<%=basePath%>member/back/findAll.action',method:'post',id:'testReload', page: true, limit: 10}"
			lay-filter="demo" >
			<thead>
				<tr>
					
					<th lay-data="{field:'MB_ID',hidden}" rowspan="2">会员ID</th>
					<th lay-data="{field:'INVITATION_CODE', width:120, align: 'center',templet:'#invitationCode'}" rowspan="2">邀请码</th>
					<th lay-data="{field:'MB_LOGIN', width:120, align: 'center'}" rowspan="2">登录账号</th>
					<th lay-data="{field:'MB_NAME', width:120, align: 'center'}" rowspan="2">会员姓名</th>
					<th lay-data="{field:'MB_SEX', width:120, align: 'center'}" rowspan="2">会员性别</th>
					<th lay-data="{field:'LEVEL_NAME', width:120, align: 'center'}" rowspan="2">会员等级</th>
					<th lay-data="{field:'MB_PHONE', width:120, align: 'center'}" rowspan="2">会员电话</th>
					<th lay-data="{field:'MB_ISBZJ', width:120, align: 'center',templet: '#sexTpl'}" rowspan="2">是否缴纳保证金</th>
					<th
						lay-data="{fixed: 'right', width: 350, align: 'center', toolbar: '#barDemo',templet:'#button'}"
						rowspan="2">操作</th>
					
				</tr>
				<!--  <tr>
      <th lay-data="{field:'province', width:120}">省</th>
      <th lay-data="{field:'city', width:120}">市</th>
      <th lay-data="{field:'zone', width:200}">区</th>
    </tr>  -->
			</thead>
		</table>
	</div>
	<script type="text/html" id="barDemo">
 		<a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
 		<a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
 		<a class="layui-btn layui-btn-mini" lay-event="file"><i class="layui-icon">&#xe67c;</i>修改头像</a>
		{{#  if(d.INVITATION_CODE !==""){ }}
		
		{{# }else{ }}
			<a class="layui-btn layui-btn-mini" lay-event="addInvitationCode" >生成邀请码</a>
		{{# } }}
 		<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
	</script>



	<script>
	
	/* layui.use('form', function(){
		  
		  
		  //各种基于事件的操作，下面会有进一步介绍
	}); */
	
		var member_Id ;
		var table ;
		layui.use('table', function() {
			table = layui.table;
			
			
			//监听工具条
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				
				if (obj.event === 'detail') {
					
						
					
					var invitationCode;
					if(data.INVITATION_CODE==null || data.INVITATION_CODE==""){
						
						invitationCode="无";
					}else{
						invitationCode=data.INVITATION_CODE;
					}
					var station ;
					if(data.MB_STATION==null || data.MB_STATION==""){
						
						station="无";
					}else{
						station=data.MB_STATION;
					}
					var MB_LOGIN ;
					if(data.MB_LOGIN==null || data.MB_LOGIN==""){
						
						MB_LOGIN="无";
					}else{
						MB_LOGIN=data.MB_LOGIN;
					}
					var MB_ADDR ;
					if(data.MB_ADDR==null || data.MB_ADDR==""){
						
						MB_ADDR="无";
					}else{
						MB_ADDR=data.MB_ADDR;
					}
					var MB_BIRTHDAY ;
					if(data.MB_BIRTHDAY==null || data.INVITATION_CODE==""){
						
						MB_BIRTHDAY="无";
					}else{
						MB_BIRTHDAY=data.MB_BIRTHDAY;
					}
					var MB_QQ ;
					if(data.MB_QQ==null || data.MB_QQ==""){
						
						MB_QQ="无";
					}else{
						MB_QQ=data.MB_QQ;
					}
					var station ;
					if(data.MB_CODE==null || data.MB_CODE==""){
						
						MB_CODE="无";
					}else{
						MB_CODE=data.MB_CODE;
					}
					var MB_SEX	 ;
					if(data.MB_SEX	==null || data.MB_SEX	==""){
						
						MB_SEX	="无";
					}else{
						MB_SEX	=data.MB_SEX	;
					}
					var MB_EMAIL ;
					if(data.MB_EMAIL==null || data.MB_EMAIL==""){
						
						MB_EMAIL="无";
					}else{
						MB_EMAIL=data.MB_EMAIL;
					}
					var MB_CARDID ;
					if(data.MB_CARDID==null || data.MB_CARDID==""){
						
						MB_CARDID="无";
					}else{
						MB_CARDID=data.MB_CARDID;
					}
					 var MB_WEIXIN ;
					if(data.MB_WEIXIN==null || data.MB_WEIXIN==""){
						
						MB_WEIXIN="无";
					}else{
						MB_WEIXIN=data.MB_WEIXIN;
					}
					
					var MB_NAME ;
					if(data.MB_NAME==null || data.MB_NAME==""){
						
						MB_NAME="无";
					}else{
						MB_NAME=data.MB_NAME;
					}
					
					var MB_BALANCE ;
					if(data.MB_BALANCE==null || data.MB_BALANCE==""){
						
						MB_BALANCE="无";
					}else{
						MB_BALANCE=data.MB_BALANCE;
					}
					
					var MB_JIFEN ;
					if(data.MB_JIFEN==null || data.MB_JIFEN==""){
						
						MB_JIFEN="无";
					}else{
						MB_JIFEN=data.MB_JIFEN;
					}
					
					
					var LEVEL_NAME ;
					if(data.LEVEL_NAME==null || data.LEVEL_NAME==""){
						
						LEVEL_NAME="无";
					}else{
						LEVEL_NAME=data.LEVEL_NAME;
					}
					
					
					var MB_PHONE ;
					if(data.MB_PHONE==null || data.MB_PHONE==""){
						
						MB_PHONE="无";
					}else{
						MB_PHONE=data.MB_PHONE;
					}
					
					
					
					<%-- layer.msg('会员头像：<img src="<%=basePath%>'+data.MB_REMARK+'" width="50px"><br/>登录账号：'+data.MB_LOGIN);
					 --%>
					 var payTheGold ;
					 if(data.MB_ISBZJ==0){
						 var payTheGold='<font color="red">'+"未缴纳"+'</font>';
					 }else{ 
						 var payTheGold='<font color="green">'+"已缴纳"+'</font>';
					 }
					layer.msg('<table ><tr>'+
					'<td width="120px">会员头像：</td>'+
					'<td><img src="'+data.MB_REMARK+'" width="20px" ></td></tr>'+
					'<tr>'+
					'<td>登录账号：</td>'+
					'<td>'+MB_LOGIN+'</td></tr>'+
					'<tr>'+
					'<td>微信号：</td>'+
					'<td>'+MB_WEIXIN+'</td></tr>'+
					'<tr>'+
					'<td>QQ：</td>'+
					'<td>'+MB_QQ+'</td></tr>'+
					'<tr>'+
					'<td>邮箱：</td>'+
					'<td>'+MB_EMAIL+'</td></tr>'+
					'<tr>'+
					'<td>会员编码：</td>'+
					'<td>'+MB_CODE+'</td></tr>'+
					'<tr>'+
					'<td>会员姓名：</td>'+
					'<td>'+MB_NAME+'</td></tr>'+
					'<tr>'+
					'<td>会员性别：</td>'+
					'<td>'+MB_SEX+'</td></tr>'+
					'<tr>'+
					'<td>会员生日：</td>'+
					'<td>'+MB_BIRTHDAY+'</td></tr>'+
					'<tr>'+
					'<td>身份证号：</td>'+
					'<td>'+MB_CARDID+'</td></tr>'+
					'<tr>'+
					'<td>余额：</td>'+
					'<td>'+MB_BALANCE+'</td></tr>'+
					'<tr>'+
					'<td>积分：</td>'+
					'<td>'+MB_JIFEN+'</td></tr>'+
					'<tr>'+
					'<td>会员等级：</td>'+
					'<td>'+LEVEL_NAME+'</td></tr>'+
					'<tr>'+
					'<td>会员电话：</td>'+
					'<td>'+MB_PHONE+'</td></tr>'+
					'<tr>'+
					'<td>会员地址：</td>'+
					'<td>'+MB_ADDR+'</td></tr>'+
					'<tr>'+
					'<td>来源分站：</td>'+
					'<td>'+station+'</td></tr>'+
					'<tr>'+
					'<td>邀请码：</td>'+
					'<td>'+invitationCode+'</td></tr>'+
					'<tr>'+
					'<td>是否缴纳保证金：</td>'+
					'<td>'+payTheGold+'</td></tr>'+
					'</table>');
					//alert(data.html());
					
					
				} else if (obj.event === 'del') {
					layer.confirm('真的要删除行吗！', function(index) {
						var url="<%=basePath%>/member/back/deleteRec.action";
						var date ={"mbId":data.MB_ID};
					    $.post(url,date,function(mes){
						   if(mes.state=="1"){  
							   layer.msg(mes.mes);
							   table.reload('testReload');
						   }else{
							  
							   layer.msg(mes.mes);
							   table.reload('testReload');
						   }
					    },"json");
						layer.close(index);
					});
				} else if (obj.event === 'edit') {
					var edit="编辑会员信息";
					member_Id =data.MB_ID;
					addEhyMemberLevel(edit,member_Id);
				} else if(obj.event ==='file'){
					$("#updateImg").click();
					member_Id =data.MB_ID;
					
				}else if(obj.event ==='addInvitationCode'){
					addInvitationCode(data.MB_ID,data.MB_NAME);
				}
			});

			var $ = layui.$, active = {
				
					reload : function() {
					var mbName = $('#mbName').val();
					var mbPhone = $('#mbPhone').val();
					var levelId = $('#selectMemberLevel').val();
					var mbIsbzj = $('#mbIsbzj').val();
					table.reload('testReload', {
						where : {
							mbName : mbName,
							mbPhone:mbPhone,
							mbIsbzj:mbIsbzj,
							levelId:levelId
						}
					});
				}
			};
			$('.demoTable .layui-btn').on('click', function() {
				
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
			
			<%-- var date = {"levelId":"304538bcb24a11e797ce00163e02c911"};
			var url = "<%=basePath%>/memberLevel/findById.action";
			$.post(url,date); --%>

		});
		
		
		
		
		function addEhyMemberLevel(obj,member_Id){
			
			layer.open({
				type:2,
				skin: 'layui-layer-molv',
				content:'pages/back/EhyMemberFrom.jsp?id='+member_Id,
				area: ['85%', '70%'],
				title: obj,
				  

			});
		}
		function uploadFile(obj){
			//判断文件格式
			photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
		    if(photoExt!='.jpg' && photoExt!='.png' && photoExt!='.gif' && photoExt!='.jpeg'){
		    	 layer.msg('只能上传jpg/gif/png/jpeg格式文件!', {
		    	        time: 2000 //20s后自动关闭
		    	   });
		        return false;
		    }
			$("#memberId").val(member_Id);
			var form = new FormData(document.getElementById("update"));
			
			
			$.ajax({
		        url:"<%=basePath%>/member/back/updateMemberPhoto.action",
		        type:"post",
		        data:form,
		        processData:false,
		        contentType:false,
		        success:function(data){
		        	if(data.state==1){
		        		 layer.msg(data.mes, {
				    	        time: 2000, //2s后自动关闭
				    	 });	
		        		 table.reload('testReload');
		        	}else{
		        		 layer.msg(data.mes, {
				    	        time: 2000, //2s后自动关闭
				    	 });
		        		 table.reload('testReload');
		        	}
		        		        },
		        error:function(e){
		        	 layer.msg('请重新上传', {
			    	        time: 2000, //2s后自动关闭
			    	 });
		        }
		    });
		}
		
		/* $(function(){
			selectEhyMemberLevel();
			//form = layui.form;
			
			
		}); */
		var form;
		var loadIndex;
		layui.use('form', function(){
			form = layui.form;
			
			var url = "<%=basePath%>memberLevel/back/selectEhyMemberLevel.action";
			loadIndex = layer.load(); 
			$.post(url ,null,function(mes){
				
				$("#selectMemberLevel").append('<option value="">搜索选择</option>');
				for(i=0;i<mes.length;i++){
					$("#selectMemberLevel").append('<option value="'+mes[i].levelId+'">'+mes[i].levelName+'</option>');
				}
				
				form.render();
				layer.close(loadIndex);
				/* layer.close(loadIndex);//加载层关闭   */
				
			});
			
			
			
			
		}); 
		
		
		<%-- var loadIndex;
		function selectEhyMemberLevel(){
			
			var url = "<%=basePath%>memberLevel/selectEhyMemberLevel.action";
			/* loadIndex = layer.load(); */
			$.post(url ,null,function(mes){
				
				$("#selectMemberLevel").append('<option value="">搜索选择</option>');
				for(i=0;i<mes.length;i++){
					$("#selectMemberLevel").append('<option value="'+mes[i].levelId+'">'+mes[i].levelName+'</option>');
				}
				form.render(); 
				/* layer.close(loadIndex);//加载层关闭   */
				
			});
			
		} --%>
		
		
		function addInvitationCode(mbId,name){
			
			var date = {"mbId":mbId,"mbName":name};
			var url = "<%=basePath%>member/back/addInvitationCode.action";
			$.post(url ,date,function(mes){
				if(mes.state==1){
					var ehyMes=mes.mes;
					var ehyInvitationCode = ehyMes.split("-");
					 layer.open({
					        type: 1
					        ,id:'addInvitationCode'
					        ,content: '<div style="padding: 20px 100px;">'+ehyInvitationCode[0]+ehyInvitationCode[1]  +'</div>'
					        ,btn: '确定'
					        ,btnAlign: 'c' //按钮居中
					        ,yes: function(){
					          layer.closeAll();
					          table.reload('testReload');
					        }
					      });/* 
					layer.msg(ehyInvitationCode[0]+"<br/>"+ehyInvitationCode[1],{time: 5000}); */
				}else if(mes.state==3){
					layer.msg(mes.mes,{time:5000});
				}else{
					layer.msg(mes.mes,{time:3000});
				}
				
			});
		}
		
	</script>
	
	<script type="text/html" id="sexTpl">
		{{#  if(d.MB_ISBZJ === 0){ }}
    	<span style="color: #FF0000;">{{ '未缴纳' }}</span>
  		{{#  } else { }}
    	<span style="color: green;">{{ '已缴纳' }}</span>
  		{{#  } }}
	</script>
	<script type="text/html" id="invitationCode">
		{{#  if(d.INVITATION_CODE !== ""){ }}
    	{{ d.INVITATION_CODE }}
  		{{#  } else { }}
    	<span style="color: #FF0000;">{{ '无' }}</span>
  		{{#  } }}
	</script>
	
</body>
</html>