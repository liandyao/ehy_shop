<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="${pageContext.request.contextPath }/res/js/jquery-1.js"></script>
<script type="text/javascript">

$(function(){
	var url="${pageContext.request.contextPath }/member/front/findArea.action";
	$.post(url,null,function(m){
		for(i=0;i<m.length;i++){
			$("#select").append("<option value='"+m[i].areaId+"'>"+m[i].areaName+"</option>");
		}
	},"json")
})

function show(){
	$("#areaId").html("<option>---请选择---</option>");
	var url="${pageContext.request.contextPath }/member/front/findAreaById.action";
	var e=$("#select").val();
	var data={"areaId":e};
	$.post(url,data,function(m){
	
		for(i=0;i<m.length;i++){
			$("#areaId").append("<option value='"+m[i].areaId+"'>"+m[i].areaName+"</option>");
			
		}
		
	},"json")
	
}

function show1(){
	$("#areaId1").html("<option>---请选择---</option>");
	var url="${pageContext.request.contextPath }/member/front/findAreaById.action";
	var e=$("#areaId").val();
	var data={"areaId":e};
	$.post(url,data,function(m){
	
		for(i=0;i<m.length;i++){
			$("#areaId1").append("<option value='"+m[i].areaId+"'>"+m[i].areaName+"</option>");
			
		}
		
	},"json")
	
}



</script>
</head>
<body>


<select id="select" name="select" onchange="show(),show1()">
<option>---请选择---</option>
</select>

<select id="areaId" name="areaId" onchange="show1()">
<option>---请选择---</option>
</select>

<select id="areaId1" name="areaId1">
<option>---请选择---</option>
</select>


</body>
</html>