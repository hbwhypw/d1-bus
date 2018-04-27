var TalkVo = function(){};
TalkVo.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

TalkVo.prototype.add = function() {
    var _this = this;
    $("#talkVoDlg").dialog("open").dialog("setTitle", "添加聊天房间");
    $('#talkVoFm').form('clear');
    _this.url = '/talk/add';
};
TalkVo.prototype.update = function() {
    var _this = this;
    var row = $('#talkVoUpdateDg').datagrid('getSelected');
    if (row) {
        $("#talkVoUpdateDlg").dialog("open").dialog("setTitle", "修改聊天房间");
        $('#talkVoUpdateFm').form('load', row);
        _this.url = '/talk/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

TalkVo.prototype.query = function() {
    this.checkInput('typeParam',this.INPUT);
    this.checkInput('room_idParam',this.INPUT);
    this.checkInput('room_nameParam',this.INPUT);
    this.checkInput('company_idParam',this.COMBOBOX);
    $('#talkVoDg').datagrid('queryReload');
};

TalkVo.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#talkVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#talkVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

TalkVo.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#talkVoDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#talkVonameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    //	添加按钮
    $("#talkVoDgTbar table tbody tr td a").eq(1).click(function () {
        _this.add();
    });
    //	修改按钮
    $("#talkVoDgTbar table tbody tr td a").eq(2).click(function () {
        _this.update();
    });

    /* 聊天dialog */
    // 确定按钮
    $("#talkVoDlgBtn a").eq(0).click(function() {
        $('#talkVoFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#talkVoDlg').dialog('close');
                    $('#talkVoDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#talkVoDlgBtn a").eq(1).click(function() {
        $('#talkVoDlg').dialog('close');
    });
    // 确定按钮
    $("#talkVoUpdateDlgBtn a").eq(0).click(function() {
    	$('#talkVoUpdateFm').form('submit', {
    		url: _this.url,
    		onSubmit: function() {
    			return $(this).form('validate');
    		},
    		success: function(data) {
    			var data = eval('(' + data + ')');
    			if (data.code === 1) {
    				$('#talkVoUpdateDlg').dialog('close');
    				$('#talkVoUpdateDg').datagrid('reload');
    			}
    			$.messager.show({
    				title: '系统提示',
    				msg: data.msg
    			});
    		}
    	});
    });
    // 取消按钮
    $("#talkVoUpdateDlgBtn a").eq(1).click(function() {
    	$('#talkVoUpdateDlg').dialog('close');
    });
};

$(function(){
    window.talkVo = new TalkVo();
    talkVo.init();
});