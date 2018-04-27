var AdPic = function(){};
AdPic.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

AdPic.prototype.add = function() {
    var _this = this;
    $("#adPicDlg").dialog("open").dialog("setTitle", "添加广告");
    $('#adPicFm').form('clear');
//    var content = "../../../kindeditor/jsp/activity.jsp";
//	$("#contents").attr('src',content);
    _this.url = '/adPic/add';
};
AdPic.prototype.update = function() {
    var _this = this;
    var row = $('#adPicDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
    	
    	var child = $("#contents").get(0).contentWindow;
    	child.editor1.html(row.content);
    	child.$('#content1').text(row.content);
    	child.editor1.sync();
    	
        $("#adPicDlg").dialog("open").dialog("setTitle", "修改广告");
        $('#adPicFm').form('load', row);
        _this.url = '/adPic/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

AdPic.prototype.delete = function() {
    var row = $('#adPicDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/adPic/delete', {
                	ids: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#adPicDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#adPicDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

AdPic.prototype.forEver = function() {
    var row = $('#adPicDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/adPic/forEver', {
                	ids: row.id
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#adPicDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#adPicDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

AdPic.prototype.query = function() {
    this.checkInput('titleParam',this.INPUT);
    this.checkInput('company_idParam',this.COMBOBOX);
    this.checkInput('is_checkParam',this.SELCET);
    $('#adPicDg').datagrid('queryReload');
};

AdPic.prototype.recover = function() {
	var row = $('#adPicDg').datagrid('getSelected');
	if (row) {
		var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
		$.post('/adPic/updateRecover', {
			ids: ids.toString()
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#adPicDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

AdPic.prototype.select = function() {
    var _this = this;
    var row = $('#adPicDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
    	$.post('/adPic/selectById', {
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
    			$("#adPicImg").dialog("open").dialog("setTitle", "广告图片");
    		}
    	});
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

AdPic.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#adPicDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#adPicDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

AdPic.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#adPicDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#adPicnameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 查看详情按钮
    $("#adPicDgTbar table tbody tr td a").eq(1).click(function () {
        _this.select();
    });
    
    // 添加按钮
    $("#adPicDgTbar table tbody tr td a").eq(2).click(function () {
        _this.add();
    });
    // 修改按钮
    $("#adPicDgTbar table tbody tr td a").eq(3).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#adPicDgTbar table tbody tr td a").eq(4).click(function () {
        _this.delete();
    });
    // 恢复使用按钮
    $("#adPicDgTbar table tbody tr td a").eq(5).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#adPicDgTbar table tbody tr td a").eq(6).click(function () {
        _this.forEver();
    });

    /* 广告dialog */
    // 确定按钮
    $("#adPicDlgBtn a").eq(0).click(function() {
        $('#adPicFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                	$('#contentDiv').dialog('close');
                    $('#adPicDlg').dialog('close');
                    $('#adPicDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#adPicDlgBtn a").eq(1).click(function() {
        $('#adPicDlg').dialog('close');
    });
    // 关闭按钮
    $("#adPicImgBtn a").eq(0).click(function() {
    	_this.clearImg();
        $('#adPicImg').dialog('close');
    });
    // 关闭按钮
    $("#contentBtn a").eq(0).click(function() {
    	_this.contents;
    	var content = contents.window.editor1.html();
    	$('#content').attr("value",content);
    	$('#contentDiv').dialog('close');
    });
    
    $("#content").focus(function(){
		$("#contentDiv").dialog("open").dialog("setTitle", "编辑活动内容");
	});
};

AdPic.prototype.clearImg = function() {
	$('#img').empty();
};

AdPic.prototype.is_checkFormatter = function(value,row,index){
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

AdPic.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};

$(function(){
	$("#adPicDlg").css('width', document.body.scrollWidth - 200);
	$("#adPicDlg").css('height', document.body.scrollHeight - 100);
    window.adPic = new AdPic();
    adPic.init();
});