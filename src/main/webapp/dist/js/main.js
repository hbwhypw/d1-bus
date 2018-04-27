var menu_id;
function addTab(id, title, url){
	if ($('#tabs').tabs('exists', title)){
		$('#tabs').tabs('select', title);//选中并刷新
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab: currTab,
				options:{
					title: currTab.panel('options').title,
					href: url
				}
			})
		}
	} else {
        $('.tabs-title').each(function(i,n){
            var t = $(n).text();
            if(t != 'Home') {
                $('#tabs').tabs('close',t);
            }
            $('.combo-p').remove();
            $('.datagrid').remove();
            $('.window:gt(0)').remove();
            $('.window-shadow:gt(0)').remove();
            $('.window-mask:gt(0)').remove();
        });
		$('#tabs').tabs('add',{
			id: id,
			title: title,
			href: url,
			closable:true
		});
	}
	tabClose();
}
function tabAdd(title,index){
    menu_id = $('#tabs').tabs('getTab', index).eq(0).attr('id');
}
function tabClose() {
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}		
// 绑定右键菜单事件
function tabCloseEven() {
	// 退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

var common = {};
/**
 * 添加查询参数
 * @param datagrid 需要刷新的datagrid
 * @param paramName 参数名称
 * @param formType 表单输入类型
 */
common.addQueryParam = function(datagrid, paramName, formType) {
	var param;
	switch (formType){
		case 0:
			param = $('#' + paramName).val();
			break;
		case 1:
			param = $('#' + paramName + ' option:selected').val();
			break;
		default :
			param = $('#' + paramName).val();
	}
	var requestParam = paramName.substring(0, paramName.indexOf("P"));
	if (param != "") {
		var queryParams = $('#'+datagrid).datagrid('options').queryParams;
		queryParams[requestParam] = param;
	} else {
		var queryParams = $('#'+userstatisticDg).datagrid('options').queryParams;
		delete queryParams[requestParam];
	}
};

common.is_checkFormatter = function (value, row, index) {
	var is_check = row.is_check;
	switch (is_check) {
		case 1:
			return '√';
		case 0:
			return 'X';
		default :
			return '';
	}
};

common.dataGridLoader = function(param,success,error){
	var that = $(this);
	var opts = that.datagrid("options");
	if (!opts.url) {
		return false;
	}
	$.ajax({
		type : opts.method,
		url : opts.url,
		data : param,
		dataType : "json",
		success : function (data) {
			debugger;
			success(data.data);
		},
		error : function () {
			error.apply(this, arguments);
		}
	});
};

common.comboBoxLoader = function(param,success,error){
	var that = $(this);
	var opts = that.combobox("options");
	if (!opts.url) {
		return false;
	}
	$.ajax({
		type : opts.method,
		url : opts.url,
		data : param,
		dataType : "json",
		success : function (data) {
			var result = data.data,
				element = {code: '', name: '全部'};
			if($.isArray(result)){
				result.unshift(element);
			} else {
				result = [element]
			}
			success(result);
		},
		error : function () {
			error.apply(this, arguments);
		}
	});
};

common.comboBoxLoaderPage = function(param,success,error){
	var that = $(this);
	var opts = that.combobox("options");
	if (!opts.url) {
		return false;
	}
	$.ajax({
		type : opts.method,
		url : opts.url,
		data : param,
		dataType : "json",
		success : function (data) {
			var result = data.rows,
				element = {code: '', name: '全部'};
			if($.isArray(result)){
				result.unshift(element);
			} else {
				result = [element]
			}
			success(result);
		},
		error : function () {
			error.apply(this, arguments);
		}
	});
};

$(function() {
	$.ajaxSetup({
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		complete: function(xhr,textStatus){
			// 通过XMLHttpRequest取得响应头，sessionstatus，
			var sessionStatus = xhr.getResponseHeader("sessionStatus");
			if (sessionStatus == "timeout") {
				$.messager.alert('警告', '登录超时！', 'warning');
				//如果超时就处理 ，指定要跳转的页面
				window.location.replace("/admin/index.jsp");
			}
		}
	});
	getMenu();
	tabCloseEven();

	$('.cs-navi-tab').click(function() {
		var $this = $(this);
		var href = $this.attr('src');
		var option_id = $this.attr('option-id');
		var title = $this.text();
		addTab(option_id, title, href);
	});

	$('#pwd').click(function(){
		$('#updatePasswordDlg').dialog("open").dialog("setTitle", "修改密码");
	});

	$('#updatePasswordDlgBtn a').eq(0).click(function(){
		$('#updatePasswordFm').form('submit', {
			url: "/admins/updatepwd",
			onSubmit: function () {
				return $(this).form('validate');
			},
			success: function (data) {
				var data = $.parseJSON(data);
				if (data.code === 1) {
					$('#updatePasswordDlg').dialog("close");
				}
				$.messager.show({
					title: '系统提示',
					msg: data.msg
				});
			}
		});
	});

	$('#updatePasswordDlgBtn a').eq(1).click(function(){
		$('#updatePasswordDlg').dialog("close");
	});

	if(getCookie('cs-skin')) {
		var skin = getCookie('cs-skin');
		$('#swicth-style').attr('href', themes[skin]);
		$this = $('.li-skinitem span[rel='+skin+']');
		$this.addClass('cs-skin-on');
		skin == 'dark-hive' ? $('.cs-north-logo').css('color', '#FFFFFF') : $('.cs-north-logo').css('color', '#000000');
	}
	$.extend($.fn.validatebox.defaults.rules, {
		equals: {
			validator: function(value,param){
				return value == $(param[0]).val();
			},
			message: '重复密码不匹配'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		minLength: {
			validator: function(value, param){
				return value.length >= param[0];
			},
			message: '请输入至少{0}个字符。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		maxLength: {
			validator: function(value, param){
				return value.length <= param[0];
			},
			message: '请最多输入{0}个字符。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		equalsLength: {
			validator: function(value, param){
				return value.length == param[0];
			},
			message: '请输入{0}个字符。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
        specialChar: {
			validator: function(value, param){
                var reg = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
				return !reg.test(value);
			},
			message: '不可以输入特殊字符。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		username: {
			validator: function(value, param){
				var reg = /[0-9a-zA-Z]{6,18}/;
				return reg.test(value);
			},
			message: '请输入6-18个字母和数字。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
        mobilephone: {
			validator: function(value, param){
                var reg = /^1[3-8]\d{9}$/;
				return reg.test(value);
			},
			message: '请输入正确的手机号。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
        idcard: {
			validator: function(value, param){
                var reg = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
				return reg.test(value);
			},
			message: '请输入正确的身份证号。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
        num: {
			validator: function(value, param){
                var reg = /^[0-9]*$/;
				return reg.test(value);
			},
			message: '请输入数字。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
        url: {
			validator: function(value, param){
                var reg = /^((http|ftp|https):\/\/)(([a-zA-Z0-9\._-]+\.[a-zA-Z]{2,6})|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,4})*([a-zA-Z0-9\&%_\.\/-~-]*)?$/;
				return reg.test(value);
			},
			message: '请输入正确的连接。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
        carnum: {
			validator: function(value, param){
                var reg = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
				return reg.test(value);
			},
			message: '请输入正确的车牌号。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		telephone: {
			validator: function(value, param){
                var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
				return reg.test(value);
			},
			message: '请输入正确的座机号。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		decimals: {
			validator: function(value, param){
                var reg = /^\d+\.\d+$/;
				return reg.test(value);
			},
			message: '请输入正确小数'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		QQ: {
			validator: function(value, param){
                var reg = /^\d{5,10}$/;
				return reg.test(value);
			},
			message: '请输入正确的QQ号。'
		}
	});
	$.extend($.fn.validatebox.defaults.rules, {
		price: {
			validator: function(value, param){
                var reg = /^[0-9]+(\.[0-9]+)?$/;
				return reg.test(value);
			},
			message: '请输入正确的价格。'
		}
	});
	$.extend($.fn.datagrid.methods, {
		queryReload: function(jq, newposition){
			return jq.each(function(){
				$(this).datagrid("options").pageNumber = 1;   
				$(this).datagrid('getPager').pagination({pageNumber: 1}); 
				$(this).datagrid("reload",newposition);
			});
		}
	});
	$.extend($.fn.treegrid.methods, {
		queryReload: function(jq, newposition){
			return jq.each(function(){
				$(this).treegrid("options").pageNumber = 1;   
				$(this).treegrid('getPager').pagination({pageNumber: 1}); 
				$(this).treegrid("reload",newposition);
			});
		}
	});
});
function getMenu(){
	var role = $('#welcome').attr('role');
	$.ajax({
		url: '../admins/permission',
		dataType: 'json',
		async: false,
		complete: function(xhr, textStatus) {
			//called when complete
		},
		success: function(data, textStatus, xhr) {
			// called when successful
			var html = template.render('menus_tmpl', data);
			$(' .easyui-accordion ').html(html);
		},
		error: function(xhr, textStatus, errorThrown) {
			//called when there is an error
			$.messager.alert('警告', '加载菜单出错！', 'warning');
		}
	});
}

function setCookie(name,value) {// 两个参数，一个是cookie的名子，一个是值
    var Days = 30; // 此 cookie 将被保存 30 天
    var exp = new Date();    // new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

function getCookie(name) {// 取cookies函数        
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
     if(arr != null) return unescape(arr[2]); return null;
}