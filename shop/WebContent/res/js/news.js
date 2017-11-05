$(function() {
				var stId=getParam("stId");
				loadStation(stId);
			});
			
			function qb(id){
				$("#shareDivs").css("display","block");
				$("#hide_div").css("display","block");
				var url="news/back/findById.action";
				var data={"intercept":true,"newsId":id};
				$.post(url,data,function(mes){
					$("#div").html("<hr /><p><h1>"+mes.newsTitle+"</h1></P>"+
					"<font color='#6d6d6d' id='ziti'>时间:"+mes.optime+"&nbsp;&nbsp;&nbsp;作者:"+mes.oper+"</font><div class='divcss5-4'></div><br />");
                    $("#div2").html("<font color='#6d6d6d' id='ziti'>"+mes.newsContent+"</font>");
				},"json");
			}
			
			
			
			
			
			function show(id){
				var url="news/back/show.action";
				var data={"intercept":true,"station":id};
				$.post(url,data,function(arr){
					
					//内容
					for(var i=0;i<arr.list.length;i++){
						//字符串省略
						var str=arr.list[i].newsContent;
						var s=str;
						if(str.length>200){
							  s=str.substring(0,200)+"...<font color='red' id='red' onclick='qb(&apos;"+arr.list[i].newsId+"&apos;)'>点击查看全部</font>";
							}
						
						$("#content").append("<br /><p id='biati'>"+arr.list[i].newsTitle+"</p>"+
											"<p><font color='#717171'>&nbsp;&nbsp;&nbsp;"+s+"</font></P>"+
											"<br /><p align='right'><font color='#b7b0b0'>发表于:"+arr.list[i].optime+"</font></p><div class='divcss5-4'></div>");
					}
					
					
					if(arr.pages.curPage==1){
						$("#ul").append("<li class='disabled'><span aria-label='Previous'><span aria-hidden='true'>&laquo;</span></span></li>");
					}else{
						$("#ul").append("<li><a onclick='up("+(arr.pages.curPage-1)+",&apos;"+id+"&apos;);' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a>");
					}
					
					
					//分页 
					for(var j=1;j<arr.pages.totalPage+1;j++){
						
						if(j == arr.pages.curPage){
							$("#ul").append("<li class='active'><a><span>"+j+"</span></a></li>");
						
						}else{
							$("#ul").append("<li id='page'><a onclick='span("+j+",&apos;"+id+"&apos;);'><span>"+j+"</span></a></li>");
						}
					}
					
					
					
					if(arr.pages.curPage==arr.pages.totalPage){
						$("#ul").append("<li class='disabled'><span aria-label='Next'><span aria-hidden='true'>&raquo;</span></span></li>");
		 			}else{
		 				$("#ul").append("<li><a onclick='below("+(arr.pages.curPage+1)+",&apos;"+id+"&apos;);' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		 			}
					
					
				},"json");
			}
			
			function up(j,id){
				var url="news/back/show.action";
				var data={"intercept":true,"station":id,"curPage":j};
				$.post(url,data,function(arr){

					$("#content").html("");
					$("#ul").html("");
					//内容
					for(var i=0;i<arr.list.length;i++){
						//字符串省略
						var str=arr.list[i].newsContent;
						var s=str;
						if(str.length>200){
							  s=str.substring(0,200)+"...<font color='red' onclick='qb(&apos;"+arr.list[i].newsId+"&apos;)'>点击查看全部</font>";
							}
						$("#content").append("<br /><p id='biati'>"+arr.list[i].newsTitle+"</p>"+
								"<p><font color='#717171'>&nbsp;&nbsp;&nbsp;"+s+"</font></P>"+
								"<br /><p align='right'><font color='#b7b0b0'>发表于:"+arr.list[i].optime+"</font></p><div class='divcss5-4'></div>");
					}
					
					
					if(arr.pages.curPage==1){
						$("#ul").append("<li class='disabled'><span aria-label='Previous'><span aria-hidden='true'>&laquo;</span></span></li>");
					}else{
						$("#ul").append("<li><a onclick='up("+(arr.pages.curPage-1)+",&apos;"+id+"&apos;);' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a>");
					}
					//分页 
					for(var j=1;j<arr.pages.totalPage+1;j++){
						if(j == arr.pages.curPage){
							$("#ul").append("<li class='active'><a><span>"+j+"</span></a></li>");
						
						}else{
							$("#ul").append("<li id='page'><a onclick='span("+j+",&apos;"+id+"&apos;);'><span>"+j+"</span></a></li>");
						}
						
					}
					
					
					
					if(arr.pages.curPage==arr.pages.totalPage){
						$("#ul").append("<li class='disabled'><span aria-label='Next'><span aria-hidden='true'>&raquo;</span></span></li>");
		 			}else{
		 				$("#ul").append("<li><a onclick='below("+(arr.pages.curPage+1)+",&apos;"+id+"&apos;);' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		 			}
				},"json");
			}
			
			
			function below(j,id){
				var url="news/back/show.action";
				var data={"intercept":true,"station":id,"curPage":j};
				$.post(url,data,function(arr){

					$("#content").html("");
					$("#ul").html("");
					//内容
					for(var i=0;i<arr.list.length;i++){
						//字符串省略
						var str=arr.list[i].newsContent;
						var s=str;
						if(str.length>200){
							  s=str.substring(0,200)+"...<font color='red' onclick='qb(&apos;"+arr.list[i].newsId+"&apos;)'>点击查看全部</font>";
							}
						$("#content").append("<br /><p id='biati'>"+arr.list[i].newsTitle+"</p>"+
								"<p><font color='#717171'>&nbsp;&nbsp;&nbsp;"+s+"</font></P>"+
								"<br /><p align='right'><font color='#b7b0b0'>发表于:"+arr.list[i].optime+"</font></p><div class='divcss5-4'></div>");
					}
					
					
					if(arr.pages.curPage==1){
						$("#ul").append("<li class='disabled'><span aria-label='Previous'><span aria-hidden='true'>&laquo;</span></span></li>");
					}else{
						$("#ul").append("<li><a onclick='up("+(arr.pages.curPage-1)+",&apos;"+id+"&apos;);' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a>");
					}
					//分页 
					for(var j=1;j<arr.pages.totalPage+1;j++){
						if(j == arr.pages.curPage){
							$("#ul").append("<li class='active'><a><span>"+j+"</span></a></li>");
						
						}else{
							$("#ul").append("<li id='page'><a onclick='span("+j+",&apos;"+id+"&apos;);'><span>"+j+"</span></a></li>");
						}
					}
					
					
					
					if(arr.pages.curPage==arr.pages.totalPage){
						$("#ul").append("<li class='disabled'><span aria-label='Next'><span aria-hidden='true'>&raquo;</span></span></li>");
		 			}else{
		 				$("#ul").append("<li><a onclick='below("+(arr.pages.curPage+1)+",&apos;"+id+"&apos;);' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		 			}
				},"json");
			}
			
			
			function span(j,id){
				
				var url="news/back/show.action";
				var data={"intercept":true,"station":id,"curPage":j};
				
				$.post(url,data,function(arr){

					$("#content").html("");
					$("#ul").html("");
					//内容
					for(var i=0;i<arr.list.length;i++){
						//字符串省略
						var str=arr.list[i].newsContent;
						var s=str;
						if(str.length>200){
							  s=str.substring(0,200)+"...<font color='red' onclick='qb(&apos;"+arr.list[i].newsId+"&apos;)'>点击查看全部</font>";
							}
						$("#content").append("<br /><p id='biati'>"+arr.list[i].newsTitle+"</p>"+
								"<p><font color='#717171'>&nbsp;&nbsp;&nbsp;"+s+"</font></P>"+
								"<br /><p align='right'><font color='#b7b0b0'>发表于:"+arr.list[i].optime+"</font></p><div class='divcss5-4'></div>");
					}
					
					if(arr.pages.curPage==1){
						$("#ul").append("<li class='disabled'><span aria-label='Previous'><span aria-hidden='true'>&laquo;</span></span></li>");
					}else{
						$("#ul").append("<li><a onclick='up("+(arr.pages.curPage-1)+",&apos;"+id+"&apos;);' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a>");
					}
					//分页 
					for(var j=1;j<arr.pages.totalPage+1;j++){
						if(j == arr.pages.curPage){
							$("#ul").append("<li class='active'><a><span>"+j+"</span></a></li>");
						
						}else{
							$("#ul").append("<li id='page'><a onclick='span("+j+",&apos;"+id+"&apos;);'><span>"+j+"</span></a></li>");
						}
					}
					
					
					
					if(arr.pages.curPage==arr.pages.totalPage){
						$("#ul").append("<li class='disabled'><span aria-label='Next'><span aria-hidden='true'>&raquo;</span></span></li>");
		 			}else{
		 				$("#ul").append("<li><a onclick='below("+(arr.pages.curPage+1)+",&apos;"+id+"&apos;);' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		 			}
					
					
				},"json");
				
			}
			
			function link(obj,id){
				$("div.links-li li").removeClass("active");
				$(obj).parents("li").addClass("active");
				$(".links-li li > div").removeClass("active");
				$(obj).parents("li").prev().find("div").addClass("active");
				if(typeof show != 'undefined' && show instanceof Function){
					show(id);//加载新闻公告
					$("#ul").html("");
					$("#content").html(" ");
					$("#page").html(" ");
				}
			}
			function loadStation(id){
				var url="station/back/findStation.action";
				var data={"intercept":true,};
				$.post(url,data,function(arr){
					var ul=$("div.links-li > ul")[0];
					$(ul).find("li:not(:first-child)").remove();
					var index=2;
					for(var i=0;i<arr.length;i++){
						if(id!=null && arr[i].stId==id){
							index=i+index;//记录默认站点所在的节点序号
						} 
						$(ul).append("<li><a href='javascript:void(0);' "+
							"onclick='link(this,&apos;"+arr[i].stId+"&apos;)'>"+arr[i].stName+"</a>"+
							"<div class='line-height'></div></li>");
						$()
					}
					var hq=$(ul).find("li:nth-of-type("+index+") > a")[0];//得到默认站点所在的节点
					$(hq).click();
				},"json");
			}
			
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
			
			$("#closes").click(function(){
				$("#hide_div").css('display','none');
				$("#shareDivs").css('display','none');
			})