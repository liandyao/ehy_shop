<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<link rel="stylesheet" href="res/zTree_v3/css/demo.css" type="text/css">
<link rel="stylesheet" href="res/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
<!-- zTree -->
<script type="text/javascript" src="res/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="res/zTree_v3/js/jquery.ztree.excheck.min.js"></script>  
<style type="text/css">
	ul.ztree {
	    margin-top: 10px;
	    border: 1px solid #fff;
	    background: #f0f6e4;
	    width: 220px;
	    height: auto;
	    overflow-y: scroll;
	    overflow-x: auto;
	}
</style>
</head>
<body style="padding:20px 40px 0px 40px;">
	<form class="layui-form" id="mesFrom" method="post" lay-filter="from">
		<input type="hidden" name="roleId" id="roleId" />
		<div id="hideChkck">
			
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色名称</label>
			<div class="layui-input-inline">
				<input type="text" name="roleName" id="roleName" required
					lay-verify="required" placeholder="角色名称" autocomplete="off" disabled
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">模块</label>
			<div class="layui-input-inline" style="height: auto">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="button" class="layui-btn" onclick="submitFrom();"
					value="提交" />
			</div>
		</div>
	</form>
	<script type="text/javascript">
	
	$(function (){
		var roleId = GetQueryString("roleId");
		findById(roleId);
	});
	
	function findById(roleId){
		if(roleId!=null || roleId!=''){
			var url = "role/back/findById.action";
			var data = {"roleId":roleId};
			$.post(url, data,function(obj){
				$("#roleId").val(obj.roleId);
				$("#roleName").val(obj.roleName);
			});
		}
	}
	
	//注意：parent 是 JS 自带的全局对象，可用于操作父页面
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

	layui.use('form', function() {
		var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	});
	
	/**
		
	*/
	function submitFrom(){
		var url = "privilege/back/updateModRole.action";
		var arr = "";
		for(i=0; i<treeObj.getCheckedNodes().length; i++){
			if(i<treeObj.getCheckedNodes().length-1){
				arr += treeObj.getCheckedNodes()[i].id+",";
			}else{
				arr += treeObj.getCheckedNodes()[i].id;
			}
		}
		arr += "";
		var data = {"roleId":$("#roleId").val(), "modIdArr":arr};
		layer.load();
		$.post(url, data, function(info){
			layer.closeAll('loading');
			if(info.state==1){
				parent.layer.close(index);
				parent.layer.msg(info.mes);
				parent.parent.show();
			}
		});
	}
	
	var treeObj;
	
	var setting = {
		async : {
			enable : true,//采用异步加载
			url : "privilege/back/moduleTree.action",
			dataType : "json"
		},
		check : {
			enable : true,//采用异步加载
			chkStyle : "checkbox",
			nocheckInherit : true,
			chkDisabled : true
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
			onClick: function (e, treeId, treeNode, clickFlag) {   
				treeObj.checkNode(treeNode, !treeNode.checked, true);
            },//给每个节点点击事件，
			onCheck: zTreeOnClick,
			onAsyncSuccess : zTreeOnAsyncSuccess
		},
		view :{
			showLine: true
		}
	};
	
	//给每个节点点击事件
    function zTreeOnClick(event, treeId, treeNode) {
    	
	};
	
	//异步加载完成时运行，此方法将所有的节点打开
	function zTreeOnAsyncSuccess(event, treeId, msg) {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var url = "privilege/back/findByRoleId.action";
		var data = {"roleId": GetQueryString("roleId")};
		
		treeObj.expandAll(true);
		$.post(url, data, function(arr){
			for(i=0; i<arr.length; i++){
				treeObj.checkNode(treeObj.getNodeByParam("id",arr[i], null));
				$("#hideChkck").append('<input type="hidden" id="'+arr[i]+'" name="modIdArr" value="'+arr[i]+'" chkcked />');
			}
		});
	}
	
	$(document).ready(function() {
		treeObj = $.fn.zTree.init($("#treeDemo"), setting);
	});
	
	/**
		得到URL栏的参数
	 */
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}
	</script>
	
</body>
</html>