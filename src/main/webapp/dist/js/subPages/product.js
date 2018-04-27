var Product = function(){};
Product.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    this.bind();
};

Product.prototype.add = function() {
    var _this = this;
    $("#productDlg").dialog("open").dialog("setTitle", "添加商品");
    $('#productFm').form('clear');
    _this.url = '/product/add';
};

Product.prototype.update = function() {
    var _this = this;
    var row = $('#productDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $("#productDlg").dialog("open").dialog("setTitle", "修改商品");
        $('#productFm').form('load', row);
        _this.url = '/product/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Product.prototype.delete = function() {
    var row = $('#productDg').datagrid('getSelected');
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
                $.post('/product/delete', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#productDg').datagrid('reload');
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

Product.prototype.forEver = function() {
    var row = $('#productDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/product/forEver', {
                    id: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#productDg').datagrid('reload');
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

}

Product.prototype.query = function() {
    this.checkInput('pro_nameParam',this.INPUT);
    this.checkInput('pro_typeParam',this.COBOBOX);
    this.checkInput('company_idParam',this.COBOBOX);
    this.checkInput('sell_typeParam',this.COBOBOX);
    $('#productDg').datagrid('queryReload');
};

Product.prototype.look = function() {
	var _this = this;
    var row = $('#productDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
    	$.post('/product/selectById', {
    		"id": row.id
    	}, function(data) {
    		var result = eval("("+data+")");
    		var list = result.data;
    		var html = '';
    		if(1==result.code){
    			for(var i = 0;i < list.length; i++){
    				html += '<img src="' + list[i] + '" width="100%">';
    			}
    			$('#img').append(html);
    			$("#productImg").dialog("open").dialog("setTitle", "产品图片");
    		}
    	});
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }

}

Product.prototype.recover = function() {
	var row = $('#productDg').datagrid('getSelected');
	if (row) {
		$.post('/product/updateRecover', {
			"id": row.id
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#productDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }

}

Product.prototype.audit = function() {
	var row = $('#productDg').datagrid('getSelected');
	if (row) {
		console.log(row);
		if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
		$.messager.confirm('系统确认', '是否确定审核？', function(r) {
			if (r) {
				if(1==row.is_check){
					$.messager.show({
						title: '系统提示',
						msg: '已审核'
					});
					return;
				}
				$.post('/product/updateAudit', {
					"id": row.id
				}, function(data) {
					$.messager.show({
						title: '系统提示',
						msg: data.msg
					});
					$('#productDg').datagrid('reload');
				}, 'json');
			}
		}) 
	} else {
		$.messager.alert('警告','请选择一项！','warning');
	}
	
}

Product.prototype.export = function() {
	var row = $('#productDg').datagrid('getChecked');
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
    document.location.href = "/product/export/?" + param;
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Product.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#productDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#productDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Product.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#productDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#productnameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    //	查看图片按钮
    $("#productDgTbar table tbody tr td a").eq(1).click(function () {
        _this.look();
    });
    
    //	添加按钮
    $("#productDgTbar table tbody tr td a").eq(2).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#productDgTbar table tbody tr td a").eq(3).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#productDgTbar table tbody tr td a").eq(4).click(function () {
        _this.delete();
    });
    // 审核
    $("#productDgTbar table tbody tr td a").eq(5).click(function () {
    	_this.audit();
    });
    // 恢复按钮
    $("#productDgTbar table tbody tr td a").eq(6).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#productDgTbar table tbody tr td a").eq(7).click(function () {
        _this.forEver();
    });
    $("#export").click(function () {
        _this.export();
    });
    /* 用户dialog */
    // 确定按钮
    $("#productDlgBtn a").eq(0).click(function() {
        $('#productFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#productDlg').dialog('close');
                    $('#productDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#productDlgBtn a").eq(1).click(function() {
        $('#productDlg').dialog('close');
    });
    // 关闭按钮
    $("#productImgBtn a").eq(0).click(function() {
    	_this.clearImg();
        $('#productImg').dialog('close');
    });
};
Product.prototype.clearImg = function() {
	$('#img').empty();
};
Product.prototype.is_checkFormatter = function(value,row,index){
    var is_check = row.is_check;
    switch (is_check) {
    	case 2:
    		return '待审核';
        case 1:
            return '有效';
        case 0:
            return '无效';
        default :
            return '';
    }
};
Product.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
    if (row.is_check == 2){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};
$(function(){
    window.product = new Product();
    product.init();
});