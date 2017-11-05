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
<title>代理人管理</title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
<script src="res/js/drag-sort.js" type="text/javascript"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="demoTable">
 站点名称：
  <div class="layui-inline">
    <input class="layui-input" name="stName" id="stName" style="width: 150px" autocomplete="off">
  </div>
   邀请码：
  <div class="layui-inline">
    <input class="layui-input" name="code" id="code" style="width: 150px" autocomplete="off">
  </div>
  会员名称：
  <div class="layui-inline">
    <input class="layui-input" name="mbName" id="mbName" style="width: 150px" autocomplete="off">
  </div>
 
  <button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
  <button data-type="auto" class="layui-btn layui-btn-normal" onclick="showAddOrUpdate()"><i class="layui-icon">&#xe608;</i>新增</button>
</div>

	<table class="layui-table"
		lay-data="{ height:383,size:'sm', url:'invitationCode/back/showList.action', page:true, id:'idTest',method:'post'}"
		lay-filter="demo">
		<thead>
			<tr>
				<th lay-data="{field:'stName', width:100, align:'center'}">站点名称</th>
				<th lay-data="{field:'code', width:150, sort: true, align:'center'}">邀请码</th>
				<th lay-data="{field:'mbName', width:140, align:'center'}">会员名称</th>		
				<th lay-data="{field:'isva', width:140, align:'center',templet: '#isvaTpl'}">是否代理人</th>
				<th lay-data="{field:'count', width:150,sort: true, align:'center'}">邀请人数</th>
				<th lay-data="{fixed: 'right', width:300, align:'center', toolbar: '#barDemo'}"></th> 
			</tr>
		</thead>
	</table> 
	<script type="text/html" id="isvaTpl">
  		{{#  if(d.isva === 2){ }}
    			是
  		{{#  } }}
		{{#  if(d.isva === 1){ }}
    		         否
  		{{#  } }}
  
	</script>
	<script type="text/html" id="barDemo">
	  <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="stick">置顶</a>
      <a class="layui-btn layui-btn-mini" lay-event="setAgent">设为代理人</a>
      <a class="layui-btn layui-btn-mini" lay-event="cancelAgent">取消代理人</a>
      <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
	</script>
 
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
	var table;
	
	function sort(obj){
		var trs = $("tbody tr");
		var startIndex = obj.attr("data-index");
		for(i=0;i<trs.length;i++){
			$(trs[i]).attr("data-index",i);
		}
		var endIndex = obj.attr("data-index");
		var inviId = table.cache.idTest[startIndex].inviId;
		var start = table.cache.idTest[startIndex].sort;
		var end = table.cache.idTest[endIndex].sort;
		if(start!=end){
			layer.load();
			var data = {"start":start,
					"end":end,
					"inviId":inviId};
			var url = "invitationCode/back/sortInvitationCode.action";
			$.post(url, data, function(info){
				layer.closeAll('loading');
				if(info.state==1){
					layer.msg(info.mes);
					table.reload('idTest');
					$("tbody").attr({"id":"wrap","class":"wrap"});
					$('#wrap').dragSort();
				}
			});
		}
		//console.log(sortArr);
	} 
	
    layui.use(['table','laydate'], function(){
    	table = layui.table;
  		var laydate = layui.laydate;
  
  		//监听工具条
  		table.on('tool(demo)', function(obj){
    		var data = obj.data;
    		if(obj.event === 'stick'){
        		if(data.sort!=1){
        			layer.load();
    				var data = {"start":data.sort,
    						"end":1,
    						"inviId":data.inviId};
    				var url = "invitationCode/back/sortInvitationCode.action";
    				$.post(url, data, function(info){
    					layer.closeAll('loading');
    					if(info.state==1){
    						layer.msg(info.mes);
    						table.reload('idTest');
    						$("tbody").attr({"id":"wrap","class":"wrap"});
    						$('#wrap').dragSort();
    					}
    				});
    			}else{
    				layer.msg("该行已被置顶，请勿重复操作！");
    			} 
        	 
       		 } else if(obj.event === 'setAgent'){
    			if(data.isva==2){
    		        layer.msg("该会员已是代理人，请勿重复设置！"); 
    	        }else{ 
    				layer.confirm('&nbsp;&nbsp;&nbsp;&nbsp;确认设为代理人吗？该会员将会<br/>设为代理会员。', function(index){
    					layer.load();
    					var url = "invitationCode/back/setAgent.action";
	    	       		var d ={inviId:data.inviId,mbId:data.mbId};
	    	        	$.post(url,d,function(mes){
	    	        		layer.closeAll('loading');
	    	        		if(mes.state==1){
	    	        			layer.msg(mes.mes); 
	    	        		}else{
	    	        			layer.msg(mes.mes); 
	    	        		}
	    	        		table.reload('idTest');
	    	       		 },"json")
    	        	 layer.close(index);
    	       		});
    			}
    	 
		    } else if(obj.event==='cancelAgent'){
		    	if(data.isva==1){
		    		layer.msg("该会员不是代理人，请勿重复操作！"); 
		    	}else{ 
		    		layer.confirm('&nbsp;&nbsp;&nbsp;&nbsp;确认取消代理人吗？该会员将会<br/>降为普通会员。', function(index){
		    			layer.load();
		    			var url = "invitationCode/back/cancelAgent.action";
		    	        var d ={inviId:data.inviId,mbId:data.mbId};
		    	        $.post(url,d,function(mes){
		    	        	layer.closeAll('loading');
		    	        	if(mes.state==1){
		    	        		layer.msg(mes.mes); 
		    	        	}else{
		    	        		layer.msg(mes.mes); 
		    	        	}
		    	        	table.reload('idTest');
		    	        },"json")
		    	        layer.close(index);
		    	      });
		    	} 
		    }else if(obj.event === 'del'){
            	layer.confirm('真的删除行么', function(index){
    	  			layer.load();
        			var url = "invitationCode/back/delete.action"; 
       				var d ={inviId:data.inviId,mbId:data.mbId};
			        $.post(url,d,function(mes){
			        	layer.closeAll('loading');
			        	if(mes.state==1){
			        		layer.msg(mes.mes); 
			        	}else{
			        		layer.msg(mes.mes); 
			        	}
			        	table.reload('idTest');
			        },"json")
       
        			layer.close(index);
         
     		     });
    		} 
  	  });
   
  	  var $ = layui.$, active = { 
		    reload: function(){ 
		      var stName = $('#stName');
		      var code = $('#code');
		      var mbName = $('#mbName');
		      var invitationMember = $('#invitationMember'); 
		      table.reload('idTest', {
		        where: {
		        	stName: stName.val(),
		        	code: code.val(),
		        	mbName: mbName.val(),
		        	invitationMember: invitationMember.val()
		        } 
		      });
		    }
  		};
	  $('.demoTable .layui-btn').on('click', function(){ 
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
	  });
  
      $("tbody").attr({"id":"wrap","class":"wrap"});
	  $('#wrap').dragSort();
  });
  function showAddOrUpdate(inviId,stId,mbId){ 
	var from = $("#fromStr").html(); 
	var addCen= layer.open({
        type: 2//样式
        ,skin: 'layui-layer-molv'//样式
        ,area: ['85%', '70%']
	    ,title: '邀请码维护'
	    ,id : "mesFrom"
        ,shade: [0.8, '#393D49'] //显示遮罩
        ,shadeClose:true//点击也能遮罩层关闭
        ,anim:2//弹出动画
        ,maxmin: true //允许全屏最小化
        ,content: 'pages/back/invitationCodeForm.jsp?inviId='+inviId+'&stId='+stId+'&mbId='+mbId
      }); 
  }

</script>

</body>
</html>