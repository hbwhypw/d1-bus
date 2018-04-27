/**
 * Created by hbwhypw on 2015/8/21.
 */
var User = function(){};
User.prototype.init = function() {
    this.url = "";
    this.exportParam = {};
    this.bind();
};

User.prototype.add = function() {
    var _this = this;
    $("#userDlg").dialog("open").dialog("setTitle", "添加用户");
    $('#userFm').form('clear');
    _this.url = '/user/add';
};

User.prototype.update = function() {
    var _this = this;
    var row = $('#userDg').datagrid('getSelected');
    if (row) {
        $("#userDlg").dialog("open").dialog("setTitle", "修改用户");
        $('#userFm').form('load', row);
        $('#birthday').val(_this.birthdayFormatter('',row));
        _this.url = '/user/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

User.prototype.delete = function() {
    var row = $('#userDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/user/delete', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#userDg').datagrid('reload');
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

User.prototype.query = function() {
    this.checkInput('usernameParam',this.INPUT);
    this.checkInput('real_nameParam',this.INPUT);
    this.checkInput('genderParam',this.SELCET);
    $('#userDg').datagrid('queryReload');
};

User.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#userDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#userDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

User.prototype.addExportParam = function(paramKey,paramValue){
    var param = this.exportParam;
    param[paramKey] = '';
    if(paramValue != ""){
        param[paramKey] = paramValue;
    } else {
        delete param[paramKey];
    }
};

User.prototype.export = function() {
    this.addExportParam("username", $('#usernameParam').val());
    this.addExportParam("real_name", $('#real_nameParam').val());
    this.addExportParam("gender", $('#genderParam').find('option:selected').val());
    var param = $.param(this.exportParam);
    var win = window.open("/user/export?"+param,"_blank_");
    win.charset = "UTF-8";
    //document.location.href = './../user/export?real_name='+ escape('杨');
};

User.prototype.import = function() {
    $("#uploadDlg").dialog("open").dialog("setTitle", "导入Excel");
    $("#uploadFm").get(0).reset();
    var file = $(":file");
    file.after(file.clone().val(""));
    file.remove();
};

User.prototype.push = function() {
    var rows =  $('#userDg').datagrid('getChecked');
    if (rows.length == 0) {
        $.messager.alert('警告','请至少勾选一项！','warning');
    } else {
        $("#pushDlg").dialog("open").dialog("setTitle", "推送");
        var idstr = '';
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].id) {
                if (i == 0) {
                    idstr += rows[i].id;
                } else {
                    idstr += rows[i].id + ',';
                }
            } else {
                $.messager.alert('警告','数据错误，用户名为：'+rows.username+'的用户编号不存在！','warning');
            }
        }
        $('#idstr').val(idstr);
    }
};

User.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#userDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#usernameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    //	导出按钮
    $("#userDgTbar table tbody tr td a").eq(1).click(function () {
        _this.export();
    });
    //	导入按钮
    $("#userDgTbar table tbody tr td a").eq(2).click(function () {
        _this.import();
    });
    //	推送按钮
    $("#userDgTbar table tbody tr td a").eq(3).click(function () {
        _this.push();
    });
    //	添加按钮
    $("#userDgTbar table tbody tr td a").eq(4).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#userDgTbar table tbody tr td a").eq(5).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#userDgTbar table tbody tr td a").eq(6).click(function () {
        _this.delete();
    });

    /* 用户dialog */
    // 确定按钮
    $("#userDlgBtn a").eq(0).click(function() {
        $('#userFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#userDlg').dialog('close');
                    $('#userDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#userDlgBtn a").eq(1).click(function() {
        $('#userDlg').dialog('close');
    });

    /* 导入dialog */
    // 确定按钮
    $("#uploadDlgBtn a").eq(0).click(function() {
        $.messager.progress();
        $('#uploadFm').form('submit', {
            url: "./../user/importdata",
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
                    $('#uploadDlg').dialog('close');
                    $('#userDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#uploadDlgBtn a").eq(1).click(function() {
        $('#uploadDlg').dialog('close');
    });
    /* 推送dialog */
    // 确定按钮
    $("#pushDlgBtn a").eq(0).click(function() {
        $.messager.progress();
        $('#pushFm').form('submit', {
            url: "./../user/push",
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
    $("#pushDlgBtn a").eq(1).click(function() {
        $('#pushDlg').dialog('close');
    })
};

User.prototype.genderFormatter = function(value,row,index){
    var gender = row.gender;
    switch (gender) {
        case 1:
            return '男';
        case 2:
            return '女';
        case 3:
            return '保密';
        default :
            return '';
    }
};
User.prototype.phoneFormatter = function(value,row,index){
    var phone = row.phone;
    if (phone)
        phone = phone.substr(0,3) + "*****" + phone.substr(8, phone.length);
    return phone;
};
User.prototype.birthdayFormatter = function(value,row,index){
    var birthday = row.birthday;
    if(birthday)
        birthday = birthday.substr(0,10);
    return birthday;
};

$(function(){
    window.user = new User();
    user.init();
});