/**
 * Created by hbwhypw on 2015/8/21.
 */
var Resource = function () {
};
Resource.prototype.init = function () {
    this.url = "";
    this.bind();
};

Resource.prototype.add = function () {
    var _this = this;
    $("#resourceDlg").dialog("open").dialog("setTitle", "添加资源");
    $('#resourceFm').form('clear');
    $("#is_root option:first").prop("selected", 'selected');
    $("#is_check option:first").prop("selected", 'selected');
    $('#parent').combobox('reload');
    _this.url = '/resource/add';
};

Resource.prototype.update = function () {
    var _this = this;
    var row = $('#resourceDg').treegrid('getSelected');
    if (row) {
        $("#resourceDlg").dialog("open").dialog("setTitle", "修改资源");
        $('#resourceFm').form('load', row);
        $('#parent').combobox('reload');
        _this.url = '/resource/update';
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Resource.prototype.delete = function () {
    var row = $('#resourceDg').treegrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/resource/delete', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#resourceDg').treegrid('reload');
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

Resource.prototype.reset = function () {
    var row = $('#resourceDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定重置' + row.username + '的密码？', function (r) {
            if (r) {
                $.post('/resource/reset', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#resourceDg').treegrid('reload');
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

Resource.prototype.query = function () {
    $('#resourceDg').treegrid('reload');
};

// TODO 未完成 查看菜单
Resource.prototype.menu = function () {
    $('#menuWin').window('open').window("setTitle","查看菜单");
    var data = {"total":19,"rows":
        [
            {"id":"648690234002907136","name":"线路管理","url":"/line","parent":null,"is_root":1,"remark":"test","is_check":1,
            "children":[
                {"id":"652754547642605568","name":"线路管理","url":"/line","parent":"648690234002907136","is_root":0,"remark":"","is_check":1},
                {"id":"652754649736159232","name":"站点管理","url":"/linestation","parent":"648690234002907136","is_root":0,"remark":"站点管理","is_check":1},
                {"id":"652757149298073600","name":"线路时刻管理","url":"/linetime","parent":"648690234002907136","is_root":0,"remark":"","is_check":1}
            ]},
            {"id":"649050384765165568","name":"系统管理","url":"/system","parent":null,"is_root":1,"remark":"","is_check":1,
            "children":[
                {"id":"652778335608381440","name":"版本管理","url":"/version","parent":"649050384765165568","is_root":0,"remark":"","is_check":1},
                {"id":"662454063086051328","name":"管理员管理","url":"/admins","parent":"649050384765165568","is_root":0,"remark":"","is_check":1},
                {"id":"662454773118803968","name":"角色管理","url":"/role","parent":"649050384765165568","is_root":0,"remark":"","is_check":1},
                {"id":"662454875132665856","name":"资源管理","url":"/resource","parent":"649050384765165568","is_root":0,"remark":"","is_check":1},
                {"id":"662454945752162304","name":"日志管理","url":"/log","parent":"649050384765165568","is_root":0,"remark":"","is_check":1}
            ]},{"id":"649050520870330368","name":"商城管理","url":"/shop","parent":null,"is_root":1,"remark":"","is_check":1,"children":[{"id":"662451322955636736","name":"商品管理","url":"/product","parent":"649050520870330368","is_root":0,"remark":"","is_check":1},{"id":"662451844014022656","name":"积分订单管理","url":"/expOrder","parent":"649050520870330368","is_root":0,"remark":"","is_check":1},{"id":"662451936074801152","name":"商城订单管理","url":"/shopOrder","parent":"649050520870330368","is_root":0,"remark":"","is_check":1}]},{"id":"652775900387090432","name":"基础信息管理","url":"/base","parent":null,"is_root":1,"remark":"","is_check":1,"children":[{"id":"649050629980954624","name":"用户管理","url":"/user","parent":"652775900387090432","is_root":0,"remark":"","is_check":1},{"id":"662450864828588032","name":"公司管理","url":"/company","parent":"652775900387090432","is_root":0,"remark":"","is_check":1},{"id":"662452313541189632","name":"司机管理","url":"/driver","parent":"652775900387090432","is_root":0,"remark":"","is_check":1},{"id":"662453215471738880","name":"车辆管理","url":"/car","parent":"652775900387090432","is_root":0,"remark":"","is_check":1}]}],"code":1}
    var html = template.render('menus', data);
    $(' #menu ').html(html);
};

Resource.prototype.bind = function () {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#resourceDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#nameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });
    //	添加按钮
    $("#resourceDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#resourceDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#resourceDgTbar table tbody tr td a").eq(3).click(function () {
        _this.delete();
    });
    $("#resourceDgTbar table tbody tr td a").eq(4).click(function () {
        _this.menu();
    });
    /* dialog */
    // 确定按钮
    $("#resourceDlgBtn a").eq(0).click(function () {
        $('#resourceFm').form('submit', {
            url: _this.url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#resourceDlg').dialog('close');
                    $('#resourceDg').treegrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#resourceDlgBtn a").eq(1).click(function () {
        $('#resourceDlg').dialog('close');
    })

    $('#is_root').on('change', function(){
        if($("#is_root option:selected").val() == 1){
            $('#parent').combobox('disable');
        } else {
            $('#parent').combobox("enable");
        }
    });
};

Resource.prototype.is_rootFormatter = function(value, row, index) {
    var is_root = row.is_root;
    switch (is_root) {
        case 1:
            return '√';
        case 0:
            return 'X';
        default :
            return '';
    }
};

$(function () {
    window.resource = new Resource();
    resource.init();
});