// JavaScript Document
var SF = {};

// 根目录
SF.root = "/admin";



//SF Ajax基础框架：@Date:2012-07-10,@author:link
SF.adminAjax = function(params){
	var url = params.url;
	var type = params.type || "get";
	var data = params.data;
	var success = params.success;
	if (!url) {
		alert("url cannot be null!");
		return ;
	}
	//当存在beforesend时要校验其返回值
	if(params.beforesend!=null){
		if(params.beforesend()){
			
		}else{
			return ;
		}
	}
	
	//var $mask = SF.popup.mask();
    //SF.popup.loading();
//	setTimeout(function() {
		$.ajax({
			url:url,
	    	type:type,
			data:data,
			dataType:'json',
	        success:function(data){
	        	if($.isPlainObject(data)) {
	        		if (data.notLogin) {
	        			$.messager.alert("error",'用户过期!');
	    				window.top.location.href="../admin/index.action";
					    return;
					}
	        		
					if(data.noPermission){
						$.messager.alert('对不起，您没有权限',"您可以联系管理员开通！");
						return;
					}
					if(data.type == "SystemError") {
						$.messager.alert("",data.message+"请联系管理员！");
						return;
					}
					if(data.type == "ProductError") {
						SF.popup.unmask($mask);
						SF.popup.error({title:"错误提示",message:data.message });
						return;
					}
					/*
					if(!data.success){
						$.messager.alert('error',data.msg);
						if($("#tagFormIsSubmit")){
							$("#tagFormIsSubmit").val(0);
						}
						return ;
					}*/
               }
				success(data);
			},
			error:function(data) {
				if(params.error){
					error(data);
					return ;
				}
				if($("#tagFormIsSubmit")){
					$("#tagFormIsSubmit").val(0);
				}
				$.messager.alert('error',"请求错误，请联系管理员！");
			}
		});
//	}, 2000);	
};

SF.popup = {};

SF.popup.maxZ = function() {
	Math.max.apply(null,$.map($('body > *'), function(e,n){
		if($(e).css('position')=='absolute' || $(e).css('position')=='fixed')
			return parseInt($(e).css('z-index'))||1 ;
	}));
};

SF.popup.centralize = function(div) {
	var windowHeight = $(window).height();
	var windowWidth = $(window).width();
	var divHeight = div.outerHeight();
	var divWidth = div.outerWidth();
	var top = (windowHeight - divHeight) / 2;
	var left = (windowWidth - divWidth) / 2;
//	div.offset({top:top,left:left});
	div.css({top:top,left:left});
	$(window).resize(function() {
		SF.popup.centralize(div);
	});
};

SF.popup.mask = function(maskId) {
	var $mask = $('<div class="body_bg" style="opacity: 0.4;"></div>');
	var id = maskId ? maskId : ("sfMask" + new Date().getTime());
	$mask.attr("data-mask-id", id);
	$mask.focus();
	$mask.bind("unmask", function() {
		$mask.remove();
	});
	$("body").append($mask);
	$mask.focus();
	return $mask;
};
SF.popup.unmask = function(mask) {
	if (mask.trigger) {
		mask.trigger("unmask");
		return;
	}
	$("[data-mask-id='" + mask + "']").remove();
};

SF.popup.loading = function(){
	var 
	 str='<div class="loading modal w240">';
           str+='<div class="modal-body">';
		     str+='<i class="lodingtext">请求正在加载中，请稍后!</i>';
		     str+='<span class="loding"></span>';
			str+='</div>';
	  str+='</div>';
	var loading = $(str);
    $("body").append(loading);
	SF.popup.centralize(loading);
};
SF.popup.unloading = function(){
	$(".loading").remove();
};


SF.popup.error = function(params) {
	var title = params.title || "错误提示";
	var message = params.message;
	var callback = params.callback;
	var 
	str='<div class="confirm w320">';
	   str+='<div class="modal-header">';
		  str+='<button type="button" class="close" data-dismiss="modal">&times;</button>';
		  str+='<h3 style="text-align:left">提示信息</h3>';
	   str+='</div>';
	   
	   str+='<div class="confirm-body">';
		 str+='<dl class="floatl check_icon confirm_error"></dl>';
         str+='<p class="floatl m1-10" style="width:200px; line-height:22px">';
			  str+='<strong class="color-9d">'+ title+'</strong><br/>';
           str+='<i class="color-99">' + message + '</i>';
         str+='</p>';
	   str+='</div>';
	   
	   str+='<div class="modal-footer" style="clear:both">';
		  str+='<a href="#" class="btn btn-primary" data-dismiss="modal">确认</a>';
	   str+='</div>';
	str+='</div>';	
	var errorBox = $(str);
	$("body").append(errorBox);
	SF.popup.centralize(errorBox);
	var $mask = SF.popup.mask();
	
	errorBox.find(".btn-primary,.close").click(function() {
		if (callback) {callback();}
		errorBox.remove();
		SF.popup.unmask($mask);
	});
};

SF.popup.success = function(params) {
	var title = params.title || "操作成功！";
	var message = params.message;
	var callback = params.callback;
	var 
	str='<div class="confirm w320">';
	   str+='<div class="modal-header">';
		  str+='<button type="button" class="close" data-dismiss="modal">&times;</button>';
		  str+='<h3 style="text-align:left">提示信息</h3>';
	   str+='</div>';
	   
	   str+='<div class="confirm-body">';
		 str+='<dl class="floatl check_icon confirm_success"></dl>';
		  str+='<h4 class="color-3f mt15">'+ title+'</h4><br/>';
         str+='<p class="floatl m1-10" style="width:200px; line-height:22px; margin-top:5px;">';
           str+='<i>' + message + '</i>';
         str+='</p>';
	   str+='</div>';
	   
	   str+='<div class="modal-footer" style="clear:both">';
		  str+='<a href="#" class="btn btn-primary" data-dismiss="modal">确认</a>';
	   str+='</div>';
	str+='</div>';	
	var successBox = $(str);
	$("body").append(successBox);
	SF.popup.centralize(successBox);
	var $mask = SF.popup.mask();
	
	successBox.find(".btn-primary,.close").click(function() {
		if (callback) {callback();}
		successBox.remove();
		SF.popup.unmask($mask);
	});
};

SF.popup.info = function(params){
	var title = params.title || "提示";
	var message = params.message;
	var callback = params.callback;
	var 
	str='<div class="info confirm w320">';
	   str+='<div class="modal-header">';
		  str+='<button type="button" class="close">&times;</button>';
		  str+='<h3 style="text-align:left">提示信息</h3>';
	   str+='</div>';
	   
	   str+='<div class="confirm-body">';
		 str+='<dl class="floatl check_icon confirm_warn"></dl>';
         str+='<p class="floatl m1-10" style="width:200px; line-height:22px">';
			  str+='<strong class="color-c7">'+ title +'</strong><br/>';
           str+='<i>' + message + '</i>';
         str+='</p>';
	   str+='</div>';
	   
	   str+='<div class="modal-footer" style="clear:both">';
		  str+='<a href="#" class="btn btn-primary">确认</a>';
	   str+='</div>';
	str+='</div>';	
	var infoBox=$(str);
	$("body").append(infoBox);	
	SF.popup.centralize(infoBox);
	var $mask = SF.popup.mask();
	
	infoBox.find(".btn,.close").click(function(){
		if (callback) {callback();}
		infoBox.remove();	
		SF.popup.unmask($mask);
	});
};

SF.popup.login = function(){
	var 
	str='<div id="myModal" class="confirm w320">';
	   str+='<div class="modal-header">';
		  str+='<button type="button" class="close">&times;</button>';
		  str+='<h3 style="text-align:left">提示信息</h3>';
	   str+='</div>';
	   
	   str+='<div class="confirm-body">';
		 str+='<dl class="floatl check_icon confirm_warn"></dl>';
         str+='<p class="floatl m1-10" style="line-height:22px">';
			  str+='<strong class="color-c7">抱歉，登录超时！</strong><br/>';
           str+='<i>重新登录后，请回到此页面继续操作。</i>';
         str+='</p>';
	   str+='</div>';
	   
	   str+='<div class="modal-footer" style="clear:both">';
	      str+='<a class="btn btn-large mr10 loginhref">立即登陆</a>';
		  str+='<a class="btn btn-large mr10 btn-success">登陆完成</a>';
	   str+='</div>';
	str+='</div>';	
	
	var loginBox = $(str);
	loginBox.find(".loginhref").click(function() {
		window.open('/admin/');
	});
	loginBox.find(".btn-success,.close").click(function() {
		loginBox.remove();
		SF.popup.unmask($mask);
	});
	
	var $mask = SF.popup.mask();
	$("body").append(loginBox);
	SF.popup.centralize(loginBox);
};


//Ajax执行二次确认组件
SF.popup.confirm = function(params) {
	var title = params.title || "请确认";
	var message = params.message;
	var onComplete = params.onComplete;
	str='<div class="confirm w320">';
	   str+='<div class="modal-header">';
		  str+='<button type="button" class="close" data-dismiss="modal">&times;</button>';
		  str+='<h3 style="text-align:left">提示信息</h3>';
	   str+='</div>';
	   
	   str+='<div class="confirm-body">';
		 str+='<dl class="floatl check_icon confirm_warn"></dl>';
      str+='<p class="floatl m1-10" style="width:200px; line-height:22px">';
			  str+='<strong class="color-bb">'+ title+'</strong><br/>';
        str+='<i>' + message + '</i>';
      str+='</p>';
	   str+='</div>';
	   
	   str+='<div class="modal-footer" style="clear:both">';
		  str+='<a href="#" class="btn btn-primary" data-dismiss="modal">确认</a>';
		  str+='<a href="#" class="btn cancel" data-dismiss="modal">取消</a>';
	   str+='</div>';
	str+='</div>';	
	 var confirmBox=$(str);
	 var $mask = SF.popup.mask();
	 $("body").append(confirmBox);
	 SF.popup.centralize(confirmBox);
	confirmBox.find(".btn-primary").click(function() {
		confirmBox.remove();
		SF.popup.unmask($mask);
		if (onComplete) {
			onComplete(true);
		}
	});
	confirmBox.find(".close,.cancel").click(function() {
		confirmBox.remove();
		SF.popup.unmask($mask);
		if (onComplete) {
			onComplete(false);
		}
	});
};


SF.popup.prompt = function(params) {
	var title = params.title || "请确认";
	var message = params.message;
	var required = params.required || false;
	var url = params.url;
	var maxLength = params.maxLength || 0;
	var onComplete = params.onComplete;
	var onCancel = params.onCancel;
    //str='<form action="'+ url +'" method="post">';	
	str='<div class="confirm w320">';
	   str+='<div class="modal-header">';
		  str+='<button type="button" class="close" data-dismiss="modal">&times;</button>';
		  str+='<h3 style="text-align:left">提示信息</h3>';
	   str+='</div>';
	   
	   str+='<div class="confirm-body">';
	    str+='<div class="confirm-con">';
		  str+='<dl class="floatl check_icon confirm_warn"></dl>';
          str+='<p class="floatl m1-10" style="width:200px; line-height:22px">';
		   str+='<strong class="color-bb">'+ title +'</strong><br/>';
           str+='<i>' + message + '</i>';
          str+='</p>';
        str+='</div>';
      
       str+='<div class="confirm-con">';
        str+='<i style="margin-left:15px"><font class="color-9d">*</font>原因: <textarea class="w220" rows="3" name="content"></textarea></i>';
       str+='</div>';
	  str+='</div>';
	   
	   str+='<div class="modal-footer">';
		  str+='<button type="submit" class="btn btn-primary">确认</button>';
		  str+='<button type="button" class="btn cancel">取消</button>';
	   str+='</div>';
	 
	 str+='</div>';
  //str+='</form>';	
	 var promptBox=$(str);
	 promptBox.find(".btn-primary").click(function() {
		if(required && $.trim($('[name="content"]').val()) === ''){			
			alert('不能为空！');	
			return;
		}else if($('[name="content"]').val().length > maxLength){
			alert("字符长度不能大于" + maxLength);
			return;	
		}
		if (onComplete) {
			onComplete($('[name="content"]').val());
		}
		promptBox.remove();
		SF.popup.unmask($mask);
		});

	 promptBox.find(".close,.cancel").click(function() {
		    promptBox.remove();
			SF.popup.unmask($mask);
			if (onCancel) {
				onCancel();
			}
		});
	 $("body").append(promptBox);
	 SF.popup.centralize(promptBox);
	 var $mask = SF.popup.mask();
};


SF.insertScript = function(url) {
    var sfs = document.createElement('script'); 
    sfs.type = 'text/javascript';
//  sfs.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    sfs.src = url;
    var s = document.getElementsByTagName('script')[0]; 
    s.parentNode.insertBefore(sfs, s);
};

SF.insertStyleSheet = function(url) {
	var sfs = document.createElement('link'); 
	sfs.rel = 'stylesheet';
//  sfs.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	sfs.href = url;
	var s = document.getElementsByTagName('link')[0]; 
	s.parentNode.insertBefore(sfs, s);
};


//Ajax查询、列表、分页组件
SF.components = {};

//上传组件
SF.components.fileUpload = function(setting){
	var fu = new SF.components.upload(setting);
	return fu;
};

SF.components.upload = function(setting){
	this.setting = setting;
	this.init();
};

SF.components.upload.prototype = {
		swfUpload : null,
		uploadUrl:SF.root+'/common/upload.action', 
		flashUrl : SF.root+'/js/swfupload/swfupload.swf',//————————————————baiyu——————————————这个是用于显示添加图片时的  动画Flash
		buttonImgUrl:SF.root+'/images/uploadBtn.png',//————————————————baiyu——————————————这个是用于显示添加图片的  +添加图片
		uploadBtnId:"UploadBtn",
		progressTargetId:"ProgressTarget",
		setting : {
			container:'' , //文件上传组建所在位置的ID
			fileSizeLimit:"10 MB",//文件大小限制
			fileTypes : "*.*",//文件类型
			fileUploadLimit : 5,//一次最多上传个数
			callback:function(){}
		},
		init : function(){
			var _this  = this;
			var loadSwfupload = false;
			var loadFileprogress= false;
			var loadHandlers = false;
			
			SF.insertStyleSheet(SF.root+"/js/swfupload/default.css");
			$.getScript(SF.root+"/js/swfupload/swfupload.js", function(){
				loadSwfupload = true;
				_this.onReady(loadSwfupload && loadFileprogress && loadHandlers);
			});
			$.getScript(SF.root+"/js/swfupload/fileprogress.js", function(){
				loadFileprogress = true;
				_this.onReady(loadSwfupload && loadFileprogress && loadHandlers);
			});
			$.getScript(SF.root+"/js/swfupload/handlers.js", function(){
				loadHandlers = true;
				_this.onReady(loadSwfupload && loadFileprogress && loadHandlers);
			});
			
		},
		onReady:function(b){
			if(b){
				this.createDom();
				this.swfUpload = this.initSwfUpload();
			}
		},
		createDom : function(){
			$("<span ></span>").attr('id' , this.uploadBtnId).appendTo($("#"+this.setting.container));
			$("<div></div>").attr('id' ,  this.progressTargetId ).appendTo($("#"+this.setting.container));
			$('<input  />').addClass('btn  btn-primary').attr('id' , 'StartUp').attr('type' , 'button').attr('value' , '开始上传').hide().appendTo($("#"+this.setting.container));
	//		$('<input  />').attr('id' , 'CancelUp').attr('type' , 'button').attr('value' , '取消上传').hide().appendTo($("#"+this.setting.container));
		},
		initSwfUpload:function(){
			var _this = this;
			alert("+++++++++"+this.upload);
			
			var swfUpload =  new SWFUpload({
				upload_url :_this.uploadUrl,//上传URL
				flash_url : _this.flashUrl,//flash地址
				file_post_name:'file',//上传的文件服务器对应的属性名
				file_size_limit : _this.setting.fileSizeLimit,
				file_types : _this.setting.fileTypes,
				file_upload_limit :_this.setting.fileUploadLimit,
				file_types_description : "上传文件",
				
				
				
				
				button_placeholder_id : _this.uploadBtnId,//flash按钮所在节点ID
				button_image_url:_this.buttonImgUrl,//flash按钮背景图
				button_image_url1:_this.buttonImgUrl,//flash按钮背景图
				button_width: "69",
				button_height: "20",
				button_text: ' ',//flash按钮文字
				button_window_mode: SWFUpload.WINDOW_MODE.OPAQUE,//该SWF可以被页面类的其他元素通过层级的设置来覆盖它(可以是位于页面元素的最高层级或透过它看到背后的页面元素)
				button_cursor: SWFUpload.CURSOR.HAND,//鼠标划过button时的光标状态


				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler :function(file, serverData){
					_this.setting.callback(file , $.parseJSON(serverData));

					var progress = new FileProgress(file, _this.progressTargetId);
					progress.setComplete();
					progress.setStatus("成功.");
					progress.toggleCancel(false);

					if(this.getStats().files_queued == 0 ){
						$('#StartUp').hide();
//						$('#CancelUp').hide();
					}
					
				} ,
				upload_complete_handler : uploadComplete,
				queue_complete_handler : queueComplete,	// Queue plugin event
				
				custom_settings:{
					progressTarget : _this.progressTargetId
//					cancelButtonId : "CancelUp"
				},

				// Debug Settings
				debug: false
			});
			return swfUpload;
		}
		
};



//执行函数
$(document).ready(function() {
	
});
  
//拨打电话
function callTel(chan,tel,ip){
	var url = "http://"+ip+"/dial.cgi?chan="+chan+"&num="+tel;
	$.ajax({
		url:url,
        success:function(data){
			
		},
		error:function(data){
			
		}
	});
	
}



//下载 
function sfupload(s,d){
	var _this = $(s);
	var url = _this.attr('ref');
	window.location.href=url+"?"+d;
}




//闭包封装
(function($){
	
	//数据列表统一封装
	$.fn.sfdatagrid = function(params){
		//默认值
		var opt = {
				pagination:true,
			    rownumbers:true,//行数 行号
			    singleSelect:true,//单选模式	    
				remoteSort:true,//服务器端排序
				fitColumns:true,//自适应宽度
				fit:true,
				striped:true,
				border:true,//是否需要border
				idField: 'id', //后台要返回id，可以分页不同行选择删除。
				nowarp:false, // 内容过多时出现自动换行，
				pageSize:20,  //几个一分页，数字与下面list第一个要一致。
				frozenColumns:1,
				loadFilter:function(data){//处理拦截器中拦截的用户失效、无权限等，返回值没有total和rows等
					if((typeof(data)=="undefined") || data==null ){
						var mydata = "{ total:0, rows:[] }";
						data = eval(mydata);
						alert("data is null !");
					}else if(data.total==null || data.rows==null){
						data["total"]=0;
						data["rows"]=[];
						data["order"]="desc";
						data["sort"]="id";
					}
					return data;
				},
				onLoadSuccess:function(data){
					if(data.notLogin!=null && data.notLogin){//session失效
						$.messager.alert("error",'用户过期!');
						window.parent.location.href="../admin/index.action";
						return false;
					}else if(data.noPermission!=null && data.noPermission){//没有权限
						window.parent.$.messager.alert("error",'您没有权限!');
						sfTabClose();
						return false;
					}
				},
				onLoadError:function(data){
					$.messager.alert("error",data.msg);
				}
		};
		
		//如果传入参数存在则覆盖默认值
		opt = $.extend(true,opt,params);
		
		//默认宽度
		var co=opt.columns;
		if(co){
			var co1 = co[0];
			for(var i=0;i<co1.length;i++){
				if((typeof(co1[i]['width'])=="undefined")){
					co1[i]['width']=20;
					if((typeof(co1[i]['align']))=='undefined'){
						co1[i]['align']='center';
					}
				}
			}
		}
		
		$(this).datagrid(opt);
		
	};
	
	
	//处理easyui的form提交问题(权限)
	$.fn.sfform = $.fn.form;
	$.fn.form=function(opt){
		if("validate"==opt){
			//return $(this).sfform(opt);
		}
		else {
			if(typeof(opt.url)!="undefined"){
				var u = opt.url;
				var t = "";
				if(u.indexOf("?")>-1){
					
				}else{
					t="?";
				}
				opt.url=u+t+"&is_easyui_form=true";
			}
			
		}
		return $(this).sfform(opt);//这里使用return的作用是有些form是要获取返回值的，比如校验这个方法
	}
	$.fn.form.methods=$.fn.sfform.methods;//这个必须使用这个，原因可能是easyui中直接调用了form下的methods
	
	
	
})(jQuery);

