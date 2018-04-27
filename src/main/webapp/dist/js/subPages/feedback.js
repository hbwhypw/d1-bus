var FeedbackVo = function(){};
FeedbackVo.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    this.bind();
};
FeedbackVo.prototype.add = function() {
    $("#feedbackVoDlg").dialog("open").dialog("setTitle", "添加消息反馈信息");
    var _this = this;
    $('#feedbackVoFm').form('clear');
    _this.url = '/feedback/add';
    $('#feedbackVoDg').datagrid('reload');
};
FeedbackVo.prototype.update = function() {
    var _this = this;
    var row = $('#feedbackVoDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $("#feedbackVoDlg").dialog("open").dialog("setTitle", "修改消息反馈信息");
        $('#feedbackVoFm').form('load', row);
        _this.url = '/feedback/update';
        $('#feedbackVoDg').datagrid('reload');
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

FeedbackVo.prototype.delete = function() {
    var row = $('#feedbackVoDg').datagrid('getChecked');
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
                $.post('/feedback/delete', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#feedbackVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#feedbackVoDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

FeedbackVo.prototype.forEver = function() {
    var row = $('#feedbackVoDg').datagrid('getChecked');
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
                $.post('/feedback/forEver', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#feedbackVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#feedbackVoDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

FeedbackVo.prototype.query = function() {
    this.checkInput('realnameParam',this.INPUT);
    this.checkInput('is_handleParam',this.SELCET);
    $('#feedbackVoDg').datagrid('queryReload');
};

FeedbackVo.prototype.recover = function() {
	var row = $('#feedbackVoDg').datagrid('getChecked');
	if (row) {
		var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
		$.post('/feedback/updateRecover', {
			ids: ids.toString()
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#feedbackVoDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }

}

FeedbackVo.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#feedbackVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#feedbackVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

FeedbackVo.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#feedbackVoDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#feedbackVonameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 修改按钮
    $("#feedbackVoDgTbar table tbody tr td a").eq(1).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#feedbackVoDgTbar table tbody tr td a").eq(2).click(function () {
        _this.delete();
    });
    // 恢复按钮
    $("#feedbackVoDgTbar table tbody tr td a").eq(3).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#feedbackVoDgTbar table tbody tr td a").eq(4).click(function () {
        _this.forEver();
    });

    /* 用户dialog */
    // 确定按钮
    $("#feedbackVoDlgBtn a").eq(0).click(function() {
        $('#feedbackVoFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#feedbackVoDlg').dialog('close');
                    $('#feedbackVoDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#feedbackVoDlgBtn a").eq(1).click(function() {
        $('#feedbackVoDlg').dialog('close');
    });

};
FeedbackVo.prototype.is_checkFormatter = function(value,row,index){
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
FeedbackVo.prototype.is_handleFormatter = function(value,row,index){
	var is_handle = row.is_handle;
    switch (is_handle) {
        case 1:
            return '已处理';
        case 0:
            return '未处理';
        default :
            return '';
    }
}
FeedbackVo.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};
$(function(){
    window.feedbackVo = new FeedbackVo();
    feedbackVo.init();
});