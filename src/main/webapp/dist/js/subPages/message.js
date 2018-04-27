var Message = function () {
};
Message.prototype.init = function () {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

Message.prototype.add = function () {
    var _this = this;
    $("#messageDlg").dialog("open").dialog("setTitle", "添加消息");
    $('#messageFm').form('clear');
    _this.url = '/message/add';
    $('#messageDg').datagrid('reload');
};
Message.prototype.update = function () {
    var _this = this;
    var row = $('#messageDg').datagrid('getSelected');
    if (row) {
        $("#messageDlg").dialog("open").dialog("setTitle", "修改消息");
        $('#messageFm').form('load', row);
        _this.url = '/message/update';
        $('#messageDg').datagrid('reload');
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Message.prototype.delete = function () {
    var row = $('#messageDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/message/delete', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#messageDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#dictionaryDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Message.prototype.query = function () {
    this.checkInput('titleParam', this.INPUT);
    this.checkInput('typeParam', this.COMBOBOX);
    $('#messageDg').datagrid('queryReload');
};

Message.prototype.record = function () {
    var row = $('#messageDg').datagrid('getSelected');
    if (row) {
        $('#recordDg').datagrid({
            url: './../messageRecord/selectById',
            onBeforeLoad: function (param) {
                param.id = row.id;
            }
        });
        $('#recordDg').datagrid('queryReload');
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
    $("#messageRecord").dialog("open").dialog("setTitle", "消息记录");
}

Message.prototype.push = function () {
    var row = $('#messageDg').datagrid('getSelected');
    if (row) {
        $("#pushDlg").dialog("open").dialog("setTitle", "推送广播消息");
        $('#pushFm').form('load', {message_id: row.id});
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Message.prototype.checkInput = function (paramName, formType) {
    var param;
    switch (formType) {
        case 0:
            param = $('#' + paramName).val();
            break;
        case 1:
            param = $('#' + paramName + ' option:selected').val();
            break;
        case 2:
            param = $('#' + paramName).combobox('getValue');
            break;
        default :
            param = $('#' + paramName).val();
    }
    var requestParam = paramName.substring(0, paramName.indexOf("P"));
    if (param != "") {
        var queryParams = $('#messageDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#messageDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Message.prototype.bind = function () {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#query").click(function () {
        _this.query();
    });
    $("#messagenameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    $("#push").click(function () {
        _this.push();
    });
    //	消息记录按钮
    $("#show").click(function () {
        _this.record();
    });
    //	添加按钮
    $("#add").click(function () {
        _this.add();
    });
    //	修改按钮
    $("#update").click(function () {
        _this.update();
    });
    // 删除按钮
    $("#delete").click(function () {
        _this.delete();
    });

    /* 消息dialog */
    // 确定按钮
    $("#messageDlgBtn a").eq(0).click(function () {
        $('#messageFm').form('submit', {
            url: _this.url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#messageDlg').dialog('close');
                    $('#messageDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#messageDlgBtn a").eq(1).click(function () {
        $('#messageDlg').dialog('close');
    });
    // 关闭按钮
    $("#messageRecordBtn a").eq(0).click(function () {
        _this.clear();
        $('#messageRecord').dialog('close');
    });
    /* 推送dialog */
    // 确定按钮
    $('#pushDlgBtn a').eq(0).click(function(){
        $('#pushFm').form('submit', {
            url: "/push/send",
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#pushDlg').dialog('close');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });

    // 取消按钮
    $("#pushDlgBtn a").eq(1).click(function () {
        $('#pushDlg').dialog('close');
    });
};

Message.prototype.clear = function () {
    $('#recordDg').empty();
}
Message.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};
$(function () {
    window.message = new Message();
    message.init();
});