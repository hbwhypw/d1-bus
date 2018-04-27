/**
 * Created by hbwhypw on 2015/8/21.
 */
var Btn = function () {
};
Btn.prototype.init = function () {
    this.url = "";
    this.bind();
};

Btn.prototype.add = function () {
    var _this = this;
    $("#btnDlg").dialog("open").dialog("setTitle", "添加按钮");
    $('#btnFm').form('clear');
    $("#user_type option:first").prop("selected", 'selected');
    _this.url = '/btn/add';
};

Btn.prototype.update = function () {
    var _this = this;
    var row = $('#btnDg').datagrid('getSelected');
    if (row) {
        $("#btnDlg").dialog("open").dialog("setTitle", "修改按钮");
        $('#btnFm').form('load', row);
        _this.url = '/btn/update';
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Btn.prototype.delete = function () {
    var row = $('#btnDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/btn/delete', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#btnDg').datagrid('reload');
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

Btn.prototype.query = function () {
    this.checkInput('nameParam',this.INPUT);
    this.checkInput('btn_typeParam',this.SELCET);
    $('#btnDg').datagrid('queryReload');
};

Btn.prototype.loadBtnPermission = function() {
    $.ajax({
        url: '../btn/query',
        dataType: 'json',
        complete: function(xhr, textStatus) {
        },
        success: function(data, textStatus, xhr) {
            var html = template.render('fieldset_tmpl', data);
            $(' #btnPermission ').html(html);
        },
        error: function(xhr, textStatus, errorThrown) {
        }
    });
};

Btn.prototype.setBtnPermission = function() {

};

Btn.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#btnDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#btnDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Btn.prototype.bind = function () {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#btnDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#btnnameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });
    //	添加按钮
    $("#btnDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#btnDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#btnDgTbar table tbody tr td a").eq(3).click(function () {
        _this.delete();
    });

    /* btn dialog */
    // 确定按钮
    $("#btnDlgBtn a").eq(0).click(function () {
        $('#btnFm').form('submit', {
            url: _this.url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#btnDlg').dialog('close');
                    $('#btnDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#btnDlgBtn a").eq(1).click(function () {
        $('#btnDlg').dialog('close');
    });
};

Btn.prototype.btnFormatter = function (value, row, index) {
    var user_typeFormatter = row.user_type;
    switch (user_typeFormatter) {
        case 1:
            return '超级按钮';
        case 2:
            return '用户按钮';
        case 3:
            return '统计按钮';
        default :
            return '';
    }
};


$(function () {
    window.btn = new Btn();
    btn.init();
});