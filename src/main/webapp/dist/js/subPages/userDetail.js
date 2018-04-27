var UserDetailVo = function(){};
UserDetailVo.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    if(typeof btn !== 'undefined'){
        this.showBtn(btn);
    }
    this.bind();
};
UserDetailVo.prototype.add = function() {
    $("#userDetailVoDlg").dialog("open").dialog("setTitle", "添加用户信息");
    var _this = this;
    $('#userDetailVoFm').form('clear');
    //$('#username').attr('readonly', false);
    _this.url = '/userDetail/add';
};
UserDetailVo.prototype.update = function() {
    var _this = this;
    var row = $('#userDetailVoDg').datagrid('getSelected');
    if (row) {
    $("#userDetailVoDlg").dialog("open").dialog("setTitle", "修改用户信息");
    if (row.birthday && row.birthday != '') {
    	row.birthday = row.birthday.substring(0, 10);
    }
    $('#userDetailVoFm').form('load', row);
    //$('#username').attr('readonly', true);
    _this.url = '/userDetail/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

UserDetailVo.prototype.updateQrCode = function() {
    var row = $('#userDetailVoDg').datagrid('getSelected');
    if (row) {
		$.post('/userDetail/updateQrCode', {
			"user_id": row.id
		}, function(data) {
			$('#userDetailVoDg').datagrid('reload');
		}, 'json');
	}else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

UserDetailVo.prototype.updatePassWord = function() {
	
    var row = $('#userDetailVoDg').datagrid('getChecked');
    if (row && row.length == 1) {
		$.post('/userDetail/updatePassWord', {
			"user_id": row[0].id
		}, function(data) {
			$('#userDetailVoDg').datagrid('reload');
		}, 'json');
	}else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

UserDetailVo.prototype.invoke = function() {
	var row = $('#userDetailVoDg').datagrid('getChecked');
	if (row && row.length == 1) {
		$.post('/userDetail/invoke', {
			"id": row[0].id
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
            $('#userDetailVoDg').datagrid('reload');
		}, 'json');
	}else {
		$.messager.alert('警告','请选择一项！','warning');
	}
}

UserDetailVo.prototype.delete = function() {
    var row = $('#userDetailVoDg').datagrid('getChecked');
    if (row && row.length == 1) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/userDetail/delete', {
                    id: row[0].id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#userDetailVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

UserDetailVo.prototype.forEver = function() {
    var row = $('#userDetailVoDg').datagrid('getChecked');
    if (row && row.length == 1) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/userDetail/forEver', {
                    id: row[0].id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#userDetailVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

UserDetailVo.prototype.import = function() {
    var _this = this;
    $("#uploadDlg").dialog("open").dialog("setTitle", "导入用户Excel");
    $("#uploadFm").get(0).reset();
    var file = $("#uploadFm :file");
    file.after(file.clone().val(""));
    file.remove();
};

UserDetailVo.prototype.importWangYi = function() {
	var _this = this;
	$("#uploadWYDlg").dialog("open").dialog("setTitle", "导入网易用户txt");
	$("#uploadWYFm").get(0).reset();
	var file = $("#uploadFm :file");
	file.after(file.clone().val(""));
	file.remove();
};

UserDetailVo.prototype.export = function() {
	var row = $('#userDetailVoDg').datagrid('getChecked');
    if (row) {
    	var ids = [];
        if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        var param = $.param({
			ids: ids.toString()
        });
        console.log(param);
        $("#ids").val(ids.toString());
        $("#exportFormDownLoad").submit();
//    document.location.href = "/userDetail/export/?" + param;
//        $.post("/userDetail/export",{"ids": ids.toString()});
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

UserDetailVo.prototype.push = function() {
    var row = $('#userDetailVoDg').datagrid('getChecked');
    if (row) {
        var ids = [];
        if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        $("#pushDlg").dialog("open").dialog("setTitle", "推送消息");
        $('#idstr').val(ids.toString());
    } else {
        $.messager.alert('警告', '请至少选择一项！', 'warning');
    }
};

UserDetailVo.prototype.query = function() {
    this.checkInput('real_nameParam',this.INPUT);
    this.checkInput('usernameParam',this.INPUT);
    this.checkInput('card_numParam',this.INPUT);
    this.checkInput('addressParam',this.INPUT);
    this.checkInput('company_idParam',this.COBOBOX);
    this.checkInput('cityParam',this.COBOBOX);
    this.checkInput('sexParam',this.COBOBOX);
    this.checkInput('usertypeParam',this.COBOBOX);
    this.checkInput('startParam',this.INPUT);
    this.checkInput('endParam',this.INPUT);
    $('#userDetailVoDg').datagrid('queryReload');
};

UserDetailVo.prototype.look = function() {
	var _this = this;
    var row = $('#userDetailVoDg').datagrid('getChecked');
    if (row && row.length == 1) {
    	$.post('/userDetail/selectById', {
            id: row[0].id
    	}, function(data) {
    		var result = eval("("+data+")");
    		var map = result.data;
    		var html = '';
    		if(1==result.code){
				html += '<div style="font-size:20px;color:#0092DC;">二维码</div><br/><div text-align:center"><img src="' + map.qrcode + '"></div><br />';
				html += '<div style="font-size:20px;color:#0092DC;">头像</div><br /><div text-align:center"><img src="' + map.portrait + '"></div><br />';
				html += '<div style="font-size:20px;color:#0092DC;">背景</div><br /><div text-align:center"><img src="' + map.background + '"></div><br />';
    			$('#img').append(html);
    			$("#userImg").dialog("open").dialog("setTitle", "用户图片");
    		}
    	});
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

UserDetailVo.prototype.recover = function() {
    var row = $('#userDetailVoDg').datagrid('getChecked');
    if (row && row.length == 1) {
		$.post('/userDetail/updateRecover', {
			"id": row[0].id
		}, function(data) {
			$.messager.show({
                title: '系统错误',
                msg: data.msg
            });
			$('#userDetailVoDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

UserDetailVo.prototype.checkInput = function(paramName,formType) {
    var param;
    switch (formType){
        case 0:
            param = $('#' + paramName).val();
            break;
        case 1:
            param = $('#' + paramName + ' option:selected').val();
            break;
        case 2:
            param = $('#' + paramName ).combobox('getValue');
            break;
        default :
            param = $('#' + paramName).val();
    }
    var requestParam = paramName.substring(0, paramName.indexOf("P"));
    if (param != "") {
        var queryParams = $('#userDetailVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#userDetailVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};
UserDetailVo.prototype.validUserName = function() {
	$("#username").focusout(function(){
		var phone = $("#username").val();
		var phoneV = /^1[3|4|5|7|8][0-9]\d{4,8}$/;
		if (null == phone || phone.trim() == ""
			|| !(phoneV.test(phone))) {
			$.messager.show({
                title: '系统提示',
                msg: '请输入正确的手机号'
            });
			$('#phone').attr("value","");
			return;
		}
		$.post('/userDetail/selectByPhone', {
    		"phone": phone
    	}, function(data) {
    		var result = eval("("+data+")");
    		if(1==result.code){
    			$.messager.show({
                    title: '系统提示',
                    msg: '手机号已存在'
                });
    			$('#username').attr("value","");
    		}
    	},"json");
	});
}

UserDetailVo.prototype.valid = function() {
    var number = $('#number').val();
    var username = $('#username').val();
    if(number === '' && username === ''){
        $.messager.show({
            title: '系统提示',
            msg: '工号、用户名中至少有一项必填'
        });
        return false;
    } else {
        return true;
    }
};

UserDetailVo.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#query").click(function () {
        _this.query();
    });
    // 查看图片按钮
    $("#look").click(function () {
        _this.look();
    });
    // 添加按钮
    $("#add").click(function () {
        _this.add();
    });
    // 修改按钮
    $("#update").click(function () {
        _this.update();
    });
    // 重置二维码按钮
    $("#resetqrcode").click(function () {
        _this.updateQrCode();
    });
    // 重置密码按钮
    $("#resetpwd").click(function () {
        _this.updatePassWord();
    });
    // 删除按钮
    $("#delete").click(function () {
        _this.delete();
    });
    // 恢复按钮
    $("#recover").click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#forEver").click(function () {
        _this.forEver();
    });
    $("#push").click(function () {
        _this.push();
    });
    $("#import").click(function () {
        _this.import();
    });
    $("#importWangYi").click(function () {
    	_this.importWangYi();
    });
    $("#export").click(function () {
        _this.export();
    });
    // 激活按钮
    $("#invoke").click(function () {
    	_this.invoke();
    });
    // 今天
    $("#today").click(function () {
    	timeMaxMin($(this));
    	_this.query();
    });
    // 昨天
    $("#yesterday").click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本周
    $("#thisWeek").click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本月
    $("#thisMonth").click(function () {
    	timeMaxMin($(this));
        _this.query();
    });

    /* 用户dialog */
    // 确定按钮
    $("#userDetailVoDlgBtn a").eq(0).click(function() {
        $("#userDetailVoDlgBtn a").linkbutton('disable');
        $('#userDetailVoFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                var ss = _this.valid() && $(this).form('validate');
                return ss;
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#userDetailVoDlg').dialog('close');
                    $('#userDetailVoDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
                $('#userDetailVoDlgBtn a').linkbutton('enable');
            }
        });
    });
    // 取消按钮
    $("#userDetailVoDlgBtn a").eq(1).click(function() {
        $('#userDetailVoDlg').dialog('close');
    });
    // 关闭按钮
    $("#userImgBtn a").eq(0).click(function() {
    	_this.clearImg();
        $('#userImg').dialog('close');
    });
    /* 导入dialog */
    // 确定按钮
    $("#uploadWYDlgBtn a").eq(0).click(function() {
        $.messager.progress();
        $('#uploadWYFm').form('submit', {
            url: "/userDetail/importWY",
            onSubmit: function() {
                var isValid = $(this).form('validate');
                if (!isValid){
                    $.messager.progress('close');	// hide progress bar while the form is invalid
                }
                return isValid;
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                $.messager.progress('close');
                if (data.code === 1) {
                    $('#uploadWYDlg').dialog('close');
                    $('#userDetailVoDg').datagrid('reload');
                }
                $.messager.show({
                    width: 300,
                    height: 500,
                    title: '系统提示',
                    timeout:5000,
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#uploadWYDlgBtn a").eq(1).click(function() {
        $('#uploadWYDlg').dialog('close');
    });

    /* 推送dialog */
    // 确定按钮
    $("#pushDlgBtn a").eq(0).click(function() {
        $.messager.progress();
        $.post('/push/user', {
            user_ids: $('#idstr').val(),
            content: $('#pushContent').val()
        }, function (data) {
            if (data.code === 1) {
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            } else {
                $.messager.show({
                    title: '系统错误',
                    msg: data.msg
                });
            }
            $.messager.progress('close');
            $('#pushDlg').dialog('close');
        }, 'json');
    });

    // 取消按钮
    $("#pushDlgBtn a").eq(1).click(function() {
        $('#pushDlg').dialog('close');
    });



};

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
	$('#startParam').val( min );//必须用id才行
	$('#endParam').val( max );//必须用id才行
	$('#startParam').datetimebox('setValue' , min );//必须用id才行
 	$('#endParam').datetimebox('setValue' , max );//必须用id才行
		
};

var fillZero = function(n){
	if(n<10){
		return '0'+n;
	}else{
		return n;
	}
};

UserDetailVo.prototype.showBtn = function(btn_id_strings) {
    if(btn_id_strings && menu_id){
        $.ajax({
            url: '../btn/show',
            dataType: 'json',
            data: $.param({
                btn_ids: btn_id_strings,
                menu_id: menu_id
            }),
            type: 'post',
            async: false,
            complete: function (xhr, textStatus) {
            },
            success: function (data, textStatus, xhr) {
                var html = template.render('btn_tmpl', data);
                $(' #btnList ').html(html);
            },
            error: function (xhr, textStatus, errorThrown) {
                $(' #btnList ').html('按钮加载出错');
            }
        });
    }else{
        alert("按钮加载出错，无效按钮权限");
    }
};

UserDetailVo.prototype.clearImg = function() {
	$('#img').empty();
};


UserDetailVo.prototype.is_checkFormatter = function(value,row,index){
	var is_check = row.is_check;
    switch (is_check) {
        case 1:
            return '√';
        case 0:
            return 'X';
        default :
            return '';
    }
}

UserDetailVo.prototype.onClickRow = function(index,row){
    /*if (row.is_check == 0){
        $('#userDetailVoDg').datagrid('unselectRow', index);
        $('#userDetailVoDg').datagrid('uncheckRow', index);
    }*/
};

UserDetailVo.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};

UserDetailVo.prototype.usernameFormatter = function(value,row,index){
    var username = row.username;
    if (username)
    	username = username.substr(0,3) + "*****" + username.substr(8, username.length);
    return username;
};
UserDetailVo.prototype.id_codeFormatter = function(value,row,index){
    var id_code = row.id_code;
    if (id_code)
    	id_code = id_code.substr(0,6) + "*****" + id_code.substr(14, id_code.length);
    return id_code;
};
$(function(){
    window.userDetailVo = new UserDetailVo();
    userDetailVo.init();
});