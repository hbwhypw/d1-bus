var Card = function() {
};
Card.prototype.init = function() {
	this.url = "";
	this.bind();
};

Card.prototype._delete = function() {
	 var row = $('#cardDg').datagrid('getSelected');
	    if (row) {
	        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
	            if (r) {
	                $.post('/card/delete', {
	                    id: row.id
	                }, function(data) {
	                    if (data.code === 1) {
	                        $.messager.show({
	                            title: '系统提示',
	                            msg: data.msg
	                        });
	                        $('#cardDg').datagrid('reload');
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

Card.prototype.update = function() {
	var _this = this;
    var row = $('#cardDg').datagrid('getSelected');
    if (row) {
    	$("#cardDlg").dialog("open").dialog("setTitle","修改券码");
        $('#cardFm').form('load', row);
        _this.url = '/card/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

Card.prototype.add = function() {
	var _this = this;
	$("#cardDlg").dialog("open").dialog("setTitle","添加券码");
	$('#cardFm').form('clear');
	_this.url = '/card/add';
}

Card.prototype.checkInput = function(paramName, formType) {
	var param = $('#' + paramName).val();
	var requestParam = paramName.substring(0, paramName.indexOf("P"));
	if (param != "") {
		var queryParams = $('#cardDg').datagrid('options').queryParams;
		queryParams[requestParam] = param;
	} else {
		var queryParams = $('#cardDg').datagrid('options').queryParams;
		delete queryParams[requestParam];
	}
};

Card.prototype.bind = function() {
	var _this = this;

	var lineTimeDyTbar = $("#cardDgTbar table tbody tr td a");

	// 查询按钮
	lineTimeDyTbar.eq(0).click(function() {
		_this.query();
	});
	$("#card_nameParam").keyup(function(event) {
		if (event.keyCode == 13)
			_this.query();
	});

	// 添加按钮
	lineTimeDyTbar.eq(1).click(function() {
		_this.add();
	});

	// 修改按钮
	lineTimeDyTbar.eq(2).click(function() {
		_this.update();
	});

	// 修改按钮
	lineTimeDyTbar.eq(3).click(function() {
		_this._delete();
	});

	/* 线路dialog */
	// 确定按钮
	$("#cardDlgBtn a").eq(0).click(function() {
		$('#cardFm').form('submit', {
			url : _this.url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.code === 1) {
					$('#cardDlg').dialog('close');
					$('#cardDg').datagrid('reload');
				}
				$.messager.show({
					title : '系统提示',
					msg : data.msg
				});
			}
		});
	});
	// 取消按钮
	$("#cardDlgBtn a").eq(1).click(function() {
		$('#lineTimeDlg').dialog('close');
	});
};
$(function() {
	window.card = new Card();
	card.init();
});