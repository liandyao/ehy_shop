$(function(){
	setTimeout(delay,1000)
	$(".div_share_curtain").load("pages/front/share.jsp #curtain")
	$(".div_share").load("pages/front/share.jsp #dialogs")
})
function show(){
	document.getElementById("dialogs").style="display:block;";
	document.getElementById("curtain").style="display:block;";

}
function hide(){
	document.getElementById("dialogs").style="display:none;";
	document.getElementById("curtain").style="display:none;";
}
function comment(){
	var data=new FormData($( "#comment" )[0]);
	console.log(data) 
	 $.ajax({  
         url: 'comment/front/comment.action' ,  
         type: 'POST',  
         data: data,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
             alert("成功");  
         },  
         error: function () {  
             alert("失败");  
         }  
    });  
}
function delay(){
	
	$("#xFile").on('change', function () {
		 
		   //获取上传文件的数量
		   var countFiles = $(this)[0].files.length;
		 
		   var imgPath = $(this)[0].value;
		   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
		   var upload_img = $(".photoAdd");
		   $(".photo").remove();
		 
		   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
		       if (typeof (FileReader) != "undefined") {
		 
		           // 循环所有要上传的图片
		           for (var i = 0; i < countFiles; i++) {
		 
		               var reader = new FileReader();
		               reader.onload = function (e) {
		            	   upload_img.before("<div class='photo' style='width: 223px; height: 296px; float: left;margin-right:20px;'><div class='' style='width: 223px; height: 215px; border: 1px solid #d5d5d5; border-bottom: none;'><div style='height:215px;padding:2px;border-bottom: none; line-height: 215px; text-align: center; color: red; font-size: 18px;'><img style='max-width:100%;max-height:100%;padding:2px;' src='"+e.target.result+"'/></div></div><textarea name='commDesc' style='width: 223px; height: 70px;'placeholder='可输入描述文字'></textarea></div>");
		               }
		 
		               upload_img.show();
		               reader.readAsDataURL($(this)[0].files[i]);
		           }
		 
		       } else {
		           alert("你的浏览器不支持FileReader！");
		       }
		   } else {
		       alert("请选择图像文件。");
		   }
		});
}