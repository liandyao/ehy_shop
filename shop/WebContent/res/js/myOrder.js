	var state=0;
	$(function(){
		setTimeout('gsh()', 1000)
		zd();
		reveal(1);
	});
	//格式化日期框的方法
	function gsh(){
		$('.terminus').datepicker({
			todayBtn : "linked",  
			autoclose : true,  
		    endDate : new Date()  
		}).on('changeDate',function(e){
		    var endTime = e.date;  
		    $('.start').datepicker('setEndDate',endTime);
		    
		});
		$('.start').datepicker({  
			todayBtn : "linked",  
			autoclose : true,  
		    endDate : new Date()  
		}).on('changeDate',function(e){  
		    var startTime = e.date;  
		    $('.terminus').datepicker('setStartDate',startTime);  
		}); 
	}
	//显示隐藏的方法
	function Toggle() {
		var src = $(".jt").attr("src");
		if ("res/images/jt_s.png" == src) {
			$(".jt").attr("src", "res/images/jt_x.png")
		} else {
			$(".jt").attr("src", "res/images/jt_s.png")
			/* $("[name='keyword']").val(""); */
			$("[name='start']").val("");
			$("[name='terminus']").val("");
			$("[name='site']").find("option[value='']").attr("selected",true);
		}
		$(".hidn").slideToggle();
	}
	//选中的方法
	function pitchOn(obj,states){
		state=states;
		reveal(1);
		$(".ztBox .onddzt").attr("class","ddzt");
		$(obj).attr("class","onddzt")
	}
	function zd(){
		var url="manager/back/showAllStation.action?intercept=true"
		$.post(url,null,function(stList){
			for(var i=0;i<stList.length;i++){
				$(".site").append("<option value="+stList[i].stId+">"+stList[i].stName+"</option");
			}
			
		})
		
	}
	function receipt(ordId,obj){
		$.ajax({
			url:"order/front/receipt.action",
			data:{"ordId":ordId},
			type:"post",
			async:true,
			cache:false,
			success:function(mes){
				if(mes.state>0){
					var tr=$(obj).parents("tr");
					tr.empty();
					tr.append("<td colspan='2'>订单状态：已签收</td><td colspan='3'><input class='ssbt' type='button'value='申请退款'></td>");
				}
			},
			error:function(){
				alert("异常")
			}
		})
	}
	//显示的方法 
	function reveal(curPage){
		$.ajax({
			url:"order/front/showList.action?curPage="+curPage+"&ordState="+state,
			data:$("#for").serialize(),
			type:"post",
			async:true,
			cache:false,
			success:function(map){
			$(".orderb").empty();
			var orderList=map.orderList;	
			var pages=map.pages;
			var str="";
			if(orderList.length<=0){
				str="<div style='width: 100%;text-align: center;'><img style='margin-top:5%;' src='res/images/none_order.jpg'><p>没有找到订单</p></div>";
			}else{
			for(var i=0;i<orderList.length;i++){
				str="<div class='ordersBox'>"+
				"<table class='order'>"+
				"<tr class='dh'>"+
				"<td><div class='time'>下单日期："+new Date(orderList[i].opTime).format("yyyy-MM-dd")+"</div>"+
				"<div class='orderNum'>订单号："+orderList[i].ordCode+"</div></td>"+
				"<td colspan='2'>成都站</td>"+
				"<td colspan='2'><div class='kddh'>"+orderList[i].expressName+"："+orderList[i].expressCode+"</div></td>"
				var prolist=orderList[i].prolist;
				for(var j=0;j<prolist.length;j++){
					str+="<tr class='details'>"+
					"<td class='baby'>"+
					"<div class='pro'><img class='pro_img'src="+prolist[j].proPhotoPath+"></div>"+
					"<div class='pro_name'>"+prolist[j].proName+"</div></td>"+
					"<td class='price'>￥"+prolist[j].cost+"</td>"+
					"<td class='num'>"+prolist[j].mxNum+"件</td>"+
					"<td class='sj_price'>￥"+prolist[j].payment+"</td>"+
					"<td class='cz'><div><a href='javascript:show()'>分享商品</a><div><a href='#'>申请售后</a></div><div><a href='#'>我要退货</a></div></td>"
				}
				str+="<tr class='details'>"
				
				//0 已删除 1 申请退货 2 已退货 10 已确认待支付 20 已支付,待发货 30 已发货 40 已签收
				if(orderList[i].ordState>=40){
					str+="<tr class='bom'><td colspan='2'>订单状态：已签收</td><td colspan='3'><input class='ssbt' type='button'value='申请退款'>"
				}else if(orderList[i].ordState>=30){
					str+="<tr class='bom'><td colspan='2'>订单状态：待收货</td><td colspan='3'><input class='ssbt' onclick='receipt("+orderList[i].ordId+",this)' type='button'value='确认收货'>"
				}else if(orderList[i].ordState>=20){
					str+="<tr class='bom'><td colspan='2'>订单状态：待发货</td><td colspan='3'>等待商家发货"
				}else if(orderList[i].ordState>=10){
					str+="<tr class='bom'><td colspan='2'>订单状态：待付款</td><td colspan='3'><input class='ssbt' type='button'value='立即支付'>"
				}else if(orderList[i].ordState>=2){
					str+="<tr class='bom'><td colspan='2'>订单状态：已退货</td><td colspan='3'>已退货"
				}else if(orderList[i].ordState>=1){
					str+="<tr class='bom'><td colspan='2'>订单状态：退货中</td><td colspan='3'>等待商家确认"
				}
				str+="</td></table>";
				str=str.replace('null：null', '暂无数据快递数据');
				str=str.replace('null', '暂无数据');
				$(".orderb").append(str);
			}	
				var str="<div class='pages'><ul class='pagination'>"
				if(pages.curPage==1){
					str+="<li class='disabled'><span aria-label='Previous'><span aria-hidden='true'>&laquo;</span></span></li>"
				}else{
					str+="<li><a href='javascript:reveal("+(pages.curPage-1)+")' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a>"
				}
	 			for(var i=0;i<pages.totalPage;i++){
	 				if(pages.curPage==(i+1)){
	 					str+="<li class='active'><span>"+(i+1)+"</span></li>"
	 				}else{
	 					str+="<li><a href='javascript:reveal("+(i+1)+")'>"+(i+1)+"</a></li>"
	 				}
	 			}
	 			if(pages.curPage==pages.totalPage){
	 				str+="<li class='disabled'><span aria-label='Next'><span aria-hidden='true'>&raquo;</span></span></li>";
	 			}else{
	 				str+="<li><a href='javascript:reveal("+(pages.curPage+1)+")' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"
	 			}
				str+="</ul></div>"
				}
				$(".orderb").append(str);
			}
			,
			error:function(){
				alert("失败")
			}
		});
		
	}
	//转换时间格式的方法
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