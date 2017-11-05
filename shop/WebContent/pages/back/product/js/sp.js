			var sizes = {//数据
			}
			var tabledata = []
			var selectedArr = {};
			var hasdid = {};
			var hastext = [];
			/***
			 * Skumodel 为生成规格类
			 * title为规格名字  string  例：尺码
			 * times将要生成的规格项目  Array  例如：尺码：xxl,xl,m,s
			 * dataid为产生型号的标识最外层元素上的id   string
			 * **/
			var Skumodel = function(title, items, dataid) {
				//最外层div+标题栏
				this.title = title || "";
				this.items = items || [];
				this.container = $('<div class="sku_container" id="' + dataid + '"><div class="sku_modellist_title"><span class="layui-badge layui-bg-blue">' + this.title + '</span></div></div>');
				//模型列表
				this.skumodels = $('<div class="sku_models"></div>');
				this.skumlist = $('<div class="sku_list"></div>')
				this.skuinputcon = $('<div class="sku_add"></div>');
				//输入框
				this.skuinput = $('<input type="text" placeholder="请输入规格值">');
				//新建按钮
				this.addbtn = $('<a>新建</a>');
				this.init(this.items)
			}
			Skumodel.prototype = {
				//初始化显示组件
				init: function(items) {
					var html = ""
					for(var i = 0; i < items.length; i++) {
						html += '<span class="sku_item"><a data-id="' + getIndex() + '">' + items[i] + '</a><i class="sku_item_close">×</i></span>';
					}
					//获取所有生成按钮
					this.skumlist.append($(html))
					this.skumodels.append(this.skumlist)
					this.container.append(this.skumodels)
					this.skuinputcon.append(this.skuinput)
					this.skuinputcon.append(this.addbtn)
					this.skumodels.append(this.skuinputcon)
					$(".sku_modellist").append(this.container);
					this.bindEvent()
				},
				bindEvent: function() {
					var self = this;
					//点击新建按钮产生
					this.addbtn.click(function() {
						self.createItem();
					});
					this.activeItem();
					//点击删除按钮删除
					this.deleteItem();
					//控制删除符号
					this.toggleCloseEle();
				},
				//创建sku子元素
				createItem: function() {
					var value=$.trim(this.skuinput.val())
					if(value.length <= 0) {
						layer.alert("请输入内容");
						return
					}
					if(sizes[this.title].indexOf(value)>=0){
						layer.msg("请勿重复创建")
						return;
					}
					sizes[this.title].push(this.skuinput.val())
					this.skumlist.append($('<span class="sku_item"><a data-id="' + getIndex() + '">' + value + '</a><i class="sku_item_close">×</i></span>'))
					this.skuinput.val("")
				},
				//子元素是否选中事件
				activeItem: function() {
					this.skumlist.on("click", "a", function() {
						$(this).toggleClass("itemactive");
						var className = $(this).attr("class");
						//判断是否选中
						if(className.indexOf('itemactive')>-1){
							var text = $(this).text();//去当前点击的文本
							var type = $(this).parent().parent().parent().prev().text();
							$(this).next().after('<input type="text" title="'+type+"@"+text+'" class="guigeInput" name="guigems" placeholder="请输入该规格描述">');
						}else{
							var htmls = $(this).next().next().remove();
						}
						
						tableContent();//显示表格
					});
				},
				//监听删除元素
				deleteItem: function() {
					var self=this;
					this.skumlist.on("click", ".sku_item_close", function() {
						$(this).parent().remove();
						var text = $(this).parent().find("a").text();
						var textarr = sizes[self.title];
						textarr.splice(textarr.indexOf(text), 1)
						tableContent();
					});
				},
				//控制删除符号的显示
				toggleCloseEle: function() {
					//显示删除符号
					this.skumlist.on("mouseover", ".sku_item", function() {
						$(this).find(".sku_item_close").css({
							display: "inline-block"
						})
					});
					//显示删除符号
					this.skumlist.on("mouseout", ".sku_item", function() {
						$(this).find(".sku_item_close").css({
							display: "none"
						})
					});
				}
			};

			/****
			 * SkuCell动态产生表格内容类
			 * cellist为表格内部元素    Array   如["红色","xxl"]
			 * dataid为行表格id 产生元素的唯一标识   string
			 * ***/
			var SkuCell = function(celllist, dataid) {
				var factoryPrice = $("#proFactoryPrice").val();
				var price = factoryPrice*100*1.2/100;
				//每行表格的父元素
				this.cellcon = $('<div id="' + dataid + '" class="sku_cell clearfix"></div>');
				//出厂价
				this.moneyInput = $('<div class="sku_t_title"> <input type="text" style="display: inline;height:22px;" required  lay-verify="required" placeholder="请输入出厂价" autocomplete="off" class="layui-input" value="'+factoryPrice+'"></div>');
				//直销价
				this.leftInput = $('<div class="sku_t_title"><input type="text" style="display: inline;height:22px;" required  lay-verify="required" placeholder="请输入直销价" autocomplete="off" class="layui-input" value="'+price+'"></div>');
				//组合名称
				this.leftInputs = $('<div class="sku_t_title"><input type="text" style="display: inline;height:22px;" required  lay-verify="required" placeholder="请输入组合名" autocomplete="off" class="layui-input" value="'+celllist+'"></div>');
				this.init(celllist)
			};
			SkuCell.prototype = {
				constructor: SkuCell,
				init: function(celllist) {
					var html = "";
					for(var i = 0; i < celllist.length; i++) {
						html += '<div class="sku_t_title">' + celllist[i] + '</div>'
					}
					this.cellcon.append($(html));
					this.cellcon.append(this.moneyInput);
					this.cellcon.append(this.leftInput);
					this.cellcon.append(this.leftInputs);
					$('.sku_tablecell').append(this.cellcon)
				}
			};

			/****
			 * 创建表格头部
			 * arr 将要创建的表头内容 Arr ["颜色"，"尺码"]
			 * **/
			function createTablehead(arr) {
				var mustArr = ["出厂价格", "厂家直销价","组合名称"];
				var relayArr = arr.concat(mustArr);
				html = "";
				for(var i = 0, len = relayArr.length; i < len; i++) {
					html += '<div class="sku_t_title">' + relayArr[i] + '</div>'
				}
				$(".sku_tableHead").html("").append($(html))

			}

			/***
			 * 排列组合计算出选择的规格型号的组合方式
			 * 
			 * */
			function getResult() {
				var head = arguments[0][0];
				for(var i in arguments[0]) {
					if(i != 0) {
						head = group(head, arguments[0][i])
					}
				}
				tabledata = [];
				$(".sku_cell").each(function(index) {
					tabledata.push($(this).attr("id"))
				}).remove()
				for(var j = 0, len = head.length; j < len; j++) {
					var newcell = head[j]["datatext"].split(',')
					var dataid = head[j]["dataid"];
						new SkuCell(newcell, dataid);
				}
			};
			//组合前两个数据
			function group(first, second) {
				var result = [];
				for(var i = 0, leni = first.length; i < leni; i++) {
					for(var j = 0, len = second.length; j < len; j++) {
						result.push({
							dataid: first[i]["dataid"] + "-" + second[j]["dataid"],
							datatext: first[i]["datatext"] + "," + second[j]["datatext"]
						})
					}
				}
				return result
			}
			//动态产生一个索引，用于后续操作
			var i = 3;

			function getIndex() {
				return "d" + i++;
			};
			//控制表格内容
			function tableContent() {
				$(".sku_modellist .sku_models").each(function(index, ele) {
					var aa = $(this).find(".itemactive");
					selectedArr[index] = []
					for(var i = 0; i < aa.length; i++) {
						selectedArr[index][i] = {};
						selectedArr[index][i]["dataid"] = $(aa[i]).attr("data-id");
						selectedArr[index][i]["datatext"] = $(aa[i]).text();
					}
				})
				getResult(selectedArr);
			}
			$(function() {
				//点击添加多级型号事件 layer弹出层 
				$("#add_multi_sku").click(function() {
					if($("#typeId").val()==""){
						layer.msg('请先选择该产品的宝贝类型');
						return false;
					}
					layer.open({
						type: 1,
						skin: 'layui-layer-molv',//样式
						title: "选择产品规格",
						area: ["70%", "60%"],
						btn: ["确定", "取消"],
						content: $(".sku_content"), //此处后放置到弹出层内部的内容
						btn2: function(index, layero) { //取消按钮对应回调函数
							layer.close(index)
						},
						yes: function(index) { //确认按钮对应事件
							//清空规格规格
							$(".sku_modellist").html("");
							var arrs = [];
							selectedArr = {}; //清空
							//获取被选中多级型号元素
							$(".sku_content_sku_list .itemactive").each(function() {
									var text = $(this).text(); //选中元素的文字
									var dataid = $(this).attr("data-id"); //选中的元素上的参数用于创建规格时候的唯一标识
									var arr = sizes[text] || [];
									sizes[text] = arr;
									//创建规格
									//alert("text:"+text+",arr:"+arr+",dataid"+dataid);
									new Skumodel(text, arr, dataid)
									arrs.push(text)
								})
								//根据arrs数据判断出是否显示表格同时清空表格
							if(arrs.length) {
								$(".sku_guige").show();
								$(".sku_table").show();
								$(".add").show();
								$(".sku_tableHead").html('');
								$(".sku_tablecell").html("");
								$(".sku_container .itemactive").toggleClass("itemactive");
								createTablehead(arrs);
							} else {
								$(".sku_table").hide();
								$(".sku_guige").hide();
								$(".add").hide();
							}
							layer.close(index)
						}
					})
				});
				//弹窗中的新建sku
				$("#sku_addbtn").click(function() {
					var haveit = false;
					var value=$.trim($(".sku_input").val())
					if(value.length<=0){layer.alert("请输入内容");return}
					$(".sku_content_sku_list a").each(function() {
						if($(this).text() ==value ) {
							layer.msg('新建的已存在,请勿重复创建');
							haveit = true;
							$(".sku_input").val("")
						}
					})
					if(haveit) return;
					var skuitem = '<span class="sku_item"><a data-id="' + getIndex() + '">' + value+ '</a><i class="sku_item_close">×</i></span>'
					$(".sku_content_sku_list").prepend(skuitem);
					$(".sku_input").val("")
				});
				//显示删除符号
				$(".sku_content_sku_list").on("mouseover", ".sku_item", function() {
					$(this).find(".sku_item_close").css({
						display: "inline-block"
					})
				});
				//显示删除符号
				$(".sku_content_sku_list").on("mouseout", ".sku_item", function() {
					$(this).find(".sku_item_close").css({
						display: "none"
					})
				});
				//删除添加的型号
				$(".sku_content_sku_list").on("click", ".sku_item_close", function() {
					$(this).parent().remove();
				})
				$(".sku_content_sku_list").on("click", "a", function() {
					$(this).toggleClass("itemactive")
					var len = $(".sku_content_sku_list .itemactive").length;
					/*if(len > 3) {
						layer.msg("商品规格最多选择3个");
						$(this).toggleClass("itemactive")
					}*/
				});
			})