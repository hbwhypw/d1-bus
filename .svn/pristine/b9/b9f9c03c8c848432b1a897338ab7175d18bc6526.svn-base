var Dictionary = function(){};
Dictionary.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    this.bind();
};

Dictionary.prototype.add = function() {
    var _this = this;
    $("#dictionaryDlg").dialog("open").dialog("setTitle", "添加字典父节点信息");
    $('#dictionaryFmRoot').form('clear');
    _this.url = '/dictionary/add';
    $('#dictionaryDg').treegrid('queryReload');
};

Dictionary.prototype.addsub = function() {
    var _this = this;
    $("#dictionaryDlg2").dialog("open").dialog("setTitle", "添加字典子节点信息");
    $('#dictionaryFmSub').form('clear');
    _this.url = '/dictionary/addsub';
    $('#dictionaryDg').treegrid('queryReload');
    
};

Dictionary.prototype.update = function() {
    var _this = this;
    var row = $('#dictionaryDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_available){
    		$.messager.show({
                title: '系统提示',
                msg: '此项不可操作'
            });
        	return;
        }
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
        	return;
        }
    	$("#dictionaryDlg").dialog("open").dialog("setTitle", "修改字典信息");
        $('#dictionaryFmRoot').form('load', row);
        _this.url = '/dictionary/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
    $('#dictionaryDg').treegrid('queryReload');
};

Dictionary.prototype._delete = function() {
    var row = $('#dictionaryDg').treegrid('getSelected');
    if (row) {
    	if(0==row.is_available){
    		$.messager.show({
                title: '系统提示',
                msg: '此项不可操作'
            });
    		return;
    	}
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/dictionary/delete', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#dictionaryDg').treegrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#dictionaryDg').treegrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Dictionary.prototype.forEver = function() {
    var row = $('#dictionaryDg').treegrid('getSelected');
    if (row) {
    	if(0==row.is_available){
    		$.messager.show({
                title: '系统提示',
                msg: '此项不可操作'
            });
    		return;
    	}
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/dictionary/forEver', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#dictionaryDg').treegrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#dictionaryDg').treegrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }

}

Dictionary.prototype.recover = function() {
	var row = $('#dictionaryDg').datagrid('getSelected');
	if (row) {
		$.post('/dictionary/updateRecover', {
			"id": row.id
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#dictionaryDg').treegrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }

}

Dictionary.prototype.checkInput = function(paramName,formType) {
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
    debugger;
    if (param != "") {
        var queryParams = $('#dictionaryDg').treegrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#dictionaryDg').treegrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Dictionary.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    $("#usernameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    //	添加父节点按钮
    $("#dictionaryDgTbar table tbody tr td a").eq(0).click(function () {
        _this.add();
    });
    //	添加子节点按钮
    $("#dictionaryDgTbar table tbody tr td a").eq(1).click(function () {
        _this.addsub();
    });
    //	修改按钮
    $("#dictionaryDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#dictionaryDgTbar table tbody tr td a").eq(3).click(function () {
        _this._delete();
    });
    // 恢复按钮
    $("#dictionaryDgTbar table tbody tr td a").eq(4).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#dictionaryDgTbar table tbody tr td a").eq().click(function () {
        _this.forEver();
    });
    
    /* 用户dialog */
    // 确定按钮
    $("#dictionaryDlgBtn a").eq(0).click(function() {
        $('#dictionaryFmRoot').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                	$('#dictionaryDg').treegrid('reload');
                    $('#dictionaryDlg').dialog('close');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#dictionaryDlgBtn a").eq(1).click(function() {
        $('#dictionaryDlg').dialog('close');
    });
    
    /* 用户dialog */
    // 确定按钮
    $("#dictionaryDlgBtn2 a").eq(0).click(function() {
        $('#dictionaryFmSub').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                	$('#dictionaryDg').treegrid('reload');
                    $('#dictionaryDlg2').dialog('close');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#dictionaryDlgBtn2 a").eq(1).click(function() {
        $('#dictionaryDlg2').dialog('close');
    });
};

Dictionary.prototype.is_subFormatter = function(value,row,index){
    var is_sub = row.is_sub;
    switch (is_sub) {
        case 1:
            return '√';
        case 0:
            return 'X';
        default :
            return '';
    }
};
Dictionary.prototype.is_availableFormatter = function(value,row,index){
    var is_available = row.is_available;
    switch (is_available) {
        case 1:
            return '√';
        case 0:
            return 'X';
        default :
            return '';
    }
};
Dictionary.prototype.is_checkFormatter = function(value,row,index){
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
Dictionary.prototype.phoneFormatter = function(value,row,index){
    var phone = row.phone;
    if (phone)
        phone = phone.substr(0,3) + "*****" + phone.substr(8, phone.length);
    return phone;
};
$(function(){
    window.dictionary = new Dictionary();
    dictionary.init();
});