$(function(){
	init();//页面初始化
});
var images=[];
/**
 * 初始化加载的方法
 * @returns
 */
function init(){
	//注册小图片点击事件
	$("div.min-img").on("click","li",function(){
		$("div.min-img li").removeClass("active");
		$(this).addClass("active");
		var src=$(this).find("img").attr("src");
		$("div.max-img > img").attr("src",src);
	});
	//注册尺码点击事件
	$(".details").on("click",".specification > .list > ul > li",function(){
		$(this).parents("ul").find("li").removeClass("active");
		$(this).addClass("active");
	});
	//注册标题点击事件
	$(".cont > .title > div").click(function(){
		$(".cont > .title > div").removeClass("active");
		$(this).addClass("active");
	});
	
	//注册颜色图片点击事件
	$(".img-color > .list li").click(function(){
		$(".img-color > .list li").removeClass("active");
		$(this).addClass("active");
	});
	var proId=getParam("proId");//获取地址栏参数
	loadInfo(proId);//加载宝贝详情
	loadInfoImages(proId,1);//加载图片
	loadInfoSpecification(proId);//加载规格参数
}

/**
 * 增加或者减少数量的方法
 * @param obj 被点击的元素节点
 * @returns
 */
function addOrCut(obj){
	var span=document.querySelector(".number > .box > .num");//得到产品数量所在的文档节点
	var sign=obj.innerText;//获取点击的符号
	var num=parseInt(span.innerText);//将产品数量转化成整数型数字
	if(num==1 && sign=="-") return;//如果数量等于'1'并且点击的符号是'-',则直接返回
	if(sign=="+"){//如果点击的是'+'号
		span.innerText=num+1;//产品数量+1
	}else if(sign=="-"){//如果点击的是'-'号
		span.innerText=num-1;//产品数量-1
	}
}

function loadInfoSpecification(proId){
	var url="proshow/front/findByProId.action";
	var data={"intercept":true,"proId":proId};
	$.post(url,data,function(arr){//发送Ajax请求
		var div=$("div.details")[0];
		$(div).find("div.specification").remove();
		for(var i=0;i<arr.length;i++){
			var spt=arr[i];
			
			var spList=spt.spNames.split(",");
			$(div).find("div.number").before(
				"<div class='specification'>"+
					"<div class='text'>"+spt.sptName+"</div>"+
					"<div class='list'>"+
						"<ul>"+
							builder(spList)+
						"</ul>"+
					"</div>"+
				"</div>"
			);
		}
		$(div).find("div.specification li:first-child").click();
	},"json");//设置返回参数类型
}

function builder(arr){
	var html="";
	for(var i=0;i<arr.length;i++){
		var spValue=arr[i];
		html+="<li>"+spValue+"</li>";
	}
	return html;
}

/**
 * 加载宝贝详情
 * @returns
 */
function loadInfo(proId){
	var url="proshow/front/findById.action";//设置action请求地址
	var data={"intercept":true,"proId":proId};//设置请求参数
	$.post(url,data,function(map){//发送Ajax请求
		var pro=map.proVo;
		$("#proName").text(pro.proName);
		$("#proFactoryPrice").text("￥"+pro.proFactoryPrice);
		$("#proPrice").text("￥"+pro.proPrice);
	},"json");//设置返回参数类型
}

function loadInfoImages(proId,imgType){
	var url="proshow/front/findImgByProId.action";
	var data={"intercept":true,"proId":proId,"imgType":imgType};
	$.post(url,data,function(arr){//发送Ajax请求
		var ul=$("div.min-img > ul")[0];
		$(ul).find("li").remove();
		for(var i=0;i<arr.length && i<6;i++){
			var imgPath=arr[i].imgPath;
			$(ul).append("<li><img src="+imgPath+"></li>");
		}
		$(ul).find("li:first-child").click();
		images=arr;
	},"json");//设置返回参数类型
}

