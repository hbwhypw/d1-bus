


/***
 * s 是a标签的this 
 * title 标签名称
 * 
 * 在父类的Tabs上打开心的 tab
 * 如已经打开则刷新
 * @author wangzy 
 * 
 * ***/
function sfAddTab(s,titleStr)
{
	var _this = $(s);
	if(titleStr == '' || titleStr == null)
	{
		titleStr = _this.text() ;
	}
	var tabs = window.parent.$('#Tabs');
	if(!tabs.tabs('exists' , titleStr)){//判断选项卡是否存在
		tabs.tabs('add',{  //创建选项卡
		    title:titleStr,  
		    closable:true,
		    content:'<iframe scrolling="auto" frameborder="0"  src="'+_this.attr('ref') +'" style="width:100%;height:99%;"></iframe>'//请求的链接
		});
	}else{
		tabs.tabs('select' ,titleStr ); //根据title选中当前选项卡
		var currTab = tabs.tabs('getSelected');
		var url = _this.attr('ref');
		if(url){
			tabs.tabs('update',{
				tab:currTab,
				options:{
					content:'<iframe scrolling="auto" frameborder="0"  src="'+url +'" style="width:99%;height:100%;"></iframe>'
				}
			});
		}
	}
} ;

/***
 * s 是a标签的this 
 * title 标签名称
 * 
 * 在父类的Tabs上打开心的 tab
 * 如已经打开则刷新
 * @author wangzy 
 * 
 * ***/
function sfAddUrlTab(urls,titleStr)
{
	
	var tabs = window.parent.$('#Tabs');
	if(!tabs.tabs('exists' , titleStr)){//判断选项卡是否存在
		tabs.tabs('add',{  //创建选项卡
		    title:titleStr,  
		    closable:true,
		    content:'<iframe scrolling="auto" frameborder="0"  src="'+urls +'" style="width:100%;height:99%;"></iframe>'//请求的链接
		});
	}else{
		tabs.tabs('select' ,titleStr ); //根据title选中当前选项卡
		var currTab = tabs.tabs('getSelected');
		var url = urls;
		if(url){
			tabs.tabs('update',{
				tab:currTab,
				options:{
					content:'<iframe scrolling="auto" frameborder="0"  src="'+url +'" style="width:100%;height:100%;"></iframe>'
				}
			});
		}
	}
} ;

/**
 * 更新当前tab页
 * **/
function sfUpdateTab()
{
	var tabs = window.parent.$('#Tabs');
	var currTab = tabs.tabs('getSelected');
	var url = $(currTab.panel('options').content).attr('src');
	if(url){
		tabs.tabs('update',{
			tab:currTab,
			options:{
				content:'<iframe scrolling="auto" frameborder="0"  src="'+url +'" style="width:100%;height:99%;"></iframe>'
			}
		});
	}
} ;

/** 
 * 关闭当前tab页  -- 在ready中调用不到 
 * @return
 */
function sfClostTab(){
	
	var tabs = window.parent.$('#Tabs');
	var currTab = tabs.tabs('getSelected');
	var index = tabs.tabs('getTabIndex',currTab);
	tabs.tabs('close',index);
	
}

/**
 * 更新当前tab页 打开指定的网址
 * **/
function sfTabSelected(url,newTitle)
{
	var tabs = window.parent.$('#Tabs');
	var currTab = tabs.tabs('getSelected');
	if(url){
		tabs.tabs('update',{
			tab:currTab,
			title:newTitle, 
			options:{
				title:newTitle,
				content:'<iframe scrolling="auto" frameborder="0"  src="'+url +'" style="width:99%;height:100%;"></iframe>'
			}
		});
	}
} ;

var fillZero = function(n){
	if(n<10){
		return '0'+n;
	}else{
		return n;
	}
};

/***
 * 时间选择框  最大最小  
 * 今天 昨天 本周 本月 
 * $('.Time a').click(function(){
		timeMaxMin($(this));
	});	
 * @author wangzy	
 * **/
function timeMaxMin(s){

	var now = new Date();
	var name = $(s).attr('name');

	var min = '';
	var max = '';
	switch (name) {
	   case 'today' :
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate()) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate()) + " 23:59:59";  
	   break;
	   case 'yesterday' :
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate() - 1) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate() - 1) + " 23:59:59";  
	   break;
	   case 'thisWeek' :		  
		   nowDay = now.getDate();
		   nowDayOfWeek = now.getDay(); 
		   thisweek = nowDay - nowDayOfWeek	 ; 		   
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(thisweek + 1) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(thisweek + 7) + " 23:59:59"; 
	   break;
	   case 'thisMonth' :	
		   var hour=now.getHours();     
		   var minute=now.getMinutes();     
		   var second=now.getSeconds(); 	
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-' + 01 + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-' + fillZero(now.getDate() ) +" " + fillZero(hour)+":" + fillZero(minute)+":" + fillZero(second); 
       break;
	   default :
	       alert('error');
	} 
	$('#min').val( min );//必须用id才行
	$('#max').val( max );//必须用id才行
	$('#min').datetimebox('setValue' , min );//必须用id才行
 	$('#max').datetimebox('setValue' , max );//必须用id才行
		
};	

jQuery.extend({//自己扩展一个
	 toJson:function(s){
	    var kvs=s.split('&');
	    var obj={};
	    var kv;
	    for(var i=0;i<kvs.length;i++){
	       kv=kvs[i].split('=');
	       if(kv.length==2)obj[kv[0]]=kv[1];
	    }
	    return obj;
	 },
	
	serializeObject:function(formName) {
    var o = {};
    var a = $("#"+formName).serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
	}
});


function GetJSONStr(class_name) {
	var a = [];
	//文本框
	$("." + class_name).filter(":text").each(function(i) {
	//alert(this.name);
	//alert(this.value);
		a.push({ name: this.name, value: this.value });
	});
	
	//下拉列表
	$("." + class_name).filter("select").each(function(i) {
	//alert(this.name);
	//alert(this.value);
		a.push({ name: this.name, value: this.value });
	});
	
	//单选框
	$("." + class_name).filter(":radio").filter(":checked").each(function(i) {
	//alert(this.name);
	//alert(this.value);
		a.push({ name: this.name, value: this.value });
	});
	
	//复选框开始
	var temp_cb = "";
	$("." + class_name).filter(":checkbox").filter(":checked").each(function(i) {
		if (temp_cb.indexOf(this.name) == -1) {
			temp_cb += this.name + ",";
		}
	});
	
	var temp_cb_arr = temp_cb.split(",");
	var cb_name = "";
	var cb_value = "";
	for (var temp_cb_i = 0; temp_cb_i < temp_cb_arr.length - 1; temp_cb_i++) {
		cb_name = temp_cb_arr[temp_cb_i];
		var cb_value_length = $("input[name='" + temp_cb_arr[temp_cb_i] + "']:checked").length;
		$("input[name='" + temp_cb_arr[temp_cb_i] + "']:checked").each(function(i) {
			if (i == cb_value_length - 1)
				cb_value += this.value;
			else
				cb_value += this.value + ",";
		});
	//alert(cb_name);
	//alert(cb_value);
		a.push({ name: cb_name, value: cb_value });
	}
	
	//复选框结束
	//组合为JSON
	var temp_json = "";
	for (var json_i = 0; json_i < a.length; json_i++) {
		if (json_i != a.length - 1) {
			temp_json += '"' + a[json_i].name + '":"' + a[json_i].value + '",';
		}
		else {
			temp_json += '"' + a[json_i].name + '":"' + a[json_i].value + '"';
		}
	}
	return "{" + temp_json + "}";
} ;




