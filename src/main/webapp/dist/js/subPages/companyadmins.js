/**
 * Created by hbwhypw on 2015/8/21.
 */
var Admins = function () {
};
Admins.prototype.init = function () {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.bind();
};

Admins.prototype.add = function () {
    var _this = this;
    $("#adminsDlg").dialog("open").dialog("setTitle", "添加集团管理员");
    $('#adminsFm').form('clear');
    $("#is_check option:first").prop("selected", 'selected');
    _this.url = '/admins/company/add';
};

Admins.prototype.update = function () {
    var _this = this;
    var row = $('#adminsDg').datagrid('getSelected');
    if (row) {
        $("#adminsDlg").dialog("open").dialog("setTitle", "修改集团管理员");
        $('#adminsFm').form('load', row);
        _this.url = '/admins/company/update';
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Admins.prototype.delete = function () {
    var row = $('#adminsDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/admins/delete', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#adminsDg').datagrid('reload');
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
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Admins.prototype.reset = function () {
    var row = $('#adminsDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定重置' + row.username + '的密码？', function (r) {
            if (r) {
                $.post('/admins/reset', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#adminsDg').datagrid('reload');
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
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Admins.prototype.query = function () {
    this.checkInput('usernameParam',this.INPUT);
    this.checkInput('user_typeParam',this.SELCET);
    $('#adminsDg').datagrid('queryReload');
};

Admins.prototype.checkInput = function(paramName,formType) {
    var param;
    debugger;
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
        var queryParams = $('#adminsDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#adminsDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Admins.prototype.bind = function () {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#adminsDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#adminsnameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });
    //	添加按钮
    $("#adminsDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#adminsDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#adminsDgTbar table tbody tr td a").eq(3).click(function () {
        _this.delete();
    });
    // 重置按钮
    $("#adminsDgTbar table tbody tr td a").eq(4).click(function () {
        _this.reset();
    });

    /* dialog */
    // 确定按钮
    $("#adminsDlgBtn a").eq(0).click(function () {
        $('#adminsFm').form('submit', {
            url: _this.url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = $.parseJSON(data);
                if (data.code === 1) {
                    $('#adminsDlg').dialog('close');
                    $('#adminsDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#adminsDlgBtn a").eq(1).click(function () {
        $('#adminsDlg').dialog('close');
    })
};

Admins.prototype.roleFormatter = function (value, row, index) {
    var user_typeFormatter = row.user_type;
    switch (user_typeFormatter) {
        case 1:
            return '超级集团管理员';
        case 2:
            return '用户集团管理员';
        case 3:
            return '统计集团管理员';
        default :
            return '';
    }
};


$(function () {
    window.admins = new Admins();
    admins.init();
});