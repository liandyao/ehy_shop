(function (window, undefined) {
	var ehy=new Object();//定义一个验证登陆的对象
	ehy.isLogin=false;//是否登陆
	//前台会员登陆验证
	ehy.member=function(){
		var url="member/front/isLogin.action";
		var data={"intercept":true};
		$.post(url,data,function(flag){
			ehy.isLogin=flag;
		},"json");
	};
	
	//后台用户登陆验证
	ehy.manager=function(){
		var url="manager/back/isLogin.action";
		var data={"intercept":true};
		$.post(url,data,function(flag){
			if(!flag){//如果返回值是false
				window.location.href="pages/back/login.jsp";//跳转到后台登陆页面
			}
		},"json");
	};
	window.ehy=ehy;//将这个登陆对象返回到window
})(window);

//页面初始化加载
$(function(){
	var url=window.location.href;//取出URL地址
	if(url.indexOf("back")>-1){//如果是后台的页面
		ehy.manager();//调用后台登陆验证
	}else{//如果是前台的页面
		ehy.member();//调用前台登陆验证
	}
});
//日期 格式化方法。调用的方法 new Date(取出来的时间).format("yyyy-MM-dd HH:mm:ss")
Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}   

