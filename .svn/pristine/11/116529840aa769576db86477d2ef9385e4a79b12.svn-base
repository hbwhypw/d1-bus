var ProductType = function(){};
ProductType.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

ProductType.prototype.add = function() {
    var _this = this;
    $("#productTypeDlg").dialog("open").dialog("setTitle", "添加产品类型");
    $('#productTypeFm').form('clear');
    _this.url = '/productType/add';
};
ProductType.prototype.update = function() {
    var _this = this;
    var row = $('#productTypeDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $("#productTypeDlg").dialog("open").dialog("setTitle", "修改产品类型");
        $('#productTypeFm').form('load', row);
        _this.url = '/productType/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

ProductType.prototype.delete = function() {
    var row = $('#productTypeDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/productType/delete', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#productTypeDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#productTypeDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

ProductType.prototype.forEver = function() {
    var row = $('#productTypeDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/productType/forEver', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#productTypeDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#productTypeDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

ProductType.prototype.query = function() {
    this.checkInput('nameParam',this.INPUT);
    this.checkInput('is_checkParam',this.SELCET);
    $('#productTypeDg').datagrid('queryReload');
};

ProductType.prototype.recover = function() {
	var row = $('#productTypeDg').datagrid('getSelected');
	if (row) {
		$.post('/productType/updateRecover', {
			"id": row.id
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#productTypeDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

ProductType.prototype.select = function() {
    var _this = this;
    var row = $('#productTypeDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
    	$.post('/productType/selectById', {
    		"id": row.id
    	}, function(data) {
    		var result = eval("("+data+")");
    		var html = '';
    		if(1==result.code){
    			html += '<img src="' + result.data + '" width="100%">';
    			$('#img').append(html);
    			$("#productTypeImg").dialog("open").dialog("setTitle", "产品类型图片");
    		}
    	});
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

ProductType.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#productTypeDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#productTypeDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

ProductType.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#productTypeDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#productTypenameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    //	查看详情按钮
    $("#productTypeDgTbar table tbody tr td a").eq(1).click(function () {
        _this.select();
    });
    
    //	添加按钮
    $("#productTypeDgTbar table tbody tr td a").eq(2).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#productTypeDgTbar table tbody tr td a").eq(3).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#productTypeDgTbar table tbody tr td a").eq(4).click(function () {
        _this.delete();
    });
    //	恢复使用按钮
    $("#productTypeDgTbar table tbody tr td a").eq(5).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#productTypeDgTbar table tbody tr td a").eq(6).click(function () {
        _this.forEver();
    });

    /* 产品类型dialog */
    // 确定按钮
    $("#productTypeDlgBtn a").eq(0).click(function() {
        $('#productTypeFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#productTypeDlg').dialog('close');
                    $('#productTypeDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#productTypeDlgBtn a").eq(1).click(function() {
        $('#productTypeDlg').dialog('close');
    });
    // 关闭按钮
    $("#productTypeImgBtn a").eq(0).click(function() {
    	_this.clearImg();
        $('#productTypeImg').dialog('close');
    });
};

ProductType.prototype.clearImg = function() {
	$('#img').empty();
};

ProductType.prototype.is_checkFormatter = function(value,row,index){
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
ProductType.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};
$(function(){
    window.productType = new ProductType();
    productType.init();
});