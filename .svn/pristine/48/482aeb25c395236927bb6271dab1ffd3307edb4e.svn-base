/**
 * Created by hbwhypw on 2015/10/22.
 */
var Log = function () {
};
Log.prototype.init = function () {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.bind();
};

Log.prototype.delete = function () {
    var row = $('#logDg').datagrid('getChecked');
    if (row) {
        var ids = [];
        if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        $.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/log/delete', {
                    ids: ids.toString()
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#logDg').datagrid('reload');
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
        $.messager.alert('警告', '请至少选择一项！', 'warning');
    }
};


Log.prototype.query = function () {
    this.checkInput('descriptionParam',this.INPUT);
    this.checkInput('nameParam',this.SELCET);
    $('#logDg').datagrid('queryReload');
};

Log.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#logDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#logDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Log.prototype.bind = function () {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#search").on("click",function(){
        _this.query();
    });
    $("#lognameParam").on("keyup",function (event) {
        if (event.keyCode == 13) _this.query();
    });
    // 删除按钮
    $("#del").on("click",function () {
        _this.delete();
    });

    /* dialog */
    // 确定按钮
    $("#logDlgBtn a").eq(0).click(function () {
        $('#logFm').form('submit', {
            url: _this.url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#logDlg').dialog('close');
                    $('#logDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#logDlgBtn a").eq(1).click(function () {
        $('#logDlg').dialog('close');
    })
};

Log.prototype.typeFormatter = function (value, row, index) {
    var type = row.type;
    switch (type) {
        case 0:
            return '控制层日志';
        case 1:
            return '服务层日志';
        default :
            return '';
    }
};


$(function () {
    window.log = new Log();
    log.init();
});