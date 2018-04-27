var Version = function(){};
Version.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

Version.prototype.add = function() {
    var _this = this;
    $("#versionDlg").dialog("open").dialog("setTitle", "添加聊天房间");
    $('#versionFm').form('clear');
    _this.url = '/version/add';
};
Version.prototype.update = function() {
    var _this = this;
    var row = $('#versionDg').datagrid('getSelected');
    if (row) {
        $("#versionDlg").dialog("open").dialog("setTitle", "修改聊天房间");
        $('#versionFm').form('load', row);
        _this.url = '/version/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Version.prototype.query = function() {
    this.checkInput('versionParam',this.INPUT);
    $('#versionDg').datagrid('queryReload');
};

Version.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#versionDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#versionDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Version.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#versionDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#versionnameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    //	添加按钮
    $("#versionDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#versionDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });

    /* 聊天dialog */
    // 确定按钮
    $("#versionDlgBtn a").eq(0).click(function() {
        $('#versionFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#versionDlg').dialog('close');
                    $('#versionDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#versionDlgBtn a").eq(1).click(function() {
        $('#versionDlg').dialog('close');
    });
};
Version.prototype.is_checkFormatter = function(value,row,index){
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
$(function(){
    window.version = new Version();
    version.init();
});