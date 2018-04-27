/**
 * 定义线路对象
 */
var LineTime = function() {
};

LineTime.prototype._delete = function() {
	var row = $('#lineTimeDg').datagrid('getChecked');
	if (row) {
		var ids = [];
		if ($.isArray(row)) {
			for (var i = 0; i < row.length; i++) {
				ids.push(row[i].id);
			} 
		} else {
			ids = ids.push(row.id);
		}
		$.messager.confirm('系统确认', '是否确定删除？', function (r) {
            if (r) {
                $.post('/lineTime/delete', {
                    "ids": ids.toString()
                }, function (data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#lineTimeDg').datagrid('reload');
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
}

LineTime.prototype.update = function() {
	_this = this;
	var row = $('#lineTimeDg').datagrid('getChecked');
	if (row) {
		if (1 == row.length) {
			$("#lineTimeDlg").dialog("open").dialog("setTitle","修改班次");
			$('#lineTimeFm').form('load', row[0]);
			_this.url = '/lineTime/update';
		} else {
			$.messager.alert('警告', '只能选择一项！', 'warning');
		}
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
};

LineTime.prototype.query = function() {
	this.checkInput('line_nameParam',this.INPUT);
	this.checkInput('driver_nameParam',this.INPUT);
	this.checkInput('car_numParam',this.INPUT);
	this.checkInput('driving_stateParam',this.COBOBOX);
	this.checkInput('company_idParam',this.COBOBOX);
	this.checkInput('startParam',this.INPUT);
	this.checkInput('endParam',this.INPUT);
	$('#lineTimeDg').datagrid('queryReload');
};

LineTime.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#lineTimeDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#lineTimeDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

LineTime.prototype.bind = function() {
	var _this = this;

	// 查询按钮
	$("#query").click(function() {
		_this.query();
	});
	/*$("#line_nameParam").keyup(function(event) {
		if (event.keyCode == 13)
			_this.query();
	});*/
	// 今天
	$("#today").click(function () {
    	timeMaxMin($(this));
    	_this.query();
    });
    // 昨天
	$("#yesterday").click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本周
	$("#thisWeek").click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本月
	$("#thisMonth").click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
	// 修改按钮
	$("#update").click(function() {
		_this.update();
	});

	// 删除按钮
	$("#delete").click(function() {
		_this._delete();
	});
	
	/* 线路dialog */
	// 确定按钮
	$("#lineTimeDlgBtn a").eq(0).click(function() {
		$('#lineTimeFm').form('submit', {
			url : _this.url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.code === 1) {
					$('#lineTimeDlg').dialog('close');
					$('#lineTimeDg').datagrid('reload');
				}
				$.messager.show({
					title : '系统提示',
					msg : data.msg
				});
			}
		});
	});
	// 取消按钮
	$("#lineTimeDlgBtn a").eq(1).click(function() {
		$('#lineTimeDlg').dialog('close');
	});
};

LineTime.prototype.init = function() {
	this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    this.bind();
};

function timeMaxMin(s){

	var now = new Date();
	var name = $(s).attr('name');

	var min = '';
	var max = '';
	switch (name) {
	   case 'today' :
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate()) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate()) + " 23:59:59"; 
	   break;
	   case 'yesterday' :
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate() - 1) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate() - 1) + " 23:59:59";  
	   break;
	   case 'thisWeek' :		  
		   nowDay = now.getDate();
		   nowDayOfWeek = now.getDay(); 
		   thisweek = nowDay - nowDayOfWeek	 ; 		   
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(thisweek + 1) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(thisweek + 7) + " 23:59:59"; 
	   break;
	   case 'thisMonth' :	
		   var hour=now.getHours();     
		   var minute=now.getMinutes();     
		   var second=now.getSeconds(); 	
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-' + 01 + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-' + fillZero(now.getDate() ) +" " + fillZero(hour)+":" + fillZero(minute)+":" + fillZero(second); 
       break;
	   default :
	       alert('error');
	} 
	$('#startParam').val( min );//必须用id才行
	$('#endParam').val( max );//必须用id才行
	$('#startParam').datetimebox('setValue' , min );//必须用id才行
 	$('#endParam').datetimebox('setValue' , max );//必须用id才行
		
};	

var fillZero = function(n){
	if(n<10){
		return '0'+n;
	}else{
		return n;
	}
};

$(function() {
	window.lineTime = new LineTime();
	lineTime.init();
});