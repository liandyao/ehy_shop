/**
 * 增加或者减少产品数量
 * @param obj 点击的元素节点
 * @returns
 */
function addOrCut(obj){
	var span=obj.parentNode.querySelector(".num");
	var sign=obj.innerText;
	
	var num=parseInt(span.innerText);
	if(num==1 && sign=="-") return;
	if(sign=="+"){
		num++;
	}else if(sign=="-"){
		num--;
	}
	var tr=$(span).parents("tr")[0];
	var cartId=$(tr).find("input").val();
	var url="cart/front/addOrCut.action";
	var data={"cartId":cartId,"cartNum":num};
	$.post(url,data,function(info){
		if(info>0){
			span.innerText=num;
			totalAlu(tr);
			sumAlu();
		}
	},"json");
	
}

/**
 * 全选
 * @returns
 */
function checkAll(){
	var flag=document.getElementById("checkAll").checked;
	var arr=document.querySelectorAll("#cartList tbody input");
	for(var i=0;i<arr.length;i++){
		arr[i].checked=flag;
	}
	if(flag){
		sumAlu();
		document.getElementById("opt").innerText=arr.length;
	}else{
		document.getElementById("sum").innerText="￥0.00";
		document.getElementById("opt").innerText="0";
	}
	
}

//多选
function itemClick(){
	var allArr = document.querySelectorAll("#cartList tbody input");
	var trueArr = document.querySelectorAll("#cartList tbody input:checked");
	document.getElementById("opt").innerText=trueArr.length;
	var flag=allArr.length==trueArr.length;
	document.getElementById("checkAll").checked=flag;
	sumAlu();
}

/**
 * 总金额计算器
 * @returns
 */
function sumAlu(){
	var arr=document.querySelectorAll("#cartList tbody .cartId:checked");
	var sum=0;
	for(var i=0;i<arr.length;i++){
		var td=$(arr[i]).parents("tr").find(".subtotal")[0];
		var subtotal=parseFloat($(td).text().substr(1));
		sum+=subtotal;
	}
	$("#sum").text("￥"+sum.toFixed(2));
}

/**
 * 小计
 * @param tr 事件源
 * @returns
 */
function totalAlu(tr){
	var num=parseInt($(tr).find(".num-box > .num").text());
	var price=parseFloat($(tr).find(".price").text().substr(1));
	var subtotal=parseFloat(num*price).toFixed(2);
	$(tr).find(".subtotal").text("￥"+subtotal);
}

/**
 * 购物车初始化加载
 * @returns
 */
function cartInit(){
	var url=window.location.href;
	if(url.indexOf("#Section5")>-1) $("#mav > li:nth-child(4) > a").click();
	$("#Section5").load("pages/front/cart.jsp #cartList",function(){
		loadCartList();//加载购物车集合
	});
	
	//注册全选点击事件
	$("#Section5").on("click","#checkAll",function(){
		checkAll();
	});
	
	$("#Section5").on("click","#cartList tbody input",function(){
		itemClick();
	});
	
	//注册购物车删除事件
	$("#Section5").on("click","#cartList tbody > tr > td:last-child > a",function(){
		var cartId=$(this).attr("data-value");
		var url="cart/front/delete.action";
		var data={"cartId":cartId};
		$.post(url,data,function(info){
			if(info>0){
				$("#Section5").load("pages/front/cart.jsp #cartList",function(){
					loadCartList();
				});
			}
		},"json");
	});
}

/**
 * 加载购物车集合
 * @returns
 */
function loadCartList(){
	var trTop=$("#cartList tbody tr")[0];
	var trBody=$("#cartList tbody tr")[1];
	$("#cartList tbody tr:nth-child(n+3)").remove();
	var url="cart/front/findByMbId.action";
	var data={};
	$.post(url,data,function(arr){
		if(arr.length>0){
			$("#rows").text(arr.length);
			for(var i=0;i<arr.length;i++){
				var obj=arr[i];
				
				//时间、站点
				$(trTop).find("td:first-child > span").text(obj.stName);
				$(trTop).find("td:last-child > span").text(obj.cartDatetime);
				$("#cartList > table > tbody").append($(trTop).prop("outerHTML"));
				
				//产品信息
				$(trBody).find("input").val(obj.cartId);
				var price=parseFloat(obj.cartPrice);
				var cartNum=parseInt(obj.cartNum);
				var subtotal=(price*cartNum).toFixed(2);
				$(trBody).find(".img > img").attr("src",obj.proImg);
				$(trBody).find("div.txt > .proName").text(obj.proName);
				var spNames="";
				for(var j=0;j<obj.spValues.length;j++){
					spNames+="<br/>"+obj.spValues[j];
				}
				$(trBody).find(".info").html(spNames.substr(5));
				$(trBody).find(".num-box > .num").text(obj.cartNum);
				$(trBody).find(".price").text("￥"+obj.cartPrice)
				$(trBody).find(".subtotal").text("￥"+subtotal);
				$(trBody).find("a").attr("data-value",obj.cartId);
				$("#cartList > table > tbody").append($(trBody).prop("outerHTML"));
			}
			$(trTop).remove();
			$(trBody).remove();
			$("#checkAll").click();
		}
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