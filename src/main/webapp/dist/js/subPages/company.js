/**
 * Created by hbwhypw on 2015/8/25.
 */
var Company = function(){};
Company.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

Company.prototype.query = function () {
    this.checkInput('nameParam',this.INPUT);
    this.checkInput('city_idParam',this.COMBOBOX);
    $('#companyDg').datagrid('queryReload');
};

Company.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#companyDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#companyDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};
Company.prototype.add = function () {
    var _this = this;
    _this.url = '/company/add';
    $("#companyDlg").dialog("open").dialog("setTitle", "添加公司信息");
    $('#companyFm').form('clear');
    $("#is_check option:first").prop("selected", 'selected');
};

Company.prototype.update = function () {
    var _this = this;
    var row = $('#companyDg').datagrid('getSelected');
    if (row) {
        _this.url = '/company/update';
        $("#companyDlg").dialog("open").dialog("setTitle", "修改公司信息");
        $('#companyFm').form('load', row);
    } else {
        $.messager.alert('警告', '请选择一项！', 'warning');
    }
};

Company.prototype.delete = function () {
    var row = $('#companyDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/company/delete', {
                    id: row.id
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#companyDg').datagrid('reload');
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

Company.prototype.export = function() {
	var row = $('#companyDg').datagrid('getChecked');
    if (row) {
    	var ids = [];
        if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        var param = $.param({
			ids: ids.toString()
        });
    document.location.href = "/company/export/?" + param;
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Company.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#companyDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#nameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });
    //	添加按钮
    $("#companyDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#companyDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#companyDgTbar table tbody tr td a").eq(3).click(function () {
        _this.delete();
    });
    $("#export").click(function () {
        _this.export();
    });
    /* dialog */
    // 确定按钮
    $("#companyDlgBtn a").eq(0).click(function () {
        $('#companyFm').form('submit', {
            url: _this.url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#companyDlg').dialog('close');
                    $('#companyDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#companyDlgBtn a").eq(1).click(function () {
        $('#companyDlg').dialog('close');
    })
    
    _this.validName();
};

Company.prototype.validName = function() {
	$("#name").focusout(function(){
		var name = $("#name").val();
		$.post('/company/selectByName', {
    		"name": name
    	}, function(data) {
    		if(0==data.code){
    			$.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
    			$('#name').attr("value","");
    		}
    	},"json");
	});
}

Company.prototype.licenseFormatter = function (value, row, index) {
    var business_license_url = row.business_license_url;
    var html = '';
    if (business_license_url) {
        html = '<img src="' + business_license_url + '" width="40" height="40">';
    }
    return html;
};

Company.prototype.logoFormatter = function (value, row, index) {
    var logo_pic_url = row.logo_pic_url;
    var html = '';
    if (logo_pic_url) {
        html = '<img src="' + logo_pic_url + '" width="40" height="40">';
    }
    return html;
};

$(function(){
    window.company = new Company();
    company.init();
});

