$(function() {
	//加载页面元素节点
	$.get("pages/front/base.jsp",function(data){
		$("#header").html($(data).filter("#header").html());//加载页眉
		$("#toolbar").html($(data).filter("#toolbar").html());//加载工具栏
		$("#footer").html($(data).filter("#footer").html());//加载页脚
		var url=window.location.href+"#main-top";//得到当前页面的URL地址
		$("#toolbar #ceiling").attr("href", url);//设置锚链接目标元素的URL地址
	},"html");
	loadStation();//加载站点
});


/**
 * 站点点击事件
 * @param obj 被点击的A标签
 * @param id 站点ID
 * @returns 
 */
function link(obj,id){
	$("div.links-li li").removeClass("active");
	$(obj).parents("li").addClass("active");
	$(".links-li li > div").removeClass("active");
	$(obj).parents("li").prev().find("div:last-child").addClass("active");	
	if(typeof loadImages != 'undefined' && loadImages instanceof Function){
		loadImages(id);//加载产品图片
	}
	if(typeof loadType != 'undefined' && loadType instanceof Function){
		loadType(id);//加载产品类型
	}
	if(typeof shownews != 'undefined' && shownews instanceof Function){
		shownews(id);//加载新闻公告
	}
	if(typeof loadSpecification != 'undefined' && loadSpecification instanceof Function){
		loadSpecification(id);
	}
	
}

/**
 * 加载站点
 * @returns
 */
function loadStation(){
	var url="station/back/findStation.action";
	var data={"intercept":true,};
	$.post(url,data,function(arr){
		var ul=$("div.links-li > ul")[0];
		$(ul).find("li:not(:first-child)").remove();
		var index=2;
		for(var i=0;i<arr.length;i++){
			if(arr[i].stType==0){
				index=i+index;//记录默认站点所在的节点序号
			} 
			$(ul).append("<li><a href='javascript:void(0);' "+
				"onclick='link(this,&apos;"+arr[i].stId+"&apos;)'>"+arr[i].stName+"</a>"+
				"<div class='line-height'></div></li>");
		} 
		$(ul).find("li:nth-of-type(2)").prepend("<div class='line-height'></div>");
		var hq=$(ul).find("li:nth-of-type("+index+") > a")[0];//得到默认站点所在的节点
		$(hq).click();
	},"json");
}


/**
 * 获取URL参数的方法
 * @param name 属性名
 * @returns 如果存在返回对应的值,不存在返回null
 */
function getParam(name) { 
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //设置正则表达式的规则
  var url= window.location.search;//获取URL地址
  url=decodeURIComponent(url);//URL解码
  var r =url.substr(1).match(reg); 
  if (r != null) {  
    return unescape(r[2]); 
  } 
  return null; 
}
