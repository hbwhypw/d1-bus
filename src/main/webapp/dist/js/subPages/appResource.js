var AppResource = function(){};
AppResource.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    this.bind();
};
AppResource.prototype.add = function() {
    $("#appResourceDlg").dialog("open").dialog("setTitle", "添加资源信息");
    var _this = this;
    $('#appResourceFm').form('clear');
    _this.url = '/appResource/add';
};
AppResource.prototype.update = function() {
    var _this = this;
    var row = $('#appResourceDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $("#appResourceDlg").dialog("open").dialog("setTitle", "修改资源信息");
        $('#appResourceFm').form('load', row);
        _this.url = '/appResource/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

AppResource.prototype.delete = function() {
    var row = $('#appResourceDg').datagrid('getChecked');
    if (row) {
    	var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
    	$.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/appResource/delete', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#appResourceDg').datagrid('reload');
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

AppResource.prototype.forEver = function() {
    var row = $('#appResourceDg').datagrid('getChecked');
    if (row) {
    	var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/appResource/forEver', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#appResourceDg').datagrid('reload');
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

AppResource.prototype.query = function() {
    this.checkInput('nameParam',this.INPUT);
    this.checkInput('urlParam',this.INPUT);
    this.checkInput('is_checkParam',this.SELCET);
    $('#appResourceDg').datagrid('queryReload');
};

AppResource.prototype.recover = function() {
	var row = $('#appResourceDg').datagrid('getChecked');
	if (row) {
		var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
		$.post('/appResource/updateRecover', {
			ids: ids.toString()
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#appResourceDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }

}

AppResource.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#appResourceDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#appResourceDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

AppResource.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#appResourceDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#appResourcenameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 添加按钮
    $("#appResourceDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    // 修改按钮
    $("#appResourceDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#appResourceDgTbar table tbody tr td a").eq(3).click(function () {
        _this.delete();
    });
    // 恢复按钮
    $("#appResourceDgTbar table tbody tr td a").eq(4).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#appResourceDgTbar table tbody tr td a").eq(5).click(function () {
        _this.forEver();
    });

    /* 用户dialog */
    // 确定按钮
    $("#appResourceDlgBtn a").eq(0).click(function() {
        $('#appResourceFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#appResourceDlg').dialog('close');
                    $('#appResourceDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#appResourceDlgBtn a").eq(1).click(function() {
        $('#appResourceDlg').dialog('close');
    });
    // 关闭按钮
    $("#appResourceImgBtn a").eq(0).click(function() {
    	_this.clearImg();
        $('#appResourceImg').dialog('close');
    });
};

AppResource.prototype.clearImg = function() {
	$('#img').empty();
};

AppResource.prototype.is_checkFormatter = function(value,row,index){
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

AppResource.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};

$(function(){
    window.appResource = new AppResource();
    appResource.init();
});