var LineApplyVo = function(){};
LineApplyVo.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    this.bind();
};
LineApplyVo.prototype.update = function() {
    var _this = this;
    var row = $('#lineApplyVoDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $("#lineApplyVoDlg").dialog("open").dialog("setTitle", "修改申请线路信息");
        $('#lineApplyVoFm').form('load', row);
        _this.url = '/lineApply/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

LineApplyVo.prototype.delete = function() {
    var row = $('#lineApplyVoDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/lineApply/delete', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#lineApplyVoDg').datagrid('reload');
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

LineApplyVo.prototype.forEver = function() {
    var row = $('#lineApplyVoDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/lineApply/forEver', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#lineApplyVoDg').datagrid('reload');
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

LineApplyVo.prototype.query = function() {
    this.checkInput('city_idParam',this.COBOBOX);
    this.checkInput('is_checkParam',this.SELCET);
    $('#lineApplyVoDg').datagrid('queryReload');
};

LineApplyVo.prototype.recover = function() {
	var row = $('#lineApplyVoDg').datagrid('getSelected');
	if (row) {
		$.post('/lineApply/updateRecover', {
			"id": row.id
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#lineApplyVoDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }

}

LineApplyVo.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#lineApplyVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#lineApplyVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

LineApplyVo.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#lineApplyVoDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#lineApplyVonameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 修改按钮
    $("#lineApplyVoDgTbar table tbody tr td a").eq(1).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#lineApplyVoDgTbar table tbody tr td a").eq(2).click(function () {
        _this.delete();
    });
    // 恢复按钮
    $("#lineApplyVoDgTbar table tbody tr td a").eq(3).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#lineApplyVoDgTbar table tbody tr td a").eq(4).click(function () {
        _this.forEver();
    });

    /* 用户dialog */
    // 确定按钮
    $("#lineApplyVoDlgBtn a").eq(0).click(function() {
        $('#lineApplyVoFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#lineApplyVoDlg').dialog('close');
                    $('#lineApplyVoDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#lineApplyVoDlgBtn a").eq(1).click(function() {
        $('#lineApplyVoDlg').dialog('close');
    });
    // 关闭按钮
    $("#lineApplyVoImgBtn a").eq(0).click(function() {
    	_this.clearImg();
        $('#lineApplyVoImg').dialog('close');
    });
};

LineApplyVo.prototype.is_checkFormatter = function(value,row,index){
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
LineApplyVo.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};
$(function(){
    window.lineApplyVo = new LineApplyVo();
    lineApplyVo.init();
});