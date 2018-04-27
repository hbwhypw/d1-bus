/**
 * Created by hbwhypw on 2015/8/21.
 */
var Role = function () {
};
Role.prototype.init = function () {
    this.url = "";
    this.bind();
};

Role.prototype.add = function () {
    var _this = this;
    $("#roleDlg").dialog("open").dialog("setTitle", "添加角色");
    $('#roleFm').form('clear');
    $('#roleResourceTree').tree({
        url:'./../role/tree'
    });
    _this.loadBtnPermission();
    $("#user_type option:first").prop("selected", 'selected');
    _this.url = '/role/add';
};

Role.prototype.update = function () {
    var _this = this;
    var row = $('#roleDg').datagrid('getSelected');
    if (row) {
        $("#roleDlg").dialog("open").dialog("setTitle", "修改角色");
        $('#roleFm').form('load', row);
        _this.url = '/role/update';
        $('#roleResourceTree').tree({
            url:'./../role/tree',
            onBeforeLoad: function(node, param){
                param.roleId = row.id;
            }
        });
        _this.loadBtnPermission();
        _this.setBtnPermission(row.id);
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Role.prototype.delete = function () {
    var row = $('#roleDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/role/delete', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#roleDg').datagrid('reload');
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

Role.prototype.query = function () {
    this.checkInput('nameParam',this.INPUT);
    $('#roleDg').datagrid('queryReload');
};

Role.prototype.loadBtnPermission = function() {
    $.ajax({
        url: '../btn/group',
        dataType: 'json',
        complete: function(xhr, textStatus) {
        },
        success: function(data, textStatus, xhr) {
            var html = template.render('fieldset_tmpl', data);
            $(' #btnPermission ').html(html);
        },
        error: function(xhr, textStatus, errorThrown) {
            $(' #btnPermission ').html('加载失败');
        }
    });
};

Role.prototype.getBtnPermission = function() {
    var arr_btn = [];
    $('#btnPermission input:checked').each(function(index, domEle) {
        var btn_id = $(domEle).attr('data-options');
        arr_btn.push(btn_id);
    });
    return arr_btn.toString();
};

Role.prototype.setBtnPermission = function(roleId) {
    $.ajax({
        url: '../role/btn',
        dataType: 'json',
        data: $.param({
            roleId: roleId
        }),
        complete: function(xhr, textStatus) {
        },
        success: function(data, textStatus, xhr) {
            var btns = data.data;
            if(!btns) return;
            $('#btnPermission input:checkbox').each(function(index, domEle) {
                var btn_id = $(domEle).attr('data-options');
                for(var i = 0; i < btns.length; i++){
                    var btn = btns[i];
                    if(btn.id == btn_id) {
                        $(domEle).attr('checked', 'checked');
                    }
                }
            });
        },
        error: function(xhr, textStatus, errorThrown) {
            alert('加载失败');
        }
    });
};

Role.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#roleDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#roleDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Role.prototype.getTree = function() {
    var nodes = $('#roleResourceTree').tree('getChecked');
    var nodeArr = [];
    for(var i = 0; i < nodes.length; i++){
        nodeArr.push(nodes[i].attributes.id);
    }
    return nodeArr.toString();
};

Role.prototype.bind = function () {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#roleDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#rolenameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });
    //	添加按钮
    $("#roleDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#roleDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#roleDgTbar table tbody tr td a").eq(3).click(function () {
        _this.delete();
    });

    /* role dialog */
    // 确定按钮
    $("#roleDlgBtn a").eq(0).click(function () {
        $('#resource').val(_this.getTree());
        $('#btn').val(_this.getBtnPermission());
        $('#roleFm').form('submit', {
            url: _this.url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#roleDlg').dialog('close');
                    $('#roleDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#roleDlgBtn a").eq(1).click(function () {
        $('#roleDlg').dialog('close');
    });
};

Role.prototype.roleFormatter = function (value, row, index) {
    var user_typeFormatter = row.user_type;
    switch (user_typeFormatter) {
        case 1:
            return '超级角色';
        case 2:
            return '用户角色';
        case 3:
            return '统计角色';
        default :
            return '';
    }
};


$(function () {
    window.role = new Role();
    role.init();
});