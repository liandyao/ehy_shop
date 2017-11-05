var citiesArr={},areasArr={};
var pro="",city="",area="";
$(function(){
	pp();
	$("#titleP").click(function(){
		lineShow(this);
		$(this).text("请选择");
		$("#titleC,#cities,#titleD,#district").hide();
		$("#provinces").show();
	});
	$("#titleC").click(function(){
		ccClick(this);
	});
	$("#titleD").click(function(){
		aaClick(this);
	});
});
function lineShow(id){
	$("#options > li > p span").removeClass("active");
	$(id).toggleClass("active");
}
function onOff(){
	$('#options').toggleClass('boxShow');
	$("#address").toggleClass('address-open');
}
function pp(){
	var url="/shop/res/area/json/provinces.json";
	$.getJSON(encodeURI(url),function(arr){ 
		if(arr.length>0){
			for(var i=0;i<arr.length;i++){
				var p="<p class='item' old-name='"+arr[i].provinceId+"'><span>"+arr[i].province+"</span></p>";
			
				$("#provinces").append(p);
			}
		 itemClick("#provinces p","#titleP","#titleC");
		}
	});
	url="/shop/res/area/json/cities.json";
	$.getJSON(encodeURI(url),function(arr){ 
		citiesArr=arr;
	});
	url="/shop/res/area/json/areas.json";
	$.getJSON(encodeURI(url),function(arr){ 
		areasArr=arr;
	});
}
function ccClick(obj){
	lineShow(obj);
	$(obj).text("请选择");
	var id=$("#provinces p .font-blue").parents("p").attr("old-name");
	cc(id);
}
function cc(id){
	var arr=citiesArr[id];
	if(arr.length>0){
		$("#cities").html("");
		for(var i=0;i<arr.length;i++){
			var p="<p class='item' old-name='"+arr[i].cityId+"'><span>"+arr[i].city+"</span></p>";
			$("#cities").append(p);
		}
		itemClick("#cities p","#titleC","#titleD");
		$("#provinces,#titleD,#district").hide();
		$("#cities").show();
	}
}
function aaClick(obj){
	lineShow(obj);
	$(obj).text("请选择");
	var id=$("#cities p .font-blue").parents("p").attr("old-name");
	aa(id);
}
function aa(id){
	var arr=areasArr[id];
	if(arr.length>0){
		$("#district").html("");
		for(var i=0;i<arr.length;i++){
			var p="<p class='item'><span>"+arr[i].area+"</span></p>";
			$("#district").append(p);
		}
		itemClick("#district p","#titleD","#options");
		$("#provinces,#cities").hide();
		$("#district").show();
	}
}
	
function itemClick(str,id,openId){
	$(str).click(function(){
		$(str).find("span").removeClass("font-blue");
		$(this).find("span").addClass("font-blue");
		$(id).text($(this).text());
		if(openId!="#options"){
			$(openId).show();
			if(id=="#titleP"){
				ccClick("#titleC");
			}else{
				aaClick("#titleD");
			}
		}else{
			var area=$("#titleP").text()+$("#titleC").text()+$("#titleD").text();
			$(".address-item").text(pro+city+area);
			onOff();
		}
		
	});
}